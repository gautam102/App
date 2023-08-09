package com.example.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityVitalInputBinding
import com.example.app.utils.addWatcher

class VitalInput : AppCompatActivity() {
   private lateinit var binding: ActivityVitalInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVitalInputBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addWatcher(binding.weight, 1.0, 1.0)
        addWatcher(binding.height, 1.0, 1.0)
        addWatcher(binding.bloodPressure, 1.0, 1.0)
        addWatcher(binding.temperature, 1.0, 1.0)
        addWatcher(binding.breathingRate, 1.0, 1.0)
        addWatcher(binding.pulseRate, 1.0, 1.0)
        addWatcher(binding.age, 1.0, 1.0)
    }
}