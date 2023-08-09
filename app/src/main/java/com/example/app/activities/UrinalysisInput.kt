package com.example.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityUrinalysisInputBinding

class UrinalysisInput : AppCompatActivity() {
    private lateinit var binding: ActivityUrinalysisInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUrinalysisInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}