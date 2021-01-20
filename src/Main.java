import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        if (args.length != 0) {

            NaoInterativo.main(args);

        } else {

            Menu.Menu();

        }

    }

}
