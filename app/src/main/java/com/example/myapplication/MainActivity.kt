package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextAltura: EditText
    private lateinit var radioButtonMasculino: RadioButton
    private lateinit var radioButtonFeminino: RadioButton
    lateinit var buttonCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(res.layout.activity_main)

        editTextAltura = findViewById(R.id.editTextAltura)
        radioButtonMasculino = findViewById(R.id.radioButtonMasculino)
        radioButtonFeminino = findViewById(R.id.radioButtonFeminino)
        buttonCalcular = findViewById(R.id.buttonCalcular)

        buttonCalcular.setOnClickListener {
            val alturaText = editTextAltura.text.toString()
            if (alturaText.isEmpty()) {
                Toast.makeText(this, "Digite sua altura", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val altura = alturaText.toDouble()
            val pesoIdeal: Double

            pesoIdeal = when {
                radioButtonMasculino.isChecked -> (72.7 * altura) - 58
                radioButtonFeminino.isChecked -> (62.1 * altura) - 44.7
                else -> {
                    Toast.makeText(this, "Selecione o sexo", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            val mensagem = "Seu peso ideal é: %.2f kg".format(pesoIdeal)
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }
}





