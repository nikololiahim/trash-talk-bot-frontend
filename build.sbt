import org.scalajs.jsenv.selenium.SeleniumJSEnv
import org.openqa.selenium.chrome.ChromeOptions

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.6"

val slinkyVersion = "0.7.2"


def seleniumConfig(
    port: Int,
    baseDir: File,
    testJsDir: File,
): SeleniumJSEnv.Config = {
  import _root_.io.github.bonigarcia.wdm.WebDriverManager
  WebDriverManager.chromedriver().setup()
  SeleniumJSEnv
    .Config()
    .withMaterializeInServer(
      testJsDir.getAbsolutePath,
      s"http://localhost:$port/${testJsDir.relativeTo(baseDir).get}/",
    )
}

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "trash-talk-bot-frontend",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withSourceMap(false)
    },
    Test / jsEnv := {
      new SeleniumJSEnv(
        new ChromeOptions().setHeadless(true),
        seleniumConfig(
          port = 3000,
          baseDir = baseDirectory.value,
          testJsDir = (Test / fastLinkJS / scalaJSLinkerOutputDirectory).value,
        ),
      )
    },
    licenses := Seq(License.MIT),
    libraryDependencies ++= Seq(
      "me.shadaj" %%% "slinky-core" % slinkyVersion,
      "me.shadaj" %%% "slinky-web" % slinkyVersion,
      "me.shadaj" %%% "slinky-hot" % slinkyVersion,
      "org.scalameta" %%% "munit" % "1.0.0-M2",
    ),
  )
