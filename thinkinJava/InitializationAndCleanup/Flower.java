package InitializationAndCleanup;

//: initialization/Flower.java
// Calling constructors with "this"

/*
The constructor Flower(String s, int petals) shows that, while you can call one
constructor using this, you cannot call two. In addition, the constructor call must be the first
thing you do, or you’ll get a compiler error message.

This example also shows another way you’ll see this used. Since the name of the argument s
and the name of the member data s are the same, there’s an ambiguity. You can resolve it
using this.s, to say that you’re referring to the member data. You’ll often see this form used
in Java code, and it’s used in numerous places in this book.

In printPetalCount( ) you can see that the compiler won’t let you call a constructor from
inside any method other than a constructor.
*/

/**
 * Created by saima on 4/02/16.
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";
    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor /w int arg only, petalCount= "
                + petalCount);
    }
    Flower(String ss) {
        System.out.println("Constructor /w String arg only, s = " + ss);
        s = ss;
    }
    Flower(String s, int petals) {
        this(petals);
        //!
        // this(s); // Can’t call two!
        this.s = s; // Another use of "this"
        System.out.println("String & int args");
    }
    Flower() {
        this("hi", 47); // use this to represent to Flower class
        System.out.println("default constructor (no args)");
    }
    void printPetalCount() {
        //! this(11); // Not inside non-constructor!
        System.out.println("petalCount = " + petalCount + " s = "+ s);
    }
    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
} /* Output:
Constructor w/ int arg only, petalCount= 47
String & int args
default constructor (no args)
petalCount = 47 s = hi
*///:~

