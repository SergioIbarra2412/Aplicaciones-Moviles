package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast

class MainActivity11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        val bundle = intent.extras
        val dato = bundle?.getString("direccion")
        val webView1=findViewById<WebView>(R.id.webView1)
        val boton1=findViewById<Button>(R.id.button)
        webView1.loadUrl("https://${dato}")
        boton1.setOnClickListener {
            finish();
        }
    }
}