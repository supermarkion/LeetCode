package InitializationAndCleanup;

//: initialization/Burrito.java

/**
 * Created by saima on 5/02/16.
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree) {
        this.degree = degree;
    }
    public void describe() {
        System.out.print("This hurrito is ");
        switch(degree) {
            case NOT:
                System.out.println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM:
                System.out.println("a little not.");
                break;
            case HOT:
            case FLAMING:
            default:
                System.out.println("maybe too hot.");
        }
    }

    public static void main(String[] args) {
        Burrito
                plain = new Burrito(Spiciness.NOT),
                gereenChile = new Burrito(Spiciness.MEDIUM),
                jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        gereenChile.describe();
        jalapeno.describe();
    }
}/* Output:
This burrito is not spicy at all.
This burrito is a little hot.
This burrito is maybe too hot.
*///:~

