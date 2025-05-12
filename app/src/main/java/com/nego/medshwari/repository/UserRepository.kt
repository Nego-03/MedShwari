package com.nego.medshwari.repository

import android.content.Context
import com.nego.medshwari.data.UserDao
import com.nego.medshwari.model.User

class UserRepository(private val userDao: UserDao) {
    val applicationContext: Context

    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}