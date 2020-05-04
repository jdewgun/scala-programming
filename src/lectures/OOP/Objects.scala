package lectures.OOP

object Objects {

  object Person { // Type + Only Instance

    // Scala Object - SINGLETON INSTANCE

    // "static" / "class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory Method
    def apply(mother: Person, father: Person): Person = {
      new Person("Bobbie")
    }
  }

  class Person(val name:String) {
    // instance-level functionality
  }

  // COMPANIONS
  def main(args: Array[String]): Unit = {
    val mary = new Person("Mary")
    val john = new Person("John")

    val bobbie = Person(mary, john)

    println(bobbie.name)

  }

  // Scala Applications - Scala Object with def main(args: Array([String]): Unit
}
