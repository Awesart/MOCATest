package org.example.project.di

import android.app.Application
import org.example.project.database.UserDataStore

actual class Factory(
    private val app: Application
) {
    actual fun createUserDataStore(): UserDataStore {
        return UserDataStore{
            app.filesDir
                .resolve(
                    "user.json"
                ).absolutePath
        }
    }



}