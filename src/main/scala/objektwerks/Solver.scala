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
            x: Int = 0,
            y: Int = 0): Unit =
    if (y >= 9) println(toString(board)) // final solution
    
    else if (x >= 9) solve(board, 0, y + 1) // need to fill in the next row
    
    else if (board(y)(x) > 0) solve(board, x + 1, y) // need to fill in the next cell (cell to the right)
    
    else (1 to 9)
      .filter(value => validate(board, x, y, value))
      .foreach: value =>
        board(y)(x) = value // fill the sudoku board with the value
        solve(board, x + 1, y) // try the next cell
        board(y)(x) = 0 // remove the value

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