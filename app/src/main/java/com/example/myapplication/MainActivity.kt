package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularIMC(view: View) {

        val estatura = findViewById<EditText>(R.id.est)
        val kilogramos = findViewById<EditText>(R.id.kilos)

        var bndEstatura = true
        var bndKilogramos = true

        estatura.error = null
        kilogramos.error = null

        if(estatura.text.toString().trim().isEmpty()) {

            bndEstatura = false
            estatura.error = getString(R.string.activity_main_error)

        }
        if(kilogramos.text.toString().trim().isEmpty()) {

            bndKilogramos = false
            kilogramos.error = getString(R.string.activity_main_error)

        }

        if(bndEstatura && bndKilogramos) {

            val imc = kilogramos.text.toString().toFloat() / estatura.text.toString().toFloat().pow(2)
            var imcMessage = ""

            if(imc < 15) imcMessage = "Delgadez muy severa"
            else if(imc > 15 && imc < 15.9) imcMessage = "Delgadez severa"
            else if(imc > 16 && imc < 18.4) imcMessage = "Delgadez"
            else if(imc > 18.5 && imc < 24.9) imcMessage = "Peso saludable"
            else if(imc > 25 && imc < 29.9) imcMessage = "Sobrepeso"
            else if(imc > 30 && imc < 34.9) imcMessage = "Obesidad moderada"
            else if(imc > 35 && imc < 39.9) imcMessage = "Obesidad severa"
            else if(imc > 40) imcMessage = "Obesidad mórbida"


            Toast.makeText(
                this@MainActivity,
                imc.toString() + ": " + imcMessage,
                Toast.LENGTH_LONG
            ).show()

        }



    }

}