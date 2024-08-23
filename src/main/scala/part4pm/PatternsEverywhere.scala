package part4pm

object PatternsEverywhere extends App {
  // #1
  try {

  } catch {
    case e: RuntimeException => "Runtime"
    case npe:NullPointerException => "NPE"
    case _ => "Something else"
  }

  /*
    try {

    } catch (e) {
      e match {
        case e: RuntimeException => "Runtime"
        case npe:NullPointerException => "NPE"
        case _ => "Something else"
      }
    }
   */

  // #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  // Generators are also based on PM
  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second

  // #3
//  val tuples =  (1, 2, 3)
//  val (a, b, c) = tuples
//  println(b)

  val head :: tail = list
  println(head, tail)

  // #4 - Partial function
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  }
  println(mappedList)
}