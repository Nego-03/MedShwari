package com.nego.medshwari.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nego.medshwari.model.User
import com.nego.medshwari.repository.UserRepository

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: UserRepository): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}