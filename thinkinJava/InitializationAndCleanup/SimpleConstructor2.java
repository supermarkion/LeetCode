package InitializationAndCleanup;

//: initialization/SimpleConstructor2.java
// Constructors can have arguments.

class Rock2 {
    Rock2(int i) {
        System.out.println("Rock " + i + " ");
    }
}

/**
 * Created by saima on 4/02/16.
 */
public class SimpleConstructor2 {
    public static void main() {
        for (int i = 0; i < 8; i++) {
            new Rock2(i);
        }
    }
}/* Output:
Rock 0 Rock 1 Rock 2 Rock 3 Rock 4 Rock 5 Rock 6 Rock 7
*///:~
