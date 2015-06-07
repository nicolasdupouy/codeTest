package weekPackages.week6

object video1_range {
  val r1: Range = 1 until 5                       //> r1  : Range = Range(1, 2, 3, 4)
  val r2: Range = 1 to 5                          //> r2  : Range = Range(1, 2, 3, 4, 5)
  1 to 10 by 3                                    //> res0: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res1: scala.collection.immutable.Range = Range(6, 4, 2)
}