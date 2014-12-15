package weekPackages.week5

object video4_pack {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(101); 
  val data = List("a", "a", "a", "b", "c", "c", "a");System.out.println("""data  : List[String] = """ + $show(data ));$skip(187); 

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (_ == x) // (y => y == x)
      first :: pack(rest)
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(14); val res$0 = 

  pack(data);System.out.println("""res0: List[List[String]] = """ + $show(res$0));$skip(115); 

  def encode[T](xs: List[T]): List[(T, Int)] = {
    pack(xs) map (subList => (subList.head, subList.length))
  };System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(16); val res$1 = 

  encode(data);System.out.println("""res1: List[(String, Int)] = """ + $show(res$1))}
}
