package com.nego.medshwari.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface PrscriptionDao
@Dao
interface PrescriptionDao {
    abstract val androidx: Any

    @Query("SELECT * FROM prescriptions")
    suspend fun getAllPrescriptions(): List<Prescription>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrescription(prescription: Prescription)

    @Delete
    suspend fun deletePrescription(prescription: Prescription)
}
