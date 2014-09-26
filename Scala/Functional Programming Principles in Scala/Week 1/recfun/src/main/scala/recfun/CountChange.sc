package recfun

object CountChange {
  def countChange(money: Int, coins: List[Int]): Int =
  {
    def countChangeIter(accumulator: Int, money: Int, coins: List[Int]): Int =
      if (money==0) accumulator+1
      else if (coins.isEmpty || money < 0) accumulator
      else countChangeIter(0, money-coins.head, coins) + countChangeIter(0, money, coins.tail)
      
      countChangeIter(0, money, coins.sorted.reverse)
  }                                               //> countChange: (money: Int, coins: List[Int])Int
  
  countChange(4,List(1,2))                        //> res0: Int = 3
  countChange(5,List(1,2))                        //> res1: Int = 3
  countChange(300,List(5,10,20,50,100,200,500))   //> res2: Int = 1022
  //def sort
  
  List(1,2)                                       //> res3: List[Int] = List(1, 2)
  List(1,2).reverse                               //> res4: List[Int] = List(2, 1)
  
  List(1,2).sorted.reverse                        //> res5: List[Int] = List(2, 1)
}