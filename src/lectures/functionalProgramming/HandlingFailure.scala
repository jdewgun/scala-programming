package lectures.functionalProgramming

import scala.util.{Failure, Random, Success, Try}


object HandlingFailure extends App {

  // Create Success and Failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAIL"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU")

  val potentialFailure = Try(unsafeMethod())

  println(potentialFailure)

  val anotherPotentialFailure = Try {
    // Code that might throw error
  }

  println(potentialFailure.isSuccess)
  println(potentialFailure.isFailure)


  def backupMethod(): String = "A valid response"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // For API Design

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A Valid Response")

  val betterFallBack = betterUnsafeMethod() orElse betterBackupMethod()

  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  /*
  * EXERCISE
  */
  val host = "localhost"
  val port = "9090"

  def renderHTML(page: String) =  println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())

      if (random.nextBoolean()) "<html>....</html>"
      else throw new RuntimeException("Connection Interrupted")
    }

    def getSafe(url: String): Try[String] = {
      Try(get(url))
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Port Taken")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = {
      Try(getConnection(host, port))
    }


  }

  // If we get th html page from connection, we renderHTML

  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)

}
