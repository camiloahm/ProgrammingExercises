package scalaprogram

/**
  * Created by CamiloH on 1/18/2017.
  */
object ScalaProgram {

  def abs(x: Int): Int = {
    if (x < 0) -x
    else x
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def main(args: Array[String]): Unit = {
    print(formatAbs(-42))
  }

}
