package com.nego.medshwari.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prescriptions")
data class Prescription(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val patientName: String,
    val medicineName: String,
    val dosage: String,
    val instructions: String
)