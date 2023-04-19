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
            Log.d("BBB", "Coroutine parent ${Thread.currentThread().name}")

            val job = launch {
                Log.d("BBB", "Coroutine 1 ${Thread.currentThread().name}")
                for (element in 1..1000) {
                    Log.d("BBB", "Coroutine 1 $element")
                    delay(50)
                }
            }

            job.join()
            val job2 = launch {
                Log.d("BBB", "Coroutine 2 ${Thread.currentThread().name}")
                for (element in 1..1000) {
                    Log.d("BBB", "Coroutine 2 $element")
                    delay(50)
                }
            }

            Log.d("BBB", "Job $job")
        }
    }
}
