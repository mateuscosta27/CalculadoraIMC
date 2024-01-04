package com.example.CalculadoraImc.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var weight:Double = 0.0
    private var height:Double = 0.0
    private val _valueSlider = MutableLiveData<Float>()
    val valueSlider: MutableLiveData<Float> get() = _valueSlider
    private val _editTextValue = MutableLiveData<String>()
    val valueEditText:  MutableLiveData<String> get() = _editTextValue





    fun updateValueEditText(newValue:String){
        _editTextValue.value = newValue
    }

    fun updateValueSlider(newValue:Float){
        _valueSlider.value = newValue
    }




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

    fun valueSlider(){

    }



}