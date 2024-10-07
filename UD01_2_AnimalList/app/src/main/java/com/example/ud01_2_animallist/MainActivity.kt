package com.example.ud01_2_animallist

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener{
            val spinnerAnimalType = findViewById<Spinner>(R.id.AnimalList)
            val textKindsAnimals = findViewById<TextView>(R.id.textKindsAnimals)

            textKindsAnimals.text = getAnimals(spinnerAnimalType.selectedItemId).joinToString("\n")

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun getAnimals(id : Long) = when (id){
        0L -> listOf(R.string.Sheppard, R.string.chihuahua)
        1L -> listOf(R.string.Egypt, R.string.Persian)
        2L -> listOf(R.string.Mallard, R.string.White_Call)
        else  -> listOf()
    }
}