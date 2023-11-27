package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val tv1=findViewById<TextView>(R.id.tv1)
        val et1=findViewById<EditText>(R.id.et1)
        val numero = (Math.random() * 100_001).toInt()
        tv1.text=("Recuerda el numero")
        Toast.makeText(this, "Número a recordar: ${numero}", Toast.LENGTH_LONG).show()
        val boton1=findViewById<Button>(R.id.boton1)
        boton1.setOnClickListener {
            if (numero == et1.text.toString().toInt())
                Toast.makeText(this, "Muy bien recordaste el número mostrado.", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Lo siento pero no es el número que mostré.", Toast.LENGTH_LONG).show()
        }
    }
}