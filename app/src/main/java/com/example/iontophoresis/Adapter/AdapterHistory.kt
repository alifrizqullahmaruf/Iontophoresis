package com.example.iontophoresis.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iontophoresis.Model.Treatment
import com.example.iontophoresis.databinding.HistoryDosisCardBinding

typealias Delete = (Treatment)->Unit
typealias Details = (Treatment)->Unit
class AdapterHistory (private var HistoryList:List<Treatment>, private val onDelete: Delete, private val onDetails: Details): RecyclerView.Adapter<AdapterHistory.HistoryViewHolder>() {
    inner class HistoryViewHolder(private val binding: HistoryDosisCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Treatment){
            with(binding){
                doctorName.text=data.DoctorNamme
                specialist.text=data.SpecializeDoctor
                location.text=data.Hospital
                historyTime.text=data.Date.toString()
                Glide.with(itemView.context).load(data.Image).centerCrop().into(image)
                btnDelete.setOnClickListener {
                    onDelete(data)
                }
                btnDetails.setOnClickListener {
                    onDetails(data)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding= HistoryDosisCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HistoryViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return HistoryList.size
    }
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(HistoryList[position])
    }
}