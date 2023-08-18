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
        radioGrp.setOnCheckedChangeListener { group, checkId  ->
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

            if ((height == null) || (height < 30.0) || (height > 300.0) ||
                (weight == null) || (weight < 0.0) || (weight > 500.0) ||
                (bp1 == null) || (bp1 < 60) || (bp1 > 250) ||
                (bp2 == null) || (bp2 < 60) || (bp2 > 250) ||
                (pr == null) || (pr < 30) || (pr > 200) ||
                (age == null) || (age < 1) || (age > 110) ||
                (temp == null) || (temp < 30.0) || (temp > 45.0)
            ) {
                Toast.makeText(this, "Invalid input range detected", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bmi = weight / (height * height)
            val bp = BP(bp1, bp2)

            val vo: Double = vitalsObesity(bmi, pr)
            val vhtn: Double = vitalsHTN(bmi, bp, temp, pr, age)
            val vt: Double = vitalsThyroidism(bmi, temp, pr)
            val va: Double = vitalsAnemia(bmi, temp, pr)
            val vcvd: Double = vitalsCVD(bmi, temp, pr)
            val vd: Double = vitalsDiabetes(bmi, pr)

            val res = arrayListOf(vo, vhtn, vt, va, vcvd, vd)

            var resJson = gson.toJson(res)
            if(resJson == null) { resJson = "" }
            editor.putString("vitalRes", resJson)
            editor.apply()

            setResult(RESULT_OK, resultIntent)
            finish()
       }
    }
}