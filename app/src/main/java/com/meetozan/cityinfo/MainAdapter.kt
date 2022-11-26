package com.meetozan.cityinfo

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meetozan.cityinfo.databinding.CityCardBinding

class MainAdapter(private val cityList: List<City>, private val context: Context) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    class ViewHolder(binding: CityCardBinding) : RecyclerView.ViewHolder(binding.root) {

        val cityBinding: CityCardBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CityCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cityList[position]
        holder.cityBinding.cityCard = city


        holder.cityBinding.cardCity.setOnClickListener {
            mContext = context
            val dialog = LayoutInflater.from(mContext).inflate(R.layout.custom_dialog, null)
            val builder = AlertDialog.Builder(mContext).setView(dialog).show()
            builder.setCancelable(true)

            val txtName = dialog.findViewById<TextView>(R.id.alertName)
            txtName.text = city.name

            val txtNumber = dialog.findViewById<TextView>(R.id.alertNumber)
            txtNumber.text = city.number

            val txtPopulation = dialog.findViewById<TextView>(R.id.alertPopulation)
            txtPopulation.text = city.population.toString()

            val txtRegion = dialog.findViewById<TextView>(R.id.alertRegion)
            txtRegion.text = city.region

            val txtMajor = dialog.findViewById<TextView>(R.id.alertMajor)
            txtMajor.text = city.major

            val txtFood = dialog.findViewById<TextView>(R.id.alertFood)
            txtFood.text = city.food

            val imageBack = dialog.findViewById<ImageView>(R.id.imageBack)
            imageBack.setOnClickListener {
                builder.dismiss()
            }
        }
    }

    override fun getItemCount(): Int = cityList.size
}