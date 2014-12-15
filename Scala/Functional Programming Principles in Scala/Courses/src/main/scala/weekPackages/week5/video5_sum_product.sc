package weekPackages.week5

object video5_sum_product {
  val l1 = List(1, 2, 3, 4)                       //> l1  : List[Int] = List(1, 2, 3, 4)
  def sumReduceLeftL(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x + y)
                                                  //> sumReduceLeftL: (xs: List[Int])Int
  def sumReduceLeftC(xs: List[Int]): Int = (0 :: xs) reduceLeft (_ + _)
                                                  //> sumReduceLeftC: (xs: List[Int])Int
  def sumFoldLeft(xs: List[Int]): Int = (xs foldLeft 0)(_ + _)
                                                  //> sumFoldLeft: (xs: List[Int])Int

  sumReduceLeftL(l1)                              //> res0: Int = 10
  sumReduceLeftC(l1)                              //> res1: Int = 10
  sumFoldLeft(l1)                                 //> res2: Int = 10

  def productReduceLeftL(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x * y)
                                                  //> productReduceLeftL: (xs: List[Int])Int
  def productReduceLeftC(xs: List[Int]): Int = (0 :: xs) reduceLeft (_ * _)
                                                  //> productReduceLeftC: (xs: List[Int])Int
  def productFoldLeft(xs: List[Int]): Int = (xs foldLeft 1)(_ * _)
                                                  //> productFoldLeft: (xs: List[Int])Int

  productReduceLeftC(l1)                          //> res3: Int = 0
  productFoldLeft(l1)                             //> res4: Int = 24

  def productFoldRight(xs: List[Int]): Int = (xs foldRight 1)(_ * _)
                                                  //> productFoldRight: (xs: List[Int])Int

  productFoldRight(l1)                            //> res5: Int = 24
}