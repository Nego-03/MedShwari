package com.nego.medshwari.repository

import com.example.medshwari.data.local.PatientDao
import com.example.medshwari.data.local.PatientEntity
import kotlinx.coroutines.flow.Flow

class PatientRepository(private val patientDao: PatientDao) {

    suspend fun registerPatient(patient: PatientEntity) {
        patientDao.insertPatient(patient)
    }

    suspend fun getPatientByEmailAndPassword(email: String, password: String): PatientEntity? {
        return patientDao.getPatientByEmailAndPassword(email, password)
    }

    suspend fun updatePatient(patient: PatientEntity) {
        patientDao.updatePatient(patient)
    }

    suspend fun deletePatient(patient: PatientEntity) {
        patientDao.deletePatient(patient)
    }

    fun getPatientById(patientId: Int): Flow<PatientEntity?> {
        return patientDao.getPatientById(patientId)
    }

    fun getAllPatients(): Flow<List<PatientEntity>> {
        return patientDao.getAllPatients()
    }
}