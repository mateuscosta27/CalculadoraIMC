package com.example.CalculadoraImc

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
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


        binding.buttonCalculateImc.setOnClickListener {
            validateFields()
        }

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)



    }

    /**
     * Valida os campos de entrada e exibe um toast se algum campo estiver vazio
     */
    private fun validateFields() {
        val weight = binding.textInputWeight.text.toString().toDoubleOrNull() ?: 0.0
        val height = binding.textInputHeight.text.toString().toDoubleOrNull() ?: 0.0

        viewModel.setWeight(weight)
        viewModel.setHeight(height)




        if (weight == 0.0 && height == 0.0 || weight== 0.0 && height != 0.0 || weight != 0.0 && height == 0.0 ) {
            Toast.makeText(this, R.string.warningFields, Toast.LENGTH_LONG).show()
        } else {
            val imcResult = viewModel.calculateImc()
            val intent = Intent(this, ResultImcActivity::class.java)
            intent.putExtra("imcResult", imcResult)
            startActivity(intent)

        }
    }


}


