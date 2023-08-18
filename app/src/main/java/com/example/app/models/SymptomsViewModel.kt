package com.example.app.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.utils.allSymptoms
class SymptomsViewModel: ViewModel() {
    // MutableLiveData to hold the list of symptoms
    val symptomsLiveData = MutableLiveData<ArrayList<Symptom>>()

    init {
        symptomsLiveData.value = generate() // Initialize with the generated list of symptoms
    }
    private fun generate() : ArrayList<Symptom>{
       val symptomList = ArrayList<Symptom>()

        for (symptomDescription in allSymptoms) {
            val symptom = Symptom(symptomDescription)
            symptomList.add(symptom)
        }

        return symptomList
    }
    val symptomsList: ArrayList<Symptom> = generate()
}