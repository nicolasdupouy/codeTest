package weekPackages.week5

object video4_squareList {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(188); 
  def squareListMatch(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareListMatch(ys)
  };System.out.println("""squareListMatch: (xs: List[Int])List[Int]""");$skip(73); 

  def squareListMap(xs: List[Int]): List[Int] =
    xs map (x => x * x);System.out.println("""squareListMap: (xs: List[Int])List[Int]""");$skip(30); 

  val l1 = List(1, 2, -3, 4);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(26); 
  val l2 = List(5, -9, 3);System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(23); val res$0 = 

  squareListMatch(l1);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(22); val res$1 = 
  squareListMatch(l2);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(21); val res$2 = 

  squareListMap(l1);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(20); val res$3 = 
  squareListMap(l2);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(157); 

  def posElemMatch(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => if (y > 0) y :: posElemMatch(ys) else posElemMatch(ys)
  };System.out.println("""posElemMatch: (xs: List[Int])List[Int]""");$skip(73); 

  def posElemMap(xs: List[Int]): List[Int] =
    xs filter (x => x > 0);System.out.println("""posElemMap: (xs: List[Int])List[Int]""");$skip(20); val res$4 = 

  posElemMatch(l1);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(19); val res$5 = 
  posElemMatch(l2);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(18); val res$6 = 

  posElemMap(l1);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(17); val res$7 = 
  posElemMap(l2);System.out.println("""res7: List[Int] = """ + $show(res$7))}
}
