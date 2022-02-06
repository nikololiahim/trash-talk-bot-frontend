import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

object Main {
  def main(args: Array[String]): Unit = {
    val HelloMessage = ScalaComponent
      .builder[String]
      .render($ => <.div("Hello ", $.props))
      .build

    val root = dom.document.getElementById("app")
    HelloMessage("John").renderIntoDOM(root)
  }
}
