package com.example.desafo1_gt182673

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SalarioActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salario)

        fun calcularRenta(salarioBase: Double): Double {
            return when {
                salarioBase <= 472.00 -> 0.0
                salarioBase <= 895.24 -> (salarioBase - 472.00) * 0.10 + 17.67
                salarioBase <= 2038.10 -> (salarioBase - 895.24) * 0.20 + 60.00
                else -> (salarioBase - 2038.10) * 0.30 + 288.57
            }
        }

        findViewById<Button>(R.id.btnCalcular).setOnClickListener{
            val salarioBase = findViewById<EditText>(R.id.etSalario).text.toString().toDoubleOrNull() ?: 0.0
            val afp = salarioBase * 0.0725
            val isss = salarioBase * 0.03
            val renta = calcularRenta(salarioBase)


            val salarioNeto = salarioBase - afp - isss - renta

            findViewById<TextView>(R.id.tvResultado).text = """
                AFP: $${"%.2f".format(afp)}
                ISSS: $${"%.2f".format(isss)}
                Renta: $${"%.2f".format(renta)}
                Salario Neto: $${"%.2f".format(salarioNeto)}
            """.trimIndent()
        }
    }
}