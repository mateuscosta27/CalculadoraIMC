package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.databinding.ActivityResultImcBinding

class ResultImcActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultImcBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtra()
    }

    private fun getExtra() {
        val intent: Intent = getIntent()
        val imc = intent.getDoubleExtra("imcResult", 0.0)
        SetText(imc)
        val imcFormatted = String.format("%.2f",imc)

        binding.textSubTitleResult.text = "$imcFormatted Kg/m²"
    }

    private fun SetText(imc: Double) {
        val categoryImc = binding.textCategoryImc

         when {
            imc < 18.5 -> {
               categoryImc.text =  getString(R.string.underWeightCategory)
                categoryImc.setTextColor(getColor(R.color.colorUnderWeight))
            }
            imc in 18.51..24.9 -> {
                categoryImc.text =  getString(R.string.idealWeight)
            }
            imc in 25.0..29.9 -> println("SobrePeso")
            imc in 30.0..34.9 -> println("Obesidade Grau I")
            imc in 35.0..39.9 -> println("Obesidade Grau II")
            imc > 40 -> "Obresidade Grau III"
            else -> println("fora da faixa")


        }

    }



    private fun category() {
        val underWeightCategory = getString(R.string.underWeightCategory)
        val idealWeightCategory = getString(R.string.idealWeightCategory)
        val overWeightCategory = getString(R.string.overWeightCategory)
        val firstDegreeObesityCategory = getString(R.string.firstDegreeObesityCaterogy)
        val secondDegreeObesityCategory = getString(R.string.secondDegreeObesityCategory)
        val thirdDegreeObesityCategory = getString(R.string.thirdDegreeObesityCategory)
    }

}