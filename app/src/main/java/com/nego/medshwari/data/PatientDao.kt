package com.nego.medshwari.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPatient(patient: PatientEntity)

    @Query("SELECT * FROM patients WHERE email = :email AND password = :password LIMIT 1")
    suspend fun authenticatePatient(email: String, password: String): PatientEntity?

    @Query("SELECT * FROM patients WHERE id = :id")
    fun getPatientById(id: Int): Flow<PatientEntity>

    @Query("SELECT * FROM patients")
    fun getAllPatients(): Flow<List<PatientEntity>>

    @Query("DELETE FROM patients WHERE id = :id")
    suspend fun deletePatientById(id: Int)

    @Query("DELETE FROM patients")
    suspend fun clearAllPatients()
}