package com.example.coroutine20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.recyclerview.widget.RecyclerView.ViewCacheExtension
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            for (element in 1..10) {
                delay(100)
            }

            withContext(Dispatchers.Main) {
                Toast.makeText(this@MainActivity, "Finish", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
