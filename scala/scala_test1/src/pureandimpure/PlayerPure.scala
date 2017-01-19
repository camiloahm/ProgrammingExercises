package pureandimpure

/**
  * Created by CamiloH on 1/18/2017.
  */
case class PlayerPure(name: String, score: Int) {

  def winner(p: PlayerPure): Unit = {
    println(p.name + " is the winner")
  }

  def declareWinner(p1: PlayerPure, p2: PlayerPure): PlayerPure = {
    if (p1.score > p2.score) p1
    else p2
  }

}
