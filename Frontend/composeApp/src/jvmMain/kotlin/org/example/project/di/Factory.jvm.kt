package org.example.project.di

import org.example.project.database.UserDataStore

actual class Factory {
    actual fun createUserDataStore(): UserDataStore {
        TODO("Not yet implemented")
    }
}