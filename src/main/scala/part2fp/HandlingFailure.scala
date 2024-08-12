package part2fp

import scala.util.{Random, Try}

object HandlingFailure extends App {
  val hostname = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html>...<html>"
      else throw new RuntimeException("Connection interrupted")
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, Port: String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Port is fooking busy")
    }
  }

  val connection = Try(HttpService.getConnection(hostname, port))
  val page = connection.flatMap(connection => Try(connection.get("/home"))) // flatMap is used because the function inside returns a Try
  page.foreach(renderHTML)
}
