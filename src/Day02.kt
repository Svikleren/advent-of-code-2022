fun main() {

    val valuesForPart1 = mapOf(
        Pair("AX", 4),
        Pair("AY", 8),
        Pair("AZ", 3),
        Pair("BX", 1),
        Pair("BY", 5),
        Pair("BZ", 9),
        Pair("CX", 7),
        Pair("CY", 2),
        Pair("CZ", 6),
    )

    val valuesForPart2 = mapOf(
        Pair("AX", 3),
        Pair("AY", 4),
        Pair("AZ", 8),
        Pair("BX", 1),
        Pair("BY", 5),
        Pair("BZ", 9),
        Pair("CX", 2),
        Pair("CY", 6),
        Pair("CZ", 7),
    )

    fun compareChars(firstPlayer: String, secondPlayer: String, values: Map<String, Int>): Int {
        return values.get(firstPlayer + secondPlayer)?.or(0) ?: 0
    }

    fun countOneRound(oneRound: List<String>, values: Map<String, Int>): Int {
        val firstPlayer = oneRound.get(0)
        val secondPlayer = oneRound.get(1)

        return compareChars(firstPlayer, secondPlayer, values)
    }

    fun countAllRounds(input: List<String>, values: Map<String, Int>): Int {
        var totalSum = 0
        for (oneInput: String in input) {
            totalSum += countOneRound(oneInput.split(" "), values)
        }
        return totalSum
    }

    fun part1(input: List<String>): Int {
        return countAllRounds(input, valuesForPart1)
    }

    fun part2(input: List<String>): Int {
        return countAllRounds(input, valuesForPart2)
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}