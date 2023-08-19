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
fun symptomsObesity(selected: List<String>?): Double {
    val wt = 0.142

    val sel = selected ?: arrayListOf()

    val obesitySymptoms = arrayListOf("Weight gain","SOB", "Joint/Back pain", "Increased sweating", "Snoring", "Insomnia", "Fatigue(tired)")
    val res = sel.intersect(obesitySymptoms).toList()

    return wt*res.size
}
fun symptomsHTN(selected: List<String>?): Double {
    val wt = 0.1875

    val sel = selected ?: arrayListOf()

    val htnSymptoms = arrayListOf("Headache", "SOB", "Vision changes", "Abnormal heart rhythm", "Anxiety", "Dizziness", "Nose bleed", "Nausea/vomiting")
    val res = sel.intersect(htnSymptoms).toList()

    return wt*res.size
}
fun symptomsDiabetes(selected: List<String>?): Double {
    val wt = 0.142

    val sel = selected ?: arrayListOf()

    val diabetesSymptoms = arrayListOf("Urinating a lot","Losing weight", "Dry skin", "Fatigue(tired)", "Thirst", "Sores that heal slowly", "Numbness")
    val res = sel.intersect(diabetesSymptoms).toList()
    return wt*res.size
}
fun symptomsThyrodism(selected: List<String>?): Double {
    val wt = 0.111

   val sel = selected ?: arrayListOf()

    val thyroidismSymptoms = arrayListOf("Weight gain", "Constipation", "Decreased sweating", "Muscle pain", "Cold intolerance", "Fatigue(tired)", "Insomnia", "Hair loss", "Irregular periods")
    val res = sel.intersect(thyroidismSymptoms).toList()
    return wt*res.size
}
fun symptomsCVD(selected: List<String>?): Double {
    val wt = 0.125

    val sel = selected ?: arrayListOf()

    val cvdSymptoms = arrayListOf("Chest pain/discomfort", "SOB", "Numbness", "Dizziness", "Cyanosis", "Leg/ankle/feet swelling", "Fatigue(tired)", "Weakness")
    val res = sel.intersect(cvdSymptoms).toList()

    return wt*res.size
}
fun symptomsAnemia(selected: List<String>?): Double{
    val wt = 0.1666

    val sel = selected ?: arrayListOf()

    val anemiaSymptoms =  arrayListOf("Fatigue(tired)", "Dizziness", "Numbness", "Headache", "Pale skin", "Poor appetite")
    val res = sel.intersect(anemiaSymptoms).toList()

    return wt*res.size
}