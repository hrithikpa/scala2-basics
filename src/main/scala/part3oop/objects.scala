package part3oop

object objects extends App {
  // An object is a class that has exactly one instance.
  // Objects do not receive parameters
  object Logger {
    // "static"/"class" - level functionality
    def info(message: String): Unit = println(s"INFO: $message")
    // factory methods
    def apply(message: String): Logger = new Logger(message)
  }
  class Logger(val message: String) {
    // instance-level functionality
  }
  // An object with the same name as a class is called a companion object.
  Logger.info("Successful")
  val log = Logger.apply("Failed")
  println(log.message)
}
