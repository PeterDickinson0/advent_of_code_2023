import java.io.File
import java.io.InputStream

fun main()
{
    // array [red, green, blue]
    val inputStream: InputStream = File("src/raw02.txt").inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

    var total = 0

    loop@ for (l in 0..lineList.size-1)
    {
        var game = IntArray(3)
        var minRequired = IntArray(3)
        minRequired[0] = 0
        minRequired[1] = 0
        minRequired[2] = 0
        var spliced = lineList[l].split(" ")
        for (i in 3..spliced.size-1 step 2)
        {
            var color = spliced[i]
            if (spliced[i][spliced[i].length-1] == ',' || spliced[i][spliced[i].length-1] == ';')
            {
                color = spliced[i].substring(0, spliced[i].length-1)
            }
            if (color == "red") game[0] = spliced[i-1].toInt()
            if (color == "green") game[1] = spliced[i-1].toInt()
            if (color == "blue") game[2] = spliced[i-1].toInt()
            if (spliced[i][spliced[i].length-1] == ';')
            {
                println(game[0].toString() + "," + game[1].toString() + "," + game[2].toString())
                /*if (game[0] > 12 || game[1] > 13 || game[2] > 14)
                {
                    //println(game[0].toString() + "," + game[1].toString() + "," + game[2].toString())
                    continue@loop
                }
                else
                {
                    game = IntArray(3)
                }*/
                for (c in 0..2) {
                    if (game[c] > minRequired[c]) minRequired[c] = game[c]
                }
                game = IntArray(3)

            }
            else if (i == spliced.size - 1)
            {
                println(game[0].toString() + "," + game[1].toString() + "," + game[2].toString())
                /*if (game[0] > 12 || game[1] > 13 || game[2] > 14)
                {
                    //println(game[0].toString() + "," + game[1].toString() + "," + game[2].toString())
                    continue@loop
                }
                else
                {
                    game = IntArray(3)
                }*/
                for (c in 0..2) {
                    if (game[c] > minRequired[c]) minRequired[c] = game[c]
                }
                game = IntArray(3)
            }
        }
        //println(l+1)
        total+= minRequired[0] * minRequired[1] * minRequired[2]
    }
    print(total)
}