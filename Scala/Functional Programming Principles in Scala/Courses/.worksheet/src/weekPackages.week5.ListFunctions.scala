package weekPackages.week5

object ListFunctions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(206); 

  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  };System.out.println("""last: [T](xs: List[T])T""");$skip(172); 

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  };System.out.println("""init: [T](xs: List[T])List[T]""");$skip(131); 

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  };System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(122); 

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y)
  };System.out.println("""reverse: [T](xs: List[T])List[T]""");$skip(74); 
  
  def removeAt[T](xs: List[T], n: Int) = (xs take n) ::: (xs drop n+1);System.out.println("""removeAt: [T](xs: List[T], n: Int)List[T]""");$skip(32); 

  val l1 = List(1, 3, 6, 5, 2);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(25); 
  val l2 = List(8, 7, 9);System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(11); val res$0 = 
  last(l1);System.out.println("""res0: Int = """ + $show(res$0));$skip(11); val res$1 = 
  init(l1);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(17); val res$2 = 
  concat(l1, l2);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(14); val res$3 = 
  reverse(l2);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(15); val res$4 = 
  
  l1 take 3;System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(12); val res$5 = 
  l1 drop 3;System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(18); val res$6 = 
  removeAt(l1, 3);System.out.println("""res6: List[Int] = """ + $show(res$6))}
}
