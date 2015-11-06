import sbt._

object Dependencies {

  val mvnVersion = "3.3.3"
  val mvnWagonVersion = "2.9"

  //val aether         = "org.sonatype.aether" % "aether" % "1.13.1"
  val mvnAether           = "org.apache.maven" % "maven-aether-provider" % mvnVersion
  val aetherWagon         = "org.sonatype.aether" % "aether-connector-wagon" % "1.13.1"
  val mvnEmbedder         = "org.apache.maven" % "maven-embedder" % mvnVersion
  val mvnWagon            = "org.apache.maven.wagon" % "wagon-http" % mvnWagonVersion
  val mvnWagonProviderApi = "org.apache.maven.wagon" % "wagon-provider-api" % mvnWagonVersion

  val mvnWagonLwHttp      = "org.apache.maven.wagon" % "wagon-http-lightweight" % mvnWagonVersion
  val mvnWagonFile        = "org.apache.maven.wagon" % "wagon-file" % mvnWagonVersion


  def pluginDependencies =
     Seq(mvnAether, aetherWagon, mvnWagon, mvnWagonProviderApi, mvnEmbedder, mvnWagonLwHttp, mvnWagonFile)
}
