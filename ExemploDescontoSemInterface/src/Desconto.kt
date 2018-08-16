abstract class Aluno constructor(name: String, value: Double){
    abstract var name: String
    abstract var value: Double

    abstract fun mensalidade()
}

class AlunoNovo(override var name: String, override var value: Double) : Aluno(name, value) {
    override fun mensalidade() {
        println("Estudante " + name + " pagará por mês R$ " + value )
    }
}

class  AlunoEgresso(override var name: String, override var value: Double) : Aluno(name, value) {
    override fun mensalidade() {
        println("Aluno " + name + " pagará por mês R$ " + value * 0.8 )
    }
}

fun main(args: Array<String>) {

    val student2: Aluno = AlunoNovo("Lucas", 500.0)
    student2.mensalidade()

    val student1: Aluno = AlunoEgresso("Leo", 500.0)
    student1.mensalidade()
}