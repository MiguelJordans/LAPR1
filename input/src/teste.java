import  java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

<<<<<<< HEAD

public class teste<matriz> {
    public static void lerMatriz() throws FileNotFoundException {
        String nomeMatriz = "";
        int matrizLinhaAtual = 0;

        Scanner ler = new Scanner(System.in);
        System.out.print("Qual é o nome do ficheiro: ");
        String nomeFicheiro = ler.nextLine();
        File main = new File(nomeFicheiro);

            Scanner ficheiro;
            int dimensao;
            //falta definir como vai ser o tamanho da matriz
            int matriz[][] = new int[4][2];

                ficheiro = new Scanner(main);
        matriz = new int[5][5];

        ficheiro = new Scanner(main);
                nomeMatriz = ficheiro.nextLine();
                System.out.println("Nome: " + nomeMatriz);
                dimensao = Integer.parseInt(ficheiro.nextLine());

                matriz = new int[dimensao][dimensao];
                    while (ficheiro.hasNextLine()) {

                        String linhaAux = ficheiro.nextLine();
                        String linhaNumerosSeparados[] = linhaAux.split("");
                        int inteiros[] = new int[dimensao];
                            for (int i = 0; i < dimensao; i++) {
                                inteiros[i] = Integer.parseInt(linhaNumerosSeparados[i]);
                }
                                     for (int i = 0; i < dimensao; i++) {
                    matriz[matrizLinhaAtual][i] = inteiros[i];
                }
                matrizLinhaAtual++;
=======
public class teste {

    public static void main(String[] args) throws Exception {

            Scanner ficheiro = null;
            double matrix[][] = new double[100][100];

            Scanner ler = new Scanner(System.in);
            System.out.print("Qual é o nome do ficheiro: ");

            try{

                String nomeEspecie = ler.nextLine();
                File myObj = new File(nomeEspecie);
                ficheiro = new Scanner(myObj);

            } catch (FileNotFoundException e) {

                e.printStackTrace();
                System.exit(0);
>>>>>>> 5d14af9024f697b0d21ecba3cb4ecdbcae44a2b8
            }
            double[] vectorDistribPop = lerDistribPop(ficheiro);
            double[][] matrixLeslie = lerMatriz(ficheiro);

            ImprimirMatriz(matrixLeslie);

            ficheiro.close();
<<<<<<< HEAD
        }
        return matriz;

}
=======

    }

    private static double[] lerDistribPop(Scanner fx){

        String stringX;
        stringX = fx.nextLine();
        String linhaStringXSeparados[] = stringX.split(",");
        double distribPop[] = new double[linhaStringXSeparados.length];
          for (int i = 0; i < linhaStringXSeparados.length; i++){
              distribPop[i] = SeparaDouble(linhaStringXSeparados[i]);
          }
          return distribPop;
    }

    public static double[][] lerMatriz (Scanner fx) {

        String stringS, stringF;
        stringS = fx.nextLine();
        stringF = fx.nextLine();
        String linhaStringSSeparados[] = stringS.split(",");
        String linhaStringFSeparados[] = stringF.split(",");

        double matriz[][] = new double[linhaStringFSeparados.length][linhaStringFSeparados.length];

            for (int i = 0; i < linhaStringFSeparados.length; i++) {
                matriz[0][i] = SeparaDouble(linhaStringFSeparados[i]);
    }
            for(int j = 0; j < linhaStringSSeparados.length; j++ ){
                matriz[j+1][j] = SeparaDouble(linhaStringSSeparados[j]);
            }

        return matriz;
    }
>>>>>>> 5d14af9024f697b0d21ecba3cb4ecdbcae44a2b8

    public static double SeparaDouble(String valor){
        double valorD = 0;
        try{
            String valorS = valor.substring(valor.indexOf("=")+1,valor.length());
            valorD = Double.parseDouble(valorS);

        } catch (NumberFormatException e) {
        
            e.printStackTrace();
            System.exit(0);
        }
        return valorD;
    }

    public static void ImprimirMatriz(double m[][]){
int tamanhoMatriz = m.length;
        for (int i = 0; i < tamanhoMatriz; i++) {

            for (int j = 0; j < tamanhoMatriz; j++) {
                System.out.print(m[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }




    }
}
