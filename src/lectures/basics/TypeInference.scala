package lectures.basics

object TypeInference extends App {

  // Compiler can easily infer the types of values directly from the
  // RHS
  val x = "Hello World!" // compiler looks at the RHS and understands that the type is a string

  // Compiler can also infer the return type of a function directly by looking at the
  // functions implementation

  def aFunction(aString: String, n: Int) = aString + n


}
