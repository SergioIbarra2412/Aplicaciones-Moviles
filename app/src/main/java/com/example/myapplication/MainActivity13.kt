package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity13 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)
        val boton1=findViewById<Button>(R.id.btAl)
        val boton2=findViewById<Button>(R.id.btMa)
        val boton3=findViewById<Button>(R.id.btMat)
        val boton4=findViewById<Button>(R.id.btSal)

        boton1.setOnClickListener {
            val intento1 = Intent(this, MainActivity14::class.java)
            startActivity(intento1)
        }
        boton2.setOnClickListener {
            val intento2 = Intent(this, MainActivity15::class.java)
            startActivity(intento2)
        }
        boton3.setOnClickListener {
            val intento3 = Intent(this, MainActivity16::class.java)
            startActivity(intento3)
        }
        boton4.setOnClickListener {
            finish()
        }
    }
}