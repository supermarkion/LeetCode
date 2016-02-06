package ReusingClasses;

/*
The preceding example has default constructors; that is, they don’t have any arguments. It’s
easy for the compiler to call these because there’s no question about what arguments to pass.
If your class doesn’t have default arguments, or if you want to call a base-class constructor
that has an argument, you must explicitly write the calls to the base-class constructor using
the super keyword and the appropriate argument list

If you don’t call the base-class constructor in BoardGame( ), the compiler will complain
that it can’t find a constructor of the form Game( ). In addition, the call to the base-class
constructor must be the first thing you do in the derived-class constructor. (The compiler will
remind you if you get it wrong.)

*/

//: reusing/Chess.java
// Inheritance, constructors and arguments.

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

/**
 * Created by saima on 6/02/16.
 */
public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
    public static void main(String[] args) {
        Chess x = new Chess();
    }
}  /* Output:
Game constructor
BoardGame constructor
Chess constructor
*///:~
