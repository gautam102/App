package com.example.app.activities
import BloodReportsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.example.app.databinding.ActivityBloodReportsInputBinding
import com.example.app.models.SymptomsViewModel
import com.example.app.utils.addWatcher

class BloodReportsInput : AppCompatActivity() {
   private lateinit var binding: ActivityBloodReportsInputBinding
    private lateinit var viewModel: BloodReportsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBloodReportsInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[BloodReportsViewModel::class.java]

        // CBC Report Text Watchers
        val layout1 = binding.cbcReport
        addWatcher(layout1.RBC, 1.0, 2.00) //
        addWatcher(layout1.WBC, 100.00, 40000.00)
        addWatcher(layout1.Hb, 1.0, 2.00) //
        addWatcher(layout1.Hct, 1.0, 2.00) //
        addWatcher(layout1.MCV, 10.0, 500.00)
        addWatcher(layout1.Plt, 1000.0, 1000000.00)

        val layout2 = binding.cmpReport
       // CMP Report Text Watchers
        addWatcher(layout2.Glu, 10.0, 1000.00)
        addWatcher(layout2.Cal, 0.82, 102.0)
        addWatcher(layout2.Sod, 13.50, 1450.0)
        addWatcher(layout2.Pot, 3.5, 50.0)
        addWatcher(layout2.Chl, 0.96, 1060.0)
        addWatcher(layout2.Alb, 0.6, 83.0)
        addWatcher(layout2.TotPrt, 0.75, 83.0)
        addWatcher(layout2.ALP, 6.0, 1200.0)
        addWatcher(layout2.ALT, 1.5, 550.0)
        addWatcher(layout2.AST, 2.0, 480.0)
        addWatcher(layout2.Bil, 0.07, 12.0)
        addWatcher(layout2.BUN, 1.0, 200.0)
        addWatcher(layout2.Urea, 2.0, 500.0)
        addWatcher(layout2.Creatinine, 0.09, 12.0)

        // Thyroid Report Text Watchers
        val layout3 = binding.thyroidReport
        addWatcher(layout3.TSH, 0.04, 50.0)
        addWatcher(layout3.T4, 0.05, 120.0)
        addWatcher(layout3.T3, 1.0, 2.00) //
        addWatcher(layout3.FT4, 1.0, 2.00) //
        addWatcher(layout3.FT3, 1.0, 2.00) //

        // Lipid Report Text Watchers
        val layout4 = binding.lipidReport
        addWatcher(layout4.TotChl, 15.0, 2000.0)
        addWatcher(layout4.HDL, 4.0, 600.0)
        addWatcher(layout4.LDL, 10.0, 1290.0)
        addWatcher(layout4.Triglycerides, 15.0, 1990.0)
    }

}


