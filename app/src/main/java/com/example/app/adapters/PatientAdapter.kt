package com.example.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.Patient

class PatientAdapter(
    var Patients: ArrayList<Patient>,
): RecyclerView.Adapter<PatientAdapter.PatientAdapterViewHolder>() {

    inner class PatientAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*val age = itemView.findViewById<TextView>(R.id.patientAge)*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.patient, parent, false)
        return PatientAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Patients.size
    }

    override fun onBindViewHolder(holder: PatientAdapterViewHolder, position: Int) {
        holder.itemView.apply {
            /*holder.age.text = Patients[position].age.toString()*/

        }
    }
}
