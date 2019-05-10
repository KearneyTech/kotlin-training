package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myfirstapp.utils.log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineUIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_ui)
        log("CoroutineUIActivity.onCreate start")

        val textView = findViewById<TextView>(R.id.textView_content_coroutine_ui)
        val fab = findViewById<FloatingActionButton>(R.id.fab_coroutine_ui)
        setup(textView, fab)
    }

    fun setup(content: TextView, fab: FloatingActionButton) {
        val job = GlobalScope.launch(Dispatchers.Main) {
            for (i in 10 downTo 1) {
                content.text = "Countdown $i ..."
                delay(500)
            }
            content.text = "Done!"
        }

        fab.setOnClickListener {
            log("Cancelling")
            job.cancel()
        }
    }
}
