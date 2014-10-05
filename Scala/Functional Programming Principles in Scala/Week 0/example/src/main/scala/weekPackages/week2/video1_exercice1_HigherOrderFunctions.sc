package weekPackages.week2

object video1_exercice1_HigherOrderFunctions {

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)                  //> sum: (f: Int => Int, a: Int, b: Int)Int

  /*def sumInts(a: Int, b: Int): Int = sum(Id, a, b)
  def Id(x: Int): Int = x*/

  def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int

  /*def sumCubes(a: Int, b: Int): Int = sum(Cube, a, b)
  def Cube(x: Int): Int = x * x * x*/
  def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int

  def sumFact(a: Int, b: Int): Int = sum(Fact, a, b)
                                                  //> sumFact: (a: Int, b: Int)Int
  def Fact(x: Int): Int =
    if (x == 1) 1
    else x * Fact(x - 1)                          //> Fact: (x: Int)Int

  sumInts(2, 5)                                   //> res0: Int = 14
  sumCubes(2, 3)                                  //> res1: Int = 35
  sumFact(2, 3)                                   //> res2: Int = 8
  Fact(4)                                         //> res3: Int = 24
  Fact(5)                                         //> res4: Int = 120
  //Cube(3)
}