/**
* points to note about scala parallel collections.
*/

// Collectiosn with at least thoussands of elements are good candidates.
// For some types of collectiosn, converting between sequential and parallel collectiosn requires copying the content of a collection.


// Avoid side effects
// Best to avoid applying procedures with side effects when using parallel collections.
// Side effects can lead to nondeterminism
// Side effects could take affect in a different order each time an operation is executed.

// Avoid Nonassociative Operations
// In associative opeations, the order of operations does not matter. Parallel operations can be used in assocative problems.
// If compuatations are state dependent then do not use parallel collections.
