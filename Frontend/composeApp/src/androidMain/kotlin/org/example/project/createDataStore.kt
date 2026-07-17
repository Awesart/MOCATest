package org.example.project

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.FileStorage
import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesSerializer
import org.example.project.data.datastore.createDataStore
import org.example.project.data.datastore.dataStoreFileName
import java.io.File

// shared/src/androidMain/kotlin/createDataStore.android.kt

fun createDataStore(context: Context): DataStore<Preferences> {
    return createDataStore {
        context.filesDir.resolve(dataStoreFileName).absolutePath
    }
}
