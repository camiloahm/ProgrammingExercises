package com.fpin

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by dev-camiloh on 1/19/17.
  */
class Chapter2Test extends FreeSpec with Matchers {


  "test that fibo" - {

    "test that fibo(1) is equal to 1" - {
      assert(fibo(1) == 1)
    }

    "test that fibo(0) is equal to 0" - {
      assert(fibo(0) == 0)
    }

    def fibo(i: Int): Int = {

      def go(n: Int, previous: Int, actual: Int): Int = {
        if (n == 0) previous
        else go(n - 1, actual, previous + actual)
      }

      go(i, 0, 1)
    }

  }


  "test higher functions and lambda functions" - {

    val result=formatResult(5, "Increment", (x) => x + 1)
    assert(result.equals("The Increment of 5 is 6"))

    def formatResult(n: Int, name: String, f: Int => Int) {
      val msg = "The %s of %d is %d"
      msg.format(name, n, f(n))
    }

  }


}
