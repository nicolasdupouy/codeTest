package weekPackages.week5

object video5_sum_product {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  val l1 = List(1, 2, 3, 4);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(82); 
  def sumReduceLeftL(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x + y);System.out.println("""sumReduceLeftL: (xs: List[Int])Int""");$skip(72); 
  def sumReduceLeftC(xs: List[Int]): Int = (0 :: xs) reduceLeft (_ + _);System.out.println("""sumReduceLeftC: (xs: List[Int])Int""");$skip(63); 
  def sumFoldLeft(xs: List[Int]): Int = (xs foldLeft 0)(_ + _);System.out.println("""sumFoldLeft: (xs: List[Int])Int""");$skip(22); val res$0 = 

  sumReduceLeftL(l1);System.out.println("""res0: Int = """ + $show(res$0));$skip(21); val res$1 = 
  sumReduceLeftC(l1);System.out.println("""res1: Int = """ + $show(res$1));$skip(18); val res$2 = 
  sumFoldLeft(l1);System.out.println("""res2: Int = """ + $show(res$2));$skip(87); 

  def productReduceLeftL(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x * y);System.out.println("""productReduceLeftL: (xs: List[Int])Int""");$skip(76); 
  def productReduceLeftC(xs: List[Int]): Int = (0 :: xs) reduceLeft (_ * _);System.out.println("""productReduceLeftC: (xs: List[Int])Int""");$skip(67); 
  def productFoldLeft(xs: List[Int]): Int = (xs foldLeft 1)(_ * _);System.out.println("""productFoldLeft: (xs: List[Int])Int""");$skip(26); val res$3 = 

  productReduceLeftC(l1);System.out.println("""res3: Int = """ + $show(res$3));$skip(22); val res$4 = 
  productFoldLeft(l1);System.out.println("""res4: Int = """ + $show(res$4));$skip(70); 

  def productFoldRight(xs: List[Int]): Int = (xs foldRight 1)(_ * _);System.out.println("""productFoldRight: (xs: List[Int])Int""");$skip(24); val res$5 = 

  productFoldRight(l1);System.out.println("""res5: Int = """ + $show(res$5))}
}
