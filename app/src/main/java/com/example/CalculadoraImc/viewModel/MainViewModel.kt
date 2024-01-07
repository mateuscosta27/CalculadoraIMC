package com.example.CalculadoraImc.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var weight: Double = 0.0
    private var height: Double = 0.0
    private val _textInputWeight = MutableLiveData<Double>()
    private val _valueSlider = MutableLiveData<Double>()
    private val _textInputHeight = MutableLiveData<String>()



    val textInputWeight: MutableLiveData<Double> get() = _textInputWeight
    val valueSlider: MutableLiveData<Double> get() = _valueSlider
    val textInputHeight: MutableLiveData<String> get() = _textInputHeight


    fun updateValueInputWeight(newValue: Double) {
        _textInputWeight.value = newValue
    }

    fun updateValueInputHeight(newValue: String) {
        _textInputHeight.value = newValue
    }

    fun updateValueSlider(newValue: Double) {
        _valueSlider.value = newValue
    }


    fun setWeight(value: Double) {
        weight = value
    }


    fun setHeight(value: Double) {
        height = value
    }



    fun calculateImc(): Double {
        return weight / (height * height)
    }

    fun increment(){
        val newValue  = weight ++
        updateValueInputWeight(newValue)


    }




}