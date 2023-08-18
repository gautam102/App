package com.example.app.activities

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.app.databinding.ActivityMainBinding
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

//anychart

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val startInputActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
            }
        }

        binding.vitalsButton.setOnClickListener {
            val intent = Intent(this, VitalInput::class.java)
            startInputActivity.launch(intent)
        }
        binding.symptomsButton.setOnClickListener {
            val intent = Intent(this, SymptomsInput::class.java)
            startInputActivity.launch(intent)
        }
        binding.bloodReportsButton.setOnClickListener {
            val intent = Intent(this, BloodReportsInput::class.java)
            startInputActivity.launch(intent)
        }
        binding.urinalysisButton.setOnClickListener {
            val intent = Intent(this, UrinalysisInput::class.java)
            startInputActivity.launch(intent)
        }


    }

    override fun onResume() {
        super.onResume()

        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val vResJson = sharedPrefs.getString("vitalRes", null)
        if (vResJson != null) {
            val resType = object : TypeToken<ArrayList<Double>>() {}.type
            val res = gson.fromJson<ArrayList<Double>>(vResJson, resType)
            // Now you have your ArrayList<Double> back from the JSON string
            Log.d(TAG, "VITALS RESULT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! $res")
        }
        val sResJson = sharedPrefs.getString("symptomsRes", null)
        if (sResJson != null) {
            val resType = object : TypeToken<ArrayList<Double>>() {}.type
            val res = gson.fromJson<ArrayList<Double>>(sResJson, resType)
            // Now you have your ArrayList<Double> back from the JSON string
            Log.d(TAG, "SYMPTOMS RESULT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ${res.toString()}")
        }
        val bResJson = sharedPrefs.getString("bloodReportsRes", null)
        if (bResJson != null) {
            val resType = object : TypeToken<ArrayList<Double>>() {}.type
            val res = gson.fromJson<ArrayList<Double>>(bResJson, resType)
            // Now you have your ArrayList<Double> back from the JSON string
            Log.d(TAG, "BLOOD REPORTS RESULT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! $res")
        }
        val uResJson = sharedPrefs.getString("urinalysisRes", null)
        if (uResJson != null) {
            val resType = object : TypeToken<ArrayList<Double>>() {}.type
            val res = gson.fromJson<ArrayList<Double>>(uResJson, resType)
            // Now you have your ArrayList<Double> back from the JSON string
            Log.d(TAG, "URINALYSIS RESULT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! $res")
        }
    }
}
