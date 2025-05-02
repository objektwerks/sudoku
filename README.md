Sudoku
-------
>Sudoku app using Scala 3.

>The *Solver*, herein, is derived from this work [Sudoku, RockTheJvm](https://rockthejvm.com/articles/a-backtracking-sudoku-solver-in-scala)

>The *Solver.solve* method is not without issues, though. It should be tail recursive, and not contain a side effect.

>Satisfying the akward *backtracking* sudoku technique, though, makes it difficult. No doubt, someone has a better alternative. :)

Structure
---------
* Rows - 9 rows ***of*** 9 horizontal cells
* Columns - 9 columns ***of*** 9 vertical cells
* Blocks - 9 blocks ***of*** 9 cells
* Cells - 81 cells across 9 rows ***and*** 9 columns ***or*** 9 blocks

Rules
-----
1. Each row **must** contain the numbers, 1 to 9, without repetition.
2. Each column **must** contain the numbers, 1 to 9, without repetition.
3. The numbers, 1 to 9, **can only** occur **once per** row, column ***and*** block.
4. The sum of each row, column ***and*** block **must** equal 45.
5. Each puzzle **must** have a **unique** solution.

Build
-----
1. sbt clean compile

Run
---
1. sbt run

Resources
---------
* [Sudoku Rules](https://www.sudokuonline.io/tips/sudoku-rules)
* [Sudoku, RockTheJvm](https://rockthejvm.com/articles/a-backtracking-sudoku-solver-in-scala)