package com.example.simondice

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule


class Botones : AppCompatActivity() {
    var secuenciaMaquina: ArrayList<Int> = ArrayList()
    var secuenciaUsuario: ArrayList<Int> = ArrayList()
    var contador:Int=0;
    var auxContador:Int=0
   private var numRonda:Int=0
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


    iluminarBoton(secuenciaMaquina)

    }
//  fun juego(){
//       iluminarBoton()
//
//
//  }
    fun defineBoton(secuenciaUsuario:ArrayList<Int>){

     var botonRojo:Button=findViewById(R.id.botonRojo)
    val botonVerde:Button=findViewById(R.id.botonVerde)
    val botonAmarillo:Button=findViewById(R.id.botonAmarillo)
    val botonAzul:Button=findViewById(R.id.botonAzul)
    GlobalScope.launch(Dispatchers.Main) {
        botonRojo.setOnClickListener {
            secuenciaUsuario.add(0)
            contador++
            comprobarSecuencias(secuenciaUsuario,secuenciaMaquina,contador)
        }
        }
    GlobalScope.launch(Dispatchers.Main) {
        botonVerde.setOnClickListener {
            secuenciaUsuario.add(1)
            contador++
            comprobarSecuencias(secuenciaUsuario,secuenciaMaquina,contador)
        }
        }
    GlobalScope.launch(Dispatchers.Main) {
        botonAmarillo.setOnClickListener {
            secuenciaUsuario.add(2)
            contador++
            comprobarSecuencias(secuenciaUsuario,secuenciaMaquina,contador)
        }
        }
    GlobalScope.launch(Dispatchers.Main) {
        botonAzul.setOnClickListener {
            secuenciaUsuario.add(3)
            contador++
            comprobarSecuencias(secuenciaUsuario,secuenciaMaquina,contador)
        }
        }

    }


    fun iluminarBoton(secuenciaMaquina:ArrayList<Int>)= runBlocking{
        numRonda++
        var tiempoIluminado= 2000
        when(0){

            0 ->{
                GlobalScope.launch(Dispatchers.Main) {
                    botonRojo.backgroundTintList((resources.getColor(R.color.rojo_encendido)))
                    secuenciaMaquina.add(0)
                    Timer().schedule(tiempoIluminado) {
                        botonRojo.backgroundTintList((resources.getColor(R.color.rojo_apagado)))
                    }
                }
            }
            1 -> {
                GlobalScope.launch(Dispatchers.Main) {
                    botonVerde.setBackgroundColor((resources.getColor(R.color.verde_encendido)))
                    secuenciaMaquina.add(1)
                    Timer().schedule(tiempoIluminado) {
                        botonVerde.setBackgroundColor((resources.getColor(R.color.verde_apagado)))
                    }
                }
            }
            2 -> {
                GlobalScope.launch(Dispatchers.Main) {
                botonAmarillo.setBackgroundColor((resources.getColor(R.color.amarillo_encendido)))
                secuenciaMaquina.add(2)
                Timer().schedule(tiempoIluminado){
                    botonAmarillo.setBackgroundColor((resources.getColor(R.color.amarillo_apagado)))
                }
                }
            }

            3 -> {
                GlobalScope.launch(Dispatchers.Main) {
                botonAzul.setBackgroundColor((resources.getColor(R.color.azul_encendido)))
                secuenciaMaquina.add(3)
                Timer().schedule(tiempoIluminado){
                    botonAzul.setBackgroundColor((resources.getColor(R.color.azul_apagado)))
                }
                }
            }


        }
        GlobalScope.launch(Dispatchers.Main) {
            if(numRonda==secuenciaMaquina.size){
                for (Int in secuenciaMaquina){
                    defineBoton(secuenciaUsuario)
                }
                }

            }

    }
    fun comprobarSecuencias(secuenciaUsuario: ArrayList<Int>,secuenciaMaquina: ArrayList<Int>,contador:Int){
            if(secuenciaUsuario[contador]!=secuenciaMaquina[contador]){
                println("HAS FALLADO!")

            }else if(secuenciaMaquina.size == contador +1){
                iluminarBoton(secuenciaMaquina)
                this.contador =contador-1
                secuenciaUsuario.clear()
            }

    }
    fun generarColor(): Int {

        return (0..3).random()
    }
    fun comprobarColor(){

    }
}

private fun Button.backgroundTintList(color: Int) {

}

private fun Timer.schedule(tiempoIluminado: Int, function: () -> Unit) {

}

private fun <E> ArrayList<E>.add(element: Int) {

}
