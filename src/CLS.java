/**
 * Classe respetiva ao "clear" da consola
 */

public class CLS {

    public static void clearScreen() {

        System.out.print("\033[H\033[2J");

        System.out.print(String.format("\033[2J"));

        int count=20000;
        System.out.print(String.format("\033[%dA",count));

        for(int i=0;i<count;i++){
            System.out.print("\033[2K");
            System.out.println();
        }

        for(int j=0;j<10000;j++){
            System.out.println();
        }

        //Existem alguns prints com respetivos "outputs" que tentamos utilizar para dar clear à consola, mas chegamos à conclusão que a melhor maneira seria dar print a "n" linhas para "esconder" o output jà existente até o momento

    }
}