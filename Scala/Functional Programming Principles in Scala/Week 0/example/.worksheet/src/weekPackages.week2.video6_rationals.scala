package weekPackages.week2

object video6_rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 

  val x = new Rational(1, 3);System.out.println("""x  : weekPackages.week2.video6_rationals.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : weekPackages.week2.video6_rationals.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : weekPackages.week2.video6_rationals.Rational = """ + $show(z ));$skip(13); val res$0 = 

  x - y - z;System.out.println("""res0: weekPackages.week2.video6_rationals.Rational = """ + $show(res$0));$skip(8); val res$1 = 
  y + y;System.out.println("""res1: weekPackages.week2.video6_rationals.Rational = """ + $show(res$1));$skip(8); val res$2 = 
  x < y;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(10); val res$3 = 
  x max y;System.out.println("""res3: weekPackages.week2.video6_rationals.Rational = """ + $show(res$3));$skip(19); val res$4 = 

  new Rational(2);System.out.println("""res4: weekPackages.week2.video6_rationals.Rational = """ + $show(res$4))}

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
