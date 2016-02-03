package Operators;

//: operators/PassObject.java
// Passing objects to methods may not be
// what you’re used to.

class Letter {
    char c;
}

/**
 * Created by saima on 3/02/16.
 */
public class PassObject {
    static void f(Letter y) {
        y.c = 'z';
    }
    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x);
        System.out.println("2: x.c: " + x.c);
    }
}/* Output:
1: x.c: a
2: x.c: z
*///:~
