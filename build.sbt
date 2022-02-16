ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.6"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "trash-talk-bot-frontend",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) },
    licenses := Seq(License.MIT),
    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % "2.0.1",
      "org.scala-js" %%% "scalajs-dom" % "2.1.0",
    ),
  )
