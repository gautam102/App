package com.example.app.utils

import android.content.ContentValues.TAG
import android.util.Log
import com.example.app.models.Symptom

val allSymptoms = arrayListOf(
    "Weight gain",
    "Fatigue(tired)",
    "Joint/Back pain",
    "Increased sweating",
    "Snoring",
    "Headache",
    "SOB",
    "Vision changes",
    "Abnormal heart rhythm",
    "Anxiety",
    "Dizziness",
    "Nose bleed",
    "Nausea/vomiting",
    "Urinating a lot",
    "Losing weight",
    "Dry skin",
    "Thirst",
    "Sores that heal slowly",
    "Numbness",
    "Constipation",
    "Decreased sweating",
    "Muscle pain",
    "Cold intolerance",
    "Weakness",
    "Insomnia",
    "Hair loss",
    "Irregular periods",
    "Chest pain/discomfort",
    "Cyanosis",
    "Leg/ankle/feet swelling",
    "Pale skin",
    "Poor appetite"
)
fun symptomsObesity(selected: List<String>): Double {
    val wt = 0.142
    val obesitySymptoms = arrayListOf("Weight gain","SOB", "Joint/Back pain", "Increased sweating", "Snoring", "Insomnia", "Fatigue(tired)")
    val res = selected.intersect(obesitySymptoms).toList()

    Log.d(TAG,"OBESITY: ${selected.toString()}")
    Log.d(TAG, res.size.toString())
    return wt*res.size
}
fun symptomsHTN(selected: List<String>): Double {
    val wt = 0.1875
    val htnSymptoms = arrayListOf("Headache", "SOB", "Vision changes", "Abnormal heart rhythm", "Anxiety", "Dizziness", "Nose bleed", "Nausea/vomiting")
    val res = selected.intersect(htnSymptoms).toList()
    Log.d(TAG, "HYPERTENSION: ${selected.toString()}")
    Log.d(TAG, res.size.toString())
    return wt*res.size
}
fun symptomsDiabetes(selected: List<String>): Double {
    val wt = 0.142
    val diabetesSymptoms = arrayListOf("Urinating a lot","Losing weight", "Dry skin", "Fatigue(tired)", "Thirst", "Sores that heal slowly", "Numbness")
    val res = selected.intersect(diabetesSymptoms).toList()
    Log.d(TAG, "DIABETES: ${selected.toString()}")
    Log.d(TAG, res.size.toString())
    return wt*res.size
}
fun symptomsThyrodism(selected: List<String>): Double {
    val wt = 0.111
    val thyroidismSymptoms = arrayListOf("Weight gain", "Constipation", "Decreased sweating", "Muscle pain", "Cold intolerance", "Fatigue(tired)", "Insomnia", "Hair loss", "Irregular periods")
    val res = selected.intersect(thyroidismSymptoms).toList()
    Log.d(TAG, "THYROIDISM: ${selected.toString()}")
    Log.d(TAG, res.size.toString())
    return wt*res.size
}
fun symptomsCVD(selected: List<String>): Double {
    val wt = 0.125
    val cvdSymptoms = arrayListOf("Chest pain/discomfort", "SOB", "Numbness", "Dizziness", "Cyanosis", "Leg/ankle/feet swelling", "Fatigue(tired)", "Weakness")
    val res = selected.intersect(cvdSymptoms).toList()
    Log.d(TAG, "CVD: ${selected.toString()}")
    Log.d(TAG, res.size.toString())
    return wt*res.size
}
fun symptomsAnemia(selected: List<String>): Double{
    val wt = 0.1666
    val anemiaSymptoms =  arrayListOf("Fatigue(tired)", "Dizziness", "Numbness", "Headache", "Pale skin", "Poor appetite")
    val res = selected.intersect(anemiaSymptoms).toList()
    Log.d(TAG, "ANEMIA: ${selected.toString()}")
    Log.d(TAG, res.size.toString())
    return wt*res.size
}