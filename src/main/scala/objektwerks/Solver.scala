package objektwerks

object Solver: 
  type Board = Array[Array[Int]]

/* 
  def solve(): Option[Array[Array[Int]]] = solveHelper(0, 0)
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

  private def getValidDigits(row: Int, col: Int): Seq[Int] = // Logic to determine valid digits for the given row and column
*/

  def solve(board: Board,
            column: Int = 0,
            row: Int = 0): Option[Board] =
    if (row >= 9) Some(board)
    
    else if (column >= 9) solve(board, 0, row + 1) // need to fill in the next row
    
    else if (board(row)(column) > 0) solve(board, column + 1, row) // need to fill in the next cell (cell to the right)
    
    else (1 to 9)
      .filter(value => validate(board, column, row, value))
      .foreach: value =>
        board(row)(column) = value // fill the sudoku board with the value
        solve(board, column + 1, row) // try the next cell
        board(row)(column) = 0 // remove the value
      None

  def validate(board: Board,
               x: Int,
               y: Int,
               value: Int): Boolean =
    val row = board(y)
    val doesRowContainValue = !row.contains(value)

    val column = board.map(r => r.apply(x))
    val doesColumnContainValue = !column.contains(value)

    val boxX = x / 3
    val boxY = y / 3
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