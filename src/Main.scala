object Main {
  private def usePerson(): Unit = {
    val p = new Person("1234567890", "Kowalski", "Jan")
    println(p.givenName)
  }

  private def useInt2DVec(): Unit = {
    val v1 = Int2DVec(1, 1)
    val v2 = Int2DVec(-1, 1)
    val v3 = v1 + v2
    val v4 = -v2
    if (v1 |-? v2) println("v1 and v2 are orthogonal")
    else println("v1 and v2 are not orthogonal")
    println(v3)
    println(v4)
    println(Int2DVec())
    println(Int2DVec(v1 + v1 + v2))
  }

  private def useFraction(): Unit = {
    val f1 = Fraction(3, 7)
    val f2 = Fraction(4, 9)
    val f3 = Fraction(1, 19, loggable = true)
    val f1f2 = f1 * f2
    println(f1.toString + " * " + f2.toString + " = " + f1f2)
    println(f3.toString + " * " + f2.toString + " * " +
      f1.toString + " = " + f3 * f2 * f1)
  }

  def main(args: Array[String]): Unit = {
    usePerson()
    useInt2DVec()
    useFraction()
  }
}