package lectures.OOP

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = {
      movie == favoriteMovie
    }

    def hangOutWith(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    def unary_! : String = {
      s"${this.name}, What the... ! "
    }

    def isAlive: Boolean = true

    def apply(): String = {
      s"Hi, my name is ${this.name} and my favourite movie is ${this.favoriteMovie}"
    }
  }

  val mary = new Person("Mary", "Inception")
  val tom = new Person("Tom", "Fight Club")

  // InFix Notation (Operator Notation) (SYNTACTIC SUGAR)
  println(mary likes "Inception") // Equivalent to println(mary.likes("Inception"))
  println(mary hangOutWith tom)

  // PreFix Notations
  val x = -1 // Equivalent to 1.unary_-
  val y = 1.unary_-

  /*
  * unary_ only works with +, -, ~, !*/

  println(!mary)
  println(mary.unary_!)

  // PostFix Notations
  println(mary.isAlive)
  //println(mary isAlive)

  // Apply
  println(mary.apply())
  println(mary()) // Equivalent
}
