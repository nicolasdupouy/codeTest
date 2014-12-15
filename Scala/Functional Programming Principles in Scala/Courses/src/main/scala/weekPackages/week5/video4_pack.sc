package weekPackages.week5

object video4_pack {
  val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (_ == x) // (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  pack(data)                                      //> res0: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 

  def encode[T](xs: List[T]): List[(T, Int)] = {
    pack(xs) map (subList => (subList.head, subList.length))
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]

  encode(data)                                    //> res1: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}