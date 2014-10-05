package weekPackages.week2

object exercice1_currying {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(204); 
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
  
  1;System.out.println("""res0: Int(1) = """ + $show(res$0))}
  //sum(x => x * x, 2, 3)
}
