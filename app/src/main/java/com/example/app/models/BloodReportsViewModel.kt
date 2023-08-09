import androidx.lifecycle.ViewModel
import com.example.app.models.CBCParams
import com.example.app.models.CMPParams
import com.example.app.models.LipidParams
import com.example.app.models.ThyroidParams

class BloodReportsViewModel : ViewModel() {
    fun generate(): ArrayList<Any> {
     val bloodReportsString = """CBC:
    RBC	4.7 to 6.1 million cells/mcL	4.2 to 5.4 million cells/mcL
    WBC	4,500 to 10,000 cells/mcL
    Hb	13.8 to 17.2 gm/dL	12.1 to 15.1 gm/dL
    Hemaocrit	40.7% to 50.3%	36.1% to 44.3%
    MCV	80 to 95 femtoliter
    Platelet	150,000 to 450,000/dL

    Comprehensive Metabolic Profile:
    Glucose	70-100 mg/dL
    Calcium	8.5-10.2 mg/dL
    Sodium	135-145 nmol/L
    Potassium	3.5-5.0 nmol/L
    Chloride	96-106 nmol/L
    Albumin	6.0-8.3 g/dL
    Total Protein	7.5-8.3 g/dL
    ALP	60-120 IU/L
    ALT	15-55 IU/L
    AST	20-48 IU/L
    Bilirubin	0.7-1.2 mg/dL
    BUN	10-20 mg/dL
    Urea	20-50 mg/dL
    Creatinine	0.9-1.2 mg/dL

    Thyroid Function Test:
    TSH	0.4-5.0 miU/L
    T T4	5-12 microg/dL
    T T3	80-220 ng/dL
    F T4
    F T3

    Lipid Profile:
    Total Cholestrol	150-200 mg/dL
    HDL	40-60
    LDL	100-129
    Triglycerides	150 - 199 mg/dL""".trimIndent()
         val bloodReportLines = bloodReportsString.lines()

        val bloodReports = ArrayList<Any>()

        bloodReports.add(CBCParams(5.6, 1, 1.1, 1.1, 1.1, 1))
        bloodReports.add(CMPParams(12.0))
        bloodReports.add(ThyroidParams(5.6))
        bloodReports.add(LipidParams(5.6))

        return bloodReports
   }
   val bloodReports: ArrayList<Any> = generate()
}
