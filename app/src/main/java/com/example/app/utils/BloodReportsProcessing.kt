package com.example.app.utils

//THYROID TEST
fun thyroidObesity(TSH: Double): Double {
    var res = 0.0
    val wt = 0.2

    if (TSH>4.0) { res+=wt } //TSH check (slight increase)
    return res
}
fun thyroidThyroidism(TSH: Double, T3: Double, T4: Double): Double {
    var res = 0.0
    val wt = 0.333

    if (TSH<0.4) { res+=wt } //TSH check (low) hypo
    if (T3<60) { res+=wt } //T3 check (low) hypo
    if (T4<5) { res+=wt } //T4 check (low) hypo
    return res
}

//LIPID TEST
fun lipidObesity(TC:Double, HDL:Double, LDL:Double, TG:Double): Double {
    var res = 0.0
    val wt = 0.2

    if (TC>150) { res+=wt } //high TC
    if (HDL>60) { res+=wt } //high HDL
    if (LDL>129) { res+=wt } //high LDL
    if (TG>199) { res+=wt } //high TG
    return res
}
fun lipidCVD(TC:Double, HDL:Double, LDL:Double, TG:Double): Double {
    var res = 0.0
    val wt = 0.1666

    if (TC>200) { res+=wt } //high TC or low
    if (HDL>600) { res+=wt } //high HDL or low
    if (LDL>129) { res+=wt } //high LDL or low
    if (TG>199) { res+=wt } //high TG or low
    return res
}

//CBC TEST
fun cbcAnemia(RBC: Double, Hb: Double, Hct: Double, MCV: Double, Sex: String): Double {
    var res = 0.0
    val wt = 0.25

    if(Sex=="M"){
        if (RBC<4.7) { res+=wt } //male low rbc
        if (Hb<13.8) { res+=wt } //male low hb
        if (Hct<40.7) { res+=wt } //male low hct
    } else {
        if (RBC<4.2) { res+=wt } //female low rbc
        if (Hb<12.1) { res+=wt } //fm low hb
        if (Hct<36.1){ res+=wt } //fm low hct
    }
    if (MCV<80) { res+=wt } //low mcv
    return res
}

// CMP TEST
fun cmpDiabetes(glu: Double): Double{
    var res = 0.0
    val wt = 0.33

    if (glu>100) { res+=wt } //high glucose
    return res
}

//

// URINALYSIS TEST
fun urinalysisDiabetes(glu: Boolean, ket: Boolean): Double{
    var res = 0.0
    val wt = 0.33

    if (glu) { res+=wt } //pos glucose
    if (ket) { res+=wt } //pos ketones
    return res
}


