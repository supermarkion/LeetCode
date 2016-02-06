package ReusingClasses;

/*
it’s essential that the base-class subobject be initialized correctly, and there’s only
one way to guarantee this: Perform the initialization in the constructor by calling the base-
class constructor, which has all the appropriate knowledge and privileges to perform the
base-class initialization. Java automatically inserts calls to the base-class constructor in the
derived-class constructor. The following example shows this working with three levels of
inheritance.

You can see that the construction happens from the base “outward,” so the base class is
initialized before the derived-class constructors can access it. Even if you don’t create a
constructor for Cartoon( ), the compiler will synthesize a default constructor for you that
calls the base class constructor.
*/

//: reusing/Cartoon.java
// Constructor calls during inheritance.

class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drwaing constructor");
    }
}

/**
 * Created by saima on 6/02/16.
 */
public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}/* Output:
Art constructor
Drawing constructor
Cartoon constructor
*///:~
