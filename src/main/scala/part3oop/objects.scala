package part3oop

object objects extends App {
  // An object is a class that has exactly one instance.
  // Objects do not receive parameters
  object Person{ // type + it's only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    // factory methods
    def apply(mother: Person, father: Person): Person = new Person("Bob")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // An object with the same name as a class is called a companion object.

  // Scala object = Singleton instance
  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val marry = new Person("Marry") // this is calling class
  val john = new Person("John")

  val bob = Person(marry, john) // Similar to Person.apply(marry, john)
}
