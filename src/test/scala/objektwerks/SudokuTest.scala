package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Sudoku.*

final class SukokuTest extends AnyFunSuite with Matchers:
  test("sudoku"):
    val problem =
      Array(
        Array(5,3,0, 0,7,0, 0,0,0),
        Array(6,0,0, 1,9,5, 0,0,0),
        Array(0,9,8, 0,0,0, 0,6,0),
        Array(8,0,0, 0,6,0, 0,0,3),
        Array(4,0,0, 8,0,3, 0,0,1),
        Array(7,0,0, 0,2,0, 0,0,6),
        Array(0,6,0, 0,0,0, 2,8,0),
        Array(0,0,0, 4,1,9, 0,0,5),
        Array(0,0,0, 0,8,0, 0,7,9)
      )

    println(prettyString(problem))
    solve(problem)