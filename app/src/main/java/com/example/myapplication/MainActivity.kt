package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et1 = findViewById<EditText>(R.id.num1)
        val et2 = findViewById<EditText>(R.id.num2)
        val tv1 = findViewById<TextView>(R.id.resultado)
        val bt1 = findViewById<Button>(R.id.boton1)
        val bt2 = findViewById<Button>(R.id.cambio)
        bt1.setOnClickListener {
            tv1.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
        }
    }

    }
