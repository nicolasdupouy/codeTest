package weekPackages.week5
import math.Ordering

object video3_msort_pair_parameter_ordering {
  def msort[T](xs: List[T])(order: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (xs, Nil) => xs
          case (Nil, ys) => ys
          case (x :: xs1, y :: ys1) =>
            if (order.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (first, second) = xs splitAt n
      merge(msort(first)(order), msort(second)(order))
    }
  }                                               //> msort: [T](xs: List[T])(order: scala.math.Ordering[T])List[T]


  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  
  msort(nums)(Ordering.Int)                       //> res0: List[Int] = List(-4, 1, 2, 5, 7)
  msort(fruits)(Ordering.String)                  //> res1: List[String] = List(apple, banana, orange, pineapple)
}