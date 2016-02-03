package EverythingIsAnObject;

/**
 * Created by saima on 3/02/16.
 * Test the default value of different types in Java
 */
public class exercise1 {

    public static void main(String[] args) {
        Test sample = new Test();
        System.out.println(sample.a);
        System.out.println(sample.b);
    }

}

class Test {
    int a;
    char b;
    public Test() {

    }
}
