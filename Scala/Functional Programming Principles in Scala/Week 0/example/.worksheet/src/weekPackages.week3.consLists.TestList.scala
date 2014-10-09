package weekPackages.week3.consLists

object TestList {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(121); 
  def singleton[T](element: T) = new Cons[T](element, new Nil[T]);System.out.println("""singleton: [T](element: T)weekPackages.week3.consLists.Cons[T]""");$skip(23); val res$0 = 
  
  singleton[Int](1);System.out.println("""res0: weekPackages.week3.consLists.Cons[Int] = """ + $show(res$0));$skip(27); val res$1 = 
  singleton[Boolean](true);System.out.println("""res1: weekPackages.week3.consLists.Cons[Boolean] = """ + $show(res$1))}
}
