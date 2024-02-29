package com.example.iontophoresis.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iontophoresis.Model.Hospital
import com.example.iontophoresis.databinding.HospitalCardBinding


class AdapterHospitalActivity (private var HospitalList:List<Hospital>):RecyclerView.Adapter<AdapterHospitalActivity.HospitalViewHolder>() {
    inner class HospitalViewHolder (private val binding: HospitalCardBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Hospital){
            with(binding){
                hospitalName.text=data.Name
                hospitalLocation.text=data.Location
                nmbRating.text=data.Rating
//                ratingStars.numStars=data.Rating.toInt()
                Glide.with(itemView.context).load(data.Image).centerCrop().into(imgHospital)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        val binding=HospitalCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HospitalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return HospitalList.size
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bind(HospitalList[position])
    }
}