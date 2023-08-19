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
    private var selectedSymptomNames = ArrayList<String>()
    private var so: Double = 0.0
    private var scvd: Double = 0.0
    private var shtn: Double = 0.0
    private var st: Double = 0.0
    private var sa: Double = 0.0
    private var sd: Double = 0.0
    private lateinit var res: ArrayList<Double>
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
            if (selectedSymptomsList.isEmpty()){

            }
            for (symptom in selectedSymptomsList) {
                selectedSymptomNames.add(symptom.symptom)
            }

            so = symptomsObesity(selectedSymptomNames)
            shtn = symptomsHTN(selectedSymptomNames)
            scvd = symptomsCVD(selectedSymptomNames)
            sa = symptomsAnemia(selectedSymptomNames)
            sd = symptomsDiabetes(selectedSymptomNames)
            st = symptomsThyrodism(selectedSymptomNames)

            res = arrayListOf(so, shtn, sd, st, scvd, sa)

            var resJson = gson.toJson(res)
            if(resJson == null) { resJson = "" }
            editor.putString("symptomsRes", resJson)
            editor.apply()

            setResult(RESULT_OK, resultIntent)
            finish()
       }
    }
}