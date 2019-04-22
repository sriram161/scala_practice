/**
* Spark statistics
*/

import org.apache.spark.mllib.stat.Statistics

val bigRng = scala.util.Random.shuffle(1 to 100000)

val bigPRng = sc.parallelize(bigRng)
val bigPRng1 = bigPRng.map(_ * 2)
val x = bigPRng2.takeSample(true, 1000) // Sample with replacement. (Random sample)
val x = bigPRng2.takeSample(true, 1000, 1234) // Sample with replacement. (Random sample) seed is 1234.

bigPRng2.mean
bigPRng2.min
bigPRng2.max
bigPRng.stats

// correlations
val series1 = Array.fill(10000)(Random.nextDouble)
val series2 = Array.fill(10000)(Random.nextDouble)
val pseries1 = sc.parallelize(series1)
val pseries2 = sc.parallelize(series2)
val myCorrelation:Double = Statistics.corr(pseries1, pseries2, "pearson")

// Kolmogorov Smirnov Test
/**
* Some times we want to see how normal the data is distributed?
* does it follow bell curve shape?
* then we apply this test.
*/

val distTest = Statistics.kolmogorovSmirnovTest(pseries1, "norm", 0 , 1)
