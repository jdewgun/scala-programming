package lectures.OOP

object AbstractDataTypes extends App {

  /*
  * Cannot be Instantiated
  * */
  // Abstract Class
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("Dog is eating.")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "croc"
    def eat: Unit = println("NomNomNom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  /*
  * Traits and Abstract Classes
  * Abstract Classes can have both abstract and non abstract members and so can Traits
  * Traits cannot have constructor parameters
  * Multiple traits can be inherited by the same class, however on a single class can be inherited
  * Traits are behaviour and Abstracts Classes define a thing
  */


  /*
  * Scala Type Hierarchy
  * scala.Any <- scala.AnyRef <- scala.Null <- scala.Nothing
  * scala.Any <- scala.AnyVal <- scala.Nothing
  * */
}
