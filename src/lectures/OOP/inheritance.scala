package lectures.OOP

object inheritance extends App {

  class Animal {
    val creatureType = "Wild"
    protected def eat: Unit = {
      println("NomNomNom")
    }

  }

  class Cat extends Animal

  val cat = new Cat {
    def crunch = {
      eat // Can be called even when protected
      println("NomCrunchNomCrunch")
    }
  }

  // cat.eat // Cannot be called because protected
  cat.crunch


  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)


/*  class Dog(dogType: String) extends Animal {
    override val creatureType: String = "Domestic"
    override def eat = println("CrunchCrunchCrunch")
  }*/

//  class Dog(dogType: String) extends  Animal {
//    override val creatureType: String = dogType
//    override def eat = println("CrunchCrunchCrunch")
//  }


  class Dog(override val creatureType : String) extends Animal {
    override def eat: Unit = {
      super.eat
      println("Crunch, Crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  /*
  * Preventing Overrides
  * 1 - use finals on members
  * 2 - Using final on class prohibts extension of finalized Class
  * 3 - Seal the class (Can be extended only in the given file but prevents extension in other files)
  * */

}
