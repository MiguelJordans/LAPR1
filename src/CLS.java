
public class CLS {

    public static void clearScreen() { //Por compor , função para apagar o system.out

        System.out.print("\033[H\033[2J");

        System.out.print(String.format("\033[2J"));

        int count=20000;
        System.out.print(String.format("\033[%dA",count)); // Move up

        for(int i=0;i<count;i++){
            System.out.print("\033[2K"); // Erase line content
            System.out.println();
        }

        for(int j=0;j<10000;j++){
            System.out.println();
        }

        //tentei procurar no stackoverflow durante muito tempo mas cheguei à conclusão que este é o melhor plano que temos

    }
}