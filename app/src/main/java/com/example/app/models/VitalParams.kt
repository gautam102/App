package com.example.app.models

data class VitalParams(
    private val name: String?= null,
    private val age: Int?= null,
    private val gender: Boolean?= null,
    private val wt: Double?= null,
    private val ht: Double?= null,
    private val bp: BP?= null,
    private val temp: Double?= null,
    private val pulseRate: Int?= null,
    private val breathingRate: Int?= null
)

data class BP(
    val sys: Int,
    val di: Int
)
