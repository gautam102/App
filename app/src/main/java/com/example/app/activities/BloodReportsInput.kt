package com.example.app.activities

import BloodReportsViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.ActivityBloodReportsInputBinding

class BloodReportsInput : AppCompatActivity() {
   private lateinit var binding: ActivityBloodReportsInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBloodReportsInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bloodReportsViewModel = ViewModelProvider(this).get(BloodReportsViewModel::class.java)

    }
}