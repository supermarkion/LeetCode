package generics;

/**
 * Created by saima on 16/02/16.
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
