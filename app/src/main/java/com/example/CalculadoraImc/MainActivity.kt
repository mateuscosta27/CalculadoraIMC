package com.example.CalculadoraImc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.CalculadoraImc.databinding.ActivityMainBinding
import com.example.CalculadoraImc.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
         * ViewModelProvider -> classe fornecida pelo Android Jetpack, ela ajuda a obter instancia da ViewModel ela recebe o parametro this
         * this -> representa a instancia da Activity e é usado como parte do escopo da vida util da viewModel
         * [ViewModel::class.java] -> è uma forma de obter a classe viewModel
         */

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonCalculateImc.setOnClickListener {
            validateFields()
        }
    }

    /**
     * Valida os campos de entrada e exibe um toast se algum campo estiver vazio
     */
    private fun validateFields() {
        /**
         * Tratamento da obtenção dos valores caso o valor encontrado seja nullo com o operador elvis é possivel atribuir um valor padrão
         */
        val weight = binding.textInputWeight.text.toString().toDoubleOrNull() ?: 0.0
        val height = binding.textInputHeight.text.toString().toDoubleOrNull() ?: 0.0
        viewModel.setWeight(weight)
        viewModel.setHeight(height / 100)
        if (weight == 0.0 && height == 0.0) {
            Toast.makeText(this, R.string.warningFields, Toast.LENGTH_LONG).show()
        } else {
            val imcResult = viewModel.calculateImc()
            val intent = Intent(this, ResultImcActivity::class.java)
            intent.putExtra("imcResult", imcResult)
            startActivity(intent)

        }
    }


}


