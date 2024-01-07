package com.example.CalculadoraImc.viewModel


import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    private var weight: Double = 0.0
    private var height: Double = 0.0


    fun setWeight(newValue: Double) {
        weight = newValue
    }

    fun setHeight(newValue: Double) {
        height = newValue / 100
    }


    fun calculateImc(): Double {
        return weight / (height * height)

    }


}