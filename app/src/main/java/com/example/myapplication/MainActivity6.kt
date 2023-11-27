package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {

    private val calculationHistory = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val input1 = findViewById<EditText>(R.id.input1)
        val input2 = findViewById<EditText>(R.id.input2)
        val input3 = findViewById<EditText>(R.id.input3)
        val addRadioButton = findViewById<RadioButton>(R.id.sum)
        val subtractRadioButton = findViewById<RadioButton>(R.id.rest)
        val multiplyRadioButton = findViewById<RadioButton>(R.id.mult)
        val divideRadioButton = findViewById<RadioButton>(R.id.div)
        val resultTextView = findViewById<TextView>(R.id.result)
        val historyTextView = findViewById<TextView>(R.id.hist)
        val calculateButton = findViewById<Button>(R.id.cal)

        calculateButton.setOnClickListener {
            resultTextView.text = ""

            val num1 = input1.text.toString().toIntOrNull()
            val num2 = input2.text.toString().toIntOrNull()
            val num3 = input3.text.toString().toIntOrNull()

            if (num1 != null && num2 != null && num3 != null) {
                when {
                    addRadioButton.isChecked -> performCalculation(num1 + num2 + num3, resultTextView)
                    subtractRadioButton.isChecked -> performCalculation(num1 - num2 - num3, resultTextView)
                    multiplyRadioButton.isChecked -> performCalculation(num1 * num2 * num3, resultTextView)
                    divideRadioButton.isChecked -> {
                        if (num2 != 0) {
                            performCalculation(num1 / num2, resultTextView)
                        } else {
                            resultTextView.text = "Error: el segundo numero no debe ser 0"
                        }
                    }
                }

                input1.text.clear()
                input2.text.clear()
                input3.text.clear()
            } else {
                resultTextView.text = "Error: no debe haber campos vacios"
            }

            historyTextView.text = "Historial:\n${calculationHistory.joinToString("\n")}"
            hideKeyboard()
        }
    }

    private fun performCalculation(result: Int, resultTextView: TextView) {
        resultTextView.text = "Resultado: $result"
        addToHistory(result)
    }
    private fun addToHistory(result: Int) {
        calculationHistory.add("Resultado: $result")
    }

    private fun hideKeyboard() {
        val view = currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}