fun main() {
    fun part1(input: List<String>): Int {
        var maxCalories = 0
        var caloriesSum = 0
        for (oneInput: String in input) {
            when (oneInput) {
                "" -> {
                    maxCalories = if (caloriesSum > maxCalories) caloriesSum else maxCalories
                    caloriesSum = 0
                }

                else -> caloriesSum += oneInput.toInt()
            }
        }
        return maxCalories
    }

    fun part2(input: List<String>): Int {
        var caloriesByElf = arrayListOf<Int>()
        var caloriesSum = 0
        for (oneInput: String in input) {
            when (oneInput) {
                "" -> {
                    caloriesByElf.add(caloriesSum)
                    caloriesSum = 0
                }

                else -> caloriesSum += oneInput.toInt()
            }
        }
        return caloriesByElf.sortedDescending().subList(0, 3).sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
