package weekPackages.week2

object video5_rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(82); 
  val a = new Rational(1, 2);System.out.println("""a  : weekPackages.week2.Rational = """ + $show(a ));$skip(14); val res$0 = 
  a.numerator;System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
  a.denominator;System.out.println("""res1: Int = """ + $show(res$1));$skip(30); 

  val b = new Rational(2, 3);System.out.println("""b  : weekPackages.week2.Rational = """ + $show(b ));$skip(11); val res$2 = 
  a.add(b);System.out.println("""res2: weekPackages.week2.Rational = """ + $show(res$2));$skip(30); 

  val x = new Rational(1, 3);System.out.println("""x  : weekPackages.week2.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : weekPackages.week2.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : weekPackages.week2.Rational = """ + $show(z ));$skip(19); val res$3 = 

  x.sub(y).sub(z);System.out.println("""res3: weekPackages.week2.Rational = """ + $show(res$3));$skip(11); val res$4 = 
  y.add(y);System.out.println("""res4: weekPackages.week2.Rational = """ + $show(res$4));$skip(12); val res$5 = 
  x.less(y);System.out.println("""res5: Boolean = """ + $show(res$5));$skip(11); val res$6 = 
  x.max(y);System.out.println("""res6: weekPackages.week2.Rational = """ + $show(res$6));$skip(19); val res$7 = 

  new Rational(2);System.out.println("""res7: weekPackages.week2.Rational = """ + $show(res$7))}
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
