package com.example.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityUrinalysisInputBinding
import com.example.app.utils.addWatcher

class UrinalysisInput : AppCompatActivity() {
    private lateinit var binding: ActivityUrinalysisInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUrinalysisInputBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addWatcher(binding.pH, 1.0, 2.00)
        addWatcher(binding.specificGravity, 1.0, 1.0)

       // watcher for glucose, blood, ketones
    }
}