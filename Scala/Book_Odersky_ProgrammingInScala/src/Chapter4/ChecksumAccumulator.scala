package Chapter4

import scala.collection.mutable

object ChecksumAccumulator {

  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val accumulator = new ChecksumAccumulator
      for (c <- s)
        accumulator.add(c.toByte)
      val checksum = accumulator.checksum()
      cache += (s -> checksum)

      checksum
    }
  }
}

class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}
