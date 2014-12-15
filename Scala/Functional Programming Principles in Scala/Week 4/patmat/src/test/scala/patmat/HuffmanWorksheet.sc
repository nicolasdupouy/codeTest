package patmat
import Huffman._

object HuffmanWorksheet {
  val p = ('a', 3)                                //> p  : (Char, Int) = (a,3)
  val list_aba = List('a', 'b', 'a')              //> list_aba  : List[Char] = List(a, b, a)

  def printPair(pair: (Char, Int)) = {
    println("(" + pair._1 + ", " + pair._2 + ")")
  }                                               //> printPair: (pair: (Char, Int))Unit

  printPair(p)                                    //> (a, 3)
  val freqs = times(list_aba)                     //> freqs  : List[(Char, Int)] = List((a,2), (b,1))
  
  freqs.sortBy(_._2) map {
  case (c, i) => Leaf(c, i)
  }                                               //> res0: List[patmat.Huffman.Leaf] = List(Leaf(b,1), Leaf(a,2))
}