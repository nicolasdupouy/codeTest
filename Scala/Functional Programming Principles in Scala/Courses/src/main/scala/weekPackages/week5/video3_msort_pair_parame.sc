package weekPackages.week5

object video3_msort_pair_parame {
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
  }                                               //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]


  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  
  msort(nums)((x: Int, y: Int) => x<y)            //> res0: List[Int] = List(-4, 1, 2, 5, 7)
  msort(fruits)((s1: String, s2: String) => s1.compareTo(s2) < 0)
                                                  //> res1: List[String] = List(apple, banana, orange, pineapple)
}