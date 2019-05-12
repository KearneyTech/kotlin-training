package com.example.myfirstapp.weatherAPI

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name") val name: String,
    @SerializedName("main.temp") val temperature: Double,
    @SerializedName("main.temp_min") val temperatureLow: Double,
    @SerializedName("main.temp_max") val temperatureHigh: Double,
    @SerializedName("weather.description") val description: String,
    @SerializedName("main.humidity") val humidity: Int,
    @SerializedName("wind.speed") val wind: Double
)