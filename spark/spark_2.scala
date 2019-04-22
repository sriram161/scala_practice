/**
* Spark features
* Fast processing of librarires for analytics
* Stream processing
* Fault tolerant
* Scalable  
*/

// $spark-shell starts spark using scala input.

/** RDD features
* Immutable distributed collection
* Organized into logical partitions
* Fault-tolerant collection
* May keep data in memory or persisted
*/

/** RDD like parallel Collections
* Groups of daa of the same type or structure.
* Data processed in parallel
* RDDs are partitioned by a hash functions
* RDD are distributed across multiple server
* Parallel collections are broken into subsets and distributed across cores or threads within a single server at run time.
*/

import scala.util.Random
val bigRng = scala.util.Random.shuffle(1 to 10000)
val bigPRng = sc.parallelize(bigRng)
bigPRng.mean
bigPRng.min
bigPRng.max
bigPRng.popStdev

// Mapping functions
bigPRng.take(25)
val bigPRng2 = bigPRng.map(_ * 2)
bigPRng2.take(23)
bigPRng2.mean

def div(x:Int): Boolean = {val y:Int = (x%3); return (y==0)}

val bigBool = bigPRng2.map(div(_))
bigBool.take(25)

val republic = sc.textFile("/User/path/sampl.txt")
republic.take(25).foreach(println)

val linesWithSocrates = republic.filter(line => line.contains("Socrates")) // annonimus fuction is created line
linesWithSocrates.take(10).foreach(println)






