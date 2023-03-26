trait Fraction {
  val num: Int
  val denom: Int

  def *(other: Fraction): Fraction
}


object Fraction {
  // one of the "creational patterns/idioms"
  def apply(num: Int, denom: Int, loggable: Boolean = false): Fraction =
    if (loggable) new LoggableImpl(num, denom)
    else new DefaultImpl(num, denom)

  private class DefaultImpl(val num: Int, val denom: Int) extends Fraction {
    override def *(other: Fraction): Fraction =
      Fraction(this.num * other.num, this.denom * other.denom)

    override def toString: String = num.toString + "/" + denom.toString
  }

  private class LoggableImpl(num: Int, denom: Int)
    extends DefaultImpl(num, denom) with Loggable {
    private def timeStamp = System.nanoTime // to keep the example short...

    override def *(other: Fraction): Fraction = {
      log(timeStamp, "multiplying " + this.toString + " by " + other.toString)
      // super.*(other) is not loggable
      Fraction(this.num * other.num, this.denom * other.denom, loggable = true)
    }
  }
}


