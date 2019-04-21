/**
* functiosn over Parallel collections using scala
*/

val v = (1 to 10).toArray

val pv = v.par 

v.map( _ * 2) // _ is alisa for each member.

pv.map(_ * 2) 

def square(x: Int): Int={
    return x**2
}

v.map(square(_)) 
pv.map(square(_))

