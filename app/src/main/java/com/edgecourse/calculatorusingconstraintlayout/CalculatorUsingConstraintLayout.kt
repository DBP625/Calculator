package com.edgecourse.calculatorusingconstraintlayout

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.reflect.InvocationTargetException

class CalculatorUsingConstraintLayout : AppCompatActivity() {

    private var firstOperand: Double =
        0.0 //It stores the first number entered before an operator (like *, +, etc.) is chosen.
    private var operator: String = "" //It stores the operator chosen by the user.
    private var isNewEntry: Boolean = true
    private val historyList: MutableList<String> = mutableListOf()
    //MutableList: Represents a list where you can modify its contents (e.g., add, remove, update items).
    //mutableListOf(): A Kotlin function that creates an empty, mutable list.

    private fun updateHistory(operation: String, result: String) {
        val historyTextView: TextView = findViewById(R.id.History)
        val historyEntry = "$operation = $result"
        historyList.add(historyEntry)
        historyTextView.text = historyList.joinToString("\n")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculator_using_constraint_layout)

        try {
            setContentView(R.layout.activity_calculator_using_constraint_layout)

            val Btn0: Button = findViewById(R.id.btnzeroo)
            val Btn1: Button = findViewById(R.id.btn1)
            val Btn2: Button = findViewById(R.id.btn2)
            val Btn3: Button = findViewById(R.id.btn3)
            val Btn4: Button = findViewById(R.id.btn4)
            val Btn5: Button = findViewById(R.id.btn5)
            val Btn6: Button = findViewById(R.id.btn60)
            val Btn7: Button = findViewById(R.id.btn7)
            val Btn8: Button = findViewById(R.id.btn8)
            val Btn9: Button = findViewById(R.id.btn9)
            val BtnAC: Button = findViewById(R.id.btnAC)
            val Display: TextView = findViewById(R.id.Display)
            val BtnPlus: Button = findViewById(R.id.btnplus)
            val BtnMinus: Button = findViewById(R.id.btnminus)
            val BtnMul: Button = findViewById(R.id.btnmult)
            val BtnDiv: Button = findViewById(R.id.btndivide)
            val BtnEqual: Button = findViewById(R.id.btnequal)
            val BtnPercentage: Button = findViewById(R.id.btnpercent)


            BtnAC.setOnClickListener { view ->
                Display.setText("0")
                historyList.clear()
                val historyTextView: TextView = findViewById(R.id.History)
                historyTextView.text = ""
            }

            BtnPercentage.setOnClickListener { view ->
                firstOperand = Display.text.toString().toDouble()
                operator = "%"
                Display.text = "$firstOperand %"
            }
            BtnPlus.setOnClickListener { view ->
                firstOperand = Display.text.toString().toDouble()
                operator = "+"
                Display.text = "$firstOperand +"
                isNewEntry = true


            }

            BtnMinus.setOnClickListener { view ->
                firstOperand = Display.text.toString().toDouble()
                operator = "-"
                Display.text = "$firstOperand -"
                isNewEntry = true
            }

            BtnMul.setOnClickListener { view ->
                firstOperand = Display.text.toString().toDouble()
                operator = "*"
                Display.text = "$firstOperand *"
                isNewEntry = true
            }

            BtnDiv.setOnClickListener { view ->
                firstOperand = Display.text.toString().toDouble()
                operator = "/"
                Display.text = "$firstOperand /"
                isNewEntry = true
            }

            BtnEqual.setOnClickListener { view ->
                val secondOperand = if (operator != "%") Display.text.toString().trim()
                    .removePrefix("$firstOperand $operator").toDouble() else 0.0
                var result = when (operator) {
                    "+" -> firstOperand + secondOperand
                    "-" -> firstOperand - secondOperand
                    "*" -> firstOperand * secondOperand
                    "/" -> firstOperand / secondOperand
                    "%" -> firstOperand / 100
                    else -> secondOperand
                }
                val operation = if (operator != "%") "$firstOperand $operator $secondOperand"
                else "$firstOperand $operator"
                updateHistory(operation, result.toString())
                Display.text = result.toString()
                isNewEntry = true
            }

            Btn0.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("0")
                else Display.setText(current + "0")
            }

            Btn1.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("1")
                else Display.setText(current + "1")
            }


            Btn2.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("2")
                else Display.setText(current + "2")
            }

            Btn3.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("3")
                else Display.setText(current + "3")
            }

            Btn4.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("4")
                else Display.setText(current + "4")
            }

            Btn5.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("5")
                else Display.setText(current + "5")
            }

            Btn6.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("6")
                else Display.setText(current + "6")
            }

            Btn7.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("7")
                else Display.setText(current + "7")
            }

            Btn8.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("8")
                else Display.setText(current + "8")
            }

            Btn9.setOnClickListener { view ->
                val current = Display.text.toString().trim()
                if (current == "0") Display.setText("9")
                else Display.setText(current + "9")
            }

        } catch (e: InvocationTargetException) {
            val cause = e.cause
            System.err.println("InvocationTargetException caught: $cause")
            cause?.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }
}