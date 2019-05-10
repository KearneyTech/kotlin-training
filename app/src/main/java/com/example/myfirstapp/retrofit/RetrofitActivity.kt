package com.example.myfirstapp.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapp.R
import com.example.myfirstapp.utils.log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_retrofit.*
import org.json.JSONArray
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        log("RetrofitActivity.onCreate start")

        rv__list_posts.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/").build()

        val postsApi = retrofit.create(INetworkAPI::class.java)

        var response = postsApi.getAllPosts()

        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
            rv__list_posts.adapter = PostItemAdapter(it, this)
        }

        val sampleJson = """
            [
                {
                  "userId": 1,
                  "id": 1,
                  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                  "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
                }
            ]
        """

        var jsonArray = JSONArray(sampleJson)
        for (jsonIndex in 0..(jsonArray.length() - 1)) {
            Log.d("JSON", jsonArray.getJSONObject(jsonIndex).getString("title"))
        }

        var jsonArray2 = Gson().fromJson(sampleJson, JsonArray::class.java)
        for (jsonIndex in 0..(jsonArray2.size() - 1)) {
            Log.d("JSON2", jsonArray.getJSONObject(jsonIndex).getString("title"))
        }
    }
}
