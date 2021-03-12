package com.costoda.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById<Button>(R.id.button)
        val tvLucky: TextView = findViewById<TextView>(R.id.tvLucky)
        val diceImage: ImageView = findViewById<ImageView>(R.id.imageView)

        rollButton.setOnClickListener {
            val message: String

            val dice = Dice(6)
            val rollValue = dice.roll()

            diceImage.contentDescription = rollValue.toString()
            tvLucky.text = ""

            when(rollValue) {
                1 -> {
                    tvLucky.text = "you rolled a critical fail"
                    diceImage.setImageResource(R.drawable.dice_1)
                }
                2 -> {
                    diceImage.setImageResource(R.drawable.dice_2)
                }
                3 -> {
                    diceImage.setImageResource(R.drawable.dice_3)
                }
                4 -> {
                    diceImage.setImageResource(R.drawable.dice_4)
                }
                5 -> {
                    diceImage.setImageResource(R.drawable.dice_5)
                }
                dice.numSides -> {
                    tvLucky.text = "you rolled a crit!"
                    diceImage.setImageResource(R.drawable.dice_6)
                }
            }
            message = "Dice Rolled!"

            var toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}