package com.example.finalapp

class homoclaveRecilado {


    private val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    fun Generator(lenght:Int, specialword: String = ""): String{

        val sb = StringBuilder(lenght)
        for (X:Int in 0 until lenght){
            val random = (characters.indices).random()
            sb.append(characters[random])
        }
        sb.insert((0 until lenght).random(),specialword)
        return sb.toString()
    }
}