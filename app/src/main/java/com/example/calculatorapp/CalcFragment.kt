package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.databinding.FragmentCalcBinding
import net.objecthunter.exp4j.ExpressionBuilder


class CalcFragment : Fragment() {


    lateinit var binding: FragmentCalcBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcBinding.inflate(inflater, container,false)

        binding.btnClear.setOnClickListener {
            binding.inputText.text = ""
            binding.outputText.text = ""
        }

        binding.btnZeroZero.setOnClickListener {
            binding.inputText.append("00")
        }

        binding.btnZero.setOnClickListener {
            binding.inputText.append("0")
        }

        binding.btnOne.setOnClickListener {
            binding.inputText.append("1")
        }

        binding.btnTwo.setOnClickListener {
            binding.inputText.append("2")
        }


        binding.btnThree.setOnClickListener {
            binding.inputText.append("3")
        }

        binding.btnFour.setOnClickListener {
            binding.inputText.append("4")
        }

        binding.btnFive.setOnClickListener {
            binding.inputText.append("5")
        }


        binding.btnSix.setOnClickListener {
            binding.inputText.append("6")
        }

        binding.btnSeven.setOnClickListener {
            binding.inputText.append("7")
        }

        binding.btnEight.setOnClickListener {
            binding.inputText.append("8")
        }

        binding.btnNine.setOnClickListener {
            binding.inputText.append("9")
        }

        binding.btnDecimal.setOnClickListener {
            binding.inputText.append(".")
        }

        binding.btnAdd.setOnClickListener {
            binding.inputText.append(" + ")
        }

        binding.btnDivide.setOnClickListener {
            binding.inputText.append(".")
        }

        binding.btnAdd.setOnClickListener {
            binding.inputText.append(" + ")
        }

        binding.btnDivide.setOnClickListener {
            binding.inputText.append(" / ")
        }

        binding.btnSubtract.setOnClickListener {
            binding.inputText.append(" - ")
        }

        binding.btnMultiply.setOnClickListener {
            binding.inputText.append(" * ")
        }

        binding.btnModulo.setOnClickListener {
            binding.inputText.append(" % ")
        }

        binding.btnExponentation.setOnClickListener {
            binding.inputText.append(" ^ ")
        }

        /*
        binding.btnStartBracket.setOnClickListener {
            binding.inputText.append(" ( ")
        }

        binding.btnEndBracket.setOnClickListener {
            binding.inputText.append(" ) ")
        }
        */

        binding.btnEqual.setOnClickListener{

            try {
                val expression = ExpressionBuilder(binding.inputText.text.toString()).build()

                val result = expression.evaluate()
                val longResult = result.toLong()


                if(result == longResult.toDouble()) {

                    binding.outputText.text = longResult.toString()
                }else {
                    binding.outputText.text = result.toString()
                }
            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }


        }

        return binding.root
    }


}