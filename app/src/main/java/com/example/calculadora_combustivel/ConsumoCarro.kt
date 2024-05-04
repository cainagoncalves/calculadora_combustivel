package com.example.calculadora_combustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculadora_combustivel.databinding.ActivityConsumoCarroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class ConsumoCarro : AppCompatActivity() {

    private lateinit var binding: ActivityConsumoCarroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsumoCarroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edtConsumo = findViewById<TextInputEditText>(R.id.edt_consumo)
        val btnConsumo = findViewById<Button>(R.id.btn_consumo)
        btnConsumo.setOnClickListener {
            val consumoText = edtConsumo.text.toString()

            if (consumoText.isNotEmpty()) {
                val consumo = consumoText.toFloat()
                val combustivel = intent.getFloatExtra("combustivel", 0f)
                IrParaDistancia(consumo, combustivel)
            } else {
                Snackbar.make(
                    edtConsumo,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            }

        }
    }

    private fun IrParaDistancia(consumo: Float, combustivel: Float) {
        val intent = Intent(this, DistanciaDestino::class.java)
        intent.putExtra("consumo", consumo)
        intent.putExtra("combustivel", combustivel)
        startActivity(intent)
    }
}