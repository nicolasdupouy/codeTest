package weekPackages.week2

object video2_exercice1_currying {
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int

  /*def Fact(x: Int): Int =
    if (x == 1) 1
    else x * Fact(x - 1)
  def sumFactorials = sum(Fact)*/
  
  1                                               //> res0: Int(1) = 1
  //sum(x => x * x, 2, 3)
  sumInts(1, 2)                                   //> res1: Int = 3
  sumCubes(1, 3)                                  //> res2: Int = 36
  sum(x => x * x * x)(1, 10)                      //> res3: Int = 3025
}