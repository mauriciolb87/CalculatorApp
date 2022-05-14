package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class CalcActivity : AppCompatActivity() {
    // TextView usado para exibir a entrada e a saída
    lateinit var txtInput: TextView

    // Representa se a última tecla pressionada é numérica ou não
    var lastNumeric: Boolean = false

    // Representar que o estado atual está com erro ou não
    var stateError: Boolean = false

    // Se verdadeiro, não permite adicionar outro DOT ponto
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        txtInput = findViewById(R.id.resultsTV)
    }


    fun onDigit(view: View) {
        if (stateError) {
            // Se o estado atual for Erro, substitua a mensagem de erro
            txtInput.text = (view as Button).text
            stateError = false
        } else {
            // Se não, já existe uma expressão válida, então anexe a ela
            txtInput.append((view as Button).text)
        }
        //Definir a flag
        lastNumeric = true
    }

    /**
     * Adiciona . ao TextView
     */
    fun onDecimalPoint(view: View) {
        if (lastNumeric && !stateError && !lastDot) {
            txtInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    /**
     * Adiciona +,-,*,/ operadores no TextView
     */
    fun onOperator(view: View) {
        if (lastNumeric && !stateError) {
            txtInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false    // Reset o DOT flag
        }
    }


    /**
     * limpa TextView
     */
    fun onClear(view: View) {
        this.txtInput.text = ""
        lastNumeric = false
        stateError = false
        lastDot = false
    }

    /**
     * calculadora usando Exp4j
     */
    fun onEqual(view: View) {
        // Se o estado atual for erro, nada a fazer.
        //Se a última entrada for apenas um número, a solução pode ser encontrada
        if (lastNumeric && !stateError) {
            //Leia a expressão
            val txt = txtInput.text.toString()
            //Criar uma expressão
            //Uma classe da biblioteca exp4j
            val expression = ExpressionBuilder(txt).build()
            try {
                //Calcular o resultado e exibi
                val result = expression.evaluate()
                txtInput.text = result.toString()
                lastDot = true // O resultado contém um  dot ponto
            } catch (ex: ArithmeticException) {
                //Exibir uma mensagem de erro
                txtInput.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }
}