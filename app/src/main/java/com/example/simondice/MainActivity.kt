package com.example.simondice

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import java.util.*
import androidx.lifecycle.Observer
import com.example.simondice.database.RecordDao
import com.example.simondice.database.RecordDataBase
import kotlinx.coroutines.selects.select


class MainActivity : AppCompatActivity() {

    var secuenciaMaquina = IntArray(1000)
    var secuenciaUsuario: ArrayList<Int> = ArrayList()
    var contador: Int = 0;
    var auxContador: Int = 0
    var puntuacion: Int = 0
    var botonesActivados: Boolean = true
    var eleccionUsuario: Int = 0
    private var numRonda: Int = 1
    lateinit var botonStart: Button
    lateinit var botonRojo: Button
    lateinit var botonVerde: Button
    lateinit var botonAmarillo: Button
    lateinit var botonAzul: Button
    lateinit var diseManise: TextView
    lateinit var recordDao:RecordDao
    val mimodelo by viewModels<MiModelo>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonStart = findViewById(R.id.botonInicio)
        botonRojo = findViewById(R.id.botonRojo)
        botonVerde = findViewById(R.id.botonVerde)
        botonAmarillo = findViewById(R.id.botonAmarillo)
        botonAzul = findViewById(R.id.botonAzul)
        diseManise= findViewById(R.id.diseManise)

        botonStart.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                iniciarJuego()
            }

        })

        recordDao=RecordDataBase.getDatabase(this).getRecordDao()
        mimodelo.cambiosRonda.observe(this, Observer
        {
            fun(paraRonda: Int) {
                diseManise = findViewById(R.id.diseManise)
                diseManise.text = "" + paraRonda
            }
        })
    }
    fun iniciarJuego(){
        generarColor()
    }
    fun generarColor() {


        botonesActivados = false
        habilitarBotones(botonesActivados)

        for (i in 0..numRonda) {
            val coloresAleatorios = (0..3).random()
            secuenciaMaquina.set((numRonda - 1), coloresAleatorios)
        }
        defineBoton(secuenciaMaquina)
        iluminarBoton()


    }
    fun iluminarBoton() {
        val rutinaCambioColor = GlobalScope.launch(Dispatchers.Main) {
            var tiempoIluminado = 1000L

            for (i in 0..numRonda) {


                when (secuenciaMaquina[i]) {

                    1 -> {

                        botonRojo.setBackgroundColor(Color.parseColor("#FD2929"))
                        delay(tiempoIluminado-(numRonda*8))
                        println("COLOR GENERADO")
                        botonRojo.setBackgroundColor(Color.parseColor("#7E0000"))
                        delay(tiempoIluminado-(numRonda*8))

                    }
                    2 -> {

                        botonVerde.setBackgroundColor(Color.parseColor("#8DC126"))
                        delay(tiempoIluminado-(numRonda*8))
                        println("COLOR GENERADO")
                        botonVerde.setBackgroundColor(Color.parseColor("#3D5C00"))
                        delay(tiempoIluminado-(numRonda*8))

                    }
                    3 -> {

                        botonAmarillo.setBackgroundColor(Color.parseColor("#FCED7E"))
                        delay(tiempoIluminado-(numRonda*8))
                        println("COLOR GENERADO")
                        botonAmarillo.setBackgroundColor(Color.parseColor("#D08E00"))
                        delay(tiempoIluminado-(numRonda*8))

                    }

                    4 -> {

                        botonAzul.setBackgroundColor(Color.parseColor("#54B7FE"))
                        delay(tiempoIluminado-(numRonda*8))
                        println("COLOR GENERADO")
                        botonAzul.setBackgroundColor(Color.parseColor("#055690"))
                        delay(tiempoIluminado-(numRonda*8))

                    }


                }


            }
            botonesActivados=true
            habilitarBotones(botonesActivados)
        }
        rutinaCambioColor
    }
    fun defineBoton(secuenciaMaquina: IntArray) {
        botonRojo.setOnClickListener() {

        if (botonesActivados) {

                eleccionUsuario = 1

                comprobarSecuencias(secuenciaMaquina)
            }
        }
        botonVerde.setOnClickListener() {
        if (botonesActivados) {

                eleccionUsuario = 2

                comprobarSecuencias(secuenciaMaquina)
            }
        }
        botonAmarillo.setOnClickListener() {
        if (botonesActivados) {

                eleccionUsuario = 3

                comprobarSecuencias(secuenciaMaquina)
            }
        }
        botonAzul.setOnClickListener() {
        if (botonesActivados) {

                eleccionUsuario = 4

                comprobarSecuencias(secuenciaMaquina)
            }
        }

    }
    fun comprobarSecuencias(secuenciaMaquina: IntArray) {
        if (secuenciaMaquina[contador] == eleccionUsuario && contador != numRonda) {
            contador = contador + 1

            if (contador == numRonda) {
                comprobarSecuencias(secuenciaMaquina)

            }
            println("mierda")

//                println("HAS FALLADO!")

        } else if (secuenciaMaquina[contador] == eleccionUsuario || contador == numRonda) {
//                println("No se si entra aqui")
            numRonda = numRonda + 1
            mimodelo.rondaIncremento()
            diseManise.text = " " + numRonda
            contador = 0
            println("HOLA QUE TAL")
            generarColor()

        } else {
            for(i in 0..(numRonda-1)){
                secuenciaMaquina[i]=0;
                println("Fallaste")
                guardarDatos()
                consultaDatos()
            }
        }

    }
           fun habilitarBotones(check: Boolean) {
                botonRojo.isClickable == check
                botonVerde.isClickable == check
                botonAmarillo.isClickable == check
                botonAzul.isClickable == check
            }

            fun guardarDatos(){
                val gsp = getSharedPreferences("puntos", Context.MODE_PRIVATE)
                val escribir=gsp.edit()
                escribir.apply(){
                    putInt("INT_KEY", numRonda)
                }.apply()
            }
     fun consultaDatos(){
        val gsp = getSharedPreferences("puntos", Context.MODE_PRIVATE)
        val consultarRecord = gsp.getInt("INT_KEY", 0)
        println("PUNTUACIONES: "+consultarRecord)
//        recordDao.selectAllRecords().toString()


    }











        }


//    fun llamarJuego(){
//        val botonInicio=findViewById<Button>(R.id.botonInicio)
//        botonInicio.setOnClickListener{
//        startActivity(
//            Intent(
//                this,
//                Botones::class.java
//            )
//        )
//    }

//    }
