package weekPackages.week2

object video6_rationals {

  val x = new Rational(1, 3)                      //> x  : weekPackages.week2.video6_rationals.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : weekPackages.week2.video6_rationals.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : weekPackages.week2.video6_rationals.Rational = 3/2

  x - y - z                                       //> res0: weekPackages.week2.video6_rationals.Rational = -79/42
  y + y                                           //> res1: weekPackages.week2.video6_rationals.Rational = 10/7
  x < y                                           //> res2: Boolean = true
  x max y                                         //> res3: weekPackages.week2.video6_rationals.Rational = 5/7

  new Rational(2)                                 //> res4: weekPackages.week2.video6_rationals.Rational = 2/1

  class Rational(x: Int, y: Int) {
    require(y > 0, "denominator must be positive.")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private val g = gcd(x, y)

    def numerator = if (g == -1) x else x / g
    def denominator = if (g == -1) y else y / g

    def <(that: Rational): Boolean = this.numerator * that.denominator < that.numerator * this.denominator

    def max(that: Rational): Rational = if (this < that) that else this

    def +(that: Rational) =
      new Rational(
        this.numerator * that.denominator + that.numerator * this.denominator,
        this.denominator * that.denominator)

    def unary_- : Rational = new Rational(-numerator, denominator)

    def -(that: Rational) = this + -that

    override def toString() = numerator + "/" + denominator //+ " (" + g + ")"
  }
}