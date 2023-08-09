package com.example.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.CbcDataBinding
import com.example.app.databinding.CmpDataBinding
import com.example.app.databinding.LipidDataBinding
import com.example.app.databinding.ThyroidDataBinding
import com.example.app.models.BloodReport
import com.example.app.models.BloodReportsViewModel

class BloodReportAdapter(
    private val items: List<Any>
): RecyclerView.Adapter<SymptomAdapter.SymptomAdapterViewHolder>() {

    inner class CBCAdapterViewHolder(private val binding: CbcDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /*val age = itemView.findViewById<TextView>(R.id.patientAge)*/
        val WBC = binding.RBC
    }
    inner class CMPAdapterViewHolder(private val binding: CmpDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val Glu = binding.Glucose
    }
    inner class ThyroidAdapterViewHolder(private val binding: ThyroidDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val TSH = binding.TSH
    }
    inner class LipidAdapterViewHolder(private val binding: LipidDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
            val TotChl = binding.TotChl
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
           0 -> {
               val binding = CbcDataBinding.inflate(inflater, parent, false)
               CBCAdapterViewHolder(binding)
           }
           1 -> {
               val binding = CmpDataBinding.inflate(inflater, parent, false)
               CMPAdapterViewHolder(binding)
           }
           2 -> {
               val binding = ThyroidDataBinding.inflate(inflater, parent, false)
               ThyroidAdapterViewHolder(binding)
           }
           3 -> {
               val binding = LipidDataBinding.inflate(inflater, parent, false)
               LipidAdapterViewHolder(binding)
           }
           else -> {
               throw IllegalArgumentException("Unknown view type")
           }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.apply {
            /*holder.age.text = Patients[position].age.toString()*/
            when(holder) {
                is CBCAdapterViewHolder -> {
                    val item = items[position] as BloodReport.CBCReport
                }
                is CMPAdapterViewHolder -> {
                    holder.Glu

                }
                is ThyroidAdapterViewHolder -> {

                }
                is LipidAdapterViewHolder -> {

                }
                else -> {
                    throw IllegalArgumentException("Unknown view holder type")
                }

            }
        }
    }
}