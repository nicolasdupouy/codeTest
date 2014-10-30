package weekPackages.week5

object ListFunctions {

  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }                                               //> last: [T](xs: List[T])T

  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case y :: ys => reverse(ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]
  
  def removeAt[T](xs: List[T], n: Int) = (xs take n) ::: (xs drop n+1)
                                                  //> removeAt: [T](xs: List[T], n: Int)List[T]

  val l1 = List(1, 3, 6, 5, 2)                    //> l1  : List[Int] = List(1, 3, 6, 5, 2)
  val l2 = List(8, 7, 9)                          //> l2  : List[Int] = List(8, 7, 9)
  last(l1)                                        //> res0: Int = 2
  init(l1)                                        //> res1: List[Int] = List(1, 3, 6, 5)
  concat(l1, l2)                                  //> res2: List[Int] = List(1, 3, 6, 5, 2, 8, 7, 9)
  reverse(l2)                                     //> res3: List[Int] = List(9, 7, 8)
  
  l1 take 3                                       //> res4: List[Int] = List(1, 3, 6)
  l1 drop 3                                       //> res5: List[Int] = List(5, 2)
  removeAt(l1, 3)                                 //> res6: List[Int] = List(1, 3, 6, 2)
}