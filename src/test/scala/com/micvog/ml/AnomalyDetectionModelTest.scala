package com.evrenio.ml

import com.holdenkarau.spark.testing.{RDDComparisons, SharedSparkContext}
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.rdd.RDD
import org.scalatest.{FlatSpec, Matchers}

class AnomalyDetectionModelTest extends FlatSpec with Matchers with SharedSparkContext {

  val means = Vectors.dense(Array(14.1122257839456, 14.9977105081362))
  val variances = Vectors.dense(Array(1.83263141349452, 1.70974533082878))

  "predict" should "return correct results given appropriate RDD points as input" in {

    val arr1 = Array(14.8593411857427, 14.9006647394062)
    val arr2 = Array(12.14234, 20.432)
    val rdd: RDD[Vector] = sc.makeRDD(Seq(arr1, arr2))
      .map(rdd => Vectors.dense(rdd))

    val rddResults = new AnomalyDetectionModel(means, variances, 0.05).predict(rdd)
    RDDComparisons.assertRDDEqualsWithOrder(sc.makeRDD(List((Vectors.dense(arr1), false), (Vectors.dense(arr2), true))), rddResults)
  }

}
