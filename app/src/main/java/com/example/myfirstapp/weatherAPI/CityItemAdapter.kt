package com.example.myfirstapp.weatherAPI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R
import kotlinx.android.synthetic.main.item_layout_city.view.*

class CityItemAdapter(val cityList: City, val context: Context) :
    RecyclerView.Adapter<CityItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_layout_city, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.weather__txtContent_name.text = cityList.name
        holder.itemView.weather__txtContent_description.text = cityList.weather[0].description
        holder.itemView.weather__txtContent_temperature.text = cityList.main.temperature.toString()
        holder.itemView.weather__txtContent_temperatureHigh.text = cityList.main.temperatureHigh.toString()
        holder.itemView.weather__txtContent_temperatureLow.text = cityList.main.temperatureLow.toString()
        holder.itemView.weather__txtContent_windSpeed.text = cityList.wind.speed.toString()
        holder.itemView.weather__txtContent_humidity.text = cityList.main.humidity.toString()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}