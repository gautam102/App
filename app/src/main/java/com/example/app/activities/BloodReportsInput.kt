package com.example.app.activities
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityBloodReportsInputBinding
import com.example.app.utils.addWatcher
import com.google.gson.Gson
import com.example.app.utils.thyroidThyroidism
import com.example.app.utils.thyroidObesity
import com.example.app.utils.lipidCVD
import com.example.app.utils.lipidObesity
import com.example.app.utils.cbcAnemia
import com.example.app.utils.cmpDiabetes
class BloodReportsInput : AppCompatActivity() {
    private lateinit var binding: ActivityBloodReportsInputBinding
    private var bro:Double = 0.0
    private var brt:Double = 0.0
    private var brcvd:Double = 0.0
    private var bra:Double = 0.0
    private  var brd:Double = 0.0
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

            val gson = Gson()
            val editor = sharedPrefs.edit()

            if(lipidValidate(totChl, hdl, ldl, tg) == true) {
                bro += lipidObesity(totChl!!, hdl!!, ldl!!, tg!!)
                val lcvd = lipidCVD(totChl, hdl, ldl, tg)
                brcvd = lcvd
            }

            val tv = thyroidValidate(tsh, t4, t3)
            if(tv==1) {
                bro += thyroidObesity(tsh!!)
            }else if(tv==2){
                brt = thyroidThyroidism(tsh!!, t3!!, t4!!)
                bro += thyroidObesity(tsh!!)
            }

            val sex = sharedPrefs.getString("sex", null)
            if(cbcValidate(rbc, hb, hct, mcv, sex)){
                bra = cbcAnemia(rbc!!, hb!!, hct!!, mcv!!, "M")
            }
            if(cmpValidate(glu) == true) {
                brd = cmpDiabetes(glu!!)
            }

            val res = arrayListOf(bro, brcvd, bra, brd, brt, 0)
            var resJson = gson.toJson(res)
            if(resJson == null) { resJson = "" }
            editor.putString("bloodReportsRes", resJson)
            editor.apply()

            setResult(RESULT_OK, resultIntent)
            finish()
       }
    }
    private fun thyroidValidate(tsh:Double?, t4:Double?, t3:Double?): Int{

        return 2
        //null value handling
    }
    private fun lipidValidate(totChl:Double?, hdl:Double?, ldl:Double?, tg:Double?): Boolean{
        if (totChl != null && hdl != null && ldl != null && tg != null) { //null check
            if (totChl in 10.0..500.0 && hdl in 10.0..500.0 && ldl in 10.0..180.0
                && tg in 10.0..500.0) { //range check
                return true
            }
        } else {
            // Handle null values for lipid parameters
        }
        return false
    }
    private fun cbcValidate(rbc: Double?, hb: Double?, hct: Double?, mcv: Double?, sex: String?): Boolean{
        if (rbc != null && hb != null && hct != null && mcv != null) {
            if (rbc in 1.0..10.0 && hb in 2.0..20.0 && hct in 10.0..70.0
                && mcv in 10.0..300.0) {
                return true
            }
        } else {
            // Handle null values for CBC parameters
        }

        return false
    }
    private fun cmpValidate(glu:Double?): Boolean{
        if (glu != null) {
            if (glu in 10.0..1000.0) {
                return true
            }
        } else {
            // Handle null value for CMP parameter
        }
        return false
    }
    private fun inputError(){
        Toast.makeText(this, "Invalid input range detected", Toast.LENGTH_SHORT).show()
    }
}


