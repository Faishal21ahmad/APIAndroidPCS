package com.aplikasi.pcs

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var input1 : EditText? = null
    var input2 : EditText? = null
    var output : TextView? = null
    var v1 : Int? = null
    var v2 : Int? = null
    var Hasil : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input1 = findViewById<View>(R.id.input1) as EditText
        input2 = findViewById<View>(R.id.input2) as EditText
        output = findViewById<View>(R.id.Hasil) as TextView
    }

    fun konversi(){
        v1 = input1!!.text.toString().toInt()
        v2 = input2!!.text.toString().toInt()
    }

    fun prosesTambah(view: View?){
        konversi()
        Hasil = v1!! + v2!!
        output!!.text = java.lang.Integer.toString(Hasil!!)

    }


}