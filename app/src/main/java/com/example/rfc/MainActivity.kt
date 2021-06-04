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
        val buttonBora = findViewById<Button>(R.id.buttonBora)
        val buttonRFc = findViewById<Button>(R.id.RFC)

        val editText1 = findViewById<EditText>(R.id.one)
        val editText2 = findViewById<EditText>(R.id.editTextTextPersonName2)

        val editText3 = findViewById<EditText>(R.id.editTextTextPersonName3)
        val editText4 = findViewById<EditText>(R.id.editTextTextPersonName4)
        val editText5 = findViewById<EditText>(R.id.editTextTextPersonName5)
        val editText6 = findViewById<EditText>(R.id.editTextTextPersonName6)


        val one = findViewById<TextView>(R.id.textView99)
        val pp = findViewById<TextView>(R.id.textView6)
        val nom = findViewById<TextView>(R.id.textViewNO)
        val ano = findViewById<TextView>(R.id.textView7año)
        val mes = findViewById<TextView>(R.id.textViewMEs)

        val dia = findViewById<TextView>(R.id.textViewdia)
        val homo = findViewById<TextView>(R.id.homo_text)

        buttonBora.setOnClickListener {     // Set the first EditText empty
            editText1.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")
            editText5.setText("")
            editText6.setText("")
            one.setText("")
            pp.setText("")
            nom.setText("")
            ano.setText("")
            mes.setText("")
            dia.setText("")
            homo.setText("")


        }
      val gen = GeneradorHomo()

        buttonRFc.setOnClickListener {
        val hom = gen.Generator(lenght = 3,specialword = "")
        homo.text = hom

            val msg = editText3.text.toString().substring(0, 2);
            val msg2 = editText2.text.toString().substring(0, 1);
            val msg3 = editText1.text.toString().substring(0, 1);
            val msg4 = editText6.text.toString().substring(0, 2);
            val msg5 = editText5.text.toString().substring(0, 2);
            val msg6 = editText4.text.toString().substring(0, 2);

            one.apply { text = msg }
            pp.apply { text = msg2 }
            nom.apply { text = msg3 }
            ano.apply { text = msg4 }
            mes.apply {  text = msg5 }
            dia.apply { text = msg6 }



        }






    }

}