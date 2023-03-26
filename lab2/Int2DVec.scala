class Int2DVec private(val x: Int, val y: Int) {
  def +(other: Int2DVec) = new Int2DVec(x + other.x, y + other.y)

  def unary_- = new Int2DVec(-x, -y)

  def |-?(other: Int2DVec): Boolean = if ((x * other.x + y * other.y) == 0) true else false


  override def toString: String = "(" + x.toString + "," + y.toString + ")"

}

object Int2DVec {
  def apply(x: Int, y: Int) = new Int2DVec(x, y)

  def apply() = new Int2DVec(0, 0)

  def apply(prototype: Int2DVec) = new Int2DVec(prototype.x, prototype.y)

  def unitVectorOf(int2DVec: Int2DVec): Int2DVec = {
    val length = Math.sqrt(int2DVec.x * int2DVec.x + int2DVec.y * int2DVec.y)
    new Int2DVec((int2DVec.x / length).toInt, (int2DVec.y / length).toInt)
  }
}
