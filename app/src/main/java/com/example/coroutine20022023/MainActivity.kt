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

//        CoroutineScope(Dispatchers.IO).launch {
//            val handler = CoroutineExceptionHandler { _, throwable ->
//                Log.d("BBB", throwable.toString())
//            }
//
//            CoroutineScope(handler).launch{
//                throw NullPointerException()
//            }
//
//            CoroutineScope(handler).launch {
//                throw AssertionError()
//            }
//        }

//        CoroutineScope(Dispatchers.IO).launch   {
//            val a = async { throw Exception() }
//            try {
//                a.await()
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
