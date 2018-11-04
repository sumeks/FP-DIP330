package WordCount

object WordCount{

    fun phrase(input: String) : Map<String, Int> =

        input
            .toLowerCase()
            .replace(Regex("[^\\w']"), " ")
            .replace(Regex(" '"), " ")
            .replace(Regex("' "), " ")
            .trim()
            .split(Regex("\\s+"))
            .groupBy{it}
            .mapValues({ it.value.size })

}