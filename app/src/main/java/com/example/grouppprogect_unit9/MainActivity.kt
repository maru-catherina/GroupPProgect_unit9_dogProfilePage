package com.example.grouppprogect_unit9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val moveToDogProfileBut: Button = findViewById(R.id.moveToDogPageButton)

        // Set an onClickListener on the button
        moveToDogProfileBut.setOnClickListener {
            // Create an intent to navigate to MainActivity2
            val intent = Intent(this, DogProfile::class.java)
            // Start MainActivity2 using the intent
            startActivity(intent)
        }
    }
}
