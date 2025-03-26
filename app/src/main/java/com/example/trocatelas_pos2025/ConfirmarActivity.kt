package com.example.trocatelas_pos2025

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCod : TextView
    private lateinit var tvQtd : TextView
    private lateinit var tvValor : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar)

        val cod = intent.getStringExtra("cod")
        val qtd = intent.getStringExtra("qtd")
        val valor = intent.getStringExtra("valor")


        tvCod = findViewById(R.id.tvCod)
        tvQtd = findViewById(R.id.tvQtd)
        tvValor = findViewById(R.id.tvValor)

        tvCod.setText( cod )
        tvQtd.setText( qtd )
        tvValor.setText( valor )


    }

    fun btEnviarOnClick(view: View) {
        val sms_body = "cod: ${tvCod.text} qtd: ${tvQtd.text} valor: ${tvValor.text} "
        val phone_number = "sms:+5514996394514"

        val intent = Intent( Intent.ACTION_VIEW)
        intent.setData( Uri.parse( phone_number))
        intent.putExtra("sms_body", sms_body)

        startActivity(intent)
    }
}