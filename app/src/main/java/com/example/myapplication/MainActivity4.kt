package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val tv1=findViewById<TextView>(R.id.texto)
        val boton1=findViewById<ImageButton>(R.id.image)
        boton1.setOnClickListener {
            tv1.text="Llamando"
        }
    }
}