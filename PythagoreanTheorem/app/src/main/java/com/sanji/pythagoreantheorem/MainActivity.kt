package com.sanji.pythagoreantheorem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sanji.pythagoreantheorem.databinding.ActivityMainBinding
import java.lang.Math.sqrt
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickButtonOfResult(view: View){
        if (!correctFill()){
            binding.apply {
                val result = getString(R.string.result) + getResult()
                resultText.text = result
            }
        }
    }

    private fun correctFill():Boolean {
        binding.apply {
            if (textInputA.text.isNullOrEmpty()) textInputA.error = "Field is empty!"
            if (textInputB.text.isNullOrEmpty()) textInputB.error = "Field is empty!"
            return textInputA.text.isNullOrEmpty() || textInputB.text.isNullOrEmpty()
        }
    }

    private fun getResult():String {
        val a: Double
        val b: Double
        binding.apply {
            a = textInputA.text.toString().toDouble()
            b = textInputB.text.toString().toDouble()
        }
        return (sqrt(a.pow(2)+b.pow(2))).toString()
    }
}