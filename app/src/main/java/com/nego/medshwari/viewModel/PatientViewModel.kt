package com.nego.medshwari.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nego.medshwari.data.PatientEntity
import com.nego.medshwari.repository.PatientRepository
import kotlinx.coroutines.launch

class PatientProfileViewModel(private val repository: PatientRepository) : ViewModel() {

    private val _patient = mutableStateOf<PatientEntity?>(null)
    val patient = _patient

    fun loadPatientByEmail(email: String) {
        viewModelScope.launch {
            _patient.value = repository.getPatientByEmail(email = email)
        }
    }

    fun updatePatient(updatedPatient: PatientEntity) {
        viewModelScope.launch {
            repository.updatePatient(updatedPatient)
            _patient.value = updatedPatient
        }
    }
}