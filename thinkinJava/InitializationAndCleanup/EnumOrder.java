package InitializationAndCleanup;

/*
The compiler automatically adds useful features when you create an enum. For example, it
creates a toString( ) so that you can easily display the name of an enum instance, which is
how the print statement above produced its output. The compiler also creates an ordinal( )
method to indicate the declaration order of a particular enum constant, and a static
values( ) method that produces an array of values of the enum constants in the order that
they were declared
*/

/**
 * Created by saima on 5/02/16.
 */
public class EnumOrder {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}/* Output:
NOT, ordinal 0
MILD, ordinal 1
MEDIUM, ordinal 2
HOT, ordinal 3
FLAMING, ordinal 4
*///:~
