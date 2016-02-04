package InitializationAndCleanup;

//: initialization/BananaPeel.java

class Banana {
    void peel(int i) {

    }
}

/**
 * Created by saima on 4/02/16.
 */
public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(), b = new Banana();
        a.peel(1);
        b.peel(2);
    }
} ///:~
