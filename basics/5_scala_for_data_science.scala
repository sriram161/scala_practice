/**
* This file discusses class and objects.
*/

val y = Array("England", "Liberia", "India")
y.sorted

class location(var latitude:Int, var lat_direction:Int, var long_direction:Char,var Altitude:Int)

val loc1=location(24, 'N', 120, 'w', 2=300)
loc1.lat_direction

loc1. //Press tab to see the members 

// careting a private members

class myPublicPrivate(val x:Int=0, val y:Int=0, private val z:Int=0)

val myPP = new myPublicPrivate

myPP. //press tab will print public methods


// define an opetration in the class

class Point2D(coord1:Int, coord2:Int){
    var a: Int = coord1
    var b: Int = coord2

    def move(delta_a: Int, dalta_b: Int) {   // where is unit??
        a = a+delta_a
        b = b+delta_b
    }
}

val point1 = new Point2D(10, 20)

point1.a 
point1.b 
point1.move(5, 15)
point1.a 
point1.b