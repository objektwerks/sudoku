package objektwerks

opaque type Digit = Int

object Digit:
  def apply(digit: Int): Digit = digit
  extension (digit: Digit)
    def value: Int = digit
 
type Grid = Array[Array[Digit]]