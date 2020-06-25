package com.sujay2811.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


//hi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one.setOnClickListener { append("1",true) }
        two.setOnClickListener { append("2",true) }
        three.setOnClickListener { append("3",true) }
        four.setOnClickListener { append("4",true) }
        five.setOnClickListener { append("5",true) }
        six.setOnClickListener { append("6",true) }
        seven.setOnClickListener { append("7",true) }
        eight.setOnClickListener { append("8",true) }
        nine.setOnClickListener { append("9",true) }
        zero.setOnClickListener { append("0",true) }


        plus.setOnClickListener { append("+",false) }
        minus.setOnClickListener { append("-",false)}
        multi.setOnClickListener { append("*",false)}
        divide.setOnClickListener { append("/",false)}
        open.setOnClickListener { append("(",false)}
        close.setOnClickListener { append(")",false)}


        back.setOnClickListener {
            val string = expression.text.toString()
            if(string.isNotEmpty()){
                expression.text = string.substring(0,string.length-1)
            }
            result.text = ""
        }

        clear.setOnClickListener {
            result.text=""
            expression.text=""
        }

        equal.setOnClickListener {
            try {

                val expression = ExpressionBuilder(expression.text.toString()).build()
                val output = expression.evaluate()
                val longResult = output.toLong()
                if(output == longResult.toDouble())
                    result.text = longResult.toString()
                else
                    result.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }
    fun append(string: String, clear: Boolean)
    {
        if(result.text.isNotEmpty()){
            expression.text = ""
        }
        if (clear)
        {
            result.text=""
            expression.append(string)
        }
        else
        {
            expression.append(result.text)
            expression.append(string)
            result.text = ""

        }
    }

}