package trash.bot

import scala.scalajs.js.annotation.JSExportTopLevel
import scala.scalajs.LinkingInfo

import slinky.core._
import slinky.web.ReactDOM
import slinky.hot
import App._
import org.scalajs.dom

object Main {
  val css = Css.Index

  @JSExportTopLevel("main")
  def main(args: Array[String]): Unit = {
    if (LinkingInfo.developmentMode) {
      hot.initialize()
    }

    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }

    ReactDOM.render(App(), container)
  }
}
