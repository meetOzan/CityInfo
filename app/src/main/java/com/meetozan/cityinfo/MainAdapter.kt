package com.meetozan.cityinfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.cityinfo.databinding.CityCardBinding

class MainAdapter(private val cityList: List<City>) : RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    class ViewHolder(binding: CityCardBinding):RecyclerView.ViewHolder(binding.root){
        val cityBinding : CityCardBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CityCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cityList[position]
        holder.cityBinding.cityCard = city

    }

    override fun getItemCount(): Int = cityList.size
}