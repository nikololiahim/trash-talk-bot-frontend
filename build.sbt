ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.6"

val slinkyVersion = "0.7.2"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "trash-talk-bot-frontend",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= { conf =>
      conf
        .withModuleKind(ModuleKind.ESModule)
    },

    Test / scalaJSLinkerConfig ~= {
        conf => conf.withModuleKind(ModuleKind.CommonJSModule)
    },
    Test / jsE
    licenses := Seq(License.MIT),
    libraryDependencies ++= Seq(
      "me.shadaj" %%% "slinky-core" % slinkyVersion,
      "me.shadaj" %%% "slinky-web" % slinkyVersion,
      "me.shadaj" %%% "slinky-hot" % slinkyVersion,
      "org.scalameta" %%% "munit" % "1.0.0-M2",
    ),
  )
