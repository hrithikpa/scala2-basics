import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    // IF EXPRESSION
    val aCondition = true
    val aConditionedValue = if(aCondition) 5 else 2
    println(aConditionedValue)

    /* EVERYTHING IN SCALA IS EXPRESSION
       THEY ARE LIKE INSTRUCTIONS BUT IN SCALA THEY ARE STILL EXPRESSIONS RETURNING UNIT
       EXAMPLE:
     */
    var aVariable = 5
    val aWeiredValue = (aVariable = 2) // this return UNIT

    // WHEN YOU NEED LOOPS, USE RECURSION (THIS IS FUNDAMENTAL IDEA OF FUNCTIONAL PROGRAMMING)
    // In Scala, we use tail recursion. Tail recursion compiles to the same bytecode as java loops, by reusing the same stack frame with every recursive call.
    // So there is no concern for potential stack overflows.

    // COMPILERS CAN INFER TYPES OF VAL, VAR AND RETURN TYPES OF FUNCTIONS

    def factorial(num: Int): Int = {
      if(num == 1) num
      else num * factorial(num - 1) // Not tail recursive
    }
    println(factorial(5))

    def fibo(num: Int): Int = {
      if(num <= 2) 1
      else fibo(num - 1) + fibo(num - 2) // Not tail recursive
    }
    println(fibo(8))

    @tailrec
    def isPrime(num: Int, d: Int): Boolean = {
      if(d == num) true
      else if(num % d == 0) false
      else isPrime(num, d + 1) // This is the last expression that's why it is tail recursion
    }
    println(isPrime(8, 2))

    def isPrimeA(num: Int): Boolean = {
      @tailrec
      def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
        if(!isStillPrime) false
        else if(t <= 1) true
        else isPrimeTailrec(t - 1, num % t != 0 && isStillPrime)
      }
      isPrimeTailrec(num / 2, isStillPrime = true)
    }
    println(isPrimeA(5))
  }
}