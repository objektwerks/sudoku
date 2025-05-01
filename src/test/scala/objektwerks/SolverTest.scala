package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

final class SolverTest extends AnyFunSuite with Matchers:
  test("solver"):
    println(s"input board:\n${Solver.print( Solver.default() )}")
    Solver.solve( Solver.default() )