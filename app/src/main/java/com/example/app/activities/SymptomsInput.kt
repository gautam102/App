package com.example.app.activities

import com.example.app.models.SymptomsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivitySymptomsInputBinding
import com.example.app.adapters.SymptomAdapter

class SymptomsInput : AppCompatActivity() {
   private lateinit var binding: ActivitySymptomsInputBinding
    private lateinit var viewModel: SymptomsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySymptomsInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialization of ViewModel
        viewModel = ViewModelProvider(this)[SymptomsViewModel::class.java]

        // Setting up the adapter for displaying symptoms
        val adapter: SymptomAdapter = SymptomAdapter(viewModel.symptomsList)
        binding.symptomsRecyclerView.adapter = adapter
        binding.symptomsRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}