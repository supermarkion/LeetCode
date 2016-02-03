package Operators;

//: operators/HelloDate.java
import java.util.*;
import static net.mindview.util.Print.*;

/**
 * Created by saima on 3/02/16.
 *
 * So when should you use static import? Very sparingly! Only use it when you'd otherwise be
 * tempted to declare local copies of constants, or to abuse inheritance (the Constant Interface
 * Antipattern). In other words, use it when you require frequent access to static members from
 * one or two classes. If you overuse the static import feature, it can make your program unreadable
 * and unmaintainable, polluting its namespace with all the static members you import.
 */
public class HelloDate {

    public static void main(String[] args) {
        print("Hello, it's ");
        print(new Date());
    }
}/* Output: *(55% match)
Hello, it's:
Wed Oct 05 14:39:05 MDT 2005
*///~
