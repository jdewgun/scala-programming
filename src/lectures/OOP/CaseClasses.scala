package lectures.OOP

object CaseClasses extends App {


  case class Person(name: String, age: Int)

  // 1. Class Params are fields
  val jim = new Person("Jim", 34)
  println(jim.name)
  // 2. Sensible to string
  // println(instance) == println(instance.toString())
  println(jim)
  // 3. Equals and HashCode are implemented OOTB
  val jim2 = new Person("Jim", 34)

  println(jim == jim2)

  //4. Case Classes have handy Copy Methods
  val jim3 = jim.copy(age = 45)

  // 5. Case Classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. Case Classes are Serializable
  // 7. Case Classes have extractor Patterns and can be used in Pattern Matching

  case object UnitedKingdom {
    def name: String = "The United Kingdom of Great Britain and Northern Ireland"
  }

}
