package ReusingClasses;

/*
Any private methods in a class are implicitly final. Because you can’t access a private
method, you can’t override it. You can add the final specifier to a private method, but it
doesn’t give that method any extra meaning.

This issue can cause confusion, because if you try to override a private method (which is
implicitly final), it seems to work, and the compiler doesn’t give an error message

*/

//: reusing/FinalOverridingIllusion.java
// It only looks like you can override
// a private or private final method.

class WithFinals {
    // Identical to "private" alone:
    private final void f() {
        System.out.println("WithFinals.f()");
    }
    // Also automatically "final":
    private void g() {
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }
    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}
class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }
    public void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}

/**
 * Created by saima on 6/02/16.
 */
public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can’t call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
    }
} /* Output:
OverridingPrivate2.f()
OverridingPrivate2.g()
*///:~
