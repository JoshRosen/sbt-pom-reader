import sbtrelease.ReleasePlugin.autoImport._
import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

name := "sbt-pom-reader"

organization := "org.spark-project"

sbtPlugin := true

publishMavenStyle := true

libraryDependencies ++= Dependencies.pluginDependencies

scalacOptions ++= Seq("-target:jvm-1.6")

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scriptedLaunchOpts <+= version apply { v => "-Dproject.version="+v }

initialCommands :=
  """| import com.typesafe.sbt.pom._
     | import sbt._
     | val localRepo = file(sys.props("user.home")) / ".m2" / "repository"
     | val pom = loadEffectivePom(localRepo, file("src/sbt-test/simple-pom/can-extract-basics/pom.xml"))
     |""".stripMargin


scriptedSettings

scriptedLaunchOpts <+= version apply { v => "-Dproject.version="+v }

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

releasePublishArtifactsAction := PgpKeys.publishSigned.value

useGpg := true

pomExtra := (
  <url>https://github.com/joshrosen/sbt-pom-reader</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:JoshRosen/sbt-pom-reader.git</url>
    <connection>scm:git:git@github.com:JoshRosen/sbt-pom-reader.git</connection>
  </scm>
  <developers>
    <developer>
      <id>JoshRosen</id>
      <name>Josh Rosen</name>
      <url>https://github.com/JoshRosen</url>
    </developer>
    <developer>
      <id>ScrapCodes</id>
      <name>Prashant Sharma</name>
      <url>https://github.com/ScrapCodes</url>
    </developer>
  </developers>)
