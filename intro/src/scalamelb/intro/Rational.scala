package scalamelb.intro

class Rational(n: Int, d: Int) {
    require (d != 0)
    private val gcd: Int = gcd(n.abs, d.abs)
    val numer: Int = n / gcd
    val denom: Int = d / gcd

    def this(n: Int) = this(n, 1)
  
    def add(that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
    def +(that: Rational): Rational = add(that)
    def *(that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)
    def -(that: Rational): Rational = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
    def /(that: Rational): Rational = new Rational(numer * that.denom, denom * that.numer)
    def lessThan(that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom

    // Method overloading
    def +(that: Int): Rational = this + (new Rational(that))
    def *(that: Int): Rational = this * (new Rational(that))
    def -(that: Int): Rational = this - (new Rational(that))
    def /(that: Int): Rational = this / (new Rational(that))

    override def toString = {
        numer + "/" + denom
    }

    def max(that: Rational): Rational = if (this lessThan that) that else this
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object RationalCalculations extends Application {
  val quarter = new Rational(1, 4)
  val five = new Rational(5)
  val result = five / quarter
  println("Result is " + result)
  val statementOfFact = if (result lessThan five) "five is bigger than result" else "result is bigger than five"
  println(statementOfFact)
}