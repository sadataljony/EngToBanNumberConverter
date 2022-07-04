package com.sadataljony.app.android.englishtobengalinumberconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sadataljony.app.android.englishtobengalinumberconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnConvert.setOnClickListener {
            if (!binding.etNumber.text.isBlank()) {
                val number: String =
                    convertEnglishToBanglaNumber(binding.etNumber.text.toString().trim())
                binding.tvShowConvertedNumber.text = number
            }
        }
    }

    private fun convertEnglishToBanglaNumber(number: String): String {
        val englishNumber = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        val banglaNumber = arrayOf('০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯')
        val values = StringBuilder()
        val character = number.toCharArray()
        for (value in character) {
            var c = ' '
            for (j in englishNumber.indices) {
                if (value == englishNumber[j]) {
                    c = banglaNumber[j]
                    break
                } else {
                    c = value
                }
            }
            values.append(c)
        }
        return values.toString()
    }
}