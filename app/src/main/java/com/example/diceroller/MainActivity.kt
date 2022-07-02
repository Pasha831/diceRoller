package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        // Create new Dice1 and Dice 2 objects with 6 sides and roll them
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        // Update the screen with the roll of the first dice
        val resultTextView1: TextView = findViewById(R.id.dice1)
        resultTextView1.text = dice1.roll().toString()

        // Update the screen with the roll of the second dice
        val resultTextView2: TextView = findViewById(R.id.dice2)
        resultTextView2.text = dice2.roll().toString()
    }
}

/**
 * Roll the dice and update the screen with the result
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}