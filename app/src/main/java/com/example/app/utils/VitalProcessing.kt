package com.example.app.utils

import com.example.app.models.BP

private fun vitalsObesity(bmi: Double, pr: Int): Double{
    var res: Double = 0.0
    val wt: Double = 0.5 // weightage

    //conditions
    if(bmi > 30) { res += wt } //bmi check
    if(pr > 100) { res+= wt } //pulse rate check
    return res //return result
}

private fun vitalsHTN(bmi: Double, bp: BP,temp: Double, pr: Int, br: Int, age: Int): Double{
    var res: Double = 0.0
    val wt: Double = 0.3 // weightage

    //conditions
    if (bmi > 30) { res += wt } //bmi check
    if (bp.sys > 120 && bp.di > 80) { res += wt } //hypertension check
    if (bp.sys > 120 && bp.di > 80) { res += wt } //hypotension check
    if (pr > 100) { res += wt } // pulse rate check
    if (age > 5) { res += wt } // age check
    return res //return result
}

private fun vitalsDiabetes(bmi: Double, pr: Int): Double{
    var res: Double = 0.0
    val wt: Double = 0.5 //weightage

    //conditions
    if(bmi > 30) { res += wt } //bmi check
    if(pr > 100) { res += wt } //pulse rate check
    return res
}

private fun vitalsThyroidism(bmi: Double, temp: Double, pr: Int) : Double{
    var res: Double = 0.0
    val wt: Double = 0.33 //weightage

   //conditions
   if(bmi > 30) { res += wt } //bmi check
   if(temp > 38) { res += wt } //temp check
   if(pr > 100) { res += wt } //pulse Rate check
   return res
}

private fun vitalsCVD(bmi: Double, temp: Double, pr: Int): Double{
    var res: Double = 0.0
    val wt: Double = 0.33 //weightage

    if(bmi > 30) { res += wt } //bmi check
    if(temp >= 40) { res += wt } //temp check
    if(pr > 100 || pr < 60) { res += wt } //pulse Rate check
    return res
}

private fun vitalsAnemia(bmi: Double, temp: Double, pr: Int): Double {
    var res: Double = 0.0
    val wt: Double = 0.33 //weightage

    //conditions
    if(bmi < 18.5) { res += wt } //bmi check
    if(temp <= 36) { res += wt } //temp check
    if(pr > 100 || pr < 60) { res += wt } //pulse Rate check
    return res
}
