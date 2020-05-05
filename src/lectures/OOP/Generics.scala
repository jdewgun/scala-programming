package lectures.OOP

object Generics extends App {

  class MyList[A] {
    // Generic Class using Type A
  }

  val listOfInts = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic Methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInts = MyList.empty[Int]

  // Variance Problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  /*
  * Does list of cats mean a list of animals?
  * Option1: Yes, principle of Covariance
  * Option2: No, principle of Invariance
  * Option3: Hell NO, principle of Contravariance */
  // Option 1:
  class CovariantList[+A] // Declaring COVARIANT Class
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? Hard Question. Adding a Dog would lead to a list of Animals, which is more generic and
  // we return a list of animals

  // Option 2:
  class InvariantList[A] // Declaring an Invariant Class
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  // Option 3:
  class Trainer[-A] // Declaring a contravariant Class
  val trainer: Trainer[Cat] = new Trainer[Animal]


  // Bounded Class
  class Cage[A <: Animal](animal: A) // Upper Bounded Type
  val cageVal = new Cage(new Dog)


}
