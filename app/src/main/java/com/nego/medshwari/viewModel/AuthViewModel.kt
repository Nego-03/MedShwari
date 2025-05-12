package com.nego.medshwari.viewModel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.nego.medshwari.data.AppDatabase
import com.nego.medshwari.model.User
import com.nego.medshwari.repository.UserRepository
import kotlinx.coroutines.launch

class AuthViewModel(application: UserRepository) : AndroidViewModel(application = Application()) {
    private val db = AppDatabase.getDatabase(application)
    private val userDao = db.userDao()

    val registrationStatus = mutableStateOf("")
    val loginStatus = mutableStateOf("")

    fun register(username: String, email: String, password: String, role: String) {
        viewModelScope.launch {
            try {
                userDao.registerUser(User(username = username, email = email, password = password, role = role))
                registrationStatus.value = "Success"
            } catch (e: Exception) {
                registrationStatus.value = "Failed: ${e.message}"
            }
        }
    }

    fun login(email: String, password: String, sessionViewModel: SessionViewModel) {
        viewModelScope.launch {
            val user = userDao.loginUser(email, password)
            if (user != null) {
                sessionViewModel.currentUser = user  // Store user globally
                loginStatus.value = "Success"
            } else {
                loginStatus.value = "Invalid credentials"
            }
        }

    }
}

