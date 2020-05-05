package lectures.functionalProgramming

object AnonymousFunctions extends App {

  // Lambda Functions
  // Single Parameter
  val doubler: Int => Int = x => x * 2

  // Multiple Parameters
  val adder: (Int, Int) => Int = (a:Int, b:Int) => a + b

  // No Params
  val returnInt: () => Int = () => 3

  println(returnInt) // Function
  println(returnInt()) // Function Call

}
