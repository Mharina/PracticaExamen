package com.example.practicaexamen

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(context: Context) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION){
    companion object{
        private const val DATABASE_VERSION=1
        private const val DATABASE="libros.db"
        private const val TABLA_LIBROS="libros"
        private const val KEY_ID="id"
        private const val COLUMN_TITULO="titulo"
        private const val COLUMN_AUTOR="autor"
        private const val COLUMN_EDITORIAL="editorial"
        private const val COLUMN_FECHA_PUBLI="fecha_publi"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_LIBROS ($KEY_ID INTEGER, $COLUMN_TITULO TEXT, $COLUMN_AUTOR TEXT, $COLUMN_EDITORIAL TEXT, $COLUMN_FECHA_PUBLI DATE)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_LIBROS")
        onCreate(db)
    }

    fun insertarLibro(titulo:String, autor: String, edit: String, fecha: String):Long{
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITULO, titulo)
            put(COLUMN_AUTOR, autor)
            put(COLUMN_EDITORIAL, edit)
            put(COLUMN_FECHA_PUBLI, fecha)
        }
        val id=db.insert(TABLA_LIBROS, null, values)
        db.close()
        return id
    }

    @SuppressLint("Range")
    fun getLibros():ArrayList<String>{
        val libros = ArrayList<String>()
        val selectQuery = "SELECT * FROM $TABLA_LIBROS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val titulo = cursor.getString(cursor.getColumnIndex(COLUMN_TITULO))
                val autor = cursor.getString(cursor.getColumnIndex(COLUMN_AUTOR))
                val edit = cursor.getString(cursor.getColumnIndex(COLUMN_EDITORIAL))
                val fecha = cursor.getString(cursor.getColumnIndex(COLUMN_FECHA_PUBLI))
                libros.add("El $titulo está escrito por $autor de la editorial $edit publicado en $fecha")
            } while (cursor.moveToNext())
        }
        return libros
    }
}