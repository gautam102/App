package com.example.app.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.app.databinding.ActivityUrinalysisInputBinding
import com.example.app.utils.addWatcher
import com.google.gson.Gson
import com.example.app.utils.urinalysisDiabetes

class UrinalysisInput : AppCompatActivity() {
    private lateinit var binding: ActivityUrinalysisInputBinding
    private var glu: Boolean = false
    private var ket: Boolean = false
    private var bld: Boolean = false
    private var ud: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUrinalysisInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // add text watchers
        addWatcher(binding.pH, 1.0, 14.0)
        addWatcher(binding.specificGravity, 0.750, 1.2000)


        // radiogrps
        val bldRG: RadioGroup = binding.bldRG
        val ketRG: RadioGroup = binding.ketRG
        val gluRG: RadioGroup = binding.gluRG

        gluRG.setOnCheckedChangeListener { group, checkId ->
            val selected: RadioButton = findViewById(checkId)
            when (selected.id) {
                binding.gluPos.id -> {
                    glu = true
                }

                binding.gluNeg.id -> {
                    glu = false
                }
            }
        }
        ketRG.setOnCheckedChangeListener { group, checkId ->
            val selected: RadioButton = findViewById(checkId)
            when (selected.id) {
                binding.ketPos.id -> {
                    ket = true
                }

                binding.ketNeg.id -> {
                    ket = false
                }
            }
        }
        bldRG.setOnCheckedChangeListener { group, checkId ->
            val selected: RadioButton = findViewById(checkId)
            when (selected.id) {
                binding.bldPos.id -> {
                    bld = true
                }

                binding.bldNeg.id -> {
                    bld = false
                }
            }
        }

        val resultIntent = Intent()
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.button2.setOnClickListener {
            val gson = Gson()
            val editor = sharedPrefs.edit()

            if(glu!=null || ket!=null) {
                ud += urinalysisDiabetes(glu, ket)
            }

            val res = arrayListOf(0, 0, 0, 0, 0, ud)
            var resJson = gson.toJson(res)
            if (resJson == null) {
                resJson = ""
            }
            editor.putString("urinalysisRes", resJson)
            editor.apply()

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}