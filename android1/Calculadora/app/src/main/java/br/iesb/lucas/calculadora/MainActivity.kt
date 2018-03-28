package br.iesb.lucas.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import br.iesb.lucas.calculadora.Operator.*
import org.w3c.dom.Text
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(){

    internal var display: TextView  by Delegates.notNull()

    val operationList: MutableList<String> = arrayListOf()
    val numberCache: MutableList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateDisplay("")
    }

    fun updateDisplay(mainDisplayString: String){

        val fullCalculationString = makeString(operationList, " ")
        var fullCalculationTextView = findViewById<TextView>(R.id.fullCalculationText)
        fullCalculationTextView.text = fullCalculationString

        val mainTextView = findViewById<TextView>(R.id.display)
        mainTextView.text = mainDisplayString
    }

    fun makeString(list: List<String>,joiner: String = "") : String {

        if (list.isEmpty()) return ""
        return list.reduce { r, s -> r + joiner + s }
    }

    fun numberClick(view: View) {
        val button = view as TextView

        numberCache.add(button.text.toString())
        val text = makeString(numberCache)
        updateDisplay(text)
    }

    fun buttonClick(view: View) {

        val button = view as TextView

        if (numberCache.isEmpty()) return

        operationList.add(makeString(numberCache))
        numberCache.clear()
        operationList.add(button.text.toString())

        updateDisplay(button.text.toString())
    }

    fun equalsClick(view: View) {
        operationList.add(makeString(numberCache))
        numberCache.clear()

        val calculator = StringCalculator()
        val answer = calculator.calculate(operationList)

        updateDisplay("=" + answer.toString())
        clearCache()
    }

    fun clearCache() {
        numberCache.clear()
        operationList.clear()
    }

    fun clearClick(view: View) {
        clearCache()
        updateDisplay("");
    }

}
