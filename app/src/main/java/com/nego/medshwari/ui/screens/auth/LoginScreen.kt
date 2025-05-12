package com.nego.zawadimart.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nego.medshwari.ui.screens.about.AboutScreen
import com.nego.medshwari.ui.theme.newLiBlue
import com.nego.medshwari.viewModel.AuthViewModel
import com.nego.medshwari.viewModel.SessionViewModel

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    sessionViewModel: SessionViewModel,
    onNavigatePatient: () -> Unit,
    onNavigateDoctor: () -> Unit,
    onNavigateProvider: () -> Unit,
    onRegisterNavigate: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Login", fontSize = 24.sp)
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())

        Button(onClick = {
            authViewModel.login(email, password, sessionViewModel)
        }) {
            Text("Login")
        }

        Text(authViewModel.loginStatus.value)

        // Redirect on success
        if (authViewModel.loginStatus.value == "Success") {
            LaunchedEffect(Unit) {
                when (sessionViewModel.currentUser?.role) {
                    "Patient" -> onNavigatePatient()
                    "Doctor" -> onNavigateDoctor()
                    "Provider" -> onNavigateProvider()
                }
            }
        }

        TextButton(onClick = onRegisterNavigate) {
            Text("Don't have an account? Register")
        }
    }
}
