package objektwerks

object Solver: 
  type Board = Array[Array[Int]]

/* 
  def solve(): Option[Array[Array[Int]]] = solveHelper(row = 0, col = 0)
  private def solveHelper(row: Int, col: Int): Option[Array[Array[Int]]] =
    if (row == 9) {
      Some(puzzle)
    } else if (col == 9) {
      solveHelper(row + 1, 0)
    } else if (puzzle(row)(col) != 0) {
      solveHelper(row, col + 1)
    } else {
      val validDigits = getValidDigits(row, col)
      validDigits.foreach { digit =>
        puzzle(row)(col) = digit
        val result = solveHelper(row, col + 1)
        if (result.isDefined) {
          return result
        }
        puzzle(row)(col) = 0
      }
      None
    }
*/

  def solve(board: Board,
            row: Int = 0,
            column: Int = 0): Option[Board] =
    if (row >= 9) Some(board)
    
    else if (column >= 9) solve(board, 0, row + 1) // need to fill in the next row
    
    else if (board(row)(column) > 0) solve(board, column + 1, row) // need to fill in the next cell (cell to the right)
    
    else
      (1 to 9)
        .filter(value => validate(board, row, column, value))
        .foreach: value =>
          board(row)(column) = value // fill board with value
          solve(board, row, column + 1) // try the next cell
          board(row)(column) = 0 // remove the value
      None

  def validate(board: Board,
               row: Int,
               column: Int,
               value: Int): Boolean =
    val doesRowContainValue = !board(row).contains(value)

    val doesColumnContainValue = !board.map(rows => rows.apply(column)).contains(value)

    val boxX = column / 3
    val boxY = row / 3
    val box = for {
      rowY <- (boxY * 3) until (boxY * 3 + 3)
      colX <- (boxX * 3) until (boxX * 3 + 3)
    } yield board(rowY)(colX)
    val doesBoxContainValue = !box.contains(value)

    doesRowContainValue && doesColumnContainValue && doesBoxContainValue

  def toString(board: Board): String =
    board.grouped(3).map: bigGroup =>
      bigGroup.map: row =>
        row.grouped(3).map: smallGroup =>
          smallGroup.mkString(" ", " ", " ")
        .mkString("|", "|", "|")
      .mkString("\n")
    .mkString("+-------+-------+-------+\n", "\n+-------+-------+-------+\n", "\n+-------+-------+-------+")