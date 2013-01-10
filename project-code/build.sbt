import sbt._
import sbt.Keys._
import scala.Some

javacOptions ++= Seq("-source", "1.7", "-target", "1.7", "-encoding", "utf8")

publishTo <<= version {
  v: String =>
    val nexus = "http://sfxcode01.corp.ezrez:8081/nexus"
    if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "/content/repositories/snapshots/")
    else Some("releases" at nexus + "/nexus/content/repositories/releases/")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := {
  _ => false
}

pomExtra := (
  <url>https://github.com/switchfly/play2-guice-module</url>
    <licenses>
      <license>
        <name>Apache</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:switchfly/play2-guice-module.git</url>
      <connection>scm:git:git@github.com:switchfly/play2-guice-module.git</connection>
    </scm>
  )
