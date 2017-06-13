Running on Spark
----------------

First compile:

```
sbt
compile
run
```

Download Spark (1.6.1) and put it in your Path from here: http://spark.apache.org/downloads.html

Run the project locally. From project root:

```
spark-submit --class "MainRun" --master local[8] target/scala-2.10/anomaly-detection_2.10-1.0.jar
```

