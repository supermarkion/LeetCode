package Interfaces;

/*
It’s possible to make a class abstract without including any abstract methods. This is
useful when you’ve got a class in which it doesn’t make sense to have any abstract methods,
and yet you want to prevent any instances of that class.
The Instrument class from the previous chapter can easily be turned into an abstract
class. Only some of the methods will be abstract, since making a class abstract doesn’t force
you to make all the methods abstract.

*/

//: interfaces/music4/Music4.java
// Abstract classes and methods.

enum Note {
    MIDDLE_C, C_SHARP, B_FLAT; // Etc.
}

abstract class Instrument {
    private int i; // Storage allocated for each
    public abstract void play(Note n);
    public String what() { return "Instrument"; }
    public abstract void adjust();
}

class Wind extends Instrument {
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
    public String what() { return "Wind"; }
    public void adjust() {}
}

class Percussion extends Instrument {
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }
    public String what() { return "Percussion"; }
    public void adjust() {}
}
class Stringed extends Instrument {
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }
    public String what() { return "Stringed"; }
    public void adjust() {}
}
class Brass extends Wind {
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }
    public void adjust() { System.out.println("Brass.adjust()"); }
}
class Woodwind extends Wind {
    public void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }
    public String what() { return "Woodwind"; }
}

/**
 * Created by saima on 7/02/16.
 */
public class Music4 {
    // Doesn’t care about type, so new types
// added to the system still work right:
    static void tune(Instrument i) {
// ...
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
// Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~
