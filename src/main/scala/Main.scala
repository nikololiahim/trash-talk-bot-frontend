import japgolly.scalajs.react.*
import japgolly.scalajs.react.vdom.html_<^.*
import org.scalajs.dom
import scala.util.Try


object Main:
  def main(args: Array[String]): Unit =

    case class FibProps(n: Int)
    class Backend($: BackendScope[Unit, FibProps]):

      def onTextChange(e: ReactEventFromInput) =
        e.extract(_.target.value)(
          value => $.modState(_ => Try(value.toInt)
            .map(FibProps(_))
            .getOrElse(FibProps(0)))
        )

      def fib(n: Int): BigInt =
        (2 until n).foldLeft[(BigInt, BigInt)]((1, 1)) {
          case ((n1, n2), _) => (n2, n1+n2)
        }._2


    val Input = ScalaComponent
      .builder[(FibProps, Backend)]
      .render_P {case (n, b) => <.input.text(
        ^.value := n.n,
        ^.onChange ==> b.onTextChange
      )}
      .build


    val Fibonacci = ScalaComponent
      .builder[(FibProps, Backend)]
      .render_P {
        case (p, b) => <.div(
          <.h1(s"${p.n}th fibonacci number is ${b.fib(p.n)}")
        )
      }
      .build

    val Page = ScalaComponent
      .builder[Unit]
      .initialState(FibProps(0))
      .backend(new Backend(_))
      .renderS(($, s) =>
        <.div(
          <.div("Enter desired fib index:"),
          Input((s, $.backend)),
          Fibonacci((s, $.backend)),
        )
      )
      .build


    val root = dom.document.getElementById("app")
    Page().renderIntoDOM(root)

  end main
end Main
