package InitializationAndCleanup;
//: initialization/PassingThis.java

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        System.out.println("Yummy");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        return apple; // Peeled
    }
}

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}

/**
 * Created by saima on 4/02/16.
 */
public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
} /* Output:
Yummy
*///:~

/*
Apple needs to call Peeler.peel( ), which is a foreign utility method that performs an
operation that, for some reason, needs to be external to Apple (perhaps the external method
can be applied across many different classes, and you don’t want to repeat the code). To pass
itself to the foreign method, it must use this.
 */
