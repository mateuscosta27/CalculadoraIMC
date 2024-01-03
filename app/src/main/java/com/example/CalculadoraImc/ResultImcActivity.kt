package com.example.CalculadoraImc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.CalculadoraImc.databinding.ActivityResultImcBinding

class ResultImcActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultImcBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtra()
        binding.buttonRecalculate.setOnClickListener {
            returnForRecalculate()
        }
        binding.buttonFinishApp.setOnClickListener {
            finishAffinity()
        }
    }

    private fun getExtra() {
        val intent: Intent = getIntent()
        val imc = intent.getDoubleExtra("imcResult", 0.0)
        SetText(imc)
        val imcFormatted = String.format("%.2f", imc)

        binding.textSubTitleResult.text = "$imcFormatted Kg/m²"
    }

    private fun SetText(imc: Double) {
        val textDescriptionCategory = binding.textCategoryImc
        val textResultDescription = binding.textResultDescription


        when {
            imc < 18.5 -> {
                textDescriptionCategory.text = getString(R.string.underWeightCategory)
                textResultDescription.text = getString(R.string.underWeight)

            }

            imc in 18.51..24.9 -> {
                textDescriptionCategory.text = getString(R.string.idealWeightCategory)
                textResultDescription.text = getString(R.string.idealWeight)


            }

            imc in 25.0..29.9 -> {
                textDescriptionCategory.text = getString(R.string.overWeightCategory)
                textResultDescription.text = getString(R.string.overweight)

            }

            imc in 30.0..34.9 -> {
                textDescriptionCategory.text = getString(R.string.firstDegreeObesityCaterogy)
                textResultDescription.text = getString(R.string.firstDegreeObesityCaterogy)

            }

            imc in 35.0..39.9 -> {
                textDescriptionCategory.text = getString(R.string.secondDegreeObesityCategory)
                textResultDescription.text = getString(R.string.secondDegreeObesity)

            }

            imc > 40 -> {
                textDescriptionCategory.text = getString(R.string.thirdDegreeObesityCategory)
                textResultDescription.text = getString(R.string.thirdDegreeObesity)
            }

            else -> println("fora da faixa")


        }

    }

    private fun returnForRecalculate() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

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