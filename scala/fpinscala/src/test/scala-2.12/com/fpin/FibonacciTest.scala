package com.fpin

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by dev-camiloh on 1/19/17.
  */
class FibonacciTest extends FreeSpec with Matchers {


  "test that fibo(1) is equal to 1" - {

    val result = fibo(1)


    def fibo(i: Int): Int = {


      def go(n: Int, previus: Int, actual: Int): Unit = {
        if (n == 0) previus
        else go(n - 1, actual, previus + actual)
      }

      go(i, 0, 1)
    }

  }


}
