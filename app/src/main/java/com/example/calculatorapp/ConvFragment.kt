package com.example.calculatorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.calculatorapp.databinding.FragmentConvBinding


class ConvFragment : Fragment() {

    lateinit var binding: FragmentConvBinding

    lateinit var inputText: EditText
    lateinit var outputText: TextView
    lateinit var optCelcius: RadioButton
    lateinit var optFahreinheit:RadioButton
    lateinit var btnConverter: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConvBinding.inflate(inflater, container,false)

        inputText = binding.inputText
        inputText.requestFocus()

        outputText = binding.outputText
        optCelcius = binding.optCelcius
        optFahreinheit = binding.optFahreinheit
        btnConverter = binding.btnConvert

        btnConverter.setOnClickListener{convert(it)}

        return return binding.root
    }

    fun convert(view: View) {
        if (inputText.text.isEmpty()) {
            val msg = Toast.makeText(view.context, "Digite o valor a ser convertido.", Toast.LENGTH_LONG)
            msg.show()
            return
        }

        var temp:Double = inputText.text.toString().toDouble()
        temp = if (optCelcius.isChecked) {
            (temp - 32) * 5/9
        } else {
            temp * 9/5 + 32
        }

        outputText.text = temp.toString()
    }

}