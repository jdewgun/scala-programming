package exercises

object Functions extends App {

  def aGreetingFunction(nameString: String, age: Int): String = {
    "Hi, my name is " + nameString + " and I am " + age + " years old"
  }

  println(aGreetingFunction("John", 12))

  def aFactorialFunction(n: Int): Int = {
    if (n <= 0) 1
    else n * aFactorialFunction(n - 1)
  }

  println(aFactorialFunction(12))

  def aFibonacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacciFunction(n-1) + aFibonacciFunction(n - 2)
  }

  println(aFibonacciFunction(6))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t -1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrime(21))
  println(isPrime(37))


}
