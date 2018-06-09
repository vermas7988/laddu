package com.yaka.calculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Double

class MainActivity : AppCompatActivity() {
    val TAG:String = "FIRST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

    }
    fun goingThere(view: View){
        val intent=Intent(this,Main2Activity::class.java)
        startActivity(intent)
    }

    fun onbutton(view: View) {
        Log.d(TAG, "you just pressed this button")
        var s1=op1.text
        var s2= op2.text
        val n1=Double.parseDouble(s1.toString())
        val n2=Double.parseDouble(s2.toString())
        val n3=n1+n2
        op3.setText(n3.toString())
        Toast.makeText(this,"the output is "+n3.toString(),Toast.LENGTH_LONG).show()

    }

    fun onbutton1(view: View) {
        Log.d(TAG, "you just pressed this button")
        var s1=op1.text
        var s2= op2.text
        val n1=Double.parseDouble(s1.toString())
        val n2=Double.parseDouble(s2.toString())
        val n3=n1-n2
        op3.setText(n3.toString())

    }

    fun onbutton2(view: View) {
        Log.d(TAG, "you just pressed this button")
        var s1=op1.text
        var s2= op2.text
        val n1=Double.parseDouble(s1.toString())
        val n2=Double.parseDouble(s2.toString())
        val n3=n1*n2
        op3.setText(n3.toString())

    }
    fun onbutton3(view: View) {
        Log.d(TAG, "you just pressed this button")
        var s1=op1.text
        var s2= op2.text
        val n1=Double.parseDouble(s1.toString())
        val n2=Double.parseDouble(s2.toString())
        val n3=n1/n2
        op3.setText(n3.toString())

    }
}
