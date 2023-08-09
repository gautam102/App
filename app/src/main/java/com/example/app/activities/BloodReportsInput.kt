package com.example.app.activities
import BloodReportsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        addWatcher(binding.RBC, 1.0, 2.00)
        addWatcher(binding.WBC, 4500.00, 10000.00)
        addWatcher(binding.Hb, 1.0, 2.00)
        addWatcher(binding.Hct, 1.0, 2.00)
        addWatcher(binding.MCV, 80.0, 95.00)
        addWatcher(binding.Plt, 150000.0, 450000.00)

       // CMP Report Text Watchers
        addWatcher(binding.Glu, 70.0, 100.00)
        addWatcher(binding.Cal, 8.2, 10.20)
        addWatcher(binding.Sodium, 135.0, 145.00)
        addWatcher(binding.Hb, 3.5, 5.00)
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


