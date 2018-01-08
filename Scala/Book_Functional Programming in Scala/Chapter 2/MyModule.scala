import scala.annotation.tailrec

object MyModule {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def factorial(n: Int): Int = {
    @tailrec
    def loop(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else loop(n - 1, n * acc)

    loop(n, 1)
  }

  private def fibonacci(n: Int): Int = {
    @tailrec
    def loop(x: Int, first: Int, second: Int): Int =
      if (x == n) first
      else loop(x + 1, second, first + second)

    loop(0, 0, 1)
  }

  private def formatResult(name: String, x: Int, f: Int => Int): String = {
    val msg = "The %s value of %d is %d"
    msg.format(name, x, f(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute", -42, abs))
    println(formatResult("factorial", 7, factorial))
    println(formatResult("Fibonacci", 0, fibonacci))
    println(formatResult("Fibonacci", 1, fibonacci))
    println(formatResult("Fibonacci", 6, fibonacci))
    println(formatResult("Fibonacci", 13, fibonacci))
  }
}