package utils

object PasswordGenerator {
  val allowedChars: Seq[Char] = ('0' to '9') ++
    ('A' to 'Z') ++
    ('a' to 'z') ++
    Array('-', '.', '_')

  def nextPassword(passwdLen: Int): String = {
    val passwd = new StringBuilder(passwdLen)

    for (_ <- 1 to passwdLen)
      passwd += nextChar()

    passwd.toString
  }

  private def nextChar(): Char = {
    allowedChars(util.Random.nextInt(allowedChars.length))
  }
}
