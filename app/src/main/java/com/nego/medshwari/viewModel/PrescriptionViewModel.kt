package com.nego.medshwari.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.nego.medshwari.data.Prescription
import com.nego.medshwari.repository.PrescriptionRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class PrescriptionViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "medshwari_db"
    ).build()

    private val repository = PrescriptionRepository(db.prescriptionDao())

    val allPrescriptions: StateFlow<List<Prescription>> = repository.allPrescriptions
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun insertPrescription(prescription: Prescription) {
        viewModelScope.launch {
            repository.insert(prescription)
        }
    }
}