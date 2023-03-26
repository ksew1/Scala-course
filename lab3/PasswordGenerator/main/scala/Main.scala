import utils._
object Main {
  private def readFile(inFileName: String, outFileName: String): Unit = try {
    println("Opening the file...")
    val inFile = scala.io.Source.fromFile(inFileName)
    val outFile = new java.io.PrintWriter(outFileName)

    for (login <- inFile.getLines) {
      val passwd = PasswordGenerator.nextPassword(10)
      outFile.println(login + ":" + passwd)
    }
    println("Closing the file...")
    outFile.close()
    inFile.close()

  } catch {
    case ex: java.io.FileNotFoundException =>
      println(ex.getMessage)
    case ex: Throwable =>
      println("Default exception handler: " + ex.getMessage)
  }

  def main(args: Array[String]): Unit = {
    readFile("logins.txt", "passwords.txt")
  }
}
