package com.example.practicaexamen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class mostrar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)

        val libros = findViewById<TextView>(R.id.textView)
        val boton = findViewById<Button>(R.id.button5)
        val database =BaseDatos(this)

        val titulo =intent.getStringExtra("titulo")
        val autor =intent.getStringExtra("autor")
        val edito =intent.getStringExtra("edito")
        val fecha =intent.getStringExtra("fecha")

        database.insertarLibro(titulo!!, autor!!, edito!!, fecha!!)
        libros.text="${database.getLibros()}"
        boton.setOnClickListener {
            val intent = Intent(this@mostrar, MainActivity::class.java)
            startActivity(intent)
        }
    }
}