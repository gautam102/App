package com.example.app.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.Symptom
import com.example.app.databinding.SymptomBinding

class SymptomAdapter(
    var Symptoms: ArrayList<Symptom>,
): RecyclerView.Adapter<SymptomAdapter.SymptomAdapterViewHolder>() {

    // symptom viewholder class
    inner class SymptomAdapterViewHolder(private val binding:SymptomBinding) : RecyclerView.ViewHolder(binding.root) {
        //views to be held
        val symptom = binding.symptomTV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        // the inflater passed here has taken symptombinding as its context
        val binding = SymptomBinding.inflate(inflater, parent, false)

        // the inflated vew is passed to the symptom viewholder class (the view here is the symptom.xml)
        return SymptomAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Symptoms.size
    }

    override fun onBindViewHolder(holder: SymptomAdapterViewHolder, position: Int) {
        holder.itemView.apply {
            //data from the array recieved from the activity is bound to the views that were held
            //when the adapter was created
            holder.symptom.text = Symptoms[position].symptom
        }
    }
}
