package com.nego.medshwari.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nego.medshwari.data.PatientEntity
import com.nego.medshwari.ui.theme.newBlue
import com.nego.medshwari.viewModel.PatientProfileViewModel


@Suppress("KotlinConstantConditions")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientScreen(viewModel: PatientProfileViewModel, email: String,patient: PatientEntity) {
    val patient = viewModel.patient.value

    LaunchedEffect (email) {
        viewModel.loadPatientByEmail(email)
    }

    if (patient != null) {
        var name by remember { mutableStateOf(patient.fullName) }
        var phone by remember { mutableStateOf(patient.phone) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My Profile", fontWeight = FontWeight.Bold) },
                   Modifier.background(newBlue),
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Text("Edit Profile", style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.height(16.dp))

                TextField(value = name, onValueChange = {
                    val it =""
                    name = it
                }, label = { Text(text = "Full Name") })
                Spacer(modifier = Modifier.height(8.dp))

                TextField(value = patient.email, onValueChange = {}, enabled = false, label = { Text(text = "Email") })
                Spacer(modifier = Modifier.height(8.dp))

                TextField(value = phone, onValueChange = {
                    val it = ""
                    phone = it
                }, label = { Text(text = "Phone") })
                Spacer(modifier = Modifier.height(24.dp))

                Button(onClick = {
                    val updated = patient.copy(fullName = name, phone = phone)
                    viewModel.updatePatient(updated)
                }) {
                    Text("Save Changes")
                }
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}