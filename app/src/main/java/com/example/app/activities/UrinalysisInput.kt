package com.example.app.activities

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.app.databinding.ActivityUrinalysisInputBinding
import com.example.app.utils.addWatcher

class UrinalysisInput : AppCompatActivity() {
    private lateinit var binding: ActivityUrinalysisInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUrinalysisInputBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addWatcher(binding.pH, 1.0, 14.0)
        addWatcher(binding.specificGravity, 1.001, 1.0035)

        // watcher for glucose, blood, ketones
        val gluSpinner: Spinner = binding.glucose
        val ketSpinner: Spinner = binding.ketones
        val bloodSpinner: Spinner = binding.blood

        // Create an ArrayAdapter with the options
        val options = arrayOf("Positive", "Negative")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, options)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        gluSpinner.adapter = adapter
        ketSpinner.adapter = adapter
        bloodSpinner.adapter = adapter

        // Set a listener to handle item selections
        gluSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                // Handle the selected item (positive or negative)
                // You can perform any logic here based on the selected item
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing here
            }
        }

    }
}