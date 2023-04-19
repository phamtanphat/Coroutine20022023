package com.example.coroutine20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CoroutineScope(CoroutineName("name1") + Dispatchers.IO + Job()).launch {
            val startTime = System.currentTimeMillis()
            val job = launch(Dispatchers.Default) {
                var nextPrintTime = startTime
                var i = 0
                while (i < 5) { // computation loop, just wastes CPU
                    // print a message twice a second
                    if (isActive) {
                        if (System.currentTimeMillis() >= nextPrintTime) {
                            Log.d("BBB","job: I'm sleeping ${i++} ...")
                            nextPrintTime += 500L
                        }
                    }
                }
            }
            delay(1300L) // delay a bit
            Log.d("BBB","main: I'm tired of waiting!")
            job.cancelAndJoin() // cancels the job and waits for its completion
            Log.d("BBB","main: Now I can quit.")
        }
    }
}
