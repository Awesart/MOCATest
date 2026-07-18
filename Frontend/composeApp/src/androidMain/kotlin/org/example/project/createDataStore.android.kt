package org.example.project

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.example.project.data.datastore.createDataStore
import org.example.project.data.datastore.dataStoreFileName

// shared/src/androidMain/kotlin/createDataStore.android.kt

fun createDataStore(context: Context): DataStore<Preferences> {
    return createDataStore {
        context.filesDir.resolve(dataStoreFileName).absolutePath
    }
}
