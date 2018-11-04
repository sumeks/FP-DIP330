package Isogram

object Isogram{

    fun isIsogram(input: String): Boolean =

        !input
            .toLowerCase()
            .replace(Regex("[^\\w]"), "")
            .replace(Regex("\\s+"), "")
            .groupingBy{ it }
            .eachCount()
            .any {it.value > 1}




//            if(input.length>1){
//                input.toLowerCase().any {!input.substring(1, input.length).contains(it) && isIsogram(input.substring(1, input.length).replace("-","")) }}
//             else
//                true

}


