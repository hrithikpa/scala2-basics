package oop

object OOBasics extends App {
  private val author = new Writer("James", "Clear", 1964)
  private val novel = new Novel("Atomic Habits", 2019, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))
}

class Writer(firstName: String, surName: String, val year: Int) { // firstName, surName are parameters and year is field
  def fullName: String = firstName + " " + surName
}

class Novel(name: String, yearOfRelease: Int, author: Writer){
  def authorAge: Int = yearOfRelease - author.year
  def isWrittenBy(author: Writer): Boolean = this.author == author
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}