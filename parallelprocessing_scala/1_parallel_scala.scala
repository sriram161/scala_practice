/**
* Parallel collections using scala
*/

import scala.collection.parallel.immutable._
// Convert a sequential collections
val rng100 = 1 t0 100
val prng100 = rng100.par 

// Create a parallel collections
val prng100 = ParVector.range(0, 200)
