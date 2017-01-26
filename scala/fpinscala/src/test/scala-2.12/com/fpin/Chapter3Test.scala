package com.fpin

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by dev-camiloh on 1/25/17.
  */
class Chapter3Test extends FreeSpec with Matchers {


  "test pattern matcher" - {

    def tail[A](l: List[A]): List[A] =
      l match {
        case Nil => sys.error("tail of empty list")
        case Cons(_, t) => t
      }

  }
}
