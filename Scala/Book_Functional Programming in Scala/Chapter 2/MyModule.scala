object MyModule {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def iter(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else iter(n - 1, n * acc)

    iter(n, 1)
  }

  private def fibonacci(n: Int): Int = {
    def iteration(n: Int): Int =
      if (n <= 1) n
      else fibonacci(n-1) + fibonacci(n-2)
    iteration(n)
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(x: Int): String = {
    val msg = "The factorial of %d is %d"
    msg.format(x, factorial(x))
  }

  private def formatFibonacci(n: Int): String = {
    val message = "The value of the %d Fibonacci number is %d"
    message.format(n, fibonacci(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(7))
    println(formatFibonacci(6))
  }
}