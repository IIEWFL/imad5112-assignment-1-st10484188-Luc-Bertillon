package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //assigned variables
        val btnReset = findViewById<Button>(R.id.btnReset)
        val txtView = findViewById<TextView>(R.id.TxtView)
        val edtTime = findViewById<EditText>(R.id.EdtTime)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val btnExit = findViewById<Button>(R.id.btnExit)

        //Generates meal for time of day
        btnGenerate.setOnClickListener {
            val input = edtTime.text.toString().trim().lowercase()

            val meals: String

            when (input) {
                "morning" -> {
                    meals = "Breakfast: Oatmeal"
                }
                "mid-morning" -> {
                    meals = "Snack: Banana berry smoothie"
                }
                "afternoon" -> {
                    meals = "Lunch: Toasted chicken mayo"
                }
                "mid-afternoon" -> {
                    meals = "Snack: Nuggets"
                }
                "dinner" -> {
                    meals = "Main Course: Spaghetti Bolognese"
                }
                "after dinner" -> {
                    meals = "Dessert: Banana bread"
                }
                else -> {
                    meals = "Invalid input! Please enter a text"
                    Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
                }
            }
            //Displays meal
            txtView.text = meals
        }
        //Reset button to clear textviews and EditTexts
        btnReset.setOnClickListener {
            txtView.text = ""
            edtTime.text.clear()
            Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show()
        }
        //Closes App
        btnExit.setOnClickListener{
            finish()
        }
    }
}