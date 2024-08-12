package part4pm

import scala.util.Random

object patternMatching extends App {
  val random = new Random
  val num = random.nextInt(10)

  val description = num match {
    case 1 => "ONE"
    case 2 => "TWO"
    case 3 => "THREE"
    case _ => "I won't say.." // _ = WILDCARD
  }

  println(num)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and I am $a years old" // If bob is of type "Person" this will deconstruct the name as "n" and age as "a"
    case _ => "I don't know you"
  }

  println(greeting)

    /*
      1. type of PM expression = unified type of all the types in all cases
      2. PM works really well with case classes
     */

  // Exercise

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) =>
      def showParentheses(exp: Expr): String = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      showParentheses(e1) + " * " + showParentheses(e2)
  }

  println(show(Sum(Number(2), Number(5))))
  println(show(Sum(Sum(Number(2), Number(5)), Number(8))))
  println(show(Prod(Sum(Number(2), Number(5)), Number(8))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(8))))
}
