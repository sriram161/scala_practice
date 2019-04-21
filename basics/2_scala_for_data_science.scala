/**
* This file discusses maps.
*/

val capitals = Maps("Argentian" <- "Buenos Aires",
"Canada" -> "Ottowa",
"United States" -> "Washington.D.C")

capitals. // Press tab

capitals.keys

capitals.values

capitals get 'Canada'

capitals get 'India'

capitals('Canada')

capitals contains "Egypt"

capitals getOrElse("China", "No Capitals found")

capitals + ("Ireland"-> "Dublin")

capitals - "Canada"

