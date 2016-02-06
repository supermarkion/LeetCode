package ReusingClasses;

/*
The protected keyword is a nod to pragmatism. It says “This is private as far as the class
user is concerned, but available to anyone who inherits from this class or anyone else in the
same package.” (In Java, protected also provides package access.)

Although it’s possible to create protected fields, the best approach is to leave the fields
private; you should always preserve your right to change the underlying implementation.
You can then allow controlled access to inheritors of your class through protected methods

*/

//: reusing/Orc.java
// The protected keyword.

class Villain {
    private String name;
    protected void set(String nm) { name = nm; }
    public Villain(String name) { this.name = name; }
    public String toString() {
        return "I’m a Villain and my name is " + name;
    }
}

/**
 * Created by saima on 6/02/16.
 */
public class Orc extends Villain {
    private int orcNumber;
    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }
    public void change(String name, int orcNumber) {
        set(name); // Available because it’s protected
        this.orcNumber = orcNumber;
    }
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }
    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        System.out.println(orc);
        orc.change("Bob", 19);
        System.out.println(orc);
    }
} /* Output:
Orc 12: I’m a Villain and my name is Limburger
Orc 19: I’m a Villain and my name is Bob
*///:~