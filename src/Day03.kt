fun main() {
    fun charToValue(char: Char): Int {
        if (char > 64.toChar() && char < 91.toChar()) return char.code - 38
        if (char > 96.toChar() && char < 123.toChar()) return char.code - 96
        return 0
    }

    fun part1(input: List<String>): Int {
        return input
            .map { bag -> bag.chunked(bag.length / 2) }
            .map { (compartment1, compartment2) -> compartment1.first { it in compartment2 } }
            .sumOf { charToValue(it) }
    }

    fun part2(input: List<String>): Int {
        return input
            .chunked(3)
            .map { (bag1, bag2, bag3) -> bag1.first { it in bag2 && it in bag3 } }
            .sumOf { charToValue(it) }
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}