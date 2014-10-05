package weekPackages.week2

object video5_rationals {
  val a = new Rational(1, 2)                      //> a  : weekPackages.week2.Rational = 1/2
  a.numerator                                     //> res0: Int = 1
  a.denominator                                   //> res1: Int = 2

  val b = new Rational(2, 3)                      //> b  : weekPackages.week2.Rational = 2/3
  a.add(b)                                        //> res2: weekPackages.week2.Rational = 7/6

  val x = new Rational(1, 3)                      //> x  : weekPackages.week2.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : weekPackages.week2.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : weekPackages.week2.Rational = 3/2

  x.sub(y).sub(z)                                 //> res3: weekPackages.week2.Rational = -79/42
  y.add(y)                                        //> res4: weekPackages.week2.Rational = 10/7
  x.less(y)                                       //> res5: Boolean = true
  x.max(y)                                        //> res6: weekPackages.week2.Rational = 5/7

  new Rational(2)                                 //> res7: weekPackages.week2.Rational = 2/1
}

class Rational(x: Int, y: Int) {
  require(y > 0, "denominator must be positive.")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  def numerator = if (g == -1) x else x / g
  def denominator = if (g == -1) y else y / g

  def less(that: Rational): Boolean = this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: Rational): Rational = if (this.less(that)) that else this

  def add(rational: Rational) =
    new Rational(
      this.numerator * rational.denominator + rational.numerator * this.denominator,
      this.denominator * rational.denominator)

  def neg: Rational = new Rational(-numerator, denominator)

  def sub(rational: Rational) = add(rational.neg)

  override def toString() = numerator + "/" + denominator //+ " (" + g + ")"
}