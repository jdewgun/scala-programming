package lectures.basics

object CBVvsCBN extends App {

  /*
  * Explanation: The exact value of the call is evaluated before the function evaluates
  * and the same value is used in the func definition.
  * Value computed before call.
  * Same value used everywhere
  * */
  def calledByValue(x: Long): Unit = {
    println("By Value: " + x)
    println("By Value: " + x)
  }

  /*
  * Explanation: The exact value of the call is evaluated before the function evaluates
  * each time the function is called leading to the change in value between two calls while
  * using with the println(calledByName(System.nanoTime()))
  * Expression is passed literally
  * Expression is evaluated with every use
  * */
  def calledByName(x: => Long): Unit = {
    println("By Value: " + x)
    println("By Value: " + x)
  }

  println(calledByValue(System.nanoTime()))
  println(calledByName(System.nanoTime()))

}
