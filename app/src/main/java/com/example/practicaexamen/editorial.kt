package com.example.practicaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class editorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editorial)

        val edito = findViewById<EditText>(R.id.editTextText3)
        val boton = findViewById<Button>(R.id.button3)

        val titulo =intent.getStringExtra("titulo")
        val autor =intent.getStringExtra("autor")

        boton.setOnClickListener {
            val intent = Intent(this@editorial, fecha::class.java)
            intent.putExtra("titulo",titulo)
            intent.putExtra("autor",autor)
            intent.putExtra("edito",edito.text)
            startActivity(intent)
        }
    }
}