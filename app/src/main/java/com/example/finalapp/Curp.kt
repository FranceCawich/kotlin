package com.example.finalapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_curp.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class Curp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curp)

        var sexo = ""
        val valores = mutableListOf("0","1","2","3","4","5","6","7","8","9")
        var estados = arrayOf("AS-Aguascalientes","BC-Baja California","BS-Baja California Sur","CC-Campeche","CL-Coahuila","CM-Colima","CS-Chiapas",
            "CH-Chihuahua","DG-Durango","GT-Guanajuato","GR-Guerrero","HG-Hidalgo","JC-Jalisco","MC-México","MN-Michoacán","MS-Morelos","NT-Nayarit",
            "NL-Nuevo León","OC-Oaxaca","PL-Puebla","QT-Querétaro","QR-Quintana Roo","SP-San Luis Potosí","SL-Sinaloa","SR-Sonora","TC-Tabasco","TS-Tamaulipas",
            "TL-Tlaxcala","VZ-Veracruz","YN-Yucatan","ZS-Zacatecas","NE-Nacido en el Extrenjero")

        val arrayAdapter = ArrayAdapter(this@Curp,android.R.layout.simple_spinner_dropdown_item,estados)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
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

        val año = findViewById<EditText>(R.id.editTextTextPersonName2)
        val dia = findViewById<EditText>(R.id.editTextTextPersonName)
        val mes = findViewById<EditText>(R.id.editTextTextPersonName3)

        radio_G.setOnCheckedChangeListener { group, i ->
            if (i == R.id.radio_H)
                sexo = radio_H.text[0].toString()
            Toast.makeText(this,sexo,Toast.LENGTH_SHORT).show()
            if (i == R.id.radio_M)
                sexo = radio_M.text[0].toString()
            Toast.makeText(this,sexo,Toast.LENGTH_SHORT).show()
        }


        btncrear.setOnClickListener {
            val nombre = nombretxt.text;
            val apellido1 = apellidotxt.text
            val apellido2 = apellido2txt.text
            var apellidoVocal =checkConsonat(apellido1.toString())

            val consonanteapellido1 = checkVOcal(apellido1.toString())
            val consonanteapellido2 = checkVOcal(apellido2.toString())
            val consonantenombre = checkVOcal(nombre.toString())
            var valor2 = ""
            var valor14 = ""
            var valor15 = ""
            var valor16 = ""
            if (apellido1[0].toLowerCase() == 'a'|| apellido1[0].toLowerCase() == 'e'|| apellido1[0].toLowerCase() == 'i'|| apellido1[0].toLowerCase() == 'o'|| apellido1[0].toLowerCase() == 'u' ){
                valor2 = apellidoVocal[1].toString().toUpperCase()
            }
            else{
                valor2 = apellidoVocal[0].toString().toUpperCase()
            }
            if (apellido1[0].toLowerCase() == 'a'|| apellido1[0].toLowerCase() == 'e'|| apellido1[0].toLowerCase() == 'i'|| apellido1[0].toLowerCase() == 'o'|| apellido1[0].toLowerCase() == 'u' ){
                valor14 = consonanteapellido1[0].toString().toUpperCase()
            }
            else{
                valor14 = consonanteapellido1[1].toString().toUpperCase()
            }
            if (apellido2[0].toLowerCase() == 'a'|| apellido2[0].toLowerCase() == 'e'|| apellido2[0].toLowerCase() == 'i'|| apellido2[0].toLowerCase() == 'o'|| apellido2[0].toLowerCase() == 'u' ){
                valor15 = consonanteapellido2[0].toString().toUpperCase()
            }
            else{
                valor15 = consonanteapellido2[1].toString().toUpperCase()
            }
            if (nombre[0].toLowerCase() == 'a'|| nombre[0].toLowerCase() == 'e'|| nombre[0].toLowerCase() == 'i'|| nombre[0].toLowerCase() == 'o'|| nombre[0].toLowerCase() == 'u' ){
                valor16 = consonantenombre[0].toString().toUpperCase()
            }
            else{
                valor16 = consonantenombre[1].toString().toUpperCase()
            }

            if(nombre.length == 0 || apellido1.length == 0 || apellido2.length == 0){
                Toast.makeText(this,"alguno de los campos esta vacio",Toast.LENGTH_SHORT).show()
            }
            else{
                var valor1 = apellido1[0].toString().toUpperCase()
                var valor3 = apellido2[0].toString().toUpperCase()
                var valor4 = nombre[0].toString().toUpperCase()

                var valor11 = sexo
                var valor12 = Estadotxt.text[0]
                var valor13 = Estadotxt.text[1]

                val year= año.text.toString().substring(2, 4);

                val day = dia.text.toString().substring(0, 2);
                val month = mes.text.toString().substring(0, 2);

                ///generation de homo clave
                val gen = homoclaveRecilado()
                val hom = gen.Generator(lenght = 1,specialword = "")

              //  val valor17 = valores.random()
                val valor18 = valores.random()

                curp.text = valor1 + valor2 + valor3 + valor4 + year + day + month + valor11 + valor12 + valor13 + valor14 + valor15 + valor16 + hom + valor18
            }

        }
        btnlimpiar.setOnClickListener {
            var nombre = findViewById<EditText>(R.id.nombretxt)
            nombre.text.clear()
            var apellido = findViewById<EditText>(R.id.apellidotxt)
            apellido.text.clear()
            var apellido2 = findViewById<EditText>(R.id.apellido2txt)
            apellido2.text.clear()

            var estado = findViewById<TextView>(R.id.Estadotxt)
            estado.setText("Estado")
            var curp = findViewById<TextView>(R.id.curp)
            curp.setText("CURP")
        }
    }

    fun checkConsonat( text: String ): String {
        val result = StringBuilder()
        for ( char in text ) {
            if ( !"bcdfghjklmnñpqrstvwxyz".contains(char.toLowerCase()) ) {
                result.append( char )
            }
        }
        return result.toString()
    }

    fun checkVOcal( text: String ): String {
        val result = StringBuilder()
        for ( char in text ) {
            if ( !"aeiouw".contains(char.toLowerCase()) ) {
                result.append( char )
            }
        }
        return result.toString()
    }

}