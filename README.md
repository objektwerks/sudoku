Sudoku
------
>Sudoku app using ScalaFx and Scala 3.

Rules
-----
1. Each row **must** contain the numbers from 1 to 9, without repetitions.
2. Each column **must** contain the numbers from 1 to 9, without repetitions.
3. The digits **can only** occur **once** per block.
4. The sum of each row, column and block **must** equal 45.

Build
-----
1. sbt clean compile

Test
----
1. sbt clean test

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

jDeploy Install
---------------
1. Setup npm account at npmjs.com
2. Install node, which installs npm, which bundles npx.
3. Install jdeploy via npm - *npm install -g jdeploy*
4. Add icon.png ( 256x256 or 512x512 ) to project root and resources.
5. Edit jDeploy *package.json* as required.
6. Add *jdeploy* and *jdeploy-bundle* to .gitignore
>See [jDeploy Docs](https://www.jdeploy.com/docs/manual/#_getting_started) for details.

NPM Versioning
--------------
>The ```build.sbt``` **must** contain a ```semver 3-digit``` **version** number. See: [Npmjs Semver](https://docs.npmjs.com/about-semantic-versioning)

NPM Registry
------------
>GCiphers is deployed to: https://www.npmjs.com/package/sudoku

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