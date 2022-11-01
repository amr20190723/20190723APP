package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button=findViewById(R.id.submit)
        val editText1:EditText = findViewById(R.id.height)
        val editText2:EditText = findViewById(R.id.weight)
        val resultTV:TextView=findViewById(R.id.result)
        var flag:String="male"
        val spinnerVal: Spinner=findViewById(R.id.gender)
        var options = arrayOf("male","female")
        spinnerVal.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,options)

        button.setOnClickListener{
            var x: Int=editText1.text.toString().toInt()
            var y: Int=editText2.text.toString().toInt()
            if(flag=="male")
            resultTV.text= male(y,x).toString()
            else
                resultTV.text= female(y,x).toString()
        }
        spinnerVal.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag=options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}
public fun male(a: Int, b: Int):String{
    var x= (b/(a*a))*705
    var y: String="";
    y= if(x<= 18.5)
    {"Underweight"}
            else
                if(x<=24.9)
                {"normal"}
            else
                if(x<=29.9)
                {"overweight"}
            else
                {"very overweight"}
return y
}
public fun female(a: Int, b: Int):String{
    var x= (b/(a*a))*703
    var y: String="";
    y= if(x<= 18.5)
    {"Underweight"}
    else
        if(x<=24.9)
        {"normal"}
        else
            if(x<=29.9)
            {"overweight"}
            else
            {"very overweight"}
    return y
}
