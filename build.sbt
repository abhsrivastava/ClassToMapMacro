name := "Class2MapMacro"

organization := "com.abhi"

version := "1.0"

scalaVersion := "2.12.2"

scalacOptions ++= Seq("-unchecked", "-feature", "-deprecation")

libraryDependencies ++= Seq(
   "org.scalameta" %% "scalameta" % "1.8.0",
   "org.scalatest" %% "scalatest" % "3.0.1"
)

addCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M9" cross CrossVersion.full)
