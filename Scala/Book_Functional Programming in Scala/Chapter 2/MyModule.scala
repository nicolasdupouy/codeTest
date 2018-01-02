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
    def loop(n: Int): Int =
      if (n <= 1) n
      else fibonacci(n-1) + fibonacci(n-2)
    loop(n)
  }

  private def formatResult(name: String, x: Int, f: Int => Int): String = {
    val msg = "The %s value of %d is %d"
    msg.format(name, x, f(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute", -42, abs))
    println(formatResult("factorial", 7, factorial))
    println(formatResult("Fibonacci", 6, fibonacci))
  }
}