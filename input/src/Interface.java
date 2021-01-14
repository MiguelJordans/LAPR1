import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class Interface {

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

        double matrix[][] = new double[100][100];

        double[] vectorDistribPop = lerDistribPop(nomeFicheiro);
        double[][] matrixLeslie = lerMatriz(nomeFicheiro);

        ImprimirMatriz(matrixLeslie);


        //MODO INTERATIVO
        if (interativo == true) {

            Scanner ler = new Scanner(System.in);

        }
    }

    private static double[] lerDistribPop(String file) {

        String stringX = "";
        String charF = "";
        Scanner ficheiro = null;
        double distribPop[] = null;
        try{

            File myObj = new File(file);
            ficheiro = new Scanner(myObj);

            while (ficheiro.hasNextLine()) {
                stringX = ficheiro.nextLine();
                if (stringX.substring(0,0)=="x") {

                    String linhaStringXSeparados[] = stringX.split(",");
                    distribPop = new double[linhaStringXSeparados.length];
                    for (int i = 0; i < linhaStringXSeparados.length; i++) {
                        distribPop[i] = SeparaDouble(linhaStringXSeparados[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            //Ficheiro Inexistente
            e.printStackTrace();
            System.exit(0);
        }
        ficheiro.close();
        return distribPop;

    }
    public static double[][] lerMatriz (String file) {

        String stringY="", stringS="", stringF="";
        Scanner ficheiro = null;
        double matriz[][] = null;
        try{

            File myObj = new File(file);
            ficheiro = new Scanner(myObj);

            while(ficheiro.hasNextLine()){
                if(stringY.substring(0,0)=="s"){

                    stringS = stringY;

                }else if(stringY.substring(0,0)=="f"){

                    stringF = stringY;
                }
            }
            String linhaStringSSeparados[] = stringS.split(",");
            String linhaStringFSeparados[] = stringF.split(",");


            matriz = new double[linhaStringFSeparados.length][linhaStringFSeparados.length];

            for (int i = 0; i < linhaStringFSeparados.length; i++) {
                matriz[0][i] = SeparaDouble(linhaStringFSeparados[i]);
            }
            for(int j = 0; j < linhaStringSSeparados.length; j++ ){
                matriz[j+1][j] = SeparaDouble(linhaStringSSeparados[j]);
            }
        } catch (FileNotFoundException e) {
            //Ficheiro Inexistente
            e.printStackTrace();
            System.exit(0);
        }
        ficheiro.close();
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
