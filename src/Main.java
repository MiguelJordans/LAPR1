import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        if (args.length != 0) {

            NaoInterativo.main(args);


        } else {

            Menu.Menu();

        }

    }

}
