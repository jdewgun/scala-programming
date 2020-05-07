package lectures.functionalProgramming

object TuplesAndMaps extends App {

  // Tuple: Finite Ordered Lists
  val aTuple = Tuple2("Hello, Scala", 1) // Equivalent of Tuple2[String, Int]("Hello, Scala", 1)
  val aTupleToo = ("Hello, Scala", 1)
  val aTupleAgain = new Tuple2("Hello, Scala", 1)


  println(aTuple._1)
  println(aTuple.copy(_1 = "Ciao, Scala"))
  println(aTuple.swap)

  // Map: Key -> Value Stores
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 33431531), "Daniel" -> 23151242)
  println(phoneBook)
  println(phoneBook.contains("Jim"))
  println(phoneBook("Daniel"))
  // Incorrect, leads to exception
  // println(phoneBook("Mary"))
  // Safeguard against above case:
  val phoneBookTwo = Map(("Jim", 33431531), "Daniel" -> 23151242).withDefaultValue(-1)
  println(phoneBookTwo("Mary"))

  // Add a new pair
  val newPair = "Mary" -> 341413412
  val newPhoneBook = phoneBookTwo + newPair
  println(phoneBookTwo)

  // Functionals on Maps
  // map, flatMap, filter
  println(phoneBookTwo.map(pair => pair._1.toLowerCase() -> pair._2))


  // filterKeys
  println(phoneBookTwo.view.filterKeys(x => x.startsWith("J")).toMap)

  // mapValues
  println(phoneBookTwo.view.mapValues(number => "+33-" + number).toMap)

  // Conversions to other collections
  println(phoneBookTwo.toList)
  println(List(("Dan", 23142123)).toMap)

  val names = List("Bob", "James", "Angela", "Jack", "Adam", "Aaron")

  println(names.groupBy(name => name.charAt(0)))



}
