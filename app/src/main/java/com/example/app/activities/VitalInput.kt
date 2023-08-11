package com.example.app.activities

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import com.example.app.databinding.ActivityVitalInputBinding
import com.example.app.utils.addWatcher

class VitalInput : AppCompatActivity() {
   private lateinit var binding: ActivityVitalInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVitalInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addWatcher(binding.weight, 0.0, 500.0)
        addWatcher(binding.height, 30.0, 300.0)
        addWatcher(binding.bloodPressure, 60.0, 250.0)
        addWatcher(binding.temperature, 30.0, 45.0)
        addWatcher(binding.breathingRate, 10.0, 60.0)
        addWatcher(binding.pulseRate, 30.0, 200.0)
        addWatcher(binding.age, 1.0, 110.0)

        val radioGrp: RadioGroup = binding.radioGen

        radioGrp.setOnCheckedChangeListener { group, checkId  ->
            val selected: RadioButton = findViewById(checkId)

            when (selected.id) {
                binding.radioMale.id -> {
                    // x
                }
                binding.radioFemale.id -> {
                    // x
                }
            }
        }
    }
}