package InitializationAndCleanup;

//: initialization/Leaf.java
// Simple use of the "this" keyword.

/**
 * Created by saima on 4/02/16.
 */
public class Leaf {
    int i = 0;
    Leaf increment() {
        i++;
        return this; // return a reference to current object
    }
    void print() {
        System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
} /* Output:
i = 3
*///:~
