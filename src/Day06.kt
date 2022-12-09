fun main() {

    fun isAllCharsUnique(inputPart: String): Boolean {
        var charSet: HashSet<Char> = hashSetOf()
        var result = true
        for (oneChar in inputPart) {
            if (!charSet.add(oneChar)) {
                result = false
                break
            }
        }
        return result
    }

    fun part1(input: List<String>): Int {
        var oneString = input.get(0)
        var result = 0

        for (nums in oneString.indices) {
            if (nums >= 3) {
                var stringPart = oneString.substring(nums - 3, nums + 1)
                var check = isAllCharsUnique(stringPart)
                if (check) {
                    result = nums + 1
                    break
                }
            }
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var oneString = input.get(0)
        var result = 0

        for (nums in oneString.indices) {
            if (nums >= 13) {
                var stringPart = oneString.substring(nums - 13, nums + 1)
                var check = isAllCharsUnique(stringPart)
                if (check) {
                    result = nums + 1
                    break
                }
            }
        }
        return result
    }

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}