package generics;

class Automobile {}

/**
 * Created by saima on 16/02/16.
 */
public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) {
        this.a = a;
    }
    Automobile get() {
        return a;
    }
}
