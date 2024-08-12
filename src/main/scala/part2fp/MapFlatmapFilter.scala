package part2fp

object MapFlatmapFilter extends App {
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')

  // flatMap - It expects the provided function to return a collection(seq, list, arrays, even a option type) rather than a single value
  val combinations = (x: Char) => numbers.map(x + _.toString)
  println(chars.flatMap(combinations))

  // for-combinations
  val forCombinations = for {
    n <- numbers
    c <- chars
  } yield c + n.toString

  println(forCombinations)

  println(List(1, 2, 3).flatMap(x => Some(x * 2)))

  // Example

  class Vehicle(val name: String, val model: String, val age: Int, val color: String)

  val vehicles = Seq(
    new Vehicle("Honda", "Civic", 2023, "Red"),
    new Vehicle("Toyota", "Corolla", 2022, "Blue"),
    new Vehicle("Suzuki", "Swift", 2021, "Black")
  )

  val vehicleNames = vehicles.flatMap(vehicle => vehicle.name) // This works because String is treated as a Seq[char]
  println(vehicleNames)

}
