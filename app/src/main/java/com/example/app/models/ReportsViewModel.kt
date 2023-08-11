package com.example.app.models

import androidx.lifecycle.ViewModel

class ReportsViewModel(
    private val cbc:CBCParams?= null,
    private val cmp:CMPParams?= null,
    private val thyroid:ThyroidParams?= null,
    private val lipid:LipidParams?= null,
    private val urinalysis:UrinalysisParams?= null,
    private val vitals:VitalParams?= null
): ViewModel() {


}