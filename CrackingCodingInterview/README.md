# Technical Prepartion

All java prorgam write to test whiteboard coding ability.

* Data structures:
	+ Linked Lists (solved)
	+ Binary Trees (solved)
	+ Tries (half-solved)
	+ Stacks (solved)
	+ Queues (solved)
	+ Vecotrs / ArrayLists (solved)
	+ Hash Tables (solved)

+ Algorithms:
	+ Breadth First Search (solved)
	+ Depth First Search (solved)
	+ BInary Search (solved)
	+ Merge Sort (solved)
	+ Quick Sort (solved)
	+ Tree Insert / Find /etc

+ Concepts:
	+ Bit Manipulation (half-solved)
	+ Singleton Design Pattern (half-solved)
	+ Factory Desgin Pattern (non-solved)
	+ Memory (Stack vs Heap) (non-solved)
	+ Recursion (solved)
	+ Big-O Time

* Code Test
	+ Extreme case: 0, negative, null, maximus, etc.
	+ User error: What happends if the user passes in null or a negative value?
	+ General cases: Test the normal case.

* Five Algorithm Approaches
	+ Examplify: Write out specific examples of the problem, and see if you can figure out a general rule.
	+ Pattern Matching: Consider what problems the algorithm is similar to, and figure out if you can modify the solution to develop an algorithm for this problem.
	+ Simplify & Generalize: Change a constraint (data type, size, etc) to simplify the problem. Then try to solve it. Once you have an algorithm for the “simplified” problem, generalize the problem again.
	+ Base Cae and Build: Solve the algorithm first for a base case (e.g., just one element). Then, try to solve it for elements one and two, assuming that you have the answer for element one. Then, try to solve it for elements one, two and three, assuming that you have the answer to elements one and two.
	+ Data Structure Brainstrom: This is hacky, but it often works. Simply run through a list of data structures and try to apply each one.

# Object Oriented Design

* Real world objects are handled very similarly to software object oriented design. Suppose you are designing an object oriented design for a parking lot.
	+ What are your goals? For example: figure out if a parking spot is taken, figure out how many cars of each type are in the parking lot, look up handicapped spots, etc.
	+ Now, think about the core objects (Car, ParkingSpot, ParkingLot, ParkingMeter, etc. Car has different subclasses, and ParkingSpot is also subclassed for handicapped spot).
	+ Have we missed anything? How will we represent parking restrictions based on time or payment? Perhaps, we’ll add a class called Permission which handles different payment systems. Permission will be sub-classed into classes PaidPermission (fee to park) and FreeParking (open parking). ParkingLot will have a method called GetPermission which will return the current Permission object based on the time.
	+ How will we know whether or not a car is in a spot? Think about how to represent the data so that the methods are most efficient.