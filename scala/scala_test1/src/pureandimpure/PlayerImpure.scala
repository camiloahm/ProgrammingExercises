package pureandimpure

/**
  * Created by CamiloH on 1/18/2017.
  */
case class PlayerImpure(name: String, score: Int) {

  def printWinner(p: PlayerImpure): Unit = {
    println(p.name + " is the winner!")
  }

  def declareWinner(p1: PlayerImpure, p2: PlayerImpure): Unit = {
    if (p1.score > p2.score) printWinner(p1)
    else printWinner(p2)
  }

}
