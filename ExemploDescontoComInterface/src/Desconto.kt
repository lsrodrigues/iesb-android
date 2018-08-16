class AlunoNovo(var name: String,  var value: Double) : Desconto {

    override fun calcularDesconto(value: Double): Double {
        return value
    }

     fun mensalidade() {
        println("Aluno " + name + " pagará por mês R$ " + calcularDesconto(value))
    }
}


class AlunoEgresso(var name: String,  var value: Double) : Desconto {

    override fun calcularDesconto(value: Double): Double {
        return return (value * 0.8)
    }

    fun mensalidade() {
        println("Aluno " + name + " pagará por mês R$ " + calcularDesconto(value))
    }
}

interface Desconto {
    fun calcularDesconto(value: Double) : Double
}


fun main(args: Array<String>) {
    val student1: AlunoNovo = AlunoNovo("Lucas", 500.0)
    student1.mensalidade()

    val student2: AlunoEgresso = AlunoEgresso("Juliana", 500.0)
    student2.mensalidade()
}