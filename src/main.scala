object Main {
  def interpolate(xs: Seq[Double], ys: Seq[Double])(x: Double): Double = {
    xs.indices.map { i =>
      val basis = xs.zipWithIndex.collect {
        case (xj, j) if j != i => (x - xj) / (xs(i) - xj)
      }.product
      ys(i) * basis
    }.sum
  }

  def main(args: Array[String]): Unit = {
    val xs = Seq(0.0, 1.0, 2.0)
    val ys = Seq(1.0, 3.0, 2.0)
    println(interpolate(xs, ys)(1.5))
  }
}

object Test {
  def main(args: Array[String]) = {}
}
