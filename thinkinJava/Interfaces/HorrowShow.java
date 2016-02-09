package Interfaces;

//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

interface Monster {
    void menace();
}

interface DangerousMonstr extends Monster {
    void destory();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonstr {
    public void menace() {}
    public void destory() {}
}

interface Vampire extends DangerousMonstr, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    public void menace() {}
    public void destory() {}
    public void kill() {}
    public void drinkBlood() {}
}

/**
 * Created by saima on 9/02/16.
 */
public class HorrowShow {
    static void u(Monster b) {
        b.menace();
    }
    static void v(DangerousMonstr d) {
        d.menace();
        d.destory();
    }
    static void w(Lethal l) {
        l.kill();
    }
    public static void main(String[] args) {
        DangerousMonstr barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
} ///:~
