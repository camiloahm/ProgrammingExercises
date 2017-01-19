package pureandimpure

/**
  * Created by CamiloH on 1/18/2017.
  */
object PureAndImpure {

  def main(args: Array[String]) {
    val p1Impure = PlayerImpure("camilo", 2)
    val p2Impure = PlayerImpure("felipe", 1)
    p1Impure.declareWinner(p1Impure, p2Impure)

    val p1Pure = PlayerPure("Camilo Pure", 2)
    val p2Pure = PlayerPure("Felipe pure", 1)
    print(p1Pure.winner(p1Pure.declareWinner(p1Pure, p2Pure)))
  }
}




