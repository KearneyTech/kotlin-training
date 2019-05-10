package com.example.myfirstapp.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface INetworkAPI {
    @GET("posts/")
    fun getAllPosts(): Observable<List<Post>>
}