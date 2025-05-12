package com.nego.zawadimart.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nego.medshwari.viewModel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    viewModel: AuthViewModel,
    onLoginNavigate: NavHostController,
    function: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf("Patient") }
    val roles = listOf("Patient", "Doctor", "Provider")

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Register", fontSize = 24.sp)
        OutlinedTextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())

        // Role Dropdown
        var expanded by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
            OutlinedTextField(
                readOnly = true,
                value = selectedRole,
                onValueChange = {},
                label = { Text("Select Role") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                roles.forEach { role ->
                    DropdownMenuItem(text = { Text(role) }, onClick = {
                        selectedRole = role
                        expanded = false
                    })
                }
            }
        }

        Button(onClick = {
            viewModel.register(username, email, password, selectedRole)
        }) {
            Text("Register")
        }

        Text(viewModel.registrationStatus.value)

        TextButton(onClick = onLoginNavigate) {
            Text("Already have an account? Login")
        }
    }
}