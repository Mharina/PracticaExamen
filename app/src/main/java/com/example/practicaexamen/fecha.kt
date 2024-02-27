package com.example.practicaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class fecha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fecha)

        val fecha = findViewById<EditText>(R.id.editTextText4)
        val boton = findViewById<Button>(R.id.button4)

        val titulo =intent.getStringExtra("titulo")
        val autor =intent.getStringExtra("autor")
        val edito =intent.getStringExtra("edito")

        boton.setOnClickListener {
            val intent = Intent(this@fecha, mostrar::class.java)
            intent.putExtra("titulo",titulo)
            intent.putExtra("autor",autor)
            intent.putExtra("edito",edito)
            intent.putExtra("fecha",fecha.text)
            startActivity(intent)
        }
    }
}