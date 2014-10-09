package weekPackages.week3.consLists

object nth {
  def nth[T](n: Int, xs: List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException("List is empty")
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)                      //> nth: [T](n: Int, xs: weekPackages.week3.consLists.List[T])T

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : weekPackages.week3.consLists.Cons[Int] = weekPackages.week3.consList
                                                  //| s.Cons@47b38592
  nth(2, list)                                    //> res0: Int = 3
  nth(-1, list)                                   //> java.lang.IndexOutOfBoundsException: List is empty
                                                  //| 	at weekPackages.week3.consLists.nth$$anonfun$main$1.nth$1(weekPackages.w
                                                  //| eek3.consLists.nth.scala:5)
                                                  //| 	at weekPackages.week3.consLists.nth$$anonfun$main$1.apply$mcV$sp(weekPac
                                                  //| kages.week3.consLists.nth.scala:11)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at weekPackages.week3.consLists.nth$.main(weekPackages.week3.consLists.n
                                                  //| th.scala:3)
                                                  //| 	at weekPackages.week3.consLists.nth.main(weekPackages.week3.consLists.nt
                                                  //| h.scala)
  nth(3, list)
}