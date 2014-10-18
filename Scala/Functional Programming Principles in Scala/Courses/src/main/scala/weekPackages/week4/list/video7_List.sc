package weekPackages.week4

object TestList {

  val l1 = List(7, 3, 9, 2)                       //> l1  : List[Int] = List(7, 3, 9, 2)
  val l2 = 7 :: 3 :: 9 :: 2 :: Nil                //> l2  : List[Int] = List(7, 3, 9, 2)

  /*def sortRecursif(xs: List[Int]): List[Int] =
  if (xs.isEmpty) xs
  else insert(xs.head, sortRecursif(xs.tail))*/
  //System.out.println(google)

  def iSort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, iSort(ys))
  }                                               //> iSort: (xs: List[Int])List[Int]

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => x :: Nil // List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, xs.tail)
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]

  iSort(l1)                                       //> res0: List[Int] = List(2, 3, 7, 9)
}