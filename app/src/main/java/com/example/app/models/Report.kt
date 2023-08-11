package com.example.app.models

data class Report(
    private val cbc:CBCParams?= null,
    private val cmp:CMPParams?= null,
    private val thyroid:ThyroidParams?= null,
    private val lipid:LipidParams?= null,
    private val urinalysis:UrinalysisParams?= null,
    private val vitals:VitalParams?= null
)
