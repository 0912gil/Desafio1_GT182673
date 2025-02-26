package com.example.desafo1_gt182673

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PromedioActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio)

        findViewById<Button>(R.id.btnCalcular).setOnClickListener{
            val nombre = findViewById<EditText>(R.id.etNombre).text.toString()
            val notas = arrayOf(
                findViewById<EditText>(R.id.etNota1).text.toString().toDoubleOrNull(),
                findViewById<EditText>(R.id.etNota2).text.toString().toDoubleOrNull(),
                findViewById<EditText>(R.id.etNota3).text.toString().toDoubleOrNull(),
                findViewById<EditText>(R.id.etNota4).text.toString().toDoubleOrNull(),
                findViewById<EditText>(R.id.etNota5).text.toString().toDoubleOrNull()
            )

            if(notas.any { it == null || it !in 0.0..10.0}) {
                findViewById<TextView>(R.id.tvResultado).text = "Notas inválidas"
                return@setOnClickListener
            }

            val pesos = arrayOf(0.15, 0.15, 0.20, 0.25, 0.25)
            val promedio = notas.zip(pesos).sumByDouble { it.first!! * it.second }
            val resultado = if(promedio >= 6.0) "Aprobado" else "Reprobado"

            findViewById<TextView>(R.id.tvResultado).text = "Nota final: $promedio - $resultado"
        }
    }
}