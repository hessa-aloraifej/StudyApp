package com.example.studyapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var addbtn= findViewById<Button>(R.id.button)
        var buttonkotlin= findViewById<Button>(R.id.buttonk)
        var buttonandroid=findViewById<Button>(R.id.buttona)
        buttonkotlin.setOnClickListener {
            val intent = Intent(this, kotlinactivity::class.java)
            startActivity(intent)
        }
        buttonandroid.setOnClickListener {
            val intent = Intent(this, androidactivity::class.java)
            startActivity(intent)
        }
        addbtn.setOnClickListener {
            val intent = Intent(this, ADDContent::class.java)
            startActivity(intent)
        }

    }
}