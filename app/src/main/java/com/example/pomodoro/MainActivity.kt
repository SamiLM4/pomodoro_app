package com.example.pomodoro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.widget.TextView
import android.widget.Button
import android.widget.EditText

import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator

import android.util.Log

class MainActivity : AppCompatActivity() {

    private var tempoSegundos = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var quantPomodoro = 0
        val TextoQuantPomodoros = findViewById<TextView>(R.id.quantidadePomodoros)
        TextoQuantPomodoros.text = "Quantidade de Pomodoros concluidos, zerado a cada 4"

        val texto = findViewById<TextView>(R.id.textView)
        val botao = findViewById<Button>(R.id.button)

        val botaoPause = findViewById<Button>(R.id.buttonPause)
        var pause = false
        val textoPause = findViewById<TextView>(R.id.textViewPause)

        textoPause.text = "Começando"


        botaoPause.setOnClickListener {
            if (pause == false){
                pause = true
                textoPause.text = "pausado"
            } else {
                pause = false
                textoPause.text = "Rodando"
            }

        }


        botao.setOnClickListener {

            tempoSegundos = 0

            val editTextNumero = findViewById<EditText>(R.id.editTextNumber)
            val textoRecuperado = editTextNumero.text.toString()

            val numero = textoRecuperado.toIntOrNull()
            if (numero != null) {
                texto.text = "Número recuperado: $numero"

                while (tempoSegundos < numero*60) {

                    Thread.sleep(1000);
                    tempoSegundos++;
                    Log.d("Acao smartphone", "Tempo: " + tempoSegundos + " segundos");

                    if (pause == true) {
                        while (pause == true) {
                            Thread.sleep(1000);
                        }
                    }
                }

                Log.d("Acao smartphone","Vibrando")

                fun exemploVibracao() {
                    vibrar( 500)
                }
                quantPomodoro++
                TextoQuantPomodoros.text = "$quantPomodoro Pomodoros concluidos"

                tempoSegundos = 0

                if (quantPomodoro == 5) {
                    while (tempoSegundos < 15*60) {

                        Thread.sleep(1000);
                        tempoSegundos++;
                        Log.d("Acao smartphone", "Tempo: " + tempoSegundos + " segundos");

                        if (pause == true) {
                            while (pause == true) {
                                Thread.sleep(1000);
                            }
                        }
                    }

                    Log.d("Acao smartphone","Vibrando")

                    fun exemploVibracao() {
                        vibrar( 500)
                    }

                    quantPomodoro = 0

                } else {
                    while (tempoSegundos < 5*60) {

                        Thread.sleep(1000); // Pausa para descaso 5 minutos
                        tempoSegundos++;
                        Log.d("Acao smartphone", "Tempo: " + tempoSegundos + " segundos");

                        if (pause == true) {
                            while (pause == true) {
                                Thread.sleep(1000);
                            }
                        }
                    }

                    Log.d("Acao smartphone","Vibrando")

                    fun exemploVibracao() {
                        vibrar( 500)
                    }
                }

                texto.text = "Clique para começar o novo pomodoro"

            } else {
                texto.text="Digite um valor válido"
            }
        }
    }

    private fun vibrar(tempo: Long) {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // Verifica se a versão do Android é igual ou superior ao Android Oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Para versões do Android Oreo e superiores
            val vibrationEffect = VibrationEffect.createOneShot(tempo, VibrationEffect.DEFAULT_AMPLITUDE)
            vibrator.vibrate(vibrationEffect)
        } else {
            // Para versões anteriores ao Android Oreo
            vibrator.vibrate(tempo)
        }

    }

}