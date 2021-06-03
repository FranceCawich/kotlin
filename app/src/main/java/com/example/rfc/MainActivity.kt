package com.example.rfc


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val buttonBora = findViewById <Button>(R.id.buttonBora)
       val buttonRFc = findViewById<Button>(R.id.RFC)

       val editText1 = findViewById<EditText>(R.id.one)
        val editText2 = findViewById<EditText>(R.id.editTextTextPersonName2)

        val editText3 = findViewById<EditText>(R.id.editTextTextPersonName3)
        val editText4 = findViewById<EditText>(R.id.editTextTextPersonName4)
        val editText5 = findViewById<EditText>(R.id.editTextTextPersonName5)
        val editText6 = findViewById<EditText>(R.id.editTextTextPersonName6)




        buttonBora.setOnClickListener {     // Set the first EditText empty
            editText1.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")
            editText5.setText("")
            editText6.setText("")
        }

        buttonRFc.setOnClickListener {
            val msg = editText1.text.toString().substring(0,3);
            val text = findViewById<TextView>(R.id.textView99).apply {
                text = msg
            }



        }

    }
}