package com.example.app.models

import androidx.lifecycle.ViewModel

class SymptomsViewModel: ViewModel() {
    private fun generate() : ArrayList<Symptom>{
        val symptomsString = """
        severe headaches
chest pain
dizziness
difficulty breathing
nausea
vomiting
blurred vision
other vision changes
anxiety
confusion
buzzing in the ears
nosebleeds
abnormal hearth rhythm
shortness of breath
increased sweating
snoring
tiredness
joint pain
back pain
cold hands and feet
pale mucous membranes
Urinating a lot
Thirst
Losing weight
Have numb or tingling hands or feet
Have very dry skin
Have sores that heal slowly
Have more infections than usual
fatigue
weight gain
trouble tolerating cold
muscle pain
dry skin
dry, thinning hair
heavy or irregular menstrual periods or fertility problems
slowed heart rate
depression
Fast heartbeat, a condition called tachycardia.
Irregular heartbeat, also called arrhythmia.
Pounding of the heart, sometimes called heart palpitations.
Increased hunger.
Nervousness, anxiety and irritability.
Tremor, usually a small trembling in the hands and fingers.
Increased sensitivity to heat.
Changes in bowel patterns, especially more-frequent bowel movements.
Enlarged thyroid gland, sometimes called a goiter, which may appear as a swelling at the base of the neck.
Muscle weakness.
Sleep problems.
skin(moist and thin).
rapid breathing
Fine, brittle hair.
blood in urine
itchy skin
pale skin
coughing
chest tightness
rectal bleeding
fever
delayed growth iin children
eye irritation
skin irritation
joint irritation
persistent diarrhea
abdominal pain
cramps
stress
 ...
    """.trimIndent()

        // Split the string into lines
        val symptomLines = symptomsString.lines()

        // Create an ArrayList to hold the Symptom objects
        val symptomList = ArrayList<Symptom>()

        // Parse the lines and create Symptom objects

        for (line in symptomLines) {
            val symptomName = line.trim() // Remove leading/trailing whitespace
            val symptom = Symptom(symptomName)
            symptomList.add(symptom)
        }

        symptomList.sortBy { it.symptom?.toString() }
        return symptomList
   }
   val symptomsList: ArrayList<Symptom> = generate()

}