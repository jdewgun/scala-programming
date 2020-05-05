package lectures.functionalProgramming

object MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)

  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a Number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))


  // Exercise, print all combos between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white" )

  // List("a1", "a2", ....)

  val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions

  val forComprehensions = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forComprehensions)

  for {
    n <- numbers
  } println(n)

  // Syntax Overload -- Sometimes used in practice
  list.map { x =>
    x * 2
  }


}
