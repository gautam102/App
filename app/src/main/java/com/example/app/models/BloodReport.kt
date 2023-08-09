package com.example.app.models

sealed class BloodReport {
      data class CBCReport(val params: CBCParams) : BloodReport()
      data class CMPReport(val params: CMPParams) : BloodReport()
      data class LipidReport(val params: LipidParams) : BloodReport()
      data class ThyroidReport(val params: ThyroidParams) : BloodReport()
}