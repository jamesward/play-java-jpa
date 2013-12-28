import play.Project._

name := """play-java-jpa"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
   javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
  "org.webjars" %% "webjars-play" % "2.2.1",
  "org.webjars" % "bootstrap" % "2.3.1")

playJavaSettings
