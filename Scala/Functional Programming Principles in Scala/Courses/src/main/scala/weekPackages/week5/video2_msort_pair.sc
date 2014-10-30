package weekPackages.week5

object video2_msort_pair {
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      //def merge(xs: List[Int], ys: List[Int]): List[Int] = ???
      val (first, second) = xs splitAt n
      merge(msort(first), msort(second))
    }
  }                                               //> msort: (xs: List[Int])List[Int]

  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    (xs, ys) match {
      case (xs, Nil) => xs
      case (Nil, ys) => ys
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }                                             //> merge: (xs: List[Int], ys: List[Int])List[Int]
    
    val nums = List(2, -4, 5, 7 ,1)               //> nums  : List[Int] = List(2, -4, 5, 7, 1)
    msort(nums)                                   //> res0: List[Int] = List(-4, 1, 2, 5, 7)
}