package com.example.simondice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule


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
        while(secuenciaUsuario.equals(secuenciaMaquina)){
           iluminarBoton()
            defineBoton()

        }

    }
    fun defineBoton(){

        botonRojo.setOnClickListener {
            secuenciaUsuario.add(0)
        }
        botonVerde.setOnClickListener {
            secuenciaUsuario.add(1)
        }
        botonAmarillo.setOnClickListener {
            secuenciaUsuario.add(2)
        }
        botonAzul.setOnClickListener {
            secuenciaUsuario.add(3)
        }
    }
    fun clickRojo(botonRojo:Button){

    }

    fun iluminarBoton(){
        defineBoton()
        var tiempoIluminado= 2000
        when(generarColor()){

            0 ->{
                botonRojo.setBackgroundColor(resources.getColor(R.color.rojo_encendido))
                secuenciaMaquina.add(0)
                Timer().schedule(tiempoIluminado){
                    botonRojo.setBackgroundColor(resources.getColor(R.color.rojo_apagado))
                }

            }
            1 -> {
                botonVerde.setBackgroundColor(resources.getColor(R.color.verde_encendido))
                secuenciaMaquina.add(1)
                Timer().schedule(tiempoIluminado){
                    botonVerde.setBackgroundColor(resources.getColor(R.color.verde_apagado))
                }
            }
            2 -> {
                botonAmarillo.setBackgroundColor(resources.getColor(R.color.amarillo_encendido))
                secuenciaMaquina.add(2)
                Timer().schedule(tiempoIluminado){
                    botonAmarillo.setBackgroundColor(resources.getColor(R.color.amarillo_apagado))
                }
            }
            3 -> {
                botonAzul.setBackgroundColor(resources.getColor(R.color.azul_encendido))
                secuenciaMaquina.add(3)
                Timer().schedule(tiempoIluminado){
                    botonAzul.setBackgroundColor(resources.getColor(R.color.azul_apagado))
                }
            }


        }
    }
    fun generarColor(): Int {

        return (0..3).random()
    }
    fun comprobarColor(){

    }
}

private fun Timer.schedule(tiempoIluminado: Int, function: () -> Unit) {

}

private fun <E> ArrayList<E>.add(element: Int) {

}
