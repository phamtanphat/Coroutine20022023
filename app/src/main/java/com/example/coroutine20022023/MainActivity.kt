package com.example.coroutine20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView.ViewCacheExtension
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val handler = CoroutineExceptionHandler { _, throwable ->
                Log.d("BBB", throwable.toString())
            }

            val job = CoroutineScope(Dispatchers.Default + handler).launch {
                launch {
                    delay(200)
                    throw NullPointerException()
                }

                launch {
                    delay(100)
                    throw ArithmeticException()
                }

                launch {
                    delay(500)
                    throw NumberFormatException()
                }
            }

            delay(1000)
            job.join()
        }
    }

    suspend fun randomA(): Int {
        delay(1000)
        throw java.lang.NullPointerException()
    }

    suspend fun randomB(): Int {
        delay(1500)
        return Random.nextInt(10)
    }
}
