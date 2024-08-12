package part2fp

import scala.annotation.tailrec

object TuplesAndMaps extends App {
  // tuples = finite ordered "lists"
  val atuple = (2, "hello", "scala")
//  println(atuple._1)
//  println(atuple.copy(_2 = "goodbye java"))

  // Maps
  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
//  println(phonebook.contains("Jim"))
//  println(phonebook("Marry"))

  // add a pairing
  val newPair = "Marry" -> 678
  val newPhonebook = phonebook + newPair
//  println(newPhonebook)

  // Social network
  def addPerson(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], person1: String, person2: String): Map[String, Set[String]] = {
    val friends1 = network(person1)
    val friends2 = network(person2)
    network + (person1 -> (friends1 + person2)) + (person2 -> (friends2 + person1))
  }

  private def unfriend(network: Map[String, Set[String]], person1: String, person2: String): Map[String, Set[String]] = {
    val friends1 = network(person1)
    val friends2 = network(person2)
    network + (person1 -> (friends1 - person2)) + (person2 -> (friends2 - person1)) // '+' creates a new pairing and replace old pairing with the new one
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val socialNetwork: Map[String, Set[String]] = Map()
  val network = addPerson(addPerson(socialNetwork, "Bob"), "Johnson")
//  println(network)
//  println(friend(network, "Bob", "Johnson"))

  val people: Map[String, Set[String]] = addPerson(addPerson(addPerson(Map(), "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")
  println(testNet)

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def peopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)

  println(peopleWithNoFriends(testNet))
}