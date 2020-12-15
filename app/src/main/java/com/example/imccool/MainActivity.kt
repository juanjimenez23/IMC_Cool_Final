package com.example.imccool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.reflect.KMutableProperty0

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var edad:Int = 19
    var peso:Int = 74
    var altura:Int = 172
    var sexo:String = "Sexo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekAltura.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

               if(p1 <= 100){
                   seekAltura.setProgress(100)
                   tvAltura.text ="100"
                   altura = 100
               }else{
                   tvAltura.text ="$p1"
                   altura = p1
               }
                //tvAltura.text = "$p1"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        btnEdadMas.setOnClickListener(this)
        btnEdadMenos.setOnClickListener(this)
        btnPesoMas.setOnClickListener(this)
        btnPesoMenos.setOnClickListener(this)
        imbtnHombre.setOnClickListener(this)
        imbtnMujer.setOnClickListener(this)
        btnCalcular.setOnClickListener(this)

        tvPeso.text = "$peso"
        tvAltura.text = "$altura"

    }
    override fun onClick(p0: View?) {
        //Log.wtf("click", "Se dio clic a algo: ${p0!!.id}")
        when(p0!!.id){
            R.id.btnEdadMas->{
                edad++
                tvEdad.text = "$edad"
            }
            R.id.btnEdadMenos->{
                edad--
                tvEdad.text = "$edad"
            }
            R.id.btnPesoMas->{
                peso++
                tvPeso.text = "$peso"
            }
            R.id.btnPesoMenos->{
                peso--
                tvPeso.text = "$peso"
            }
            R.id.imbtnHombre->sexo = "m"
            R.id.imbtnMujer->sexo = "f"
            R.id.btnCalcular->{
                val imc = calculaIMC(peso, altura)
                val intencion = Intent(this,ActivityResultados::class.java)
                intencion.putExtra("bmi",imc)
                intencion.putExtra("gender",sexo)
                intencion.putExtra("age",edad)
                startActivity(intencion)
            }



        }
    }

    fun calculaIMC(peso:Int, altura:Int):Float{
        val pesof = peso.toFloat()
        val alturaf = altura.toFloat()/100
        val imc = pesof/(alturaf*alturaf)

        return imc.toFloat()
    }
}