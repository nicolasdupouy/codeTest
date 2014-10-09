package weekPackages.week2

object video2_exercice2 {
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)     //> sum: (f: Int => Int)(a: Int, b: Int)Int

  sum(x => x * x)(1, 4)                           //> res0: Int = 30
}