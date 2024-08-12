object StringOps extends App{
  // S-interpolators
  val name = "Mike"
  val age = 12
  println(s"My name is $name and I'm $age old")

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolators
  println(raw"this is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
