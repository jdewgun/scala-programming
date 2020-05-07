package lectures.functionalProgramming

import scala.util.Random

object Optionals extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // Unsafe APIs
  def unsafeMethod(): String = null

  // val result = Some(unsafeMethod()) // WRONG WRONG WRONG because Some might be
  // storing null

  val result = Option(unsafeMethod()) // Better Way

  // Chained Methods
  def backupMethod(): String = "A valid response"
  val chainedModel = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // Unsafe API Design
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A Valid Response")

  val betterChainedModel = betterUnsafeMethod() orElse betterBackupMethod()

  // Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // Unsafe: DO NOT USE

  // Map, flatMap, Filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10)) // Turns Some(4) into None
  println(myFirstOption.flatMap(x => Option(x * 10))) // Turns Some(4) into Some(40)


  // for-comprehensions
  val config: Map[String, String] = Map(
    "host" -> "176.74.23.1",
    "port" -> "50051"
  )

  class Connection {
    def connect: String = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  // Establish Connection and print the connect method

  val host = config.get("host")
  val port = config.get("port")

  /*
  * if (h != null)
  *   if (p != null)
  *     return Connection.apply(h, p)
  * */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
  * if c != null
  *   return c.connect
  * return null
  * */
  val connectionStatus = connection.map(c => c.connect)

  println(connectionStatus)
  connectionStatus.foreach(println)


  // Chained Method Solution

  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // for - comprehensions

  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  forConnectionStatus.foreach(println)

}
