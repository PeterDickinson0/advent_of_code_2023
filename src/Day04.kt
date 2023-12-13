import java.io.File
import java.io.InputStream

var lineList = mutableListOf<String>()
var total = 0

fun main()
{
    val inputStream: InputStream = File("src/raw04.txt").inputStream()

    var score = 0

    inputStream.bufferedReader().useLines {
        lines -> lines.forEach {
            lineList.add(it)
        }
    }

    analizeCard(1)

    println(total)

}

fun analizeCard(number: Int)
{
    println(number)
    total++
    var hits = 0
    val split = lineList[number-1].split("\\s+".toRegex())
    var numbers: Array<Int> = arrayOf(18, 39,  5, 97, 33 ,74 /*,70 ,35 ,40, 72*/)
    for(i in 2../*11*/ 6)
    {
        numbers[i-2] = split[i].toInt()
    }
    var winningNumbers: Array<Int> = arrayOf(62, 23, 33, 94, 18,  5, 91, 74/*, 86, 88, 82, 72, 51, 39, 95, 35, 44, 87, 65, 15, 46, 10,  3,  2, 84*/)
    for (i in /*13*/8../*37*/15)
    {
        winningNumbers[i-8] = split[i].toInt()
    }
    numbers.forEach {
        if (winningNumbers.contains(it)) hits++
    }
    for (i in 1..hits)
    {
        analizeCard(i+number)
    }
}
