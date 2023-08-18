package com.example.app.activities

import android.content.Context
import android.content.Intent
import com.example.app.models.SymptomsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivitySymptomsInputBinding
import com.example.app.adapters.SymptomAdapter
import com.google.gson.Gson
import com.example.app.utils.symptomsAnemia
import com.example.app.utils.symptomsCVD
import com.example.app.utils.symptomsHTN
import com.example.app.utils.symptomsDiabetes
import com.example.app.utils.symptomsThyrodism
import com.example.app.utils.symptomsObesity


class SymptomsInput : AppCompatActivity() {
    private lateinit var binding: ActivitySymptomsInputBinding
    private lateinit var viewModel: SymptomsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySymptomsInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Initialization of ViewModel
        viewModel = ViewModelProvider(this).get(SymptomsViewModel::class.java)
        // Setting up the adapter for displaying symptoms
        var adapter = SymptomAdapter(viewModel.symptomsLiveData)

        binding.symptomsRecyclerView.adapter = adapter
        binding.symptomsRecyclerView.layoutManager = LinearLayoutManager(this)

        val resultIntent = Intent()
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.button.setOnClickListener {
            val gson = Gson()
            val editor = sharedPrefs.edit()

            val selectedSymptomsList = adapter.getSelectedSymptoms()
            val selectedSymptomNames = ArrayList<String>()
            for (symptom in selectedSymptomsList) {
                selectedSymptomNames.add(symptom.symptom)
            }

            val so = symptomsObesity(selectedSymptomNames)
            val shtn = symptomsHTN(selectedSymptomNames)
            val scvd = symptomsCVD(selectedSymptomNames)
            val sa = symptomsAnemia(selectedSymptomNames)
            val sd = symptomsDiabetes(selectedSymptomNames)
            val st = symptomsThyrodism(selectedSymptomNames)

            val res = arrayListOf(so, shtn, sd, st, scvd, sa)

            var resJson = gson.toJson(res)
            if(resJson == null) { resJson = "" }
            editor.putString("symptomsRes", resJson)
            editor.apply()

            setResult(RESULT_OK, resultIntent)
            finish()
       }
    }
}