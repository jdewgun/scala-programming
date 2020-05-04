package lectures.OOP

object OOBasics extends App {

  val person = new Person("John", 18)
  println(person)
  println(person.age)
  println(person.greet("Daniel"))
  println(person.greet())

}

/*
* Class Parameters are NOT FIELDS
* To set a parameter as a field, we need to append the val or the var keyword
* */

// Constructor
class Person(name: String, val age: Int) {

  // Multiple Constructors
  /*
  * If we use default arguments, the constructor below stand obsolete.*/
  def this (name: String) = {
    this(name, 0)
  }

  def this() = {
    this("John Doe")
  }
  // Class methods
  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }

  // Method Overloading
  def greet(): Unit = {
    println(s"Hi, my name is $name")
  }
}
