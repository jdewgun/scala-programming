package exercises

object OOBasics extends App {

    val author = new Writer(
      "Charles",
      "Dickens",
      1812
    )

  val novel = new Novel(
    "Great Expectations",
    1861,
    author
  )

  println(author.fullName)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))


  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}


class Writer(firstName:String, lastName:String, val yearOfBirth: Int) {
  def fullName(): String = {
    s"$firstName $lastName"
  }
}

class Novel(name:String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = {
    yearOfRelease - author.yearOfBirth
  }

  def isWrittenBy(author: Writer) = {
    author == this.author
  }

  def copy(newYear: Int): Novel = {
    new Novel(name, newYear, author)
  }

}

class Counter(val count: Int = 0) {
  def inc = {
    println("Incrementing")
    new Counter(count + 1)
  } // Immutability
  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }


  def inc(n: Int): Counter = {
    if(n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)

}