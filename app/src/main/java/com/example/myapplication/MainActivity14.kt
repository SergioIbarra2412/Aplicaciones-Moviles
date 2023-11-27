package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity14 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val et3 = findViewById<EditText>(R.id.et3)
        val boton1 = findViewById<Button>(R.id.boton1)
        val boton2 = findViewById<Button>(R.id.boton2)
        val boton3 = findViewById<Button>(R.id.boton3)
        val boton4 = findViewById<Button>(R.id.boton4)
        val regresar = findViewById<Button>(R.id.regreso)
        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues().apply {
                put("nombre", et1.text.toString())
                put("nocontrol", et2.text.toString())
                put("grupo", et3.text.toString())
            }
            bd.insert("alumnos", null, registro)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            Toast.makeText(this, "Se cargaron los datos del alumno", Toast.LENGTH_SHORT).show()
        }

        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val nombreConsulta = et1.text.toString()

            val fila = bd.rawQuery(
                "SELECT id, nombre, numero, grupo FROM alumnos WHERE nombre=?",
                arrayOf(nombreConsulta)
            )
            if (fila.moveToFirst()) {
                et2.setText(fila.getString(0))
                et3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un alumno con dicho nombre", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery(
                "select nombre,grupo from alumnos where nocontrol=?", arrayOf(et2.text.toString()))
            if (fila.moveToFirst()) {
                et1.setText(fila.getString(0))
                et3.setText(fila.getString(1))
            } else {
                Toast.makeText(this, "No existe un alumno con el número de control proporcionado", Toast.LENGTH_SHORT).show()
            }
            bd.close()
        }

        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("alumnos", "nombre=?", arrayOf(et1.text.toString()))
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el alumno", Toast.LENGTH_SHORT).show()

            else
                Toast.makeText(this, "No existe el alumno", Toast.LENGTH_SHORT).show()

        }



        regresar.setOnClickListener {
            val intento1 = Intent(this, MainActivity13::class.java)
            startActivity(intento1)
        }
    }
}