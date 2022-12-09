fun main() {
    fun initData(): Array<String> {
        return arrayOf(
            "", //0
            "HTZD", //1
            "QRWTGCS", //2
            "PBFQNRCH", //3
            "LCNFHZ", //4
            "GLFQS", //5
            "VPWZBRCS", //6
            "ZFJ", //7
            "DLVZBRCS", //8
            "BHGNFZLD" //9
        )
    }

    fun initTestData(): Array<String> {
        return arrayOf(
            "", //0
            "ZN", //1
            "MCD", //2
            "P" //3
        )
    }

    fun oneAction(instruction: String, stringList: Array<String>) {
        val arr = "[0-9]+".toRegex()
            .findAll(instruction)
            .map { it.value }
            .toList()

        val count = arr.get(0).toInt()
        val stringFrom = arr.get(1).toInt()
        val stringTo = arr.get(2).toInt()

        //šeit pārcelšana pa čupiņai reizē
        val stringToMoveFrom = stringList[stringFrom]

        val stringToLeft = stringToMoveFrom.substring(0, stringToMoveFrom.length - count)
        val stringToMove = stringToMoveFrom.substring(stringToMoveFrom.length - count, stringToMoveFrom.length)

        stringList[stringTo] += stringToMove
        stringList[stringFrom] = stringToLeft
    }

    fun readResult(stringList: Array<String>): String {
        var result = ""
        for (i in 1..9) {
            result += stringList[i][stringList[i].length - 1]
        }
        return result
    }

    fun part2(input: List<String>): String {
        val data = initData()

        for (oneInstruction: String in input) {
            oneAction(oneInstruction, data)
        }
        return readResult(data)
    }

    val input = readInput("Day05")
    println(part2(input))
}