package objektwerks

object Sudoku:
  type Board = Array[Array[Int]]

  private def validate(sudoku: Board,
                       x: Int,
                       y: Int,
                       value: Int): Boolean =
    val row = sudoku(y)
    val rowProperty = !row.contains(value)

    val column = sudoku.map(r => r.apply(x))
    val columnProperty = !column.contains(value)

    val boxX = x / 3
    val boxY = y / 3
    val box = for {
      yb <- (boxY * 3) until (boxY * 3 + 3) // indices for rows in THIS box
      xb <- (boxX * 3) until (boxX * 3 + 3) // same for cols
    } yield sudoku(yb)(xb)
    val boxProperty = !box.contains(value)

    rowProperty && columnProperty && boxProperty

  def prettyString(sudoku: Board): String =
    sudoku.grouped(3).map { bigGroup =>
      bigGroup.map { row =>
        row.grouped(3).map { smallGroup =>
          smallGroup.mkString(" ", " ", " ")
        }.mkString("|", "|", "|")
      }.mkString("\n")
    }.mkString("+-------+-------+-------+\n", "\n+-------+-------+-------+\n", "\n+-------+-------+-------+")

  def solve(sudoku: Board,
            x: Int = 0,
            y: Int = 0): Unit =
    if (y >= 9) then println(prettyString(sudoku)) // final solution
    else if (x >= 9) then solve(sudoku, 0, y + 1) // need to fill in the next row
    else if (sudoku(y)(x) > 0) then solve(sudoku, x + 1, y) // need to fill in the next cell (cell to the right)
    else (1 to 9)
      .filter(value => validate(sudoku, x, y, value))
      .foreach { value =>
        sudoku(y)(x) = value // fill the sudoku board with the value
        solve(sudoku, x + 1, y) // try the next cell
        sudoku(y)(x) = 0 // remove the value
      }