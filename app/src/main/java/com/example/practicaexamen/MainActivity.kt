package com.example.practicaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titulo = findViewById<EditText>(R.id.editTextText)
        val boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            val intent = Intent(this@MainActivity, autor::class.java)
            intent.putExtra("titulo",titulo.text)
            startActivity(intent)
        }
    }
}