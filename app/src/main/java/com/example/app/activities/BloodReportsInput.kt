package com.example.app.activities
// 1
import BloodReportsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.app.databinding.ActivityBloodReportsInputBinding
// 2
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.app.utils.RangeTextWatcher
import com.example.app.utils.addWatcher

// 3
class BloodReportsInput : AppCompatActivity() {
   private lateinit var binding: ActivityBloodReportsInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBloodReportsInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bloodReportsViewModel = ViewModelProvider(this)[BloodReportsViewModel::class.java]

        // CBC Report Text Watchers
        for (i in 1..20){

        }

        // CBC Report Text Watchers
        addWatcher(binding.RBC, 1.0, 2.00)
        addWatcher(binding.WBC, 1.0, 2.00)
        addWatcher(binding.Hb, 1.0, 2.00)
        addWatcher(binding.Hct, 1.0, 2.00)
        addWatcher(binding.MCV, 1.0, 2.00)
        addWatcher(binding.Plt, 1.0, 2.00)

       // CMP Report Text Watchers
        addWatcher(binding.Glu, 1.0, 2.00)
        addWatcher(binding.Cal, 1.0, 2.00)
        addWatcher(binding.Sodium, 1.0, 2.00)
        addWatcher(binding.Hb, 1.0, 2.00)
        addWatcher(binding.Pot, 1.0, 2.00)
        addWatcher(binding.Chl, 1.0, 2.00)
        addWatcher(binding.Alb, 1.0, 2.00)
        addWatcher(binding.TotPrt, 1.0, 2.00)
        addWatcher(binding.ALP, 1.0, 2.00)
        addWatcher(binding.ALT, 1.0, 2.00)
        addWatcher(binding.AST, 1.0, 2.00)
        addWatcher(binding.Bil, 1.0, 2.00)
        addWatcher(binding.BUN, 1.0, 2.00)
        addWatcher(binding.Urea, 1.0, 2.00)
        addWatcher(binding.Creatinine, 1.0, 2.00)

        // Thyroid Report Text Watchers
        addWatcher(binding.TSH, 1.0, 2.00)
        addWatcher(binding.T4, 1.0, 2.00)
        addWatcher(binding.T3, 1.0, 2.00)
        addWatcher(binding.FT4, 1.0, 2.00)
        addWatcher(binding.FT3, 1.0, 2.00)

        // Lipid Report Text Watchers
        addWatcher(binding.TotChl, 1.0, 2.00)
        addWatcher(binding.HDL, 1.0, 2.00)
        addWatcher(binding.LDL, 1.0, 2.00)
        addWatcher(binding.Triglycerides, 1.0, 2.00)

    }

}



