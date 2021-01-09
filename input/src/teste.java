import  java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

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
            }
            double[] vectorDistribPop = lerDistribPop(ficheiro);
            double[][] matrixLeslie = lerMatriz(ficheiro);

            ImprimirMatriz(matrixLeslie);

            ficheiro.close();

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
