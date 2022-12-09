fun main() {
    fun createStack(input: String): ArrayDeque<String> {
        var stack = ArrayDeque<String>()
        for (oneChar: Char in input) {
            stack.addLast(oneChar.toString())
        }
        return stack
    }

    fun initData(): Array<ArrayDeque<String>> {
        return arrayOf(
            createStack(""), //0
            createStack("HTZD"), //1
            createStack("QRWTGCS"), //2
            createStack("PBFQNRCH"), //3
            createStack("LCNFHZ"), //4
            createStack("GLFQS"), //5
            createStack("VPWZBRCS"), //6
            createStack("ZFJ"), //7
            createStack("DLVZBRCS"), //8
            createStack("BHGNFZLD") //9
        )
    }

    fun initTestData(): Array<ArrayDeque<String>> {
        return arrayOf(
            createStack(""), //0
            createStack("ZN"), //1
            createStack("MCD"), //2
            createStack("P"), //3
        )
    }

    fun oneAction(instruction: String, stackList: Array<ArrayDeque<String>>) {
        val arr = "[0-9]+".toRegex()
            .findAll(instruction)
            .map { it.value }
            .toList()

        val count = arr.get(0).toInt()
        val stackFrom = arr.get(1).toInt()
        val stackTo = arr.get(2).toInt()

        for (i in 1..count) {
            stackList[stackTo].addLast(stackList[stackFrom].removeLast())
        }
    }

    fun readResult(stackList: Array<ArrayDeque<String>>): String {
        var result = ""
        for (i in 1..9) {
            result += stackList[i][stackList[i].size - 1]
        }
        return result
    }

    fun part1(input: List<String>): String {
        val data = initData()

        for (oneInstruction: String in input) {
            oneAction(oneInstruction, data)
        }
        return readResult(data)
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}