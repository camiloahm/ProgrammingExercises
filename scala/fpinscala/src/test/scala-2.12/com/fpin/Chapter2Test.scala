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
      fibo(1) should be(1)
    }

    "test that fibo(0) is equal to 0" - {
      fibo(0) should be(0)
    }

  }


  "test higher functions and lambda functions" - {
    def formatResult(n: Int, name: String, f: Int => Int) = {
      s"The $name of ${n} is ${f(n)}"
    }

    val result = formatResult(5, "Increment", (x) => x + 1)
    result should be("The Increment of 5 is 6")

  }


  "test binary search" - {

    def binarySearch(list: Array[Int], key: Int): Int = {

      def go(low: Int, mid: Int, high: Int): Int = {
        if (low > high) {
          -1
        } else {
          val mid2 = (high + low) / 2
          val d = list(mid2)
          if (d == key)
            mid2
          else if (key > d)
            go(mid2 + 1, mid2, high)
          else
            go(low, mid2, mid2 - 1)
        }
      }
      go(0, 0, list.length - 1)
    }

    "Test that 6 is in index 4" - {
      binarySearch(Array(2, 3, 4, 5, 6, 7, 8, 9, 10), 6) should be(4)
    }
    "Test that 4 is in index 1" - {
      binarySearch(Array(2, 4, 6, 8, 10, 12, 14, 16, 18), 4) should be(1)
    }
    "Test that 11 is in not found -1" - {
      binarySearch(Array(2, 3, 4, 5, 6, 7, 8, 9, 10), 11) should be(-1)
    }
  }


  "Test generic binary search" - {

    def genericBinarySearch[A](array: Array[A], key: A, f: (A, A) => Boolean): Int = {

      def loop[A](low: Int, mid: Int, high: Int): Int = {
        if (low > high) {
          -1
        } else {
          val mid2 = (low + high) / 2
          val a = array(mid2)
          val greater = f(a, key)
          if (!greater && !f(key, a)) {
            mid2
          } else {
            if (greater) {
              loop(low, mid2, mid2 - 1)
            } else {
              loop(mid2 + 1, mid2, high)
            }
          }
        }
      }

      loop(0, 0, array.length - 1)
    }

    "Test that 6 is in index 4" - {
      genericBinarySearch(Array(2, 3, 4, 5, 6, 7, 8, 9, 10), 6, (x1: Int, x2: Int) => x1 > x2) should be(4)
      genericBinarySearch[Int](Array(2, 3, 4, 5, 6, 7, 8, 9, 10), 6, (x1, x2) => x1 > x2) should be(4)
    }
  }

  "Generic sum" - {
    def sumValues[A](a: A, b: A)(implicit sum: (A, A) => A): A = sum(a, b)

    implicit val sumInt = (a: Int, b: Int) => a + b
    implicit val sumString = (a: String, b: String) => a + b
    implicit val sumList = (a: Seq[Int], b: Seq[Int]) => a ++ b

    sumValues(1, 3) should be(4)
    sumValues("hello", "world") should be("helloworld")
    sumValues(Seq(1, 2, 3), Seq(4, 5, 6)) should be(Seq(1, 2, 3, 4, 5, 6))
    sumValues(Seq(1, 2, 3), Seq(4, 5, 6))(sumList) should be(Seq(1, 2, 3, 4, 5, 6))
  }



  "Test improve balance parenthesis" - {


    def isBalanced(x: String): Boolean = {

      def isChar(x: String, char: Char): Boolean = {
        x.head == char
      }

      def loop(x: String, total: Int): Boolean = {
        if (x.isEmpty) {
          total == 0
        } else {
          if (isChar(x, '('))
            loop(x.tail, total + 1)
          else if (isChar(x, ')'))
            total > 0 && loop(x.tail, total - 1)
          else
            loop(x.tail, total)
        }
      }

      loop(x, 0)

    }


    "Test that (1+2) is well balanced" - {
      isBalanced("(1+2)") should be(true)
    }

    "Test that ((1+2) is well balanced" - {
      isBalanced("1+2)") should be(false)
    }

    "Test that )1+2) is well balanced" - {
      isBalanced(")1+2)") should be(false)
    }

    "Test that (3+(1+2)) is well balanced" - {
      isBalanced("(3+(1+2))") should be(true)
    }
  }


  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean = {
      if (n >= as.length - 1)
        true
      else if (gt(as(n), as(n + 1)))
        false
      else
        go(n + 1)
    }

    go(0)
  }


  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
    b => f(a, b)
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    a => b => f(a, b)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  }

  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    a => f(g(a))
  }

}