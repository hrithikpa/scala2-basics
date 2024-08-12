package fp

object Intro extends App {
  // All Scala functions are objects
  // Function types = Function1[A, B] (function with 1 param and 1 return type)
  val concatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  // Function types Function2[A, B, R] === (A, B) => R
  println(concatenator("Happy ", "Phone"))
  val superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder = superAdder(5)
  println(adder(4))
  println(superAdder(5)(4)) // curry function
}
