Sudoku
------
>Sudoku app using ScalaFx and Scala 3.

Build
-----
1. sbt clean compile

Run
---
1. sbt run

Assembly
--------
1. sbt clean test assembly copyAssemblyJar

Execute
-------
1. ```java -jar target/scala-3.6.4/sudoku-0.0.0.jar```
>or:
1. ```java -jar .assembly/sudoku-0.0.0.jar```

Deploy
------
1. edit build.sbt ( jarVersion + version )
2. edit app.conf ( about > alert > contentText )
3. edit package.json ( version + jdeploy / jar )
4. edit readme
5. sbt clean test assembly copyAssemblyJar
6. perform github release ( from https://github.com/objektwerks/sudoku )
7. npm login
8. jdeploy publish ( to https://www.jdeploy.com/~sudoku )
9. check email for npm message
>See [jDeploy Docs](https://www.jdeploy.com/docs/manual/#_getting_started) for details.

Resources
---------
* [Sudoku Rules](https://www.sudokuonline.io/tips/sudoku-rules)
* [Sudoku, RockTheJvm](https://rockthejvm.com/articles/a-backtracking-sudoku-solver-in-scala)

License
-------
>Copyright (c) [2024, 2025] [Objektwerks]

>Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    * http://www.apache.org/licenses/LICENSE-2.0

>Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.