package weekPackages.week5

object video2_msort_pair {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(309); 
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      //def merge(xs: List[Int], ys: List[Int]): List[Int] = ???
      val (first, second) = xs splitAt n
      merge(msort(first), msort(second))
    }
  };System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(244); 

  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (xs, Nil) => xs
      case (Nil, ys) => ys
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    };System.out.println("""merge: (xs: List[Int], ys: List[Int])List[Int]""");$skip(41); 
    
    val nums = List(2, -4, 5, 7 ,1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(16); val res$0 = 
    msort(nums);System.out.println("""res0: List[Int] = """ + $show(res$0))}
}
