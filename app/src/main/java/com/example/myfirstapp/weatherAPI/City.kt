package com.example.myfirstapp.weatherAPI

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("name") val name: String,
    @SerializedName("main") val main: Main,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("wind") val wind: Wind
)

data class Weather (
    @SerializedName("description") val description: String
)

data class Main (
    @SerializedName("temp") val temperature: Double,
    @SerializedName("temp_min") val temperatureLow: Double,
    @SerializedName("temp_max") val temperatureHigh: Double,
    @SerializedName("humidity") val humidity: Int
)

data class Wind (
    @SerializedName("speed") val speed: Double
)