package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val et1 = findViewById<EditText>(R.id.numero1)
        val et2 = findViewById<EditText>(R.id.numero2)
        val r1 = findViewById<RadioButton>(R.id.suma)
        val r2 = findViewById<RadioButton>(R.id.resta)
        val r3 = findViewById<RadioButton>(R.id.multi)
        val r4 = findViewById<RadioButton>(R.id.div)
        val tv1 = findViewById<TextView>(R.id.resultado)
        val button = findViewById<Button>(R.id.boton1)
        button.setOnClickListener {
            if (r1.isChecked)
                tv1.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
                hideKeyboard()
            if (r2.isChecked)
                tv1.text = "Resultado: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
                hideKeyboard()
            if (r3.isChecked)
                tv1.text = "Resultado: ${et1.text.toString().toInt() * et2.text.toString().toInt()}"
                hideKeyboard()
            if (r4.isChecked)
                if (et2.text.toString().toInt() != 0) {
                    tv1.text =
                        "Resultado: ${et1.text.toString().toInt() / et2.text.toString().toInt()}"
                    hideKeyboard()
                }
        }

    }

    private fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}