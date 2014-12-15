package forcomp

object Anagrams {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(124); val res$0 = 
  List("Every", "student", "likes", "Scala").groupBy((element: String) => element.length);System.out.println("""res0: scala.collection.immutable.Map[Int,List[String]] = """ + $show(res$0))}
}
