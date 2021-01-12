import  java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class teste {

    public static void main(String[] args) throws Exception {

        String nomeFicheiro = "";
        String nomeFicheiroSaida = "";
        String numGeracoes = "";
        String nomeEspecie = "";
        String formatFicheiro = "";
        boolean vecProprio = false;
        boolean dimPopulacao = false;
        boolean varPopGeracoes = false;
        boolean interativo = false;
        int v_arg = 0;

        //ler parâmetros
        for (int i=0;i<args.length;i++){

            switch(args[i]){

                //interativo
                case "-n":
                    try {
                        nomeFicheiro = args[i + 1];
                        interativo = true;
                    }catch(Exception e){
                        System.out.println("Parâmetros Inválidos!");
                        System.exit(0);
                    }
                    break;
                //Não Interativo
                //Número de Gerações
                case "-t":
                    try {
                        numGeracoes = args[i + 1];
                        nomeFicheiro = args[args.length - 2];
                        nomeFicheiroSaida = args[args.length - 1];
                    }catch(Exception e){
                        System.out.println("Parâmetros Inválidos!");
                        System.exit(0);
                    }
                    break;
                //Formato de Ficheiro gráfico
                case "-g":
                    try {
                        v_arg = Integer.parseInt(args[i + 1]);
                        if (v_arg == 1) {
                            formatFicheiro = "png";
                        } else if (v_arg == 2) {
                            formatFicheiro = "txt";
                        } else if ((v_arg == 3)) {
                            formatFicheiro = "eps";
                        } else {
                            System.out.println("Formato de Ficheiro inválido!");
                            System.exit(0);
                        }
                    }catch(Exception e){
                        System.out.println("Parâmetros inválidos -g");
                        System.exit(0);
                    }
                    break;
                //Calcular valor e vector próprio
                case "-e": vecProprio = true; break;
                //Calcular dimensão população a cada geração
                case "-v": dimPopulacao = true; break;
                //Calcular variação da População entre gerações
                case "-r": varPopGeracoes = true; break;
            }
        }
        Scanner ficheiro = null;
        double matrix[][] = new double[100][100];

        try{

            File myObj = new File(nomeFicheiro);
            ficheiro = new Scanner(myObj);

        } catch (FileNotFoundException e) {
            //Ficheiro Inexistente
            e.printStackTrace();
            System.exit(0);
        }
        double[] vectorDistribPop = lerDistribPop(ficheiro);
        double[][] matrixLeslie = lerMatriz(ficheiro);

        ImprimirMatriz(matrixLeslie);
        ficheiro.close();

        //MODO INTERATIVO
        if (interativo == true) {

            Scanner ler = new Scanner(System.in);

        }
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