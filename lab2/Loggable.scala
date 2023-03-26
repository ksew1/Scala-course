trait Loggable {
  def log(timeStamp: Long, msg: String): Unit =
    println("[" + timeStamp.toString + "]: " + msg)
}
