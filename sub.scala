object Sub {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    def sub(that: Rational): Rational = {
      new Rational(
        this.numer * that.denom - that.numer * this.denom,
        this.denom * that.denom
      )
    }

    // GCD function for simplification
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    override def toString: String = s"$numer/$denom"
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)  // 3/4
    val y = new Rational(5, 8)  // 5/8
    val z = new Rational(2, 7)  // 2/7
    val yMinusZ = y.sub(z)
    val result = x.sub(yMinusZ)
    println(result)
  }
}
