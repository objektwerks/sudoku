package objektwerks.ui

import com.typesafe.config.Config

import scalafx.scene.image.Image

final class Context(config: Config):
  val windowTitle = config.getString("window.title")
  val windowWidth = config.getDouble("window.width")
  val windowHeight = config.getDouble("window.height")

  val aboutAlertHeaderText = config.getString("about.alert.headerText")
  val aboutAlertContentText = config.getString("about.alert.contentText")

  val menuMenu = config.getString("menu.menu")
  val menuAbout = config.getString("menu.about")
  val menuExit = config.getString("menu.exit")

  val labelDate = config.getString("label.date")
  val labelDayOfYear = config.getString("label.dayOfYear")
  val labelRemainingDaysInYear = config.getString("label.remainingDaysInYear")
  val labelFromDate = config.getString("label.fromDate")
  val labelToDate = config.getString("label.toDate")
  val labelDateDiff = config.getString("label.dateDiff")
  val labelText = config.getString("label.text")
  val labelNumber = config.getString("label.number")
  val labelNumbers = config.getString("label.numbers")
  val labelTexts = config.getString("label.texts")
  val labelNumberListed = config.getString("label.numberListed")
  val labelEncodings = config.getString("label.encodings")

  val buttonClear = config.getString("button.clear")

  val columnNumber = config.getString("column.number")
  val columnTexts = config.getString("column.texts")
  val columnPrimeRank = config.getString("column.primeRank")
  val columnFibonacciRank = config.getString("column.fibonacciRank")
  val columnStar = config.getString("column.star")
  val columnTriangular = config.getString("column.triangular")
  val columnFactors = config.getString("column.factors")
  val columnText = config.getString("column.text")
  val columnOrdinal = config.getString("column.ordinal")
  val columnReverseOrdinal = config.getString("column.reverseOrdinal")
  val columnReduction = config.getString("column.reduction")
  val columnReverseReduction = config.getString("column.reverseReduction")
  val columnLatin = config.getString("column.latin")
  val columnChaldean = config.getString("column.chaldean")
  val columnSeptenary = config.getString("column.septenary")
  val columnKeypad = config.getString("column.keypad")
  val columnStandard = config.getString("column.standard")
  val columnReverseStandard = config.getString("column.reverseStandard")
  val columnSumerian = config.getString("column.sumerian")
  val columnReverseSumerian = config.getString("column.reverseSumerian")
  val columnPrimes = config.getString("column.primes")
  val columnReversePrimes = config.getString("column.reversePrimes")
  val columnFibonacci = config.getString("column.fibonacci")
  val columnSquares = config.getString("column.squares")
  val columnReverseSquares = config.getString("column.reverseSquares")
  val columnTrigonal = config.getString("column.trigonal")
  val columnReverseTrigonal = config.getString("column.reverseTrigonal")
  val columnSingleReduction = config.getString("column.singleReduction")
  val columnReverseSingleReduction = config.getString("column.reverseSingleReduction")
  val columnSatanic = config.getString("column.satanic")
  val columnReverseSatanic = config.getString("column.reverseSatanic")

  val tabDate = config.getString("tab.date")
  val tabDateEncodings = config.getString("tab.dateEncodings")
  val tabDateDif = config.getString("tab.dateDiff")

  def appIcon = Image(Image.getClass.getResourceAsStream("/cipher.png"))