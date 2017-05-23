package patternmatcher

/**
  * Created by CamiloH on 5/22/2017.
  */
object PatternMatcher {

  def findAnswer(i: Int): String = {
    i match {
      case 1 => "yes"
      case 2 => "no"
      case _ => throw new IllegalArgumentException("wrong value")
    }
  }

  def main(args: Array[String]): Unit = {
    println(findAnswer(1))
    println(findAnswer(2))
    try {
      println(findAnswer(3))
    } catch {
      case e: Exception => println("Something went wrong: e " + e)
    }
  }

}

