package com.example.curpviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*



import java.util.*

class rfc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rfc)
        var sexo = ""
        val valores = mutableListOf("0","1","2","3","4","5","6","7","8","9")
        var estados = arrayOf("AS-Aguascalientes","BC-Baja California","BS-Baja California Sur","CC-Campeche","CL-Coahuila","CM-Colima","CS-Chiapas",
            "CH-Chihuahua","DG-Durango","GT-Guanajuato","GR-Guerrero","HG-Hidalgo","JC-Jalisco","MC-México","MN-Michoacán","MS-Morelos","NT-Nayarit",
            "NL-Nuevo León","OC-Oaxaca","PL-Puebla","QT-Querétaro","QR-Quintana Roo","SP-San Luis Potosí")

        val arrayAdapter = ArrayAdapter(this@rfc,android.R.layout.simple_spinner_dropdown_item,estados)



        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val estado = (estados[position])
                Estadotxt.setText(estado)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }
}