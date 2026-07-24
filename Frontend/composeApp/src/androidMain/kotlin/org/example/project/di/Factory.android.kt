package org.example.project.di

import android.app.Application
import android.content.Context
import org.example.project.database.UserDataStore

actual class Factory(
    private val context: Context
) {
    actual fun createUserDataStore(): UserDataStore {
        return UserDataStore{
            context.filesDir
                .resolve(
                    "user.json"
                ).absolutePath
        }
    }



}