package oop

object Inheritance extends App {
  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = println("crunch crunch")
  }
  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0) // aux constructor
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // override
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType = "domestic"
    override def eat = println("crunch, crunch")
  }
  val dog = new Dog("K9")
  // dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on entire class
  // 3 - seal the class = extend classes in this file, prevent extension in other files
}
