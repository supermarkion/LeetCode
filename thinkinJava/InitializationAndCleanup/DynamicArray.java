package InitializationAndCleanup;

//: initialization/DynamicArray.java
// Array initialization.

/**
 * Created by saima on 5/02/16.
 */
public class DynamicArray {
    public static void main(String[] args) {
        Other.main(new String[]{ "fiddle", "de", "dum" });
    }
}

class Other {
    public static void main(String[] args) {
        for(String s : args)
            System.out.print(s + " ");
    }
} /* Output:
fiddle de dum
*///:~