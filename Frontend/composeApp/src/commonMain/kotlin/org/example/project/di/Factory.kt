package org.example.project.di

import org.example.project.database.UserDataStore

expect class Factory {

    fun createUserDataStore(): UserDataStore

}