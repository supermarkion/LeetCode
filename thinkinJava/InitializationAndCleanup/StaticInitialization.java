package InitializationAndCleanup;

/*
There’s only a single piece of storage for a static, regardless of how many objects are created.
You can’t apply the static keyword to local variables, so it only applies to fields. If a field is a
static primitive and you don’t initialize it, it gets the standard initial value for its type. If it’s
a reference to an object, the default initialization value is null.
If you want to place initialization at the point of definition, it looks the same as for non-
statics.

The order of initialization is statics first, if they haven’t already been initialized by a previous
object creation, and then the non-static objects. You can see the evidence of this in the
output. To execute main( ) (a static method), the StaticInitialization class must be
loaded, and its static fields table and cupboard are then initialized, which causes those
classes to be loaded, and since they both contain static Bowl objects, Bowl is then loaded.
Thus, all the classes in this particular program get loaded before main( ) starts. This is
usually not the case, because in typical programs you won’t have everything linked together
by statics as you do in this example.
*/

//: initialization/StaticInitialization.java
// Specifying initial values in a class definition.

class Bowl {
    Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }
    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);
    Table() {
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }
    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}

/**
 * Created by saima on 4/02/16.
 */
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
} /* Output:
Bowl(1)
Bowl(2)
Table()
f1(1)
Bowl(4)
Bowl(5)
Bowl(3)
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
f2(1)
f3(1)
*///:~