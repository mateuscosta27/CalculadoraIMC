package com.example.firstapp.viewModel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var weight:Double = 0.0
    private var height:Double = 0.0


    fun setWeight(value:Double){
        weight = value
    }


    fun setHeight(value:Double){
        height = value
    }
    fun getHeight():Double{
        return height
    }

    fun calculateImc():Double{
        return weight/(height * height)
    }



}