package com.example.imccool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultados.*

class ActivityResultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val intencion = intent
        val imc = intencion.getFloatExtra("bmi",0.0F)
        tvResultadoIMC.text = "$imc"
        btnRegresar.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
    fun interpretaIMC (imc:Float, edad:Int, sexo:String) {
        var mensaje:String=""
        if (sexo=="f"){
            when(edad){
                in 19 .. 24->{
                    when(imc){
                        in 18.9 .. 22.1 ->{
                            mensaje="Excelente te encuentras en forma"
                    }
                        in 22.2 .. 25.5 ->{
                            mensaje="Te encuentras con algo de sobre peso"
                        }
                }
            }

            }
        }else if(sexo == "m"){
            }
        }
    }
