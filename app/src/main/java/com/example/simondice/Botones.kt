package com.example.simondice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.delay


class Botones : AppCompatActivity() {
//    var listaColoresMaquina = ArrayList<Integer>()
    var secuenciaMaquina: ArrayList<Int> = arrayListOf()
//    var listaColoresUsuario= ArrayList<Integer>()
    var secuenciaUsuario: ArrayList<Int> = arrayListOf()
    var colorJuego = 0
    var colorUsuario= 0
    lateinit var botonRojo:Button
    lateinit var botonVerde:Button
    lateinit var botonAmarillo:Button
    lateinit var botonAzul:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_botones)
        botonRojo=findViewById<Button>(R.id.botonRojo)
        botonVerde=findViewById<Button>(R.id.botonVerde)
        botonAmarillo=findViewById<Button>(R.id.botonAmarillo)
        botonAzul=findViewById<Button>(R.id.botonAzul)
        defineBoton()
        start()
    }
    fun start() {
        gamePlay()
    }
    fun gamePlay(){

        var i=0
//        while(listaColoresUsuario.equals(listaColoresMaquina)){
//            listaColoresMaquina.add(generarColor())
//
//        }

    }
    fun defineBoton(){

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

    fun iluminarBoton(){
        defineBoton()
        var tiempoIluminado= 0
        when(generarColor()){

            0 ->{
                botonRojo.setBackgroundColor(resources.getColor(R.color.rojo_encendido))
                secuenciaMaquina.add(0)

            }
            1 -> {
                botonVerde.setBackgroundColor(resources.getColor(R.color.verde_encendido))
                secuenciaMaquina.add(1)
            }
            2 -> {
                botonAmarillo.setBackgroundColor(resources.getColor(R.color.amarillo_encendido))
                secuenciaMaquina.add(2)
            }
            3 -> {
                botonAzul.setBackgroundColor(resources.getColor(R.color.azul_encendido))
                secuenciaMaquina.add(3)
            }


        }
    }
    fun generarColor(): Int {

        return (0..3).random()
    }
    fun comprobarColor(){

    }
}

private fun <E> ArrayList<E>.add(element: Int) {

}
