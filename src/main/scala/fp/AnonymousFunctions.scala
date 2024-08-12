package fp

object AnonymousFunctions extends App {
  val doubler = (x: Int) => x * 2
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // No params
  val justDoSomething: () => Int = () => 3

  // Careful
  println(justDoSomething) // function itself
  println(justDoSomething()) // function call

  // curly braces
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // Syntactic sugar
  val incrementVal: Int => Int = _ + 1 // equivalent to x => x + 1
  val addValues: (Int, Int) => Int = _ + _ // each _ represents a different parameters
}