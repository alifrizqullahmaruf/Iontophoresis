package com.example.iontophoresis.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iontophoresis.Model.Doctor
import com.example.iontophoresis.Model.Hospital
import com.example.iontophoresis.databinding.DoctorCardBinding
import com.example.iontophoresis.databinding.HospitalCardBinding


typealias onClickDoctorCard = (Doctor)->Unit
class AdapterDoctorActivity(private var DoctorList:List<Doctor>,private val onClick: onClickDoctorCard): RecyclerView.Adapter<AdapterDoctorActivity.DoctorViewHolder>() {
    inner class DoctorViewHolder(private val binding: DoctorCardBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(data:Doctor){
            with(binding){
                doctorName.text=data.Name
                specialist.text=data.Specialist
                location.text=data.Location
                rating.text="${data.Rating} | (${data.Reviewers})"
                Glide.with(itemView.context).load(data.Image).centerCrop().into(image)
                itemView.setOnClickListener {
                    onClick(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val binding= DoctorCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DoctorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return DoctorList.size
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(DoctorList[position])
    }
}