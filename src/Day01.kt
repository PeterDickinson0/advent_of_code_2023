import java.io.File
import java.io.InputStream

fun main()
{
    var writtenDigits = listOf<String>("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    var total: Int = 0

    // section from https://www.bezkoder.com/kotlin-read-file/
    val inputStream: InputStream = File("src/raw01.txt").inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

    lineList.forEach {
        var int1: Int = -1
        var int2: Int = -1
        for (i in 0..it.length-1)
        {
            val j: Int = it.length-1 - i
            if (it[i].isDigit())
            {
                if (int1 < 0) int1 = it[i].digitToInt()
            }
            if (it[j].isDigit())
            {
                if (int2 < 0) int2 = it[j].digitToInt()
            }
            for (p in 0..writtenDigits.size - 1)
            {
                if (it.indexOf(writtenDigits[p]) == i)
                {
                    if (int1 < 0) int1 = p
                }
                if (it.lastIndexOf(writtenDigits[p]) == j)
                {
                    if (int2 < 0) int2 = p
                }
            }
        }
        val reading: Int = int1*10 + int2
        println(reading)
        total+= reading
    }

    println(total)
}
