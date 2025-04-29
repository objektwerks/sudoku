package objektwerks.ui

import scalafx.scene.Scene
import scalafx.scene.layout.VBox

final class View(context: Context, model: Model):
  val menu = Menu(context)

  val vbox = new VBox:
    prefWidth = context.windowWidth
    prefHeight = context.windowHeight
    children = List(
      menu,
      DatePane(context, model),
      TextsPane(context, model),
      NumbersPane(context, model),
      EncodingsPane(context, model),
      EnterPane(context, model)
    )

  val scene = new Scene:
    root = vbox
    stylesheets = List("/style.css")