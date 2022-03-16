libraryDependencies += "io.github.bonigarcia" % "webdrivermanager"     % "5.0.3"
libraryDependencies += "org.scala-js"        %% "scalajs-env-selenium" % "1.1.1"
// note, 'sbt-scalajs' must come after 'scalajs-env-selenium'
// reference: https://github.com/scala-js/scala-js-env-selenium#usage
addSbtPlugin("org.scala-js"                   % "sbt-scalajs"          % "1.9.0")
