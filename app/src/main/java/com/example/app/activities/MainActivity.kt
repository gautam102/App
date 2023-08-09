package com.example.app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vitalsButton.setOnClickListener {
            val intent = Intent(this, VitalInput::class.java )
            startActivity(intent)
        }
        binding.symptomsButton.setOnClickListener {
            val intent = Intent(this, SymptomsInput::class.java )
            startActivity(intent)
        }
        binding.bloodReportsButton.setOnClickListener {
            val intent = Intent(this, BloodReportsInput::class.java )
            startActivity(intent)
        }
        binding.urinalysisButton.setOnClickListener {
            val intent = Intent(this, UrinalysisInput::class.java )
            startActivity(intent)
        }
        binding.viewPatientsButton.setOnClickListener {
            val intent = Intent(this, ViewPatients::class.java )
            startActivity(intent)
        }

    }
}