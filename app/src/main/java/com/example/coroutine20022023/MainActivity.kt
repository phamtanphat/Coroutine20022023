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
            val handler = CoroutineExceptionHandler { _, throwable ->
                Log.d("BBB", throwable.toString())
            }

            val job1 = CoroutineScope(handler).launch {
                throw NullPointerException()
            }

            job1.join()

            val deferred = CoroutineScope(handler).async {
                throw ArithmeticException()
            }

            try {
                deferred.await()
            }catch (e: Exception) {
                Log.d("BBB", "Exception async: ${e.toString()}")
            }
        }

//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                coroutineScope {
//                    val a = async { throw Exception() }
//                    a.join()
//                    a.await()
//                }
//            } catch (e: Exception) {
//                Log.d("BBB", e.toString())
//            }
//        }
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
