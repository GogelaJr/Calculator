package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var topTextView: TextView
    private lateinit var resultTextView: TextView
    private var cleared: Int = 0
    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.resultTextView= findViewById(R.id.resultTextView)
        this.topTextView = findViewById(R.id.topTextview)
    }
    fun numberClick(clickedView: View) {
        if (clickedView is Button) {
            val toptextupdate: String = this.topTextView.text.toString()
            val number: String = clickedView.text.toString()
            var result: String = this.resultTextView.text.toString()
            if (result == "0") {
                result = ""
            }

            resultTextView.text = "$result$number"
            topTextView.text = "$toptextupdate"
        }
    }
    fun operationClick(view: View){

        if (view is Button) {
            val operstring: String =view.text.toString()
            if (resultTextView.text.isNotEmpty()){
                operand = resultTextView.text.toString().toDouble()

            }
            var operandstr:String  = operand.toString()
            this.operation =  view.text.toString()
            this.topTextView.text = "$operandstr $operstring"
            this.resultTextView.text = ""

        }
    }
    fun equalsClick(view: View) {
        val secOperandText: String = this.resultTextView.text.toString()
        var secOperand: Double = 0.0
        if (secOperandText.isNotEmpty()){
            secOperand = secOperandText.toDouble()
        }
        when(this.operation){


            "+" -> this.resultTextView.text = (this.operand + secOperand).toString()
            "-" -> this.resultTextView.text = (this.operand - secOperand).toString()
            "*" -> this.resultTextView.text = (this.operand * secOperand).toString()
            "/" -> this.resultTextView.text = (this.operand / secOperand).toString()

        }
        when(this.operation){


            "+" -> this.topTextView.text ="$operand + $secOperand"

            "-" -> this.topTextView.text ="$operand - $secOperand ="
            "*" -> this.topTextView.text ="$operand * $secOperand ="
            "/" -> this.topTextView.text ="$operand / $secOperand ="
        }

    }
    fun clearClick(clickedView: View){
        if(clickedView is Button) {

            this.operand = 0.0

            resultTextView.text = "$cleared"
            topTextView.text =""


        }
    }
    fun delClick(clickedView: View){
        if(clickedView is Button){
            val string = resultTextView.text.toString()
            if(string.isNotEmpty()){
                resultTextView.text = string.substring(0,string.length-1)
            }

        }

    }
}