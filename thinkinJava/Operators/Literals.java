package Operators;

//: operators/Literals.java

/**
 * Created by saima on 3/02/16.
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f; // Hexadecimal (lowercase)
        System.out.println("i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2F; // Hexadecimal (uppercase)
        System.out.println("i2: " + Integer.toBinaryString(i2));
        int i3 = 0177; // Octal (leading zero)
        System.out.println("i3: " + Integer.toBinaryString(i3));
        char c = 0xffff; // max char hex value
        System.out.println("c: " + Integer.toBinaryString(c));
        byte b = 0x7f; // max byte hex value
        System.out.println("b: " + Integer.toBinaryString(b));
        short s = 0x7fff; // max short hex value
        System.out.println("s: " + Integer.toBinaryString(s));
        long n1 = 200L; // long suffix
        long n2 = 200l; // long suffix (but can be confusing)
        long n3 = 200;
        float f1 = 1;
        float f2 = 1F; // float suffix
        float f3 = 1f; // float suffix
        double d1 = 1d; // double suffix
        double d2 = 1D; // double suffix
        // (Hex and Octal also work with long)
    }
}/* Output:
i1: 101111
i2: 101111
i3: 1111111
c: 1111111111111111
b: 1111111
s: 111111111111111
*///:~

/*
* A trailing character after a literal value establishes its type. Uppercase or lowercase L means
* long (however, using a lowercase l is confusing because it can look like the number one).
* Uppercase or lowercase F means float. Uppercase or lowercase D means double.
* Hexadecimal (base 16), which works with all the integral data types, is denoted by a leading
* 0x or 0X followed by 0-9 or a-f either in uppercase or lowercase. If you try to initialize a
* variable with a value bigger than it can hold (regardless of the numerical form of the value),
* he compiler will give you an error message. Notice in the preceding code the maximum
* possible hexadecimal values for char, byte, and short. If you exceed these, the compiler will
* automatically make the value an int and tell you that you need a narrowing cast for the
* assignment (casts are defined later in this chapter). You’ll know you’ve stepped over the line.
* */
