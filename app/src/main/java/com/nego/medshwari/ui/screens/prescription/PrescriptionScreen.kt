package com.nego.medshwari.ui.screens.prescription

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nego.medshwari.data.Prescription
import com.nego.medshwari.viewModel.PrescriptionViewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PrescriptionScreen(viewModel: PrescriptionViewModel) {
    var patientName by remember { mutableStateOf("") }
    var medicineName by remember { mutableStateOf("") }
    var dosage by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = patientName,
            onValueChange = { patientName = it },
            label = { Text("Patient Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = medicineName,
            onValueChange = { medicineName = it },
            label = { Text("Medicine Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = dosage,
            onValueChange = { dosage = it },
            label = { Text("Dosage") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = instructions,
            onValueChange = { instructions = it },
            label = { Text("Instructions") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (patientName.isNotEmpty() && medicineName.isNotEmpty()) {
                    viewModel.insertPrescription(
                        Prescription(
                            patientName = patientName,
                            medicineName = medicineName,
                            dosage = dosage,
                            instructions = instructions
                        )
                    )
                    patientName = ""
                    medicineName = ""
                    dosage = ""
                    instructions = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add")
        }
    }
}

@Composable
fun PrescriptionCard(
    medicineName: String,
    dosage: String,
    prescribedBy: String,
    date: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = medicineName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Dosage: $dosage")
            Text(text = "Prescribed by: $prescribedBy")
            Text(text = "Date: $date")
        }
    }
}


