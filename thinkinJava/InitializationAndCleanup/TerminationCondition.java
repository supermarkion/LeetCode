package InitializationAndCleanup;

//: initialization/TerminationCondition.java
// Using finalize() to detect an object that
// hasn’t been properly cleaned up.

/*
The termination condition is that all Book objects are supposed to be checked in before they
are garbage collected, but in main( ), a programmer error doesn’t check in one of the books.
Without finalize( ) to verify the termination condition, this can be a difficult bug to find.

Note that System.gc( ) is used to force finalization. But even if it isn’t, it’s highly probable
that the errant Book will eventually be discovered through repeated executions of the
program (assuming the program allocates enough storage to cause the garbage collector to
execute).

You should generally assume that the base-class version of finalize( ) will also be doing
something important, and call it using super, as you can see in Book.finalize( ). In this
case, it is commented out because it requires exception handling, which we haven’t covered
yet.
*/

class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    protected void finalize() {
        if (checkedOut) {
            System.out.println("Error: checked out");
            // Normally, you’ll also do this:
            // super.finalize(); // Call the base-class version
        }
    }
}


/**
 * Created by saima on 4/02/16.
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();
        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();
    }
} /* Output:
Error: checked out
*///:~

