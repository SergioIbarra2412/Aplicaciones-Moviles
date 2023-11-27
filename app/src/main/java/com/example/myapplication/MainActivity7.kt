package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity7  : AppCompatActivity() {

    private val users = arrayOf(
        User("hello", "hello")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val usernameEditText = findViewById<EditText>(R.id.et1)
        val passwordEditText = findViewById<EditText>(R.id.et2)
        val loginButton = findViewById<Button>(R.id.boton1)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            val validUser = users.any { it.name == username && it.password == password }

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Los campos no pueden quedar vacíos", Toast.LENGTH_LONG).show()
            } else if (validUser) {
                // Inicio de sesión exitoso, abrir DashboardActivity
                val intent = Intent(this, MainActivity6::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        }
    }

    data class User(val name: String, val password: String)
}
