import java.io.File
import java.io.InputStream


val inputStream: InputStream = File("src/raw03.txt").inputStream()
//val lineList = mutableListOf<String>()
lateinit var schematic: Array<CharArray>

val listOfSymbols = arrayOf('*', '#', '+', '$', '!', '@', '%', '^', '&', '-', '/', '=', '<', '>', '?', '~')
val listOfNumbers = arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
fun main()
{
    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

    schematic = Array(lineList.size) { i -> lineList[i].toCharArray()}

    var total = 0

    for (r in 0 .. schematic.size-1)
    {
        for (c in 0..schematic[0].size-1)
        {
            if (listOfSymbols.contains(schematic[r][c]))
            {
                if (r != 0)
                {
                    if (listOfNumbers.contains(schematic[r-1][c]))
                    {
                        total += findRestOfNumber(r-1, c)
                    }
                }
                if (r != schematic.size - 1)
                {
                    if (listOfNumbers.contains(schematic[r+1][c]))
                    {
                        total += findRestOfNumber(r+1, c)
                    }
                }
                if (c != 0)
                {
                    if (listOfNumbers.contains(schematic[r][c-1]))
                    {
                        total += findRestOfNumber(r, c-1)
                    }
                }
                if (c != schematic[0].size - 1)
                {
                    if (listOfNumbers.contains(schematic[r][c+1]))
                    {
                        total += findRestOfNumber(r, c+1)
                    }
                }
                if (r != 0 && c != 0)
                {
                    if (listOfNumbers.contains(schematic[r-1][c-1]))
                    {
                        total += findRestOfNumber(r-1, c-1)
                    }
                }
                if (r != schematic.size - 1 && c != 0)
                {
                    if (listOfNumbers.contains(schematic[r+1][c-1]))
                    {
                        total += findRestOfNumber(r+1, c-1)
                    }
                }
                if (r != 0 && c != schematic[0].size - 1)
                {
                    if (listOfNumbers.contains(schematic[r-1][c+1]))
                    {
                        total += findRestOfNumber(r-1, c+1)
                    }
                }
                if (r != schematic.size - 1 && c != schematic[0].size - 1)
                {
                    if (listOfNumbers.contains(schematic[r+1][c+1]))
                    {
                        total += findRestOfNumber(r+1, c+1)
                    }
                }
            }
        }
    }
    println(total)
}

fun findRestOfNumber(r: Int, c: Int) : Int
{
    var cbeg = c
    while(cbeg != schematic[0].size-1 && listOfNumbers.contains(schematic[r][cbeg + 1]))
    {
        cbeg++
    }
    var power = 0.0
    var value = 0
    while(cbeg != -1 && listOfNumbers.contains(schematic[r][cbeg]))
    {
        value+= schematic[r][cbeg].digitToInt() * Math.pow(10.0, power).toInt()
        power++
        schematic[r][cbeg] = '.'
        cbeg--
    }
    return value
}

