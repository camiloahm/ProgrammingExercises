package factorial

import scala.annotation.tailrec

/**
  * Created by CamiloH on 1/18/2017.
  */
object Factorial {

  def main(args: Array[String]): Unit = {
    println(factorial(3))
    println(factorial(7))
    println(factPatternMatcher(3))
    println(factPatternMatcher(7))
  }

  private def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }

    go(n, 1)
  }

  private def factPatternMatcher(i: Int): Int = {
    i match {
      case 0 => 1
      case n => n * factPatternMatcher(n - 1)
    }
  }
}
