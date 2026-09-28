package com.example.a24012011120_mad_practical6

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<FloatingActionButton>(R.id.Play_btn).setOnClickListener {
            Intent(applicationContext, MyService::class.java).putExtra(MyService.SERVICE_DATA, MyService.SERVICE_KEY).also{
                startService(it)
            }
        }
        findViewById<FloatingActionButton>(R.id.pause_btn).setOnClickListener {
            Intent(applicationContext, MyService::class.java).also{
                stopService(it)
            }
        }
    }
}