package weekPackages.week6

object video1_test {
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (_ * 2)                                  //> res0: Array[Int] = Array(2, 4, 6, 88)

  val helloBoss = "Hello Boss"                    //> helloBoss  : String = Hello Boss
  helloBoss filter (c => c.isUpper)               //> res1: String = HB

  helloBoss exists (c => c.isUpper)               //> res2: Boolean = true
  helloBoss forall (c => c.isUpper)               //> res3: Boolean = false

  val pairs = List(1, 2, 3) zip helloBoss         //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  helloBoss flatMap(c => List('.', c))            //> res5: String = .H.e.l.l.o. .B.o.s.s
  
  xs.sum                                          //> res6: Int = 50
  xs max                                          //> res7: Int = 44
}