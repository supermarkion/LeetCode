package ControllingExecution;

/*
    Looping is controlled by while, do-while and for, which are sometimes classified as
    iteration statements. A statement repeats until the controlling Boolean-expression evaluates
    to false.
* */

//: control/WhileTest.java
// Demonstrates the while loop.

/**
 * Created by saima on 3/02/16.
 */
public class WhileTest {
    static boolean condition() {
        boolean result = Math.random() < 0.99;
        System.out.println(result + ", ");
        return result;
    }
    public static void main(String[] args) {
        while (condition()) {
            System.out.println("Inside 'while'");
        }
        System.out.println("Exited 'while'");
    }
}/* (Execute to see output) *///:~
