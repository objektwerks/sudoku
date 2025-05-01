package objektwerks

final case class Digit()

final case class Cell(digit: Digit)

final case class Row(cells: Set[Cell])

final class Column
 
final class Grid