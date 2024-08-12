package oop

object CaseClasses extends App {
  // 1. Case classes are immutable data holding classes with little boilerplate like equals, hashCode, toString
  // 2. Case classes are good for modelling immutable data
  // 3. Case classes are representation of a data structure. Functions on data should be described in separate software entities like traits, objects
  case class Person(name: String, age: Int)
  val jim = Person("Jim", 29) // case classes have apply method by default, taking care of object construction. Also, it is possible to use the 'new' keyword explicitly
  // case class parameters are fields
  println(jim.name)
  val jim2 = Person("Jim", 29)
  // comparisons
  println(jim == jim2) // Instances of case classes are compared by structure and not by reference

  // copy
  val jim3 = jim.copy(age = 22)
  println(jim3)

  // 4. Case classes are serializable

  // 5. Case classes have extractor patterns = Case classes can be used in pattern matching
}
