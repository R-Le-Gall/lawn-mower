name := "lawn-mower"

version := "0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq("org.specs2" %% "specs2" % "2.3.10" % "test", "junit" % "junit" % "4.8.1" % "test")

scalacOptions in Test ++=Seq("-Yrangepos")

resolvers ++= Seq("snapshots","releases").map(Resolver.sonatypeRepo)

mainClass := Some("InstructionExecutor")
