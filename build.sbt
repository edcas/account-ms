name := "account-ms"
organization := "com.mybank"

version := "1.0-SNAPSHOT"
scalaVersion := "2.12.8"

lazy val root = ( project in file(".") )
  .enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  guice, 
  "org.scalatestplus.play" %% "scalatestplus-play"% "4.0.2" % Test,
  "com.typesafe.play"       %% "play-slick"                 % "3.0.1",
  "com.typesafe.play"       %% "play-slick-evolutions"      % "3.0.1",
  "com.typesafe.play"       %% "play-json"                  % "2.6.0",
  "com.h2database"          %  "h2"                         % "1.4.189",
  "org.typelevel"           %% "cats-core"                  % "1.0.1"
  
)

// assembly
test in assembly := {}
target in assembly := file( "target" )
assemblyJarName in assembly := "account-ms.jar"
assemblyMergeStrategy in assembly := {
  case PathList( "META-INF", xs @ _* ) => MergeStrategy.discard
  case x => MergeStrategy.first
}


// coverage
coverageExcludedPackages := ".*Filters.*;.*Routes.*;"
coverageMinimum := 90


// test
fork in test := true
baseDirectory in test := file( "/test/resources/" )