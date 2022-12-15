package com.example.simondice

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule
import kotlin.math.absoluteValue


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
        Toast.makeText(this, "HOLA", Toast.LENGTH_LONG).show()

    iluminarBoton(secuenciaMaquina)


    }
  fun juego(){
            if(secuenciaMaquina.isEmpty()){
                iluminarBoton(secuenciaMaquina)
            }else{

            }


  }
    fun defineBoton(secuenciaUsuario:ArrayList<Int>){

//     var botonRojo:Button=findViewById(R.id.botonRojo)
//    val botonVerde:Button=findViewById(R.id.botonVerde)
//    val botonAmarillo:Button=findViewById(R.id.botonAmarillo)
//    val botonAzul:Button=findViewById(R.id.botonAzul)
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

        var tiempoIluminado= 2000L
        numRonda++
       for(i in 0..secuenciaMaquina.size+1){

        secuenciaMaquina.add(generarColor())
        when(secuenciaMaquina[i]){

            0 ->{
                GlobalScope.launch(Dispatchers.Main) {
                    botonRojo.setBackgroundColor(Color.parseColor("#FD2929"))
                    secuenciaMaquina.add(0)
                    println("COLOR GENERADO")
                    delay(tiempoIluminado)
                        botonRojo.setBackgroundColor(Color.parseColor("#7E0000"))

                }
            }
            1 -> {
                GlobalScope.launch(Dispatchers.Main) {
                    botonVerde.setBackgroundColor(Color.parseColor("#8DC126"))
                    secuenciaMaquina.add(1)
                    println("COLOR GENERADO")
                    delay(tiempoIluminado)
                        botonVerde.setBackgroundColor(Color.parseColor("#3D5C00"))

                }
            }
            2 -> {
                GlobalScope.launch(Dispatchers.Main) {
                    botonAmarillo.setBackgroundColor(Color.parseColor("#FCED7E"))
                secuenciaMaquina.add(2)
                    println("COLOR GENERADO")
                    delay(tiempoIluminado)
                    botonAmarillo.setBackgroundColor(Color.parseColor("#D08E00"))

                }
            }

            3 -> {
                GlobalScope.launch(Dispatchers.Main) {
                    botonAzul.setBackgroundColor(Color.parseColor("#54B7FE"))
                secuenciaMaquina.add(3)
                    println("COLOR GENERADO")
                    delay(tiempoIluminado)
                    botonAzul.setBackgroundColor(Color.parseColor("#055690"))

                }
            }


        }
           defineBoton(secuenciaUsuario)
        GlobalScope.launch(Dispatchers.Main) {
            if (numRonda == secuenciaMaquina.size) {
                for (Int in secuenciaMaquina) {
                    defineBoton(secuenciaUsuario)
                }
            }
        }
            }

    }
    fun comprobarSecuencias(secuenciaUsuario: ArrayList<Int>,secuenciaMaquina: ArrayList<Int>,contador:Int){
            if(secuenciaUsuario[contador-1]!=secuenciaMaquina[contador-1]){
                println("HAS FALLADO!")

            }else if(secuenciaMaquina.size == contador +1){
                println("NO HAS KWFJOFAJWOFWAJOWAFJJFWAOJFWAOJFWAOJ")
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
