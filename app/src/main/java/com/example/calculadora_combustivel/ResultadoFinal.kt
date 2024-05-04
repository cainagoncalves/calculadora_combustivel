package com.example.calculadora_combustivel

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculadora_combustivel.databinding.ActivityResultadoBinding

const val KEY_RESULT_TOTAL = "DistanciaDestino.KEY_TOTAL"

class Resultado : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperarDados()

        val btnNovoCalculo = findViewById<Button>(R.id.btn_novoCalculo)

        btnNovoCalculo.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun recuperarDados() {
        val total = intent.getFloatExtra(KEY_RESULT_TOTAL, 0f)
        val distancia = intent.getFloatExtra("distancia", 0f)
        val combustivel = intent.getFloatExtra("combustivel", 0f)
        val consumo = intent.getFloatExtra("consumo", 0f)

        binding.telaResultado.text = "R$ " + total.toString()
        binding.exibirCombustivel.text = "Preço do combustível: R$ " + combustivel
        binding.exibirConsumo.text = "Consumo: " + consumo + " km/l"
        binding.exibirDistancia.text = "Km: " + distancia

    }

}



