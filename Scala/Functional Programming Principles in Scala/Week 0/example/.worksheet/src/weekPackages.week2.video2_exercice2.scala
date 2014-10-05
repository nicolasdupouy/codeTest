package weekPackages.week2

object video2_exercice2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(147); 
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b);System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(25); val res$0 = 

  sum(x => x * x)(1, 4);System.out.println("""res0: Int = """ + $show(res$0))}
}
