package com.example.app.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {
    private val _patientList = MutableLiveData<List<Patient>>()
    val patientList: LiveData<List<Patient>>
        get() = _patientList

    init {
        getPatientList()
    }

    private fun getPatientList(){

    }
}