package com.example.folhadeponto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val OpenLoginPageButton = findViewById<Button>(R.id.LoginPageButton)
        OpenLoginPageButton.setOnClickListener {
            val Show = Intent(this, LoginActivity::class.java)
            startActivity(Show)
        }


    }
}