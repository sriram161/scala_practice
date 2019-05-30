def bbsort2(a:Array[Int]){
  var l:Int = a.length
  var j:Int = 0
  while ( l-j > 0){
        for (i <-  0 to (l-j-2))
    {
            if (a(i) > a(i+1)) {
              val temp = a(i)
              a(i) = a(i+1)
              a(i+1) = temp
        }
        j += 1
  }}}
    
var a = Array(5, 4, 1, 2, 3)
bbsort2(a)
println(a)