package com.example.app.activities

import BloodReportsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.adapters.BloodReportAdapter
import com.example.app.databinding.ActivityBloodReportsInputBinding

class BloodReportsInput : AppCompatActivity() {
   private lateinit var binding: ActivityBloodReportsInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBloodReportsInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bloodReportsViewModel = ViewModelProvider(this).get(BloodReportsViewModel::class.java)

        // Initialize and set the adapter
        val adapter: BloodReportAdapter = BloodReportAdapter(bloodReportsViewModel.bloodReports)
        binding.bloodReportsRV.adapter = adapter
        binding.bloodReportsRV.layoutManager = LinearLayoutManager(this)
    }
}