package IsbnVerifier

class IsbnVerifier{

    fun isValid(input: String) : Boolean =
        input
            .matches(Regex("[0-9][-]?[0-9]{3}[-]?[0-9]{5}[-]?[0-9X]")) &&
        input
            .replace(Regex("-"), "")
            .reversed()
            .map{ x -> if(x == 'X') 10 else x.toString().toInt() }
            .mapIndexed { index, value -> value * (index+1) }
            .sum() % 11 == 0

}
