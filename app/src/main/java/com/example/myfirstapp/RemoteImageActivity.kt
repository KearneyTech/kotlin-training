package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_remote_image.*

class RemoteImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remote_image)

        val url1 = "https://imgur.com/RnKrY7q.jpg"

        Picasso.get().load(url1).into(imageView_remote_image)
    }
}
