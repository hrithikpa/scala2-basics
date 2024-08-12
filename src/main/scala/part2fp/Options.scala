package part2fp

import scala.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)

  // Options were invented to deal with unsafe APIs
  def unSafeMethod(): String =  null
//  val res = Some(unSafeMethod()) // Wrong: Some should always have
  val res = Option(unSafeMethod()) // Whole point of option is that we should never do a null check ourselves. the option will do for us

  def backupMethod(): String = "A valid result in this"
  val chainedRes = Option(unSafeMethod()).orElse(Option(backupMethod())) // In case that unsafe method returns null then fallback to other method

  // Design
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("Valid result")

  val betterChainedRes = betterUnsafeMethod() orElse betterBackupMethod() // If I'm getting a option that don't have to wrap in this

  // Exercise
  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")
  /*
    if host != null
      if port != null
        return new Connection.apply(h, p)
    return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p))) // flatMap is used when the function inside returns an Option
  // It flattens the nested Option[Option[A]] into a single Option[A].

  /*
    if connection != null
      return c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect) // Map is used when the function you are applying returns a single value, not an Option.
  // In our case, connect method returns just a string not a option[string]

  /*
    if connectionStatus != null
      println(connectionStatus)
   */
  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect // If host, port and connection is not null then give me a connection
  // If either of host, port and connection are none then for expr will return none

  forConnectionStatus.foreach(println)
}
