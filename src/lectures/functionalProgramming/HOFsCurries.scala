package lectures.functionalProgramming

object HOFsCurries extends App {

  // Higher Order Functions: Takes a function as a parameter or returns a function as a result

  // Define a Function that applies a function over a given value

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 1))

  // Better Way to Implement the nTimes Function

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))


  // Curried Functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  // Curried Function with multiple Parameters List
  def curriedFormatter(c: String)(x: Double): String = {
    c.format(x)
  }

  val standardFormatter: (Double => String) = curriedFormatter("%4.2f") // Always mention the Return Types
  val specificFormatter: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormatter(Math.PI))
  println(specificFormatter(Math.PI))

  /* TAKEAWAYS
  * -----------
  * Functional Programming is all about working with Functions, pass funcs as params and return funcs as results
  * Currying = Funcs with multiple Params Lists
  *
  * */


}
