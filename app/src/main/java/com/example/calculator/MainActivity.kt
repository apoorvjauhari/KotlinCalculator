package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    val output:TextView = findViewById(R.id.solution)
    val input:TextView = findViewById(R.id.query)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clear:Button = findViewById(R.id.clear)
       // val output:TextView = findViewById(R.id.solution)
       // val input:TextView = findViewById(R.id.query)

       clear.setOnClickListener {
            val removedLast = input.text.toString().dropLast(1)
            input.text = removedLast
        }


        val one:Button = findViewById(R.id.one)
        one.setOnClickListener {
            input.text = addToInputText("1")
        }
        val two:Button = findViewById(R.id.two)
        two.setOnClickListener {
            input.text = addToInputText("2")
        }
        val three:Button = findViewById(R.id.three)
        three.setOnClickListener {
            input.text = addToInputText("3")
        }
        val four:Button = findViewById(R.id.four)
        four.setOnClickListener {
            input.text = addToInputText("4")
        }
          val five:Button = findViewById(R.id.five)
        five.setOnClickListener {
            input.text = addToInputText("5")
        }
        val six:Button = findViewById(R.id.six)
        six.setOnClickListener {
            input.text = addToInputText("6")
        }
        val seven:Button = findViewById(R.id.seven)
        seven.setOnClickListener {
            input.text = addToInputText("7")
        }
        val eight:Button = findViewById(R.id.eight)
            eight.setOnClickListener {
            input.text = addToInputText("8")
        }
        val nine:Button = findViewById(R.id.nine)
        nine.setOnClickListener {
            input.text = addToInputText("9")
        }
        val zero:Button = findViewById(R.id.zero)
        zero.setOnClickListener {
            input.text = addToInputText("0")
        }
        val division:Button = findViewById(R.id.divide)
        division.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        val multiply:Button = findViewById(R.id.multiply)
        multiply.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }
        val subtract:Button = findViewById(R.id.substract)
        subtract.setOnClickListener {
            input.text = addToInputText("-")
        }
        val addition:Button = findViewById(R.id.add)
        addition.setOnClickListener {
            input.text = addToInputText("+")
        }
        val equal:Button = findViewById(R.id.equals)
        equal.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {

        return input.text.toString() + "" + buttonValue
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = ""

            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()

            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = ""

        }
    }
}