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
import com.example.app.models.CBCParams
import com.example.app.models.CMPParams
import com.example.app.models.LipidParams
import com.example.app.models.ThyroidParams

class BloodReportAdapter(
private val data: List<Any>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class CBCViewHolder(private val binding: CbcDataBinding) : RecyclerView.ViewHolder(binding.root) {
        val RBC  = binding.RBC
    }
    inner class CMPViewHolder(private val binding: CmpDataBinding) : RecyclerView.ViewHolder(binding.root) {
       val Glu = binding.Glucose
    }
    inner class ThyroidViewHolder(private val binding: ThyroidDataBinding) : RecyclerView.ViewHolder(binding.root) {
       val TSH = binding.TSH
    }
    inner class LipidViewHolder(private val binding: LipidDataBinding) : RecyclerView.ViewHolder(binding.root) {
       val TotChl = binding.TotChl
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            0 -> {
                val binding = CbcDataBinding.inflate(inflater, parent, false)
                CBCViewHolder(binding)
            }
            1 -> {
                val binding = CmpDataBinding.inflate(inflater, parent, false)
                CMPViewHolder(binding)
            }
            2 -> {
                val binding = ThyroidDataBinding.inflate(inflater, parent, false)
                ThyroidViewHolder(binding)
            }
            3 -> {
                val binding = LipidDataBinding.inflate(inflater, parent, false)
                LipidViewHolder(binding)
            }
            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        when (holder) {
            is CBCViewHolder -> {
                val cbcViewHolder = holder as CBCViewHolder
                val info = item as CBCParams
                cbcViewHolder.RBC.text = info.WBC.toString()
            }
            is CMPViewHolder -> {
                val cmpViewHolder = holder as CMPViewHolder
                val info = item as CMPParams
                cmpViewHolder.Glu.text = info.Glu.toString()
            }
            is ThyroidViewHolder -> {
                val thyroidViewHolder = holder as ThyroidViewHolder
                val info = item as ThyroidParams
                thyroidViewHolder.TSH.text = info.TSH.toString()
            }
            is LipidViewHolder -> {
                val lipidViewHolder = holder as LipidViewHolder
                val info = item as LipidParams
                lipidViewHolder.TotChl.text = info.TotChol.toString()
            }
            else -> throw IllegalArgumentException("Invalid ViewHolder type")
        }
    }

}