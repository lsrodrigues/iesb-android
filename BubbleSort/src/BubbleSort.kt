fun sort(numbers: IntArray): IntArray {
    val sortedNumbers = numbers

    for (pivot in 0..sortedNumbers.size-2) {
        for (curr in pivot + 1..sortedNumbers.size-1) {
            if (sortedNumbers[curr] < sortedNumbers[pivot]) {
                val swap = sortedNumbers[pivot]
                sortedNumbers[pivot] = sortedNumbers[curr]
                sortedNumbers[curr] = swap
            }
        }
    }

    return sortedNumbers
}

fun main(args: Array<String>) {
    var array: IntArray = intArrayOf(100,23,45,87,5,4,10,25,0,33,20,3,2,1);

    print("Entrada: ")
    array.forEach { number -> print("$number ") }
    val initialTime = System.nanoTime()

    array = sort(array)

    var totalTime = (System.nanoTime() - initialTime) / 1000000f

    print("\nSaída: ")
    array.forEach { number -> print("$number ") }

    println("\nTempo:" + totalTime)

}