import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        Path path = Paths.get("Output\\");
        Files.createDirectories(path);

        String nomeFicheiro ="";
        int f=1;


        if (args.length != 0) {

            if(args[0].equals("-n")){

                nomeFicheiro = args[1];
                f=0;
                Menu.Menu(nomeFicheiro,f);

            }else {

                NaoInterativo.main(args);

            }

        } else {

            Menu.Menu(nomeFicheiro,f);

        }

    }

}
