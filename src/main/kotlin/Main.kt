import kotlin.math.abs

fun main(args: Array<String>) {
    println("number of game you want")
    val numberOfGame: Int = readln().toInt()
    var totalFlip: Int = 0
    var totalProfit: Int = 0
    var headCount: Int = 0
    var tailCount: Int = 0
    var i: Int = 1
    var simulationNumber: Int = 1
    var gameNumber: Int = 1
    while (gameNumber <= numberOfGame) {
        println("enter random number")
        if (probabilityHeadOrTail(readln().toInt()) == 1) {
            headCount++
        } else {
            tailCount++
        }
        if (abs(headCount - tailCount) == 3) {
            println("simulation number $simulationNumber")
            println("head Cumulative : $headCount H")
            println("tail cumulative : $tailCount T")
            totalFlip += simulationNumber
            totalProfit += (i - 8)
            headCount = 0
            tailCount = 0
            simulationNumber = 1
            gameNumber++
            if (i > 8) {
                println("lose = ${abs(i - 8)} $")
            } else if (i < 8) {
                println("win = ${abs(i - 8)} $")
            } else {
                println("win 0 $")
            }
            i = 1
            continue
        }
        println("simulation number $simulationNumber")
        println("head = $headCount H")
        println("tail = $tailCount L")
        i++
        simulationNumber++
    }
    println("total money paid = $totalFlip")
    println("total money get = ${abs(totalProfit - totalFlip)}")
    println("each game on the average requires = ${totalFlip.toDouble() / numberOfGame}")

}

fun probabilityHeadOrTail(x: Int): Int {
    return when (x) {
        in 0..4 -> 1
        else -> 0
    }
}