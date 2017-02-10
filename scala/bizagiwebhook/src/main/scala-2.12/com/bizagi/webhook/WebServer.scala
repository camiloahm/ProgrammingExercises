package com.bizagi.webhook

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.bizagi.webhook.Facts.Fact

import scala.io.StdIn;

/**
  * Created by dev-camiloh on 2/9/17.
  */
object WebServer extends App {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher

  val route =
    path("api" / "webhook") {
      get {
        complete("hello world")
      } ~ post {
        complete {
          val response: String = Facts.saveFact(Fact("1", "2", "test"))
            .map(_ => "hello world")
            .recover {
              case e: Exception => e.printStackTrace(); e.toString
            }
            .getOrElse("error")
          response
        }
      }
    }

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done

}
