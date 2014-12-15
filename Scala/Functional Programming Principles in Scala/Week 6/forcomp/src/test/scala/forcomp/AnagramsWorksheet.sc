package forcomp

import Anagrams._

object AnagramsWorksheet {
  val listString = List("Every", "student", "likes", "Scala")
                                                  //> listString  : List[String] = List(Every, student, likes, Scala)

  listString groupBy ((element: String) => element.length)
                                                  //> res0: scala.collection.immutable.Map[Int,List[String]] = Map(5 -> List(Every
                                                  //| , likes, Scala), 7 -> List(student))
  //listString groupBy ((element: String) => element)

  val listInt = List(0, 1, 2, 1, 0)               //> listInt  : List[Int] = List(0, 1, 2, 1, 0)
  listInt groupBy ((element: Int) => element)     //> res1: scala.collection.immutable.Map[Int,List[Int]] = Map(2 -> List(2), 1 ->
                                                  //|  List(1, 1), 0 -> List(0, 0))

  "abcd".toLowerCase()
    .toList
    .groupBy((element: Char) => element)
    .map { case (k, v) => (k, v.length) }
    .toList
    .sortBy(_._1)                                 //> res2: List[(Char, Int)] = List((a,1), (b,1), (c,1), (d,1))
  //wordOccurrences("abcd")

  "Robert".toLowerCase()
    .toList
    .groupBy((element: Char) => element)
    .map { case (k, v) => (k, v.length) }
    .toList
    .sortBy(_._1)                                 //> res3: List[(Char, Int)] = List((b,1), (e,1), (o,1), (r,2), (t,1))

  val bigList = List("abcd", "e")                 //> bigList  : List[String] = List(abcd, e)
  bigList                                         //> res4: List[String] = List(abcd, e)

  //dictionary
  //dictionary groupBy(wordOccurrences(_))
  dictionaryByOccurrences(wordOccurrences("ablating"))
                                                  //> res5: List[forcomp.Anagrams.Word] = List(ablating)

  val teaWordOccurrences = wordOccurrences("tea") //> teaWordOccurrences  : forcomp.Anagrams.Occurrences = List((a,1), (e,1), (t,1
                                                  //| ))

  combinations(teaWordOccurrences)                //> res6: List[forcomp.Anagrams.Occurrences] = List(List(), List((a,1)), List((e
                                                  //| ,1)), List((a,1), (e,1)), List((t,1)), List((a,1), (t,1)), List((e,1), (t,1)
                                                  //| ), List((a,1), (e,1), (t,1)))
  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> x  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
  val y = List(('r', 1))                          //> y  : List[(Char, Int)] = List((r,1))
  subtract(x, y)                                  //> res7: forcomp.Anagrams.Occurrences = List((a,1), (d,1), (l,1))
  
  
  val linuxRulez = List("Linux", "rulez")         //> linuxRulez  : List[String] = List(Linux, rulez)
  val iLoveYou = List("I", "love", "you")         //> iLoveYou  : List[String] = List(I, love, you)
  val mickeyMouse = "Mickey Mouse"                //> mickeyMouse  : String = Mickey Mouse
  
  sentenceOccurrences(linuxRulez)                 //> res8: forcomp.Anagrams.Occurrences = List((e,1), (i,1), (l,2), (n,1), (r,1)
                                                  //| , (u,2), (x,1), (z,1))
  sentenceAnagrams(linuxRulez)                    //> res9: List[forcomp.Anagrams.Sentence] = List(List(Lin, Rex, Zulu), List(Lin
                                                  //| , Zulu, Rex), List(nil, Rex, Zulu), List(nil, Zulu, Rex), List(null, Rex, U
                                                  //| zi), List(null, Uzi, Rex), List(Rex, Lin, Zulu), List(Rex, nil, Zulu), List
                                                  //| (Rex, null, Uzi), List(Rex, Uzi, null), List(Rex, Zulu, Lin), List(Rex, Zul
                                                  //| u, nil), List(Linux, rulez), List(Uzi, null, Rex), List(Uzi, Rex, null), Li
                                                  //| st(rulez, Linux), List(Zulu, Lin, Rex), List(Zulu, nil, Rex), List(Zulu, Re
                                                  //| x, Lin), List(Zulu, Rex, nil))
  sentenceAnagrams(iLoveYou)                      //> res10: List[forcomp.Anagrams.Sentence] = List(List(Io, Lev, you), List(Io, 
                                                  //| you, Lev), List(Lev, Io, you), List(Lev, you, Io), List(olive, you), List(y
                                                  //| ou, Io, Lev), List(you, Lev, Io), List(you, olive))
}