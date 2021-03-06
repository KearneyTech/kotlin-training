package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfirstapp.retrofit.RetrofitActivity
import com.example.myfirstapp.utils.log
import com.example.myfirstapp.weatherAPI.WeatherAPIActivity

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun linkActivityAPICall(view: View){
        log("Start linkActivityAPICall")
        val intent = Intent(this, APICallActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun linkActivityMyFirstApp(view: View){
        log("Start linkActivityMyFirstApp")
        val intent = Intent(this, MyFirstAppActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun linkActivityRemoteImage(view: View){
        log("Start linkActivityRemoteImage")
        val intent = Intent(this, RemoteImageActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun linkActivityCoroutineUI(view: View){
        log("Start linkActivityCoroutineUI")
        val intent = Intent(this, CoroutineUIActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun linkActivityRetrofit(view: View){
        log("Start linkActivityRetrofit")
        val intent = Intent(this, RetrofitActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun linkActivityWeatherAPI(view: View){
        log("Start linkActivityWeatherAPI")
        val intent = Intent(this, WeatherAPIActivity::class.java).apply {  }
        startActivity(intent)
    }
}
