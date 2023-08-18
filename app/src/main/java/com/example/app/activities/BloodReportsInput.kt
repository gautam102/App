package com.example.app.activities
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityBloodReportsInputBinding
import com.example.app.utils.addWatcher
import com.google.gson.Gson
import com.example.app.utils.thyroidThyroidism
import com.example.app.utils.thyroidObesity
import com.example.app.utils.lipidCVD
import com.example.app.utils.lipidObesity
import com.example.app.utils.cbcAnemia
import com.example.app.utils.urinalysisDiabetes
import com.example.app.utils.cmpDiabetes
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

        val rbc: Double? = layout1.RBC.text.toString().toDoubleOrNull()
        val wbc: Double? = layout1.WBC.text.toString().toDoubleOrNull()
        val hb: Double? = layout1.Hb.text.toString().toDoubleOrNull()
        val hct: Double? = layout1.Hct.text.toString().toDoubleOrNull()
        val mcv: Double? = layout1.MCV.text.toString().toDoubleOrNull()
        val plt: Double? = layout1.Plt.text.toString().toDoubleOrNull()

        val glu: Double? = layout2.Glu.text.toString().toDoubleOrNull()
        val cal: Double? = layout2.Cal.text.toString().toDoubleOrNull()
        val sod: Double? = layout2.Sod.text.toString().toDoubleOrNull()
        val pot: Double? = layout2.Pot.text.toString().toDoubleOrNull()
        val chl: Double? = layout2.Chl.text.toString().toDoubleOrNull()
        val alb: Double? = layout2.Alb.text.toString().toDoubleOrNull()
        val totPrt: Double? = layout2.TotPrt.text.toString().toDoubleOrNull()
        val alp: Double? = layout2.ALP.text.toString().toDoubleOrNull()
        val alt: Double? = layout2.ALT.text.toString().toDoubleOrNull()
        val ast: Double? = layout2.AST.text.toString().toDoubleOrNull()
        val urea: Double? = layout2.Urea.text.toString().toDoubleOrNull()
        val creatinine: Double? = layout2.Creatinine.text.toString().toDoubleOrNull()

        val tsh: Double? = layout3.TSH.text.toString().toDoubleOrNull()
        val t4: Double? = layout3.T4.text.toString().toDoubleOrNull()
        val t3: Double? = layout3.T3.text.toString().toDoubleOrNull()
        val ft4: Double? = layout3.FT4.text.toString().toDoubleOrNull()
        val ft3: Double? = layout3.FT3.text.toString().toDoubleOrNull()

        val totChl: Double? = layout4.TotChl.text.toString().toDoubleOrNull()
        val hdl: Double? = layout4.HDL.text.toString().toDoubleOrNull()
        val ldl: Double? = layout4.LDL.text.toString().toDoubleOrNull()
        val tg: Double? = layout4.TG.text.toString().toDoubleOrNull()

        binding.submitButton.setOnClickListener {
            val gson = Gson()
            val editor = sharedPrefs.edit()


            val to = thyroidObesity(tsh)
            val lo = lipidObesity()
            val ud = urinalysisDiabetes()
            val cb = cmpDiabetes()
            val tt = thyroidThyroidism()
            val ca = cbcAnemia()
            val lcvd = lipidCVD()

            val res = arrayListOf(0)
            var resJson = gson.toJson(res)
            if(resJson == null) { resJson = "" }
            editor.putString("bloodReportsRes", resJson)
            editor.apply()

            setResult(RESULT_OK, resultIntent)
            finish()
       }

    }

}


