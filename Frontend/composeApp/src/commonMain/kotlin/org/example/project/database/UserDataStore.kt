package org.example.project.database

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.okio.OkioSerializer
import androidx.datastore.core.okio.OkioStorage
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
data class UserSession (
    val token: String = "",
)


internal object UserJsonSerializer : OkioSerializer<UserSession>{

    val json = Json {ignoreUnknownKeys = true}

    override val defaultValue: UserSession = UserSession("")

    override suspend fun readFrom(source: BufferedSource): UserSession  = json.decodeFromString<UserSession>(source.readUtf8())

    override suspend fun writeTo(
        t: UserSession,
        sink: BufferedSink
    ) {
        sink.use{
            it.writeUtf8(json.encodeToString(UserSession.serializer(), t))
        }
    }

}

class UserDataStore (
    private val produceFilePath: () -> String
){
    private val db = DataStoreFactory.create(
        storage = OkioStorage<UserSession>(
            fileSystem = FileSystem.SYSTEM,
            serializer = UserJsonSerializer,
            producePath = {
              produceFilePath().toPath()
            },
        ),
    )

    val userSession: Flow<UserSession>
        get() = db.data

    //Takes in a JWT token that updates the user class in the datastore.
    //This can be used then to send a get request to receive the username of the user in the session.
    suspend fun updateUser(
        jwtToken: String
    ){
        db.updateData { user ->
            user.copy(token = jwtToken)
        }
        println(userSession)
    }


}