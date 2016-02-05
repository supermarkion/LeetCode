package AccessControl;

//: access/IceCream.java
// Demonstrates "private" keyword.

class Sundae {
    private Sundae() {

    }
    static Sundae makeASundae() {
        return new Sundae();
    }
}

/**
 * Created by saima on 5/02/16.
 */
public class IceCream {
    public static void main(String[] args) {
        Sundae x = Sundae.makeASundae();
    }
} ///:~
