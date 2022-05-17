package com.example.calculatorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.databinding.FragmentConvBinding
import com.example.calculatorapp.databinding.FragmentImcBinding

class ImcFragment : Fragment() {

    lateinit var binding: FragmentImcBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentImcBinding.inflate(inflater, container,false)

        binding.btnCalcular.setOnClickListener {
            // peso / altura
            val peso = binding.edtPeso.text.toString().toDouble()
            val altura = binding.edtAltura.text.toString().toDouble()

            val resultado = peso / altura * altura

            binding.resultsTV.text = "Seu IMC é $resultado"
        }

        return return binding.root
    }


}