import org.scalatest.flatspec._
import utils.PasswordGenerator

class PasswordGeneratorSpec extends AnyFlatSpec {
  "PasswordGenerator" should "generate a password with a given length" in {
    val password = PasswordGenerator.nextPassword(10)
    assert(password.length == 10)
  }
  it should "generate a password with only allowed characters" in {
    val password = PasswordGenerator.nextPassword(10)
    assert(password.forall(c => PasswordGenerator.allowedChars.contains(c)))
  }
}
