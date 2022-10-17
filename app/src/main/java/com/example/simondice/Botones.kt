package com.example.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Botones : AppCompatActivity() {
    var listaColoresMaquina = ArrayList<Integer>()
    var listaColoresUsuario= ArrayList<Integer>()
    var colorJuego = 0
    var colorUsuario= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_botones)

        defineBoton()
        start()
    }
    fun start() {
        gamePlay()
    }
    fun gamePlay(){

        var i=0
        while(listaColoresUsuario.equals(listaColoresMaquina)){
            listaColoresMaquina.add(generarColor())

        }

    }
    fun defineBoton(){
        var botonRojo=findViewById<Button>(R.id.botonRojo)
        var botonVerde=findViewById<Button>(R.id.botonVerde)
        var botonAmarillo=findViewById<Button>(R.id.botonAmarillo)
        var botonAzul=findViewById<Button>(R.id.botonAzul)
        botonRojo.setOnClickListener {

        }
        botonVerde.setOnClickListener {

        }
        botonAmarillo.setOnClickListener {

        }
        botonAzul.setOnClickListener {

        }
    }
    fun clickRojo(botonRojo:Button){

    }
    fun generarColor(): Int {
        
        return (0..3).random()
    }
    fun comprobarColor(){

    }
}

private fun <E> ArrayList<E>.add(element: Int) {

}
