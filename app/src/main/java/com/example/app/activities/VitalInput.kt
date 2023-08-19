package com.example.app.activities

import android.content.Context
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.app.databinding.ActivityVitalInputBinding
import com.example.app.models.BP
import com.example.app.utils.addWatcher
import com.example.app.utils.vitalsAnemia
import com.example.app.utils.vitalsCVD
import com.example.app.utils.vitalsDiabetes
import com.example.app.utils.vitalsHTN
import com.example.app.utils.vitalsThyroidism
import com.example.app.utils.vitalsObesity
import java.math.MathContext
import com.google.gson.Gson

class VitalInput : AppCompatActivity() {
    private lateinit var binding: ActivityVitalInputBinding
    private var bmi: Double = 25.0
    private var bp: BP = BP(90, 120)
    private var vo: Double = 0.0
    private var vt: Double = 0.0
    private var vhtn: Double = 0.0
    private var vd: Double = 0.0
    private var vcvd: Double = 0.0
    private var va: Double = 0.0
    private lateinit var res: ArrayList<Double>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVitalInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()

        // add text watcher
        addWatcher(binding.weight, 0.0, 500.0)
        addWatcher(binding.height, 30.0, 300.0)
        addWatcher(binding.bp1, 60.0, 250.0)
        addWatcher(binding.bp2, 60.0, 250.0)
        addWatcher(binding.temperature, 30.0, 45.0)
        addWatcher(binding.pulseRate, 30.0, 200.0)
        addWatcher(binding.age, 1.0, 110.0)
        //setup click listener

        val resultIntent = Intent()
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val radioGrp: RadioGroup = binding.radioGen
        radioGrp.setOnCheckedChangeListener { group, checkId ->
            val selected: RadioButton = findViewById(checkId)
            val sex = selected.text.toString()

        }

        binding.submitB.setOnClickListener {
            val editor = sharedPrefs.edit()

            val height = binding.height.text.toString().toDoubleOrNull()
            val weight = binding.weight.text.toString().toDoubleOrNull()
            val bp1 = binding.bp1.text.toString().toIntOrNull()
            val bp2 = binding.bp2.text.toString().toIntOrNull()
            val pr = binding.pulseRate.text.toString().toIntOrNull()
            val age = binding.age.text.toString().toIntOrNull()
            val temp = binding.temperature.text.toString().toDoubleOrNull()



            if (height != null && weight != null) {
                bmi = weight / (height * height)
            }
            if (bp1 != null && bp2 != null) {
                bp = BP(bp1, bp2)
            }

            // input range validation
            if (height != null) {
                if ((height < 30.0) || (height > 300.0)) {
                    invalidInput()
                }
            }
            if (weight != null) {
                if ((weight < 0.0) || (weight > 500.0)) {
                    invalidInput()
                }
            }
            if (bp1 != null && bp2 != null) {
                if ((bp1 < 60) || (bp1 > 250) || (bp2 < 60) || (bp2 > 250)) {
                    invalidInput()
                }
            }
            if (pr != null) {
                if ((pr < 30) || (pr > 200)) {
                    invalidInput()
                }
            }
            if (age != null) {
                if ((age < 1) || (age > 110)) {
                    invalidInput()
                }
            }
            if (temp != null) {
                if ((temp < 30.0) || (temp > 45.0)) {
                    invalidInput()
                }
            }


            vo = vitalsObesity(bmi, pr)
            vhtn = vitalsHTN(bmi, bp, temp, pr, age)
            vt = vitalsThyroidism(bmi, temp, pr)
            va = vitalsAnemia(bmi, temp, pr)
            vcvd = vitalsCVD(bmi, temp, pr)
            vd = vitalsDiabetes(bmi, pr)

            res = arrayListOf(vo, vhtn, vd, vt, vcvd, va)

            var resJson = gson.toJson(res)
            if (resJson == null) {
                resJson = ""
            }
            editor.putString("vitalRes", resJson)
            editor.apply()

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun invalidInput() {
        Toast.makeText(this, "Invalid input range detected", Toast.LENGTH_SHORT).show()
    }
}