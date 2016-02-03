package EverythingIsAnObject;

//: object/ShowProperties.java

/**
 * Created by saima on 3/02/16.
 * We use this to check standard libraries.
 */
public class ShowProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        // list() method sends the results to its argument System.out
        System.out.println(System.getProperty("user.name"));
        System.out.println(
                System.getProperty("java.library.path"));
    }
}
