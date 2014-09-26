package recfun

object Balance {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(48); val res$0 = 
  "b(a)".toList;System.out.println("""res0: List[Char] = """ + $show(res$0));$skip(501); 

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
    };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(27); val res$1 = 

  balance("b(a)e".toList);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(36); val res$2 = 
  balance("|(• ◡•)| (❍ᴥ❍ʋ)".toList);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(42); val res$3 = 
  balance(("("*50000 + ")"*50000).toList);System.out.println("""res3: Boolean = """ + $show(res$3))}
}
