package com.example.app.utils

import com.example.app.models.BP

fun vitalsObesity(BMI: Double?, PR: Int?): Double{
    var res: Double = 0.0
    val wt: Double = 0.5 // weightage

    val bmi = BMI ?: 30.0
    val pr = PR ?: 100

    //conditions
    if(bmi > 30) { res += wt } //BMI check
    if(pr > 100) { res += wt } //pulse rate check
    return res //return result
}

fun vitalsHTN(BMI: Double?, BP: BP?,TEMP: Double?, PR: Int?, AGE: Int?): Double{
    var res: Double = 0.0
    val wt: Double = 0.3 // weightage

    val bmi = BMI ?: 30.0
    val pr = PR ?: 100
    val bp = BP ?: BP(90, 120)
    val temp = TEMP ?: 38.0
    val age = AGE ?: 65

    //conditions
    if (bmi > 30) { res += wt } //BMI check
    if (bp.sys > 120 && bp.di > 80) { res += wt } //hypertension check
    if (temp > 38) { res += wt } //TEMP check || VERIFY
    if (pr > 100) { res += wt } // pulse rate check
    if (age > 65) { res += wt } // age check
    return res //return result
}

fun vitalsDiabetes(BMI: Double?, PR: Int?): Double{
    var res: Double = 0.0
    val wt: Double = 0.5 //weightage

    val bmi = BMI ?: 30.0
    val pr = PR ?: 100

    //conditions
    if(bmi > 30) { res += wt } //BMI check
    if(pr > 100) { res += wt } //pulse rate check
    return res
}

fun vitalsThyroidism(BMI: Double?, TEMP: Double?, PR: Int?) : Double{
    var res: Double = 0.0
    val wt: Double = 0.33 //weightage

    val pr = PR ?: 100
    val bmi = BMI ?: 30.0
    val temp = TEMP ?: 38.0

   //conditions
   if(bmi > 30) { res += wt } //BMI check
   if(temp > 38) { res += wt } //TEMP check
   if(pr < 60) { res += wt } //pulse Rate check
   return res
}

fun vitalsCVD(BMI: Double?, TEMP: Double?, PR: Int?): Double{
    var res: Double = 0.0
    val wt: Double = 0.33 //weightage

    val temp = TEMP ?: 38.0
    val bmi = BMI ?: 30.0
    val pr = PR ?: 100

    if(bmi > 30) { res += wt } //BMI check
    if(temp >= 40) { res += wt } //TEMP check
    if(pr> 100 || pr< 60) { res += wt } //pulse Rate check
    return res
}

fun vitalsAnemia(BMI: Double?, TEMP: Double?, PR: Int?): Double {
    var res: Double = 0.0
    val wt: Double = 0.33 //weightage

    val temp = TEMP ?: 38.0
    val bmi = BMI ?: 30.0
    val pr = PR ?: 100

    //conditions
    if(bmi < 18.5) { res += wt } //BMI check
    if(temp <= 36) { res += wt } //TEMP check
    if(pr > 100) { res += wt } //pulse Rate check
    return res
}
