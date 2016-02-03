package EverythingIsAnObject;

//: HelloDate.java, with Documentation example

import java.util.*;

/**
 * Created by saima on 3/02/16.
 */

/**
 * The first Thinking in Java example program.
 * Displays a string and tody's date.
 * @author saima
 * @version 1.0
 */
public class HelloDate {
    /**
     * Entry point to class & application.
     * @param args array of string arguments
     * @throws exceptions No exceptions thrown
     */

    public static void main(String[] args) {
        System.out.print("Hello, it's: ");
        System.out.println(new Date());
    }  /* Output: (55% match)
     Hello. it's: Wed Feb 03 14:54:10 AEDT 2016
    *///:~
}
