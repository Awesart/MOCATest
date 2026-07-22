package org.example.project.database

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.okio.OkioSerializer
import androidx.datastore.core.okio.OkioStorage
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okio.BufferedSink
import okio.BufferedSource
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import okio.use

@Serializable
data class User (
    val token: String,
)


internal object UserJsonSerializer : OkioSerializer<User>{

    val json = Json {ignoreUnknownKeys = true}

    override val defaultValue: User = User("")

    override suspend fun readFrom(source: BufferedSource): User  = json.decodeFromString<User>(source.readUtf8())

    override suspend fun writeTo(
        t: User,
        sink: BufferedSink
    ) {
        sink.use{
            it.writeUtf8(json.encodeToString(User.serializer(), t))
        }
    }

}

class UserDataStore (
    private val produceFilePath: () -> String
){
    private val db = DataStoreFactory.create(
        storage = OkioStorage<User>(
            fileSystem = FileSystem.SYSTEM,
            serializer = UserJsonSerializer,
            producePath = {
              produceFilePath().toPath()
            },
        ),
    )

    val user: Flow<User>
        get() = db.data

    //Takes in a JWT token that updates the user class in the datastore.
    //This can be used then to send a get request to receive the username of the user in the session.
    suspend fun updateUser(
        jwtToken: String
    ){
        db.updateData { user ->
            user.copy(token = jwtToken)
        }
    }


}