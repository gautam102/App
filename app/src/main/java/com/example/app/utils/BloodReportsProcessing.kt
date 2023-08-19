package com.example.app.utils

import android.content.ContentValues.TAG
import android.util.Log

//THYROID TEST
fun thyroidObesity(TSH: Double?): Double {
    var res = 0.0
    val wt = 0.2

    val tsh = TSH ?: 4.0

    if (tsh>4.0) { res+=wt } //TSH check (slight increase)
    return res
}
fun thyroidThyroidism(TSH: Double?, T3: Double?, T4: Double?): Double {
    var res = 0.0
    val wt = 0.333

    val tsh = TSH ?: 0.4
    val t4 = T3 ?: 60.0
    val t3 = T4 ?: 5.0

    if (tsh<0.4) { res+=wt } //TSH check (low) hypo
    if (t3<60) { res+=wt } //T3 check (low) hypo
    if (t4<5) { res+=wt } //T4 check (low) hypo
    return res
}

//LIPID TEST
fun lipidObesity(TC:Double?, HDL:Double?, LDL:Double?, TG:Double?): Double {
    var res = 0.0
    val wt = 0.2

    val tc = TC ?: 150.0
    val hdl = HDL ?: 60.0
    val ldl = LDL ?: 129.0
    val tg = TG ?: 150.0

    Log.d(TAG, "TC VALUE: $TC \n HDL VALUE: $HDL")
    if (tc>200) { res+=wt } //high TC
    if (hdl>60) { res+=wt } //high HDL
    if (ldl>129) { res+=wt } //high LDL
    if (tg>150) { res+=wt } //high TG
    return res
}
fun lipidCVD(TC:Double?, HDL:Double?, LDL:Double?, TG:Double?): Double {
    var res = 0.0
    val wt = 0.1666

    val tc = TC ?: 150.0
    val hdl = HDL ?: 60.0
    val ldl = LDL ?: 129.0
    val tg = TG ?: 150.0

    if (tc>200) { res+=wt } //high TC or low
    if (hdl>60) { res+=wt } //high HDL or low
    if (ldl>129) { res+=wt } //high LDL or low
    if (tg>150) { res+=wt } //high TG or low
    return res
}

//CBC TEST
fun cbcAnemia(RBC: Double?, Hb: Double?, Hct: Double?, MCV: Double?, Sex: String?): Double {
    var res = 0.0
    val wt = 0.25

    val rbc = RBC ?: 4.7
    val hb = Hb ?: 13.8
    val hct = Hct ?: 40.7
    val mcv = MCV ?: 80.0
    val sex = Sex ?: "M"

    if(Sex=="M"){
        if (rbc<4.7) { res+=wt } //male low rbc
        if (hb<13.8) { res+=wt } //male low hb
        if (hct<40.7) { res+=wt } //male low hct
    } else {
        if (rbc<4.2) { res+=wt } //female low rbc
        if (hb<12.1) { res+=wt } //fm low hb
        if (hct<36.1){ res+=wt } //fm low hct
    }
    if (mcv<80) { res+=wt } //low mcv
    return res
}

// CMP TEST
fun cmpDiabetes(Glu: Double?): Double{
    var res = 0.0
    val wt = 0.33

    val glu = Glu ?: 140.0

    if (glu>140) { res+=wt } //high glucose
    return res
}


// URINALYSIS TEST
fun urinalysisDiabetes(Glu: Boolean?, Ket: Boolean?): Double{
    var res = 0.0
    val wt = 0.33

    val glu = Glu ?: false
    val ket = Ket ?: false

    if (glu) { res+=wt } //pos glucose
    if (ket) { res+=wt } //pos ketones
    return res
}

fun cmpCVD(ALT: Double?, AST:Double?): Double{
    var res = 0.0
    val wt = 0.1666

    val alt = ALT ?: 55.0
    val ast = AST ?: 48.0

    if(alt>55.0){ res += wt }
    if(ast>48.0) {res += wt }
    return res
}

