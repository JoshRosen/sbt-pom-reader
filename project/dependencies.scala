import sbt._

object Dependencies {

  def pluginDependencies = Seq(
    "org.apache.maven" % "maven-core" % "3.3.3",
    "org.jboss.shrinkwrap.resolver" % "shrinkwrap-resolver-depchain" % "2.2.0"
  )
}
