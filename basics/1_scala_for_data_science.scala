/**
* This file discusses Scalar data tyes and Array data types in Scala.
*/
// Scalar data types
var a_int : Int = 3
var a_char : Char = 'd'
var a_long : Long = 8345679
var b = 3
var b_char = 'b'
var b_long = 83456778  // gives error scala tries to push data to int.
var b_long = 83444545456L 
var b_float = 834.44545456f

// collections [Mutable or Immutable]
val temps=Array(50, 51, 40)
// 0 index Array
temps(0)
temps.length
temps(0) = 54
val temps2: Array[Int] = new Array[Int](10)

val temp3 = Array.ofDim[Int](10, 10)

import Array._

concat(temps, temps2)

temps. // press tab. to find all the methods that can be run on a variable.

val vec1: Vector[Int] = Vector(1,2,3,4,5,6,7,8,9,0)
vec1(2)

val myRange = 1 t0 10
val MyRange2: Range = new Range(1, 10, 2)

