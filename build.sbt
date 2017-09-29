name := "anomaly-detection"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies += "org.elasticsearch" % "elasticsearch-spark-13_2.10" % "5.3.2"
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.2"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "1.6.2"
libraryDependencies += "com.holdenkarau" % "spark-testing-base_2.10" % "1.6.2_0.7.4" % "test" // includes scalatest 2.2.1
libraryDependencies += "org.scalactic" % "scalactic_2.10" % "2.2.1"


javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
parallelExecution in Test := false