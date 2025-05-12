package com.nego.medshwari.repository

import com.nego.medshwari.data.PatientDao
import com.nego.medshwari.data.PatientEntity
import kotlinx.coroutines.flow.Flow

class PatientRepository(private val patientDao: PatientDao) {

    suspend fun insertPatient(patient: PatientEntity) {
        patientDao.insertPatient(patient)
    }

    suspend fun authenticatePatient(email: String, password: String): PatientEntity? {
        return patientDao.authenticatePatient(email, password)
    }

    fun getPatientById(id: Int): Flow<PatientEntity> {
        return patientDao.getPatientById(id)
    }

    fun getAllPatients(): Flow<List<PatientEntity>> {
        return patientDao.getAllPatients()
    }

    suspend fun deletePatientById(id: Int) {
        patientDao.deletePatientById(id)
    }

    suspend fun clearAllPatients() {
        patientDao.clearAllPatients()
    }

    fun getPatientByEmail(email: String) {}
    fun updatePatient(updatedPatient: PatientEntity) {


    }
}