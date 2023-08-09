package com.example.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityVitalInputBinding

class VitalInput : AppCompatActivity() {
   private lateinit var binding: ActivityVitalInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVitalInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}