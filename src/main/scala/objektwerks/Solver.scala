package objektwerks

object Solver: 
  type Board = Array[Array[Int]]

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
      yb <- (boxY * 3) until (boxY * 3 + 3) // indices for rows in THIS box
      xb <- (boxX * 3) until (boxX * 3 + 3) // same for cols
    } yield board(yb)(xb)
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