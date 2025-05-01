package objektwerks

opaque type Digit = Int

object Digit:
  def apply(digit: Int): Digit = digit
  extension (digit: Digit)
    def value: Int = digit

final case class Cell(digit: Digit)

final case class Row(cells: Set[Cell])

final case class Column(cells: Set[Cell])
 
final case class Grid(rows: Set[Cell], columns: Set[Cell])