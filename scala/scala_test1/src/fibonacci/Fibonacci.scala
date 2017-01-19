package fibonacci

import scala.annotation.tailrec

/**
  * Created by dev-camiloh on 1/19/17.
  */
object Fibonacci {

  def main(args: Array[String]): Unit = {
    println(calculateFibo(0))
    println(calculateFibo(1))
    println(calculateFibo(2))
    println(calculateFibo(3))
    println(calculateFibo(4))
    print(calculateFibo(5))
    print(calculateFibo(10))
  }

  private def calculateFibo(n: Int): Int = {

    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n == 1) acc
      else go(n - 1, acc + n - 1)
    }

    if (n == 0)
      0
    else if (n == 1)
      1
    else
      go(n, 0)

  }
}
