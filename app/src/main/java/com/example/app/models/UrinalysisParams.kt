package com.example.app.models

data class UrinalysisParams(
    private val ph: Double?= null,
    private val specificGravity: Double?= null,
    private val glu: Boolean?= null,
    private val ket: Boolean?= null,
    private val blood: Boolean?= null
)
