package br.iesb.lucas.calculadora

/**
 * Created by Lucas on 27/03/2018.
 */
class StringCalculator {
    fun calculate(calculationList: List<String>): Double {
        var currentOp: String = ""
        var currentNumber = 0.0

        calculationList.forEach { token ->
            when {
                token.equals("+")
                        || token.equals("/")
                        || token.equals("*")
                        || token.equals("%")
                        || token.equals("-") -> currentOp = token

                currentOp.equals("-") -> currentNumber -= token.toDouble()
                currentOp.equals("/") -> currentNumber /= token.toDouble()
                currentOp.equals("*") -> currentNumber *= token.toDouble()
                currentOp.equals("%") -> currentNumber = currentNumber.toDouble()/100
                else -> currentNumber += token.toDouble()

            }
        }

        return currentNumber
    }
}