package lectures.OOP

object AnonymousClasses extends App {

  abstract class  Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahahaah")
  }
  /*
  * Equivalent with
  * class AnonymousClasses$$anon$1 extends Animal {
  *   override def eat: Unit = println("hahahahahahaah")
  * }
  *
  * val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  * */

  println(funnyAnimal.getClass) // AnonymousClasses$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name $name")
  }

  val jim = new Person("Jim") { // Always write constructor parameters, even when writing anonymously
    override def sayHi: Unit = println("Hi, my name is Jim, How can I help?")
  }

  // Anonymous Classes work for both Abstract and Non-Abstract Classes

}
