fun main() {
    fun computeSum(input: String): Int {
        val regex = Regex("mul\\([0-9]+,[0-9]+\\)")
        val matches = regex.findAll(input, 0).map { match -> match.value }

        var result = 0
        for (match in matches) {
            var matchFiltered = Regex("mul\\(").replace(match, "")
            matchFiltered = Regex("\\)").replace(matchFiltered, "")

            val leftNum = matchFiltered.split(",")[0].toInt()
            val rightNum = matchFiltered.split(",")[1].toInt()
            result += leftNum * rightNum
        }

        return result
    }

    fun part1(input: List<String>): Int {
        val inputString = input.fold("") { acc, line -> acc + line }
        return computeSum(inputString)
    }

    fun part2(input: List<String>): Int {
        var inputString = input.fold("") { acc, line -> acc + line }
        val regex = Regex("don't\\(\\).*?do\\(\\)")

        while (true) {
            if (!regex.containsMatchIn(inputString)) break
            inputString = regex.replaceFirst(inputString, "")
        }

        inputString = Regex("don't\\(\\).*").replace(inputString, "")
        return computeSum(inputString)
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
