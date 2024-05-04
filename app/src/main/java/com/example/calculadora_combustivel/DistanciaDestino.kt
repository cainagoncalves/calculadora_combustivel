package com.example.calculadora_combustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.calculadora_combustivel.databinding.ActivityDistanciaDestinoBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class DistanciaDestino : AppCompatActivity() {

    private lateinit var binding: ActivityDistanciaDestinoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistanciaDestinoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edtDistancia = findViewById<TextInputEditText>(R.id.edt_distancia)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            val distanciaText = edtDistancia.text.toString()

            if (distanciaText.isEmpty()) {
                Snackbar.make(
                    edtDistancia,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val distancia = distanciaText.toFloat()
                val combustivel = intent.getFloatExtra("combustivel", 0f)
                val consumo = intent.getFloatExtra("consumo", 0f)
                val combConsum = combustivel / consumo
                val total = combConsum * distancia

                IrParaResultado(total, combustivel, consumo, distancia)

            }
        }

    }

    private fun IrParaResultado(
        total: Float,
        combustivel: Float,
        consumo: Float,
        distancia: Float
    ) {
        val intent = Intent(this, Resultado::class.java)
        intent.putExtra(KEY_RESULT_TOTAL, total)
        intent.putExtra("combustivel", combustivel)
        intent.putExtra("consumo", consumo)
        intent.putExtra("distancia", distancia)
        startActivity(intent)
    }
}