package lectures.basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println("Computing Factorial of " + n + ", Factorial Value Needed for: " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed Factorial of " + n)

      result
    }
  }

  println(factorial(10))
  // DO NOT RUN, leads to StackOverflow.
  // println(factorial(5000))

  def anotherFactorial(n:Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if(x<=1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1)
  }

  /*
  * Tail Recursion is the method where we user the recursive call as the LAST
  * Expression. To mark a function as tail recursive, we use the @tailrec decorator
  */

  println(anotherFactorial(10))
  println(anotherFactorial(5000))

  @tailrec
  def concateStrings(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concateStrings(aString, n - 1, aString + accumulator)
  }

  println("Hello, World!", 3, "")

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeHelper(n / 2, true)
  }

  println(isPrime(2003))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciHelper(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }

}
