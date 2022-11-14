package com.example.simondice

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule


class Botones : AppCompatActivity() {
    var secuenciaMaquina: ArrayList<Int> = ArrayList()
    var secuenciaUsuario: ArrayList<Int> = ArrayList()
    var contador:Int=0
    var auxContador:Int=0
    var numRonda:Int=0
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


        juego()
    }
  fun juego(){
       iluminarBoton()


  }
    fun defineBoton(){

        botonRojo.setOnClickListener {
            secuenciaUsuario.add(0)
            contador++
            comprobarSecuencias()
        }
        botonVerde.setOnClickListener {
            secuenciaUsuario.add(1)
            contador++
            comprobarSecuencias()
        }
        botonAmarillo.setOnClickListener {
            secuenciaUsuario.add(2)
            contador++
            comprobarSecuencias()
        }
        botonAzul.setOnClickListener {
            secuenciaUsuario.add(3)
            contador++
            comprobarSecuencias()
        }

    }


    fun iluminarBoton(){
        numRonda++
        var tiempoIluminado= 2000L
        when(generarColor()){

            0 ->{
                botonRojo.setBackgroundColor(Color.parseColor("rojo_encendido"))
                secuenciaMaquina.add(0)
                Timer().schedule(tiempoIluminado){
                    botonRojo.setBackgroundColor(Color.parseColor("rojo_apagado"))
                }

            }
            1 -> {
                botonVerde.setBackgroundColor(Color.parseColor("verde_encendido"))
                secuenciaMaquina.add(1)
                Timer().schedule(tiempoIluminado){
                    botonVerde.setBackgroundColor(Color.parseColor("verde_apagado"))
                }
            }
            2 -> {
                botonAmarillo.setBackgroundColor(Color.parseColor("amarillo_encendido"))
                secuenciaMaquina.add(2)
                Timer().schedule(tiempoIluminado){
                    botonAmarillo.setBackgroundColor(Color.parseColor("amarillo_apagado"))
                }
            }
            3 -> {
                botonAzul.setBackgroundColor(Color.parseColor("azul_encendido"))
                secuenciaMaquina.add(3)
                Timer().schedule(tiempoIluminado){
                    botonAzul.setBackgroundColor(Color.parseColor("azul_apagado"))
                }
            }


        }
            if(numRonda==secuenciaMaquina.size){
                for (items in secuenciaMaquina){
                    defineBoton()
                }

            }

    }
    fun comprobarSecuencias(){
            if(secuenciaUsuario[contador]!=secuenciaMaquina[contador]){
                println("HAS FALLADO!")

            }else if(secuenciaMaquina.size == contador +1){
                iluminarBoton()
                contador = contador -1
                secuenciaUsuario.clear()
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
