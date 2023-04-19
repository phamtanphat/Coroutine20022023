package com.example.coroutine20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            var a = async { randomA() }

            var b = async { randomB() }

            var c = a.await() + b.await()

            Log.d("BBB", a.await().toString())
            Log.d("BBB", b.await().toString())
            Log.d("BBB", c.toString())
        }
    }

    suspend fun randomA(): Int {
        delay(1000)
        return Random.nextInt(10)
    }

    suspend fun randomB(): Int {
        delay(1500)
        return Random.nextInt(10)
    }
}
