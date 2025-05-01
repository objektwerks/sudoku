package objektwerks

opaque type Digit = Int

object Digit:
  def apply(digit: Int): Digit = digit
  extension (digit: Digit)
    def value: Int = digit
 
final case class Grid(grid: Array[Array[Digit]])