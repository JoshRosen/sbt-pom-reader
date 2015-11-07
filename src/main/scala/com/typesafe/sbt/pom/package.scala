package com.typesafe.sbt

import java.io.File

/** Helper methods for dealing with starting up Aether. */
package object pom {

  def defaultLocalRepo: java.io.File = {
    import sbt._
    (file(sys.props("user.home")) / ".m2" / "repository")
  }
  
  def loadEffectivePom(pom: File, localRepo: File = defaultLocalRepo, profiles: Seq[String], userProps: Map[String, String]) =
    new MavenPomResolver(localRepo).loadEffectivePom(pom, profiles, userProps)
}
