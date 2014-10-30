package weekPackages.week5

object video3_msort_pair_parame {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(552); 
  def msort[T](xs: List[T])(lt: (T, T)=> Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (xs, Nil) => xs
          case (Nil, ys) => ys
          case (x :: xs1, y :: ys1) =>
            if (lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (first, second) = xs splitAt n
      merge(msort(first)(lt), msort(second)(lt))
    }
  };System.out.println("""msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]""");$skip(36); 


  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
  val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(42); val res$0 = 
  
  msort(nums)((x: Int, y: Int) => x<y);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(66); val res$1 = 
  msort(fruits)((s1: String, s2: String) => s1.compareTo(s2) < 0);System.out.println("""res1: List[String] = """ + $show(res$1))}
}
