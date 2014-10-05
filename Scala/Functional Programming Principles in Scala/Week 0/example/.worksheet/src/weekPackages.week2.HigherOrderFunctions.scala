package weekPackages.week2

object HigherOrderFunctions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(156); 

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b);System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(138); 

  /*def sumInts(a: Int, b: Int): Int = sum(Id, a, b)
  def Id(x: Int): Int = x*/

  def sumInts(a: Int, b: Int): Int = sum(x => x, a, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(159); 

  /*def sumCubes(a: Int, b: Int): Int = sum(Cube, a, b)
  def Cube(x: Int): Int = x * x * x*/
  def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b);System.out.println("""sumCubes: (a: Int, b: Int)Int""");$skip(54); 

  def sumFact(a: Int, b: Int): Int = sum(Fact, a, b);System.out.println("""sumFact: (a: Int, b: Int)Int""");$skip(69); 
  def Fact(x: Int): Int =
    if (x == 1) 1
    else x * Fact(x - 1);System.out.println("""Fact: (x: Int)Int""");$skip(17); val res$0 = 

  sumInts(2, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
  sumCubes(2, 3);System.out.println("""res1: Int = """ + $show(res$1));$skip(16); val res$2 = 
  sumFact(2, 3);System.out.println("""res2: Int = """ + $show(res$2));$skip(10); val res$3 = 
  Fact(4);System.out.println("""res3: Int = """ + $show(res$3));$skip(10); val res$4 = 
  Fact(5);System.out.println("""res4: Int = """ + $show(res$4))}
  //Cube(3)
}
