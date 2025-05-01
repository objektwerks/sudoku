package objektwerks

import scala.util.boundary, boundary.break

object Solver: 
  type Board = Array[Array[Int]]

  def solve(board: Board,
            row: Int = 0,
            column: Int = 0): Option[Board] =
    if (row >= 9) Some(board)
    
    else if (column >= 9) solve(board, row + 1, 0)
    
    else if (board(row)(column) > 0) solve(board, row, column + 1)
    
    else (1 to 9)
      .filter(value => validate(board, row, column, value))
      .foreach: value =>
        board(row)(column) = value
        boundary:
          val newBoard = solve(board, row, column + 1)
          if newBoard.isDefined then break(newBoard)
        board(row)(column) = 0
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

  def print(board: Board): String =
    board.grouped(3).map: bigGroup =>
      bigGroup.map: row =>
        row.grouped(3).map: smallGroup =>
          smallGroup.mkString(" ", " ", " ")
        .mkString("|", "|", "|")
      .mkString("\n")
    .mkString("+-------+-------+-------+\n", "\n+-------+-------+-------+\n", "\n+-------+-------+-------+")