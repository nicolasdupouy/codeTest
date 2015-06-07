package weekPackages.week6

object video1_isPrime {
  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
  isPrime(5)                                      //> res0: Boolean = true
  isPrime(7)                                      //> res1: Boolean = true
  isPrime(9)                                      //> res2: Boolean = false
}