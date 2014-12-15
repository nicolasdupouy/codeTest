package forcomp

import Anagrams._

object AnagramsWorksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(124); 
  val listString = List("Every", "student", "likes", "Scala");System.out.println("""listString  : List[String] = """ + $show(listString ));$skip(60); val res$0 = 

  listString groupBy ((element: String) => element.length);System.out.println("""res0: scala.collection.immutable.Map[Int,List[String]] = """ + $show(res$0));$skip(91); 
  //listString groupBy ((element: String) => element)

  val listInt = List(0, 1, 2, 1, 0);System.out.println("""listInt  : List[Int] = """ + $show(listInt ));$skip(46); val res$1 = 
  listInt groupBy ((element: Int) => element);System.out.println("""res1: scala.collection.immutable.Map[Int,List[Int]] = """ + $show(res$1));$skip(149); val res$2 = 

  "abcd".toLowerCase()
    .toList
    .groupBy((element: Char) => element)
    .map { case (k, v) => (k, v.length) }
    .toList
    .sortBy(_._1);System.out.println("""res2: List[(Char, Int)] = """ + $show(res$2));$skip(179); val res$3 = 
  //wordOccurrences("abcd")

  "Robert".toLowerCase()
    .toList
    .groupBy((element: Char) => element)
    .map { case (k, v) => (k, v.length) }
    .toList
    .sortBy(_._1);System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3));$skip(35); 

  val bigList = List("abcd", "e");System.out.println("""bigList  : List[String] = """ + $show(bigList ));$skip(10); val res$4 = 
  bigList;System.out.println("""res4: List[String] = """ + $show(res$4));$skip(114); val res$5 = 

  //dictionary
  //dictionary groupBy(wordOccurrences(_))
  dictionaryByOccurrences(wordOccurrences("ablating"));System.out.println("""res5: List[forcomp.Anagrams.Word] = """ + $show(res$5));$skip(51); 

  val teaWordOccurrences = wordOccurrences("tea");System.out.println("""teaWordOccurrences  : forcomp.Anagrams.Occurrences = """ + $show(teaWordOccurrences ));$skip(36); val res$6 = 

  combinations(teaWordOccurrences);System.out.println("""res6: List[forcomp.Anagrams.Occurrences] = """ + $show(res$6));$skip(55); 
  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1));System.out.println("""x  : List[(Char, Int)] = """ + $show(x ));$skip(25); 
  val y = List(('r', 1));System.out.println("""y  : List[(Char, Int)] = """ + $show(y ));$skip(17); val res$7 = 
  subtract(x, y);System.out.println("""res7: forcomp.Anagrams.Occurrences = """ + $show(res$7));$skip(48); 
  
  
  val linuxRulez = List("Linux", "rulez");System.out.println("""linuxRulez  : List[String] = """ + $show(linuxRulez ));$skip(42); 
  val iLoveYou = List("I", "love", "you");System.out.println("""iLoveYou  : List[String] = """ + $show(iLoveYou ));$skip(35); 
  val mickeyMouse = "Mickey Mouse";System.out.println("""mickeyMouse  : String = """ + $show(mickeyMouse ));$skip(37); val res$8 = 
  
  sentenceOccurrences(linuxRulez);System.out.println("""res8: forcomp.Anagrams.Occurrences = """ + $show(res$8));$skip(31); val res$9 = 
  sentenceAnagrams(linuxRulez);System.out.println("""res9: List[forcomp.Anagrams.Sentence] = """ + $show(res$9));$skip(29); val res$10 = 
  sentenceAnagrams(iLoveYou);System.out.println("""res10: List[forcomp.Anagrams.Sentence] = """ + $show(res$10))}
}
