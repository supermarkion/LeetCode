package Holding;

/*
In any container, you must have a way to insert elements and fetch them out again. After all,
that’s the primary job of a container—to hold things. In a List, add( ) is one way to insert
elements, and get( ) is one way to fetch elements.

If you want to start thinking at a higher level, there’s a drawback: You need to program to the
exact type of the container in order to use it. This might not seem bad at first, but what if you
write code for a List, and later on you discover that it would be convenient to apply that
same code to a Set? Or suppose you’d like to write, from the beginning, a piece of general-
purpose code that doesn’t know or care what type of container it’s working with, so that it can
be used on different types of containers without rewriting that code?

The concept of an Iterator (another design pattern) can be used to achieve this abstraction.
An iterator is an object whose job is to move through a sequence and select each object in
that sequence without the client programmer knowing or caring about the underlying
structure of that sequence. In addition, an iterator is usually what’s called a lightweight
object: one that’s cheap to create. For that reason, you’ll often find seemingly strange
constraints for iterators; for example, the Java Iterator can move in only one direction.
There’s not much you can do with an Iterator except:
1. Ask a Collection to hand you an Iterator using a method called iterator( ). That
Iterator will be ready to return the first element in the sequence.
2. Get the next object in the sequence with next( ).
3. See if there are any more objects in the sequence with hasNext( ).
4. Remove the last element returned by the iterator with remove( ).

*/

import typeinfo.pets.*;
import java.util.*;

public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while(it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
// A simpler approach, when possible:
        for(Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();
// An Iterator can also remove elements:
        it = pets.iterator();
        for(int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
} /* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric 9:Rat
10:EgyptianMau 11:Hamster
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric 9:Rat
10:EgyptianMau 11:Hamster
[Pug, Manx, Cymric, Rat, EgyptianMau, Hamster]
*///:~
