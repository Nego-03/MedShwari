package com.nego.medshwari.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Prescription::class], version = 1)
abstract class MedShwariDatabase : RoomDatabase() {
    abstract fun prescriptionDao(): PrescriptionDao
}