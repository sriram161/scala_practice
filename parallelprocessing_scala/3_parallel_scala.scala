/**
* filter collections 
*/

val v = (1 to 10000).toArray

val pv = v.par 

v.length
pv.length

pvf = pv.filter(_ > 5000)

pvf2 = pv.filterNot(_ > 5000)

def div3(x: Int): Boolean = {
    val y: Int = (x % 3)
    return (y == 0)
}

div3(9)
div3(100)

pv.filter(div3(_))
