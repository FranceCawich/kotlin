package com.example.rfc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val buttonBora = findViewById < Button >(R.id.buttonBora)
        buttonBora.setOnClickListener(i:viewOnClickListener)



    }
}