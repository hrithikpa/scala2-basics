package part4pm

import scala.collection.View.Empty

object AllThePatterns extends App {
  // 1 - constants
  val x: Any = 1
  val constants = x match {
    case 1 => "A Number"
    case "Scala" => "The Scala"
    case true => "The Truthy"
    case AllThePatterns => "Singleton Objects"
  }
  println(constants)

  // 2 - Match Anything
  // 2.1 - Wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 Variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) => "Hey it's a tuple of 1 1" // This will match only if tuple has Int elements of 1
    case (something, 2) => s"I've found $something"
  }
  println(matchATuple)

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) => s"$v"
  }

  // 4 - list patterns
  val aStandardList = List(1, 2, 3, 4, 5)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // extractor
    case List(1, _*) => "List of arbitrary length"
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 4 => // infix pattern
  }
  println(standardListMatching)

  // 5 - type specifiers
  val unknown: Any = List("2")
  // Java 5 compiler erased all generic types after type checking
  val unknownMatch = unknown match {
    case list: List[Int] => "Explicit type specifier"
    case _ => "No match"
  }
  println(unknownMatch)

  // 6 - name binding
  val nameBindingMatch = aStandardList match {
    case nonEmptyList @ List(1, _*) => s"Output: $nonEmptyList"
  }
  println(nameBindingMatch)

  // 7 - Multi-patterns => Multiple patterns chained by a pipe operator
  val multiPattern = aStandardList match {
    case List(2, _*) | List(1, _*) => // compound pattern (multi pattern) - returns same expression for multiple patterns
  }
}
