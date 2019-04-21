/**
* This file discusses fucntions.
*/

def myFunction(a:Int, b:int): Int = {
    val c = a* b
    return c
}

myFunction(3, 4)

// Proceduers are functions that doesnot return a vaule.

def myProcedure(inStr: String): Unit = {
    println(inStr)
}

myProcedure("This a log message!")

// unit is the void in java or None in python