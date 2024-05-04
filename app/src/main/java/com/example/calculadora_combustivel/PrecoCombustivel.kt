package com.example.calculadora_combustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import com.example.calculadora_combustivel.databinding.ActivityPrecoCombustivelBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class PrecoCombustivel : AppCompatActivity() {

    private lateinit var binding: ActivityPrecoCombustivelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrecoCombustivelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edtCombustivel = findViewById<TextInputEditText>(R.id.edt_combustivel)
        val btnCombustivel = findViewById<Button>(R.id.btn_combustivel)
        btnCombustivel.setOnClickListener {
            val combustivelText = edtCombustivel.text.toString()

            if (combustivelText.isNotEmpty()) {
                val combustivel = combustivelText.toFloat()
                IrParaConsumo(combustivel)
            } else {
                Snackbar.make(
                    edtCombustivel,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            }
        }
    }

    private fun IrParaConsumo(combustivel: Float) {
        val intent = Intent(this, ConsumoCarro::class.java)
        intent.putExtra("combustivel", combustivel)
        startActivity(intent)
    }
}