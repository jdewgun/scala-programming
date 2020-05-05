package lectures.functionalProgramming

import scala.util.Random

object Sequences extends App {

  // Sequence
  val aSequence = Seq(1, 3, 4, 2)

  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) // retrieves element at index 2
  println(aSequence ++ Seq(7,6,5)) // Append Sequence to Sequence

  // Range

  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  val anotherRange: Seq[Int] = 1 until 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))


  /*
  * List
  * ----
  * head, tail, isEmpty methods are fast: O(1)
  * Most other operations like length, reverse are O(n)
  */

  val aList = List(1, 2, 3)
  val prepended = 42 +: aList
  println(prepended)

  val appended = aList :+ 52
  println(appended)

  val prependedAppended = 10 +: aList :+ 20
  println(prependedAppended)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("-|"))

  /*
  * Arrays
  * ------
  * Equivalent of Java Arrays
  * Can be manually constructed with predefined lengths
  * Mutable
  * Interoperable with Java's T[] arrays
  * Indexing is fast
  */

  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)

  threeElements.foreach(println)

  // Array Mutation
  println(numbers.mkString(" "))
  numbers(2) = 0
  println(numbers.mkString(" "))

  // Arrays and Sequences
  val numbersSeq: Seq[Int] = numbers
  println(numbersSeq)

  /*
  * Vectors
  * Effectively Constant Indexed read and write: O(log32(n))
  * Fast Element addition
  * Implemented as a fixed branched trie (branch factor 32)
  * Good performance for large sizes
  */

  val vector: Vector[Int] = Vector(1, 2, 3)

  println(vector)

  // Vectors Vs List

  val maxRuns = 1000
  val maxCapacity = 100000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random

    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVec = (1 to maxCapacity).toList

  // Keeps reference to tails
  // Updating an element in the middle takes long
  println(getWriteTime(numbersList))
  // Depth of the tree is small
  // Needs to replace an entire 32 element chunk
  println(getWriteTime(numbersVec))


}
