ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.1.0"

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "trash-talk-bot-frontend",
    scalaJSUseMainModuleInitializer := true,
    licenses := Seq(License.MIT)
  )
