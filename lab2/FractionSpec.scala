import org.scalatest.flatspec._


class FractionSpec extends AnyFlatSpec {
  "A Fraction" should "be created with a numerator and denominator" in {
    val f = Fraction(3, 4)
    assert(f.numerator == 3)
    assert(f.denominator == 4)
  }
  it should "be created with a numerator and denominator and loggable" in {
    val f = Fraction(3, 4, loggable = true)
    assert(f.numerator == 3)
    assert(f.denominator == 4)
  }
  it should "be divided by another Fraction" in {
    val f1 = Fraction(3, 4)
    val f2 = Fraction(4, 5)
    val f3 = f1 / f2
    assert(f3.numerator == 15)
    assert(f3.denominator == 16)
  }
  it should "be multiplied by another Fraction" in {
    val f1 = Fraction(3, 4)
    val f2 = Fraction(4, 5)
    val f3 = f1 * f2
    assert(f3.numerator == 12)
    assert(f3.denominator == 20)
  }
  it should "be added to another Fraction" in {
    val f1 = Fraction(3, 4)
    val f2 = Fraction(4, 5)
    val f3 = f1 + f2
    assert(f3.numerator == 31)
    assert(f3.denominator == 20)
  }
  it should "be subtracted from another Fraction" in {
    val f1 = Fraction(3, 4)
    val f2 = Fraction(4, 5)
    val f3 = f1 - f2
    assert(f3.numerator == -1)
    assert(f3.denominator == 20)
  }
}
