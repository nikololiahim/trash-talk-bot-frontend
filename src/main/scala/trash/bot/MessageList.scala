package trash.bot

import slinky.core.FunctionalComponent
import slinky.core.facade.Hooks.useEffect
import slinky.web.html.{div, key, li, ul}

object MessageList {
  case class MessageListProps(chatID: Int)

  val MessageList = FunctionalComponent[MessageListProps] { props =>
    val a = Seq("example1","example2","example3")
    useEffect(() => {
      //Load data from backend into "a"
    },
      Seq(props.chatID))
      div(
            ul(
              a.map { item =>
                li(key := item)(item)
              }
            )
    )
  }
}
