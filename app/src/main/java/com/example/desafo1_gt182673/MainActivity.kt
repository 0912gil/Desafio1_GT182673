package com.example.desafo1_gt182673

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnPromedio).setOnClickListener {
            val intent = Intent(this, PromedioActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnSalario).setOnClickListener {
            val intent = Intent(this, SalarioActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnCalculadora).setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}