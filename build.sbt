ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.1.1"

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    Compile / npmDependencies ++= Seq(
      "react" -> "17.0.2",
      "react-dom" -> "17.0.2",
    ),
    name := "trash-talk-bot-frontend",
    scalaJSUseMainModuleInitializer := true,
    licenses := Seq(License.MIT),
    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % "2.0.1",
      "org.scala-js" %%% "scalajs-dom" % "2.1.0",
    ),
  )
