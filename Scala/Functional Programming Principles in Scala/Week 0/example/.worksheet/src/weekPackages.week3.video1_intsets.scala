package weekPackages.week3

object video1_intsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(95); 
  println("Welcome to the Scala worksheet");$skip(51); 

  val is3 = new NonEmpty(3, new Empty, new Empty);System.out.println("""is3  : weekPackages.week3.NonEmpty = """ + $show(is3 ));$skip(27); 
  val is35 = is3 include 5;System.out.println("""is35  : weekPackages.week3.IntSet = """ + $show(is35 ));$skip(53); 
  
  val is1 = new NonEmpty(1, new Empty, new Empty);System.out.println("""is1  : weekPackages.week3.NonEmpty = """ + $show(is1 ));$skip(27); 
  val is12 = is1 include 2;System.out.println("""is12  : weekPackages.week3.IntSet = """ + $show(is12 ));$skip(29); 
  val is124 = is12 include 4;System.out.println("""is124  : weekPackages.week3.IntSet = """ + $show(is124 ));$skip(36); 
  
  val is12345 = is124 union is35;System.out.println("""is12345  : weekPackages.week3.IntSet = """ + $show(is12345 ))}
}

abstract class IntSet {
  def include(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def include(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}

class NonEmpty(element: Int, left: IntSet, right: IntSet) extends IntSet {
  //def content = x

  def contains(x: Int): Boolean =
    if (x < element) left contains x
    else if (x > element) right contains x
    else true

  def include(x: Int): IntSet =
    if (x < element) new NonEmpty(element, left include x, right)
    else if (x > element) new NonEmpty(element, left, right include x)
    else this

  def union(other: IntSet): IntSet =
    ((left union right) union other) include element

  override def toString = "{" + left + ", " + element + ", " + right + "}"
}
