package patmat
import Huffman._

object HuffmanWorksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  val p = ('a', 3);System.out.println("""p  : (Char, Int) = """ + $show(p ));$skip(37); 
  val list_aba = List('a', 'b', 'a');System.out.println("""list_aba  : List[Char] = """ + $show(list_aba ));$skip(94); 

  def printPair(pair: (Char, Int)) = {
    println("(" + pair._1 + ", " + pair._2 + ")")
  };System.out.println("""printPair: (pair: (Char, Int))Unit""");$skip(16); 

  printPair(p);$skip(30); 
  val freqs = times(list_aba);System.out.println("""freqs  : List[(Char, Int)] = """ + $show(freqs ));$skip(62); val res$0 = 
  
  freqs.sortBy(_._2) map {
  case (c, i) => Leaf(c, i)
  };System.out.println("""res0: List[patmat.Huffman.Leaf] = """ + $show(res$0))}
}
