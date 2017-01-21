package com.fpin

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by dev-camiloh on 1/19/17.
  */
class Chapter2Test extends FreeSpec with Matchers {


  "test that fibo" - {

    def fibo(i: Int): Int = {

      def go(n: Int, previous: Int, actual: Int): Int = {
        if (n == 0) previous
        else go(n - 1, actual, previous + actual)
      }

      go(i, 0, 1)
    }

    "test that fibo(1) is equal to 1" - {
      fibo(1) should be (1)
    }

    "test that fibo(0) is equal to 0" - {
      fibo(0) should be (0)
    }

  }


  "test higher functions and lambda functions" - {
    def formatResult(n: Int, name: String, f: Int => Int) ={
      s"The $name of ${n} is ${f(n)}"
    }

    val result=formatResult(5, "Increment", (x) => x + 1)
    result should be  ("The Increment of 5 is 6")

  }


}
