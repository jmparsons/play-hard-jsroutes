import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "play-hard-jsroutes"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq()

  val main = play.Project(appName, appVersion, appDependencies).settings(
    requireJs += "main.js",
    playOnStarted <+= baseDirectory {
      root => {
        _: java.net.InetSocketAddress => {
          if (System.getProperty("jsr") == "build") {
            <x>{root}/buildroutes.sh</x> !;
          }
          ()
        }
      }
    }
  )

}
