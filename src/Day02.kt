fun main() {
    fun isReportSafe(report: List<Int>): Boolean {
        val isIncreasing = report.size > 1 && report[1] > report[0]
        var isSafe = true
        for (i in 1..<report.size) {
            val diffLevels = report[i] - report[i - 1]
            if ((isIncreasing && (diffLevels <= 0 || diffLevels > 3)) || (!isIncreasing && (diffLevels >= 0 || diffLevels < -3))) {
                isSafe = false
                break
            }
        }
        return isSafe
    }

    fun part1(input: List<String>): Int {
        var countSafeReports = 0
        for (report in input) {
            val levels = report.split(" ").map { it.toInt() }
            countSafeReports += if (isReportSafe(levels)) 1 else 0
        }
        return countSafeReports
    }

    fun part2(input: List<String>): Int {
        var countSafeReports = 0
        for (report in input) {
            val levels = report.split(" ").map { it.toInt() }
            if (isReportSafe(levels)) {
                countSafeReports += 1
                continue
            }

            var isSafe = false
            for (i in levels.indices) {
                isSafe = isSafe || isReportSafe(levels.filterIndexed { index, _ -> index != i })
            }
            countSafeReports += if (isSafe) 1 else 0
        }
        return countSafeReports
    }


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
