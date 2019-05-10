package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myfirstapp.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class APICallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        log("APICallActivity.onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apicall)
        val textView = findViewById<TextView>(R.id.textView_data)

        fetchAPI(textView)
    }

    fun fetchAPI(textView: TextView): String {

        val url2 = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val client = OkHttpClient()
        val request = Request.Builder().url(url2).build()
        var returnString = ""
        val job = GlobalScope.launch(Dispatchers.Main) {
            log("Start fetchAPI")

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    log("Failed to fetch API.")
                    log(e.message ?: "No error message")
                    returnString = ""
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseString = response.body()?.string()
                    response.body()?.close()
                    returnString = responseString ?: ""
                    textView.text = returnString
                    log(returnString ?: "API response is null")

                    /*
                val textView = findViewById<TextView>(R.id.textView_data).apply {
                    text = responseString
                }*/
                }
            })
        }

        return returnString
    }
}
