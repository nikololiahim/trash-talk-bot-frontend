import japgolly.scalajs.react.*
import japgolly.scalajs.react.vdom.html_<^.*
import org.scalajs.dom


object Main:
  def main(args: Array[String]): Unit =

    val HelloMessage = ScalaComponent
      .builder[String]
      .render($ => <.div("Hello ", $.props))
      .build

    val root = dom.document.getElementById("app")
    HelloMessage("JOHN").renderIntoDOM(root)
    
  end main
end Main
