import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Miguel Jordão
 * @author Eduardo Sousa
 * @author Beatriz Ferreira
 * @author José Pereira
 *
 *Classe para dar run ao programa
 */

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException { //Módulo para que o programa consiga dar run, tanto no modo interativo como no modo não interativo

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

                NaoInterativo.main(args); //Caso existam argumentos dar run ao modo interativo com os respetivos parâmetros

            }

        } else {

            Menu.Menu(nomeFicheiro,f); //Caso não exista argumentos na linha de comandos dar run ao modo interativo sem alterações nenhumas

        }

    }

}
