package lectures.functionalProgramming

object Functions extends App {

  // All Scala Functions are Objects

  def concatenator: (String, String) => String = new Function2[String, String, String] {
     def apply(a: String, b: String): String = a + b
  }

  println(concatenator("Hello", "Scala"))


  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))

  println(superAdder(3)(4)) // Curried Function

  /*
  * Functions as first class citizens, pass functions as params
  * use funcs as values
  * All Scala Functions are Objects
  * function traits, upto 22 params
  * Syntactic Sugar for function types
  */

}
