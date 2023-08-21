package com.example.app.adapters
import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.SymptomBinding
import com.example.app.models.Symptom

class SymptomAdapter(
    var Symptoms: MutableLiveData<ArrayList<Symptom>>,
): RecyclerView.Adapter<SymptomAdapter.SymptomAdapterViewHolder>() {
    // vars
    private val selectedSymptomsArray = ArrayList<Symptom>()

    // symptom viewholder class
    inner class SymptomAdapterViewHolder(private val binding:SymptomBinding) : RecyclerView.ViewHolder(binding.root) {
        //views to be held
        val symptom = binding.symptomTV
        val checkbox = binding.checkbox
    }

    // Method to get selected symptoms
    fun getSelectedSymptoms(): ArrayList<Symptom> {
        return selectedSymptomsArray
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // the inflater passed here has taken symptombinding as its context
        val binding = SymptomBinding.inflate(inflater, parent, false)
        // the inflated vew is passed to the symptom viewholder class (the view here is the symptom.xml)
        return SymptomAdapterViewHolder(binding)
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun getItemCount(): Int {
        val size =  Symptoms.value?.size ?: 0
        Log.d(TAG, "getItemCount: $size")
        return size
    }
    override fun onBindViewHolder(holder: SymptomAdapterViewHolder, position: Int) {
        val symptomList = Symptoms.value // Get the LiveData value
        val currentSymptom = symptomList?.get(position)
        Log.d(TAG, "holder set checked: ${currentSymptom?.checked}, position: $position" )

        currentSymptom?.let {
            holder.symptom.text = it.symptom

            // Set the checkbox state without changing the listener if the state has changed
            if (holder.checkbox.isChecked != it.checked) {
                holder.checkbox.isChecked = it.checked
            }

            // Remove the previous listener before setting a new one
            holder.checkbox.setOnCheckedChangeListener(null)

            // Set the new listener only if the symptom's state is changed by the user
            holder.checkbox.setOnCheckedChangeListener { _, isChecked ->
                // Update the checked status of the currentSymptom
                it.checked = isChecked

                // Update the selected symptoms array
                if (isChecked) {
                    selectedSymptomsArray.add(it)
                } else {
                    selectedSymptomsArray.remove(it)
                }
                val checkboxStatus = "Checkbox is checked: $isChecked, Symptom is checked: ${it.checked}"
                Log.d(TAG, "$checkboxStatus")
            }
        }
    }
}

