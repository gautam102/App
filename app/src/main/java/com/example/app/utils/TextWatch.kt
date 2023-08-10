package com.example.app.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class RangeTextWatcher(
    private val editText: EditText,
    private val minValue: Double,
    private val maxValue: Double
) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Not needed
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // Not needed
    }

    override fun afterTextChanged(s: Editable?) {
        val input = s.toString()
        try {
            val value = input.toDouble()
            if (!isInRange(value)) {
                editText.error = "Invalid input. Must be between $minValue and $maxValue."
            } else {
                editText.error = null
            }
        } catch (e: NumberFormatException) {
            editText.error = "Invalid input."
        }
    }

    private fun isInRange(value: Double): Boolean {
        return value in minValue..maxValue
    }

}

class BinaryTextWatcher(
    private val editText: EditText,
    private val type: String?= null,
) : TextWatcher {

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(s: Editable?) {
        val input = s.toString()
    }
}
fun addWatcher(ET: EditText, min: Double, max: Double) {
    ET.addTextChangedListener(RangeTextWatcher(ET, min, max))
}