trait Fraction {
  val numerator: Int
  val denominator: Int

  def *(other: Fraction): Fraction

  def -(other: Fraction): Fraction

  def +(other: Fraction): Fraction

  def /(other: Fraction): Fraction
}


object Fraction {
  // one of the "creational patterns/idioms"
  def apply(num: Int, denominator: Int, loggable: Boolean = false): Fraction =
    if (loggable) new LoggableImpl(num, denominator)
    else new DefaultImpl(num, denominator)

  private class DefaultImpl(val numerator: Int, val denominator: Int) extends Fraction {
    override def *(other: Fraction): Fraction =
      Fraction(this.numerator * other.numerator, this.denominator * other.denominator)

    override def -(other: Fraction): Fraction =
      Fraction(this.numerator * other.denominator - other.numerator * this.denominator,
        this.denominator * other.denominator)

    override def +(other: Fraction): Fraction =
      Fraction(this.numerator * other.denominator + other.numerator * this.denominator,
        this.denominator * other.denominator)

    override def /(other: Fraction): Fraction =
      Fraction(this.numerator * other.denominator, this.denominator * other.numerator)

    override def toString: String = numerator.toString + "/" + denominator.toString
  }

  private class LoggableImpl(num: Int, denominator: Int)
    extends DefaultImpl(num, denominator) with Loggable {
    private def timeStamp = System.nanoTime // to keep the example short...

    override def *(other: Fraction): Fraction = {
      log(timeStamp, "multiplying " + this.toString + " by " + other.toString)
      // super.*(other) is not loggable
      Fraction(this.num * other.numerator, this.denominator * other.denominator, loggable = true)
    }

    override def -(other: Fraction): Fraction = {
      log(timeStamp, "subtracting " + other.toString + " from " + this.toString)
      Fraction(this.num * other.denominator - other.numerator * this.denominator,
        this.denominator * other.denominator, loggable = true)
    }

    override def +(other: Fraction): Fraction = {
      log(timeStamp, "adding " + other.toString + " to " + this.toString)
      Fraction(this.num * other.denominator + other.numerator * this.denominator,
        this.denominator * other.denominator, loggable = true)
    }

    override def /(other: Fraction): Fraction = {
      log(timeStamp, "dividing " + this.toString + " by " + other.toString)
      Fraction(this.num * other.denominator, this.denominator * other.numerator, loggable = true)
    }
  }
}


