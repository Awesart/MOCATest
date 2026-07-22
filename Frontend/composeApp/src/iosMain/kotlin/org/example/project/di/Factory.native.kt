package org.example.project.di

import kotlinx.cinterop.ExperimentalForeignApi
import org.example.project.database.UserDataStore
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual class Factory {
    actual fun createUserDataStore(): UserDataStore =
        UserDataStore{
            "${fileDirectory()}/user.json"
        }

    @OptIn(ExperimentalForeignApi::class)
    private fun fileDirectory(): String{
        val directory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        return requireNotNull(directory).path!!
    }

}