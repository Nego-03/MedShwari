package com.nego.medshwari.model

data class Doctor(
    val name: String,
    val specialty: String,
    val hospital: String,
    val rating: Double,
    val available: Boolean
)

val doctorList = listOf(
    Doctor("Dr. Aisha Omar", "Cardiologist", "Aga Khan Hospital", 4.8, true),
    Doctor("Dr. Mwangi Njoroge", "Dermatologist", "Kenyatta Hospital", 4.6, false),
    Doctor("Dr. Linda Wambui", "Pediatrician", "Mater Hospital", 4.9, true),
    Doctor("Dr. Kevin Otieno", "General Practitioner", "Nairobi West Hospital", 4.5, true),
)