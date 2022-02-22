package com.tribits.biggernumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        assignNumbersToButtons()
        btnLeft.setOnClickListener {

            checkAnswer(true)

            assignNumbersToButtons()
        }

        btnRight.setOnClickListener {

            checkAnswer(false)

            assignNumbersToButtons()
        }
    }

    private fun checkAnswer(isLeftButtonSelected:Boolean){
        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        val backgroundView = findViewById<View>(R.id.backgroundView)
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if(isAnswerCorrect) {
            backgroundView.setBackgroundColor(Color.GREEN)

            Toast.makeText(this, "Correct!",Toast.LENGTH_SHORT).show()
        }
        else{
            backgroundView.setBackgroundColor(Color.RED)

            Toast.makeText(this,"Wrong!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while(rightNum == leftNum){
            rightNum = r.nextInt(10)
        }
        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }
}