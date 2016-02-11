package Exceptions;

//: exceptions/Switch.java

/**
 * Created by saima on 11/02/16.
 */
public class Switch {
    private boolean state = false;
    public boolean read() {
        return state;
    }
    public void on() {
        state = true;
        System.out.println(this);
    }
    public void off() {
        state = false;
        System.out.println(this);
    }
    public String toString() {
        return state ? "on" : "off";
    }
}
