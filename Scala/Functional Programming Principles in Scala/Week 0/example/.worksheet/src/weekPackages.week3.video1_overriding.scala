package weekPackages.week3

object video1_overriding {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 
  println("Welcome to the Scala worksheet")}

  //Base b = new Sub

}

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 3
  def bar = 2
}
