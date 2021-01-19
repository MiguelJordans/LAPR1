import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        if (args.length != 0) {

            try {
                System.out.println("a");

                NaoInterativo.main(args);

            } catch (IOException e) {
                e.printStackTrace();
            }


        } else {

            Menu.Menu();

        }

    }

}
