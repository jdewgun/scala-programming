package lectures.basics

object StringOps extends App {

  val str: String = "Hello, I'm learning Scala"


  // String Operations (Exactly Like Java Utils)
  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)


  // Some Scala Specific Utilties
  val numberString = "45"
  val number = numberString.toInt
  println('a' +: numberString :+ "z")
  println(str.reverse)
  println(str.take(2))


  // Scala Specific String Interpolaters

  // s-Interpolation
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I'm $age years old and I'll be turing ${age + 1} years old"
  println(greeting)

  // f-Interpolation
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-Interpolation
  println(raw"This is a \n newline") // The escape sequence is not taken into account


}
