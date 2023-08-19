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
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.anychart.enums.Anchor
import com.anychart.enums.Position

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val barChart: Cartesian = AnyChart.column()

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

        val sharedPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val vResJson = sharedPrefs.getString("vitalRes", null)
        val sResJson = sharedPrefs.getString("symptomsRes", null)
        val bResJson = sharedPrefs.getString("bloodReportsRes", null)
        val uResJson = sharedPrefs.getString("urinalysisRes", null)

        val resType = object : TypeToken<ArrayList<Double>>() {}.type
        val vRes: ArrayList<Double> = gson.fromJson(vResJson, resType) ?: arrayListOf()
        val sRes: ArrayList<Double> = gson.fromJson(sResJson, resType) ?: arrayListOf()
        val bRes: ArrayList<Double> = gson.fromJson(bResJson, resType) ?: arrayListOf()
        val uRes: ArrayList<Double> = gson.fromJson(uResJson, resType) ?: arrayListOf()

        val sumArray = ArrayList<Double>()
        /*if(vRes!=null && sRes!=null && bRes!=null && uRes!=null) {
            Log.d(TAG, "RESULTS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n VRES: $vRes \n SRES: $sRes \n bRES: $bRes \n URES: $uRes")
            for (i in vRes.indices) {
                val sum = vRes[i] + sRes[i] + bRes[i] + uRes[i]
                sumArray.add(sum)
            }
            val dataEntries: MutableList<DataEntry> = ArrayList()
            for (i in sumArray.indices) {
                dataEntries.add(ValueDataEntry("Index $i", sumArray[i]))
            }

// Add data to the chart
            val column = barChart.column(dataEntries)

// Customize chart appearance
            column.labels(true)
            column.labels().position("inside")  // Set labels inside the bars

// Set chart title and axes titles
            barChart.title("Sum of Values")
            barChart.xAxis(0).title("Index")
            barChart.yAxis(0).title("Sum")

// Display the chart
            binding.chartContainer.setChart(barChart)

        }*/
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
