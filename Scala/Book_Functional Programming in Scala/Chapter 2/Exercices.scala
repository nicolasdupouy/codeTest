import scala.annotation.tailrec

object Exercices {
  private def isSorted[T](as: Array[T], ordered: (T, T) => Boolean): Boolean = {
    @tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length) true
      else if (!ordered(as(n-1), as(n))) false
      else loop(n+1)
    }
    loop(1)
  }

  private def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    a => b => f(a, b)
  }

  private def formatResult[T](as: Array[T], f: (T, T) => Boolean): String = {
    val message = "is sorted: %b"
    message.format(isSorted(as, f))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult(Array("A", "B", "C"), (a: String, b: String) => a < b))
    println(formatResult(Array("A", "D", "C", "B"), (a: String, b: String) => a > b))

    println(formatResult(Array(), (a: Int, b: Int) => a < b))
    println(formatResult(Array(1), (a: Int, b: Int) => a < b))
    println(formatResult(Array(1, 2, 3), (a: Int, b: Int) => a < b))
    println(formatResult(Array(1, 4, 2, 3), (a: Int, b: Int) => a > b))
    println(formatResult(Array(4, 3, 2, 1, 0), (a: Int, b: Int) => a > b))

    def add(a: Int, b: Int): Int = a + b
    def addCurry = curry(add)
    def addCurried = (add _).curried

    def addFour = addCurry(4)
    def addFive = addCurried(5)

    val a = addFive(5)
    val b = addFour(10)

    println("add 5 to 5 = " + a + " / add 4 to 10 = " + b)
  }
}
