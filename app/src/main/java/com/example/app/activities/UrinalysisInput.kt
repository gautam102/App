package com.example.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.app.databinding.ActivityUrinalysisInputBinding
import com.example.app.utils.addWatcher

class UrinalysisInput : AppCompatActivity() {
    private lateinit var binding: ActivityUrinalysisInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUrinalysisInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // add text watchers
        addWatcher(binding.pH, 1.0, 14.0)
        addWatcher(binding.specificGravity, 1.001, 1.0035)
        // radiogrps
        val bldRG: RadioGroup = binding.bldRG
        val ketRG: RadioGroup = binding.ketRG
        val gluRG: RadioGroup = binding.gluRG
        // listener for bld radiogrp
        bldRG.setOnCheckedChangeListener { group, checkId  ->
            val selected: RadioButton = findViewById(checkId)
            when (selected.id) {
                binding.bldPos.id -> {  }
                binding.bldNeg.id -> {  }
            }
        }
    }
}