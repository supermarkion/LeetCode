package InitializationAndCleanup;

//: initialization/SimpleConstructor.java
// Demonstration of a simple constructor.

class Rock {
    Rock() { // This is the constructor
        System.out.println("Rock ");
    }
}

/**
 * Created by saima on 4/02/16.
 */
public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock(); // we initialize ten Rock instances
        }
    }
} /* Output:
Rock Rock Rock Rock Rock Rock Rock Rock Rock Rock
*///:~
