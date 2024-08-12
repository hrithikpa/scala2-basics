package fp

object hof extends App {
  val plusOne = (x: Int) => x + 1

  def ntimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else ntimes(f, n - 1, f(x))

  println(ntimes(plusOne, 10, 1))

  def ntimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x // this returns a function
    else (x: Int) => ntimesBetter(f, n - 1)(f(x)) // to the returned function we pass the f(x) i.e. x + 1
  }

  val plus10 = ntimesBetter(plusOne, 10) // this would give us x + 10
  println(plus10(1))

  // curried functions
  val supperAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  println(supperAdder(4)(9))
}
