object neg{
    class Rational(n:Int,m:Int){
          require(m != 0, "Denominator cannot be zero")  // Ensure denominator is not zero
          val number: Int = n/m
          def neg = new Rational(-n, m)
          override def toString: String = s"$n/$m"
    }
    def main(args: Array[String]): Unit = {
        val x = new Rational(5, 8)
        print(s"$x"+"\n After negation: ")
        println(x.neg)
    }
}