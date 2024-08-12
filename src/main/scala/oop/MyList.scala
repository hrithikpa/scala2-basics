package oop

// Generics: Type parameters in [] brackets
//abstract class MyList[+A] { // The [] brackets tells it is of type A, + is for covariance
//  // Other variance problem include invariant and contravariance[-A]
//  def head: A
//  def tail: MyList[A]
//  def isEmpty: Boolean
//  def add[B >: A](element: B): MyList[B]
//  def printElements: String // this is overriden by the class
//  override def toString: String = "[" + printElements + "]"
//  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
//}

//object Empty extends MyList[Nothing] {
//  def head: Nothing = throw new NoSuchElementException
//  def tail: MyList[Nothing] = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
//  def printElements: String = ""
//  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A]
//  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
//}
//
//class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
//  def head: A = h
//  def tail: MyList[A] = t
//  def isEmpty: Boolean = false
//  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
//  def printElements: String =
//    if(t.isEmpty) "" + h
//    else h + " " +  t.printElements
//}

//trait MyPredicate[-T] {
//  def test(ele: T): Boolean
//}
//
//trait MyTransformer[-A, B] {
//  def transform(ele: A): B
//}
//
//class EvenPredicate extends MyPredicate[Int] {
//  override def test(n: Int): Int = ???
//}
//
//object ListTest extends App {
//  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  val listOfStrings: MyList[String] = new Cons("1", new Cons("2", new Cons("3", Empty)))
//  println(listOfIntegers.head)
//  println(listOfStrings.head)
//  println((listOfIntegers.add(5)).toString)
//  println(listOfStrings.printElements)
//}