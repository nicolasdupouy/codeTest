package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    {
      if (c == r || c == 0) 1
      else pascal(c, r - 1) + pascal(c - 1, r - 1)
    }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    {
      def balanceIter(accumulator: Int, chars: List[Char]): Boolean =
        if (chars.isEmpty) accumulator == 0
        else if (accumulator < 0) false
        else balanceIter(computeAccumulator(chars.head, accumulator), chars.tail)

      def computeAccumulator(char: Char, accumulator: Int): Int =
        if (char == '(') accumulator + 1
        else if (char == ')') accumulator - 1
        else accumulator

      balanceIter(0, chars)
    }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    {
      def countChangeIter(accumulator: Int, money: Int, coins: List[Int]): Int =
        if (money == 0) accumulator + 1
        else if (coins.isEmpty || money < 0) accumulator
        else countChangeIter(0, money - coins.head, coins) + countChangeIter(0, money, coins.tail)

      countChangeIter(0, money, coins.sorted.reverse)
    }
}
