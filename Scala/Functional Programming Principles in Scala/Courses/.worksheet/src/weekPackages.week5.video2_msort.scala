package weekPackages.week5

object video2_msort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(304); 
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      //def merge(xs: List[Int], ys: List[Int]): List[Int] = ???
      val (first, second) = xs splitAt n
      merge(msort(first), msort(second))
    }
  };System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(234); 

  def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
    case Nil => ys
    case x :: xs1 => ys match {
      case Nil => xs
      case y :: ys1 => if (x < y) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
    }
  };System.out.println("""merge: (xs: List[Int], ys: List[Int])List[Int]""")}
}
