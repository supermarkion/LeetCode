package ReusingClasses;

/*
Many programming languages have a way to tell the compiler that a piece of data is
“constant.” A constant is useful for two reasons:
1. It can be a compile-time constant that won’t ever change.
2. It can be a value initialized at run time that you don’t want changed.

In the case of a compile-time constant, the compiler is allowed to “fold” the constant value
into any calculations in which it’s used; that is, the calculation can be performed at compile
time, eliminating some run-time overhead. In Java, these sorts of constants must be
primitives and are expressed with the final keyword. A value must be given at the time of
definition of such a constant.

A field that is both static and final has only one piece of storage that cannot be changed.

When final is used with object references rather than primitives, the meaning can be
confusing. With a primitive, final makes the value a constant, but with an object reference,
final makes the reference a constant. Once the reference is initialized to an object, it can
never be changed to point to another object. However, the object itself can be modified; Java
does not provide a way to make any arbitrary object a constant. (You can, however, write
your class so that objects have the effect of being constant.) This restriction includes arrays,
which are also objects.

*/

//: reusing/FinalData.java
// The effect of final on fields.
import java.util.*;

class Value {
    int i; // Package access
    public Value(int i) { this.i = i; }
}

/**
 * Created by saima on 6/02/16.
 */
public class FinalData {
    private static Random rand = new Random(47);
    private String id;
    public FinalData(String id) { this.id = id; }
    // Can be compile-time constants:
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    // Typical public constant:
    public static final int VALUE_THREE = 39;
    // Cannot be compile-time constants:
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);

    // Arrays:
    private final int[] a = { 1, 2, 3, 4, 5, 6 };

    public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        //! fd1.valueOne++;             // Error: can’t change value
        fd1.v2.i++;                     // Object isn’t constant!
        fd1.v1 = new Value(9);          // OK -- not final
        for(int i = 0; i < fd1.a.length; i++)
            fd1.a[i]++;                 // Object isn’t constant!
        //! fd1.v2 = new Value(0);      // Error: Can’t
        //! fd1.VAL_3 = new Value(1);   // change reference
        //! fd1.a = new int[3];
        System.out.println(fd1);
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd1);
        System.out.println(fd2);
    }
}  /* Output:
fd1: i4 = 15, INT_5 = 18
Creating new FinalData
fd1: i4 = 15, INT_5 = 18
fd2: i4 = 13, INT_5 = 18
*///:~
