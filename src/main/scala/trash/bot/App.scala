package trash.bot

import slinky.web.html._
import slinky.core.facade.Hooks._
import slinky.core.{FunctionalComponent, SyntheticEvent}
import trash.bot.ChatFind.ChatFindProps
import trash.bot.MessageList.MessageListProps

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("resources/App.css", JSImport.Default)
object AppCSS extends js.Object

object App {
  private val css = AppCSS

  val App = FunctionalComponent[Unit] { props =>
    val (chatID, setChatID) = useState(0)
    div(className:="App",
      div(className:="center",
        ChatFind.ChatFind(ChatFindProps(setChatID)),
        MessageList.MessageList(MessageListProps(chatID))
      )
    )
  }
}