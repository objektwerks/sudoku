package objektwerks

type Board = Array[Array[Int]]

final case class Solver(board: Board) derives CanEqual:
  println( print(board) )

  def solve(row: Int = 0,
            column: Int = 0): Unit =
    if (row >= 9) println( print(board) )
    
    else if (column >= 9) solve(row + 1, 0)
    
    else if (board(row)(column) > 0) solve(row, column + 1)
    
    else (1 to 9)
      .filter(value => validate(row, column, value))
      .foreach: value =>
        board(row)(column) = value
        solve(row, column + 1)
        board(row)(column) = 0

  def validate(row: Int,
               column: Int,
               value: Int): Boolean =
    val doesRowContainValue = !board(row).contains(value)

    val doesColumnContainValue = !board.map(rows => rows.apply(column)).contains(value)

    val boxX = column / 3
    val boxY = row / 3
    val box = for
      rowY <- (boxY * 3) until (boxY * 3 + 3)
      colX <- (boxX * 3) until (boxX * 3 + 3)
    yield board(rowY)(colX)
    val doesBoxContainValue = !box.contains(value)

    doesRowContainValue && doesColumnContainValue && doesBoxContainValue

  def print(board: Board): String =
    board.grouped(3).map: rows =>
      rows.map: row =>
        row.grouped(3).map: columns =>
          columns.mkString(" ", " ", " ")
        .mkString("|", "|", "|")
      .mkString("\n")
    .mkString("+-------+-------+-------+\n", "\n+-------+-------+-------+\n", "\n+-------+-------+-------+")