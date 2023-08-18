package com.example.app.activities
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityBloodReportsInputBinding
import com.example.app.utils.addWatcher
import com.google.gson.Gson

class BloodReportsInput : AppCompatActivity() {
   private lateinit var binding: ActivityBloodReportsInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBloodReportsInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // CBC Report Text Watchers
        val layout1 = binding.cbcReport
        addWatcher(layout1.RBC, 1.0, 10.0) //
        addWatcher(layout1.WBC, 1000.00, 5000.00)
        addWatcher(layout1.Hb, 2.0, 20.0) //
        addWatcher(layout1.Hct, 10.0, 70.0) //
        addWatcher(layout1.MCV, 10.0, 300.00)
        addWatcher(layout1.Plt, 10000.0, 1000000.00)
        val layout2 = binding.cmpReport
       // CMP Report Text Watchers
        addWatcher(layout2.Glu, 10.0, 1000.00)
        addWatcher(layout2.Cal, 4.00, 18.0)
        addWatcher(layout2.Sod, 30.00, 300.0)
        addWatcher(layout2.Pot, 0.1, 7.0)
        addWatcher(layout2.Chl, 20.0, 150.0)
        addWatcher(layout2.Alb, 0.6, 83.0)
        addWatcher(layout2.TotPrt, 0.75, 83.0)
        addWatcher(layout2.ALP, 10.0, 200.0)
        addWatcher(layout2.ALT, 1.0, 150.0)
        addWatcher(layout2.AST, 1.0, 150.0)
        addWatcher(layout2.Urea, 2.0, 500.0)
        addWatcher(layout2.Creatinine, 0.09, 12.0)
        // Thyroid Report Text Watchers
        val layout3 = binding.thyroidReport
        addWatcher(layout3.TSH, 0.01, 06.0)
        addWatcher(layout3.T4, 0.1, 50.0)
        addWatcher(layout3.T3, 10.0, 250.0) //
        addWatcher(layout3.FT4, 1.0, 2.00) //
        addWatcher(layout3.FT3, 1.0, 2.00) //
        // Lipid Report Text Watchers
        val layout4 = binding.lipidReport
        addWatcher(layout4.TotChl, 10.0, 500.0)
        addWatcher(layout4.HDL, 10.0, 500.0)
        addWatcher(layout4.LDL, 10.0, 180.0)
        addWatcher(layout4.TG, 10.0, 500.0)

        val resultIntent = Intent()
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        binding.submitButton.setOnClickListener {
            val gson = Gson()
            val editor = sharedPrefs.edit()


            val res = arrayListOf(0)
            var resJson = gson.toJson(res)
            if(resJson == null) { resJson = "" }
            editor.putString("vitalRes", resJson)
            editor.apply()

            setResult(RESULT_OK, resultIntent)
            finish()
       }

    }

}


