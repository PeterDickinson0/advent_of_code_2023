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
    for (i in 1..lineList.size) {
        analizeCard(i)
    }

    println(total)

}

fun analizeCard(number: Int)
{
    println(number)
    total++
    var hits = 0
    val split = lineList[number-1].split("\\s+".toRegex())
    var numbers: MutableList<Int> = mutableListOf<Int>()
    for(i in 2..11)
    {
        numbers.add(split[i].toInt())
    }
    var winningNumbers: MutableList<Int> = mutableListOf<Int>()
    for (i in 13..37)
    {
        winningNumbers.add(split[i].toInt())
    }
    numbers.forEach {
        if (winningNumbers.contains(it)) hits++
    }
    for (i in 1..hits)
    {
        println("hits:" + hits.toString())
        analizeCard(i+number)
    }
}
