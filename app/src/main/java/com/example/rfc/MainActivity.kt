package com.example.rfc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val buttonBora = findViewById < Button >(R.id.buttonBora)
       val editText1 = findViewById<EditText>(R.id.editTextTextPersonName)
        val editText2 = findViewById<EditText>(R.id.editTextTextPersonName2)
        val editText3 = findViewById<EditText>(R.id.editTextTextPersonName3)
        val editText4 = findViewById<EditText>(R.id.editTextTextPersonName4)
        val editText5 = findViewById<EditText>(R.id.editTextTextPersonName5)
        val editText6 = findViewById<EditText>(R.id.editTextTextPersonName6)



        buttonBora.setOnClickListener {     // Set the first EditText empty
            editText1.setText("");


        }



    }
}