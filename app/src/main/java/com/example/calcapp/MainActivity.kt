package com.example.calcapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

   // declared the array of my ten size
    val numberArray = IntArray(10)
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //get Ui from Activity_main
        val editNum = findViewById<EditText>(R.id.editNum)
        val txtMessage = findViewById<TextView>(R.id.txtMessage)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnAverage = findViewById<Button>(R.id.btnAverage)

        //added button
        btnSave?.setOnClickListener {
            val input = editNum.text.toString().toInt()

            if (counter >=10) {
                txtMessage.text = " More value cannot be stored."
            } else {
                numberArray[counter] = input
                counter ++
                editNum.text.clear()
            }
        }

        // added my second button
        btnAverage?.setOnClickListener {
         if (counter ==0) {
             txtMessage.text="please enter some number frist"
         } else {
             var sum = 0
             var i = 0

             // the while loop running through the saved slots
             while (i < counter){
                 sum += numberArray[i]
                 i++

                 // Apply the formula: Average = sum/ number of values
                 val Average = sum.toDouble() / counter

                 txtMessage.text = "Average: + average.toString ()"
             }
         }

        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnAverage)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}