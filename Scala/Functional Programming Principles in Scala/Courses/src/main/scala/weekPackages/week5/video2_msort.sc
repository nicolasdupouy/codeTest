package weekPackages.week5

object video2_msort {
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      //def merge(xs: List[Int], ys: List[Int]): List[Int] = ???
      val (first, second) = xs splitAt n
      merge(msort(first), msort(second))
    }
  }                                               //> msort: (xs: List[Int])List[Int]

  def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
    case Nil => ys
    case x :: xs1 => ys match {
      case Nil => xs
      case y :: ys1 => if (x < y) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
    }
  }                                               //> merge: (xs: List[Int], ys: List[Int])List[Int]
}