package com.example.myfirstapp.weatherAPI

import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {
    @GET("weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
    fun getCity(): Observable<City>
}