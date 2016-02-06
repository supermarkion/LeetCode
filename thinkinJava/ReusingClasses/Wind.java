package ReusingClasses;

/*
This description is not just a fanciful way of explaining inheritance—it’s supported directly by
the language. As an example, consider a base class called Instrument that represents
musical instruments, and a derived class called Wind. Because inheritance means that all of
the methods in the base class are also available in the derived class, any message you can
send to the base class can also be sent to the derived class. If the Instrument class has a
play( ) method, so will Wind instruments. This means we can accurately say that a Wind
object is also a type of Instrument. The following example shows how the compiler
supports this notion

*/

//: reusing/Wind.java
// Inheritance & upcasting.

class Instrument {
    public void play() {}
    static void tune(Instrument i) {
    // ...
        i.play();
    }
}

// Wind objects are instruments
// because they have the same interface:

/**
 * Created by saima on 6/02/16.
 */
public class Wind extends Instrument {
    public static void main(String[] agrs) {
        Wind flute = new Wind();
        Instrument.tune(flute);     // upcasting, directly call
    }
}
