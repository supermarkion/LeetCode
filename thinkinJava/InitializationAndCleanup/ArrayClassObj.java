package InitializationAndCleanup;

//: initialization/ArrayClassObj.java
// Creating an array of nonprimitive objects.

import java.util.*;

/**
 * Created by saima on 5/02/16.
 */
public class ArrayClassObj {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] a = new Integer[rand.nextInt(20)];
        System.out.println("length of a = " + a.length);
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(500);   // autoboxing
        }
        System.out.println(Arrays.toString(a));
    }
}  /* Output: (Sample)
length of a = 18
[55, 193, 361, 461, 429, 368, 200, 22, 207, 288, 128, 51, 89, 309, 278,
498, 361, 20]
*///:~
