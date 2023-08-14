package com.example.app.utils

//THYROID TEST
fun thyroidObesity(TSH: Double): Double {
    var res = 0.0
    val wt = 0.2

    if (true) { res+=wt } //TSH check (slight increase)
    return res
}
fun thyroidThyroidism(TSH: Double, T3: Double, T4: Double): Double {
    var res = 0.0
    val wt = 0.333

    if (true) { res+=wt } //TSH check (low) hypo
    if (true) { res+=wt } //T3 check (low) hypo
    if (true) { res+=wt } //T4 check (low) hypo
    return res
}

//LIPID TEST
fun lipidObesity(TC:Double, HDL:Double, LDL:Double, TG:Double): Double {
    var res = 0.0
    val wt = 0.2

    if (true) { res+=wt } //high TC
    if (true) { res+=wt } //high HDL
    if (true) { res+=wt } //high LDL
    if (true) { res+=wt } //high TG
    return res
}
fun lipidCVD(TC:Double, HDL:Double, LDL:Double, TG:Double): Double {
    var res = 0.0
    val wt = 0.1666

    if (true) { res+=wt } //high TC or low
    if (true) { res+=wt } //high HDL or low
    if (true) { res+=wt } //high LDL or low
    if (true) { res+=wt } //high TG or low
    return res
}

//CBC TEST
fun cbcAnemia(RBC: Double, Hb: Double, Hct: Double, MCV: Double): Double {
    var res = 0.0
    val wt = 0.25

    if (true) { res+=wt } //low rbc
    if (true) { res+=wt } //low hb
    if (true) { res+=wt } //low hct
    if (true) { res+=wt } //low mcv
    return res
}

fun cmpDiabetes(glu: Double): Double{
    var res = 0.0
    val wt = 0.33

    if (true) { res+=wt } //high glucose
    return res
}

fun urinalysisDiabetes(glu: Boolean, ket: Boolean): Double{
    var res = 0.0
    val wt = 0.33

    if (glu) { res+=wt } //pos glucose
    if (ket) { res+=wt } //pos ketones
    return res
}