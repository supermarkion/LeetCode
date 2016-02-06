package ReusingClasses;

/*
When you say that an entire class is final (by preceding its definition with the final
keyword), you state that you don’t want to inherit from this class or allow anyone else to do
so. In other words, for some reason the design of your class is such that there is never a need
to make any changes, or for safety or security reasons you don’t want subclassing.

Note that the fields of a final class can be final or not, as you choose. The same rules apply
to final for fields regardless of whether the class is defined as final. However, because it
prevents inheritance, all methods in a final class are implicitly final, since there’s no way to
override them. You can add the final specifier to a method in a final class, but it doesn’t add
any meaning.
*/

//: reusing/Jurassic.java
// Making an entire class final.

class SmallBrain {}
final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();
    void f() {}
}
//! class Further extends Dinosaur {}
// error: Cannot extend final class ‘Dinosaur’

/**
 * Created by saima on 6/02/16.
 */
public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
} ///:~
