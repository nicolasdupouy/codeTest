package weekPackages.week2

object video2_exercice1_currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(211); 
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(29); 

  def sumInts = sum(x => x);System.out.println("""sumInts: => (Int, Int) => Int""");$skip(37); 
  def sumCubes = sum(x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(113); val res$0 = 

  /*def Fact(x: Int): Int =
    if (x == 1) 1
    else x * Fact(x - 1)
  def sumFactorials = sum(Fact)*/
  
  1;System.out.println("""res0: Int(1) = """ + $show(res$0));$skip(42); val res$1 = 
  //sum(x => x * x, 2, 3)
  sumInts(1, 2);System.out.println("""res1: Int = """ + $show(res$1));$skip(17); val res$2 = 
  sumCubes(1, 3);System.out.println("""res2: Int = """ + $show(res$2));$skip(29); val res$3 = 
  sum(x => x * x * x)(1, 10);System.out.println("""res3: Int = """ + $show(res$3))}
}
