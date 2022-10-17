package com.example.simondice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun llamarJuego(){
        val botonInicio=findViewById<Button>(R.id.botonInicio)
        botonInicio.setOnClickListener{
        startActivity(
            Intent(
                this,
                Botones::class.java
            )
        )
    }
    }
}