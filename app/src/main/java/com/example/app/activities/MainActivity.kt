package com.example.app.activities

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val gson = Gson()
    private lateinit var barChart: Cartesian
    private lateinit var sharedPrefs: SharedPreferences
    private val dataEntries: MutableList<DataEntry> = ArrayList()
    private var sumArray = ArrayList<Double>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        // Set the values in shared preferences to null
        with(sharedPrefs.edit()) {
            putString("vitalRes", null)
            putString("symptomsRes", null)
            putString("bloodReportsRes", null)
            putString("urinalysisRes", null)
            apply() // Commit the changes
        }

        barChart = AnyChart.bar()
        barChart.xAxis(0).title("Diseases")
        barChart.yAxis(0).title("Probability")
        barChart.yScale().minimum(0.0)  // Set the minimum value
        barChart.yScale().maximum(3.0)  // Set the maximum value
        barChart.container("container") // Set the container id
        barChart.labels(true) // Enable labels on columns
        barChart.labels().position("inside") // Set label position
        barChart.background().fill("000000")
        binding.chartContainer.setBackgroundColor("")

        binding.chartContainer.setChart(barChart)

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

        binding.refresh.setOnClickListener{
            with(sharedPrefs.edit()) {
                putString("vitalRes", null)
                putString("symptomsRes", null)
                putString("bloodReportsRes", null)
                putString("urinalysisRes", null)
                apply() // Commit the changes
            }
            sumArray = arrayListOf(0.0,0.0,0.0,0.0,0.0,0.0)
            updateChartData()
        }
    }


    override fun onResume() {
        super.onResume()

        sharedPrefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val vResJson = sharedPrefs.getString("vitalRes", null)
        val sResJson = sharedPrefs.getString("symptomsRes", null)
        val bResJson = sharedPrefs.getString("bloodReportsRes", null)
        val uResJson = sharedPrefs.getString("urinalysisRes", null)

        val resType = object : TypeToken<ArrayList<Double>>() {}.type
        val vRes: ArrayList<Double> = gson.fromJson(vResJson, resType) ?: arrayListOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        val sRes: ArrayList<Double> = gson.fromJson(sResJson, resType) ?: arrayListOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        val bRes: ArrayList<Double> = gson.fromJson(bResJson, resType) ?: arrayListOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        val uRes: ArrayList<Double> = gson.fromJson(uResJson, resType) ?: arrayListOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

        Log.d(TAG, "RESULTS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n VRES: $vRes \n SRES: $sRes \n bRES: $bRes \n URES: $uRes")
        sumArray.clear()
        for (i in vRes.indices) {
            val sum = vRes[i] + sRes[i] + bRes[i] + uRes[i]
            sumArray.add(sum)
        }

        // Add data to the chart
        updateChartData()

        Log.d(TAG, "SUM ARRAY: $sumArray \n DATA ENTRIES: $dataEntries")

    }
    private fun updateChartData() {
        // Clear previous data entries and add new data
        dataEntries.clear()
        val diseases = arrayListOf("OBS", "HTN", "DB", "THY", "CVD", "AN")
        for (i in sumArray.indices) {
            dataEntries.add(ValueDataEntry(diseases[i], sumArray[i]))
        }

        // Remove previous series and add the updated series
        barChart.removeAllSeries()
        barChart.data(dataEntries)

    }
}
