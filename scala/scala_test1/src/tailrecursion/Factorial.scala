package tailrecursion

import scala.annotation.tailrec

/**
  * Created by CamiloH on 1/18/2017.
  */
object Factorial {

  def main(args: Array[String]): Unit = {
    print(factorial(3))
    print(factorial(7))
  }

  private def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }

    go(n, 1)
  }

}
