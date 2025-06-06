package objektwerks

import scala.collection.mutable.ArraySeq

type Board = ArraySeq[ArraySeq[Int]]

@main
def runSolver: Unit =
  println(s"input board:\n${print(default())}")
  solve( default() )

/**
 * This method should be tail recursive, and not contain a side effect.
 * Satisfying the akward backtracking sudoku technique, though, makes
 * it difficult. No doubt, someone has a better alternative. :)
 */
def solve(board: Board,
          row: Int = 0,
          column: Int = 0): Unit =
  if row >= 9 then
    println(s"output board:\n${print(board)}")
    assert(board == answer(), "*** The output board is invalid! ***")
  
  else if column >= 9 then
    solve(board, row + 1, 0)
  
  else if board(row)(column) > 0 then
    solve(board, row, column + 1)
  
  else
    (1 to 9)
      .filter(value => validate(board, row, column, value))
      .foreach: value =>
        board(row)(column) = value
        solve(board, row, column + 1)
        board(row)(column) = 0

def validate(board: Board,
              row: Int,
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

def default(): Board =
  ArraySeq(
    ArraySeq(5,3,0, 0,7,0, 0,0,0),
    ArraySeq(6,0,0, 1,9,5, 0,0,0),
    ArraySeq(0,9,8, 0,0,0, 0,6,0),

    ArraySeq(8,0,0, 0,6,0, 0,0,3),
    ArraySeq(4,0,0, 8,0,3, 0,0,1),
    ArraySeq(7,0,0, 0,2,0, 0,0,6),

    ArraySeq(0,6,0, 0,0,0, 2,8,0),
    ArraySeq(0,0,0, 4,1,9, 0,0,5),
    ArraySeq(0,0,0, 0,8,0, 0,7,9)
  )

def answer(): Board =
  ArraySeq(
    ArraySeq(5,3,4, 6,7,8, 9,1,2),
    ArraySeq(6,7,2, 1,9,5, 3,4,8),
    ArraySeq(1,9,8, 3,4,2, 5,6,7),

    ArraySeq(8,5,9, 7,6,1, 4,2,3),
    ArraySeq(4,2,6, 8,5,3, 7,9,1),
    ArraySeq(7,1,3, 9,2,4, 8,5,6),

    ArraySeq(9,6,1, 5,3,7, 2,8,4),
    ArraySeq(2,8,7, 4,1,9, 6,3,5),
    ArraySeq(3,4,5, 2,8,6, 1,7,9)
  )