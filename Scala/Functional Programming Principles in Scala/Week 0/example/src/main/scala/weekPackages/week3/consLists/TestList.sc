package weekPackages.week3.consLists

object TestList {
  def singleton[T](element: T) = new Cons[T](element, new Nil[T])
                                                  //> singleton: [T](element: T)weekPackages.week3.consLists.Cons[T]
  
  singleton[Int](1)                               //> res0: weekPackages.week3.consLists.Cons[Int] = weekPackages.week3.consLists.
                                                  //| Cons@1247de8f
  singleton[Boolean](true)                        //> res1: weekPackages.week3.consLists.Cons[Boolean] = weekPackages.week3.consLi
                                                  //| sts.Cons@2c6487a9
}