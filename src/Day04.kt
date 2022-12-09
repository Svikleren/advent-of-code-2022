fun main() {

    fun isPairContains(pairToContain: List<String>, pairToCheckInto: List<String>): Boolean {
        val firstPairStart = pairToContain[0].toInt()
        val firstPairEnd = pairToContain[1].toInt()
        val secondPairStart = pairToCheckInto[0].toInt()
        val secondPairEnd = pairToCheckInto[1].toInt()
        return (firstPairStart <= secondPairStart && firstPairEnd >= secondPairEnd)
    }

    fun isPairOverlaps(pairToContain: List<String>, pairToCheckInto: List<String>): Boolean {
        val firstPairStart = pairToContain[0].toInt()
        val firstPairEnd = pairToContain[1].toInt()
        val secondPairStart = pairToCheckInto[0].toInt()
        val secondPairEnd = pairToCheckInto[1].toInt()

        return Math.max(firstPairEnd, secondPairEnd) - Math.min(
            firstPairStart,
            secondPairStart
        ) <= (firstPairEnd - firstPairStart) + (secondPairEnd - secondPairStart)
    }

    fun checkIfContains(pair1: String, pair2: String): Boolean {
        val firstList = pair1.split("-")
        val secondList = pair2.split("-")
        return isPairContains(firstList, secondList) || isPairContains(secondList, firstList)
    }

    fun checkIfOverlaps(pair1: String, pair2: String): Boolean {
        val firstList = pair1.split("-")
        val secondList = pair2.split("-")
        return isPairOverlaps(firstList, secondList)
    }

    fun part1(input: List<String>): Int {
        return input
            .map { twoPairs -> twoPairs.split(",") }
            .map { (pair1, pair2) -> checkIfContains(pair1, pair2) }
            .count { pairResult -> pairResult }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { twoPairs -> twoPairs.split(",") }
            .map { (pair1, pair2) -> checkIfOverlaps(pair1, pair2) }
            .count { pairResult -> pairResult }
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}