package trash.bot

import slinky.web.ReactDOM
import org.scalajs.dom.document
import trash.bot.App.App

class AppTest extends munit.FunSuite {
  test("Renders without crashing") {
    val div = document.createElement("div")
    ReactDOM.render(App(), div)
    ReactDOM.unmountComponentAtNode(div)
  }
}
