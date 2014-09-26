package recfun

object CountChange {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(423); 
  def countChange(money: Int, coins: List[Int]): Int =
  {
    def countChangeIter(accumulator: Int, money: Int, coins: List[Int]): Int =
      if (money==0) accumulator+1
      else if (coins.isEmpty || money < 0) accumulator
      else countChangeIter(0, money-coins.head, coins) + countChangeIter(0, money, coins.tail)
      
      countChangeIter(0, money, coins.sorted.reverse)
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(30); val res$0 = 
  
  countChange(4,List(1,2));System.out.println("""res0: Int = """ + $show(res$0));$skip(27); val res$1 = 
  countChange(5,List(1,2));System.out.println("""res1: Int = """ + $show(res$1));$skip(48); val res$2 = 
  countChange(300,List(5,10,20,50,100,200,500));System.out.println("""res2: Int = """ + $show(res$2));$skip(28); val res$3 = 
  //def sort
  
  List(1,2);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(20); val res$4 = 
  List(1,2).reverse;System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(30); val res$5 = 
  
  List(1,2).sorted.reverse;System.out.println("""res5: List[Int] = """ + $show(res$5))}
}
