package com.nego.medshwari.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nego.medshwari.model.User

class SessionViewModel : ViewModel() {
    var currentUser by mutableStateOf<User?>(null)
}