package com.example.calculadora_combustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.calculadora_combustivel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnIniciar = findViewById<Button>(R.id.btn_iniciar)
        btnIniciar.setOnClickListener {
            IrParaCombustivel()
        }
    }

    private fun IrParaCombustivel() {
        val intent = Intent(this, PrecoCombustivel::class.java)
        startActivity(intent)
    }
}



