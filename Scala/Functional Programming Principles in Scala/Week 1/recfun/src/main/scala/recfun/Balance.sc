package recfun

object Balance {
  "b(a)".toList                                   //> res0: List[Char] = List(b, (, a, ))

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
    }                                             //> balance: (chars: List[Char])Boolean

  balance("b(a)e".toList)                         //> res1: Boolean = true
  balance("|(• ◡•)| (❍ᴥ❍ʋ)".toList)               //> res2: Boolean = true
  balance(("("*50000 + ")"*50000).toList)         //> res3: Boolean = true
}