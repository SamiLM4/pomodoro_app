package com.example.pomodoro

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.widget.TextView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val texto = findViewById<TextView>(R.id.textView)
        val botao = findViewById<Button>(R.id.button)

        botao.setOnClickListener {

            val editTextNumero = findViewById<EditText>(R.id.editTextNumber)
            val textoRecuperado = editTextNumero.text.toString()

            val numero = textoRecuperado.toIntOrNull()
            if (numero != null){
                texto.text = "Número recuperado: $numero"
            } else {
                texto.text = "Digite um número válido"
            }

            

        }
    }
}