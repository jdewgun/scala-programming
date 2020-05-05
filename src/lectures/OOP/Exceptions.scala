package lectures.OOP

object Exceptions extends App {
  val x : String = null

  // Throws NullPointerException println(x.length)

  // Throw and Catch Exceptions
  // Throwing an Exception is an expression
  throw new NullPointerException
  // And can be assigned
  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class. Exceptions and Errors are major subtypes of Throwable Class

  // Catching Errors
  try {
    // code might fail
  } catch {
    case e: RuntimeException => println("Caught a runtime exception")
  } finally {
    // Code is executed No Matter What
  }
}
