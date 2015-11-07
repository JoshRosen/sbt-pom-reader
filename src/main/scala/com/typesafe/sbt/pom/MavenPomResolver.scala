package com.typesafe.sbt.pom

import java.io.File

import org.jboss.shrinkwrap.resolver.impl.maven.MavenWorkingSessionImpl

import org.apache.maven.model.Model

class MavenPomResolver(localRepo: File) {

  def loadEffectivePom(
      pomFile: File,
      activeProfiles: Seq[String],
      userPropsMap: Map[String, String]): Model = {

    val session = new MavenWorkingSessionImpl().loadPomFromFile(pomFile, activeProfiles: _*)
    val field = classOf[MavenWorkingSessionImpl].getField("model")
    field.setAccessible(true)
    val model = field.get(session).asInstanceOf[Model]
    model
  }
}
