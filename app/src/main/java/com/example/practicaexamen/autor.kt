package com.example.practicaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class autor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autor)

        val autor = findViewById<EditText>(R.id.editTextText2)
        val boton = findViewById<Button>(R.id.button2)

        val titulo =intent.getStringExtra("titulo")

        boton.setOnClickListener {
            val intent = Intent(this@autor, editorial::class.java)
            intent.putExtra("titulo",titulo)
            intent.putExtra("autor",autor.text)
            startActivity(intent)
        }
    }
}