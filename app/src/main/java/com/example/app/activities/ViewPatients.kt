package com.example.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.Random
import com.example.app.databinding.ActivityViewPatientsBinding
import com.example.app.models.Patient
import com.example.app.adapters.PatientAdapter

class ViewPatients : AppCompatActivity() {
    private lateinit var binding:ActivityViewPatientsBinding
    lateinit var patients: ArrayList<Patient>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPatientsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val random = Random()
        fun rand(from: Int, to: Int): Int{ return random.nextInt(to - from) + from }


        patients = arrayListOf()
        for (i in 1..20){
            val randA = rand(18,70)
            val randH = rand(100,200)
            val randW = rand(40,150)

            val sex: () -> String = { if (rand(1,2)==1) "M" else "F" }
            val randS = sex()
            patients.add(Patient(randA, randS, randH.toLong(), randW.toFloat()))
        }

        val adapter: PatientAdapter = PatientAdapter(patients)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =  LinearLayoutManager(this)
    }
}