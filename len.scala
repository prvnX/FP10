object len{
    def countLetterOccurences(words:List[String]):Int={
        words.map((word)=>word.length).reduce((a,b)=>a+b)
    }
    def main(args: Array[String]): Unit = {
        val words = List("apple", "banana", "cherry","date")
        println(" Total count of letter occurrences : "+countLetterOccurences(words))
    }
}