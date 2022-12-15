package com.example.simondice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MiModelo():ViewModel() {

    var ronda=1;
    val cambiosRonda=MutableLiveData<Int>()

    init {
        cambiosRonda.value=ronda;
    }

    fun rondaIncremento(){
        ronda=ronda +1
        cambiosRonda.setValue(ronda)
    }
}