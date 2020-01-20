import java.io.File
import java.lang.StringBuilder

class Parser {


    fun parse()
    {
        val file = File ("./Cres_en.properties")
        val res = File ("./res.json")
        val sb = StringBuilder("{\n")
        val source = file.readLines()
        source.forEach {
            var key = it.substringBefore("=")
            var value = it.substringAfter("=").replace("\"", "\\\"")
            sb.appendln("$key:\'$value\",")
        }
        sb.append("}")
        res.writeText(sb.toString())
    }
}

fun main(args: Array<String>) {
    Parser().parse()
}