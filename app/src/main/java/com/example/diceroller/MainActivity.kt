package com.example.diceroller

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        rollButton.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.click_sound)
            mp.start()
            rollDice()
        }

        // Do a roll dice when the app starts
        rollDice()
    }

    private fun rollDice() {
        // Create a dice and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find an ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.diceImage)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource
        diceImage.setImageResource(drawableResource)

        // Description for screen readers for disabled people who have problems with eyesight
        diceImage.contentDescription = diceRoll.toString()
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