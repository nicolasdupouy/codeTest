package weekPackages.week3

object video1_intsets {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val is3 = new NonEmpty(3, new Empty, new Empty) //> is3  : weekPackages.week3.NonEmpty = {., 3, .}
  val is35 = is3 include 5                        //> is35  : weekPackages.week3.IntSet = {., 3, {., 5, .}}
  
  val is1 = new NonEmpty(1, new Empty, new Empty) //> is1  : weekPackages.week3.NonEmpty = {., 1, .}
  val is12 = is1 include 2                        //> is12  : weekPackages.week3.IntSet = {., 1, {., 2, .}}
  val is124 = is12 include 4                      //> is124  : weekPackages.week3.IntSet = {., 1, {., 2, {., 4, .}}}
  
  val is12345 = is124 union is35                  //> is12345  : weekPackages.week3.IntSet = {{{., 1, .}, 2, .}, 3, {{., 4, .}, 5,
                                                  //|  .}}
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