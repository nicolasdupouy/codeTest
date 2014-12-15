package weekPackages.week5

object video4_squareList {
  def squareListMatch(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareListMatch(ys)
  }                                               //> squareListMatch: (xs: List[Int])List[Int]

  def squareListMap(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareListMap: (xs: List[Int])List[Int]

  val l1 = List(1, 2, -3, 4)                      //> l1  : List[Int] = List(1, 2, -3, 4)
  val l2 = List(5, -9, 3)                         //> l2  : List[Int] = List(5, -9, 3)

  squareListMatch(l1)                             //> res0: List[Int] = List(1, 4, 9, 16)
  squareListMatch(l2)                             //> res1: List[Int] = List(25, 81, 9)

  squareListMap(l1)                               //> res2: List[Int] = List(1, 4, 9, 16)
  squareListMap(l2)                               //> res3: List[Int] = List(25, 81, 9)

  def posElemMatch(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => if (y > 0) y :: posElemMatch(ys) else posElemMatch(ys)
  }                                               //> posElemMatch: (xs: List[Int])List[Int]

  def posElemMap(xs: List[Int]): List[Int] =
    xs filter (x => x > 0)                        //> posElemMap: (xs: List[Int])List[Int]

  posElemMatch(l1)                                //> res4: List[Int] = List(1, 2, 4)
  posElemMatch(l2)                                //> res5: List[Int] = List(5, 3)

  posElemMap(l1)                                  //> res6: List[Int] = List(1, 2, 4)
  posElemMap(l2)                                  //> res7: List[Int] = List(5, 3)
}