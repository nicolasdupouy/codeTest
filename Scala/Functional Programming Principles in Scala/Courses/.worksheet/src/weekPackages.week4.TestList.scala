package weekPackages.week4

object TestList {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 

  val l1 = List(7, 3, 9, 2);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(35); 
  val l2 = 7 :: 3 :: 9 :: 2 :: Nil;System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(273); 

  /*def sortRecursif(xs: List[Int]): List[Int] =
  if (xs.isEmpty) xs
  else insert(xs.head, sortRecursif(xs.tail))*/
  //System.out.println(google)

  def iSort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, iSort(ys))
  };System.out.println("""iSort: (xs: List[Int])List[Int]""");$skip(173); 

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => x :: Nil // List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, xs.tail)
  };System.out.println("""insert: (x: Int, xs: List[Int])List[Int]""");$skip(13); val res$0 = 

  iSort(l1);System.out.println("""res0: List[Int] = """ + $show(res$0))}
}
