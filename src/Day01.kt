import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val listLeft = mutableListOf<Int>()
        val listRight = mutableListOf<Int>()

        for (line in input) {
            val pair = line.split(Regex("\\s+"))
            listLeft.add(pair[0].toInt())
            listRight.add(pair[1].toInt())
        }

        listLeft.sort()
        listRight.sort()
        var sumLists = 0
        for (i in input.indices) {
            sumLists += abs(listLeft[i] - listRight[i])
        }

        return sumLists
    }

    fun part2(input: List<String>): Int {
        val listLeft = mutableListOf<Int>()
        val hashMapRight = HashMap<Int, Int>()

        for (line in input) {
            val pair = line.split(Regex("\\s+"))
            listLeft.add(pair[0].toInt())
            hashMapRight[pair[1].toInt()] = hashMapRight.getOrPut(pair[1].toInt()) { 0 } + 1
        }

        val similarityScore = listLeft.fold(0) { sum, element -> sum + element * hashMapRight.getOrElse(element) { 0 } }

        return similarityScore
    }


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
