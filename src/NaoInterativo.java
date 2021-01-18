import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NaoInterativo {

    public static void main(String[] args) throws IOException {

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
        for (int i = 0; i < args.length; i++) {

            switch (args[i]) {

                //interativo
                case "-n":
                    try {
                        nomeFicheiro = args[i + 1];
                        interativo = true;
                    } catch (Exception e) {
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
                    } catch (Exception e) {
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
                    } catch (Exception e) {
                        System.out.println("Parâmetros inválidos -g");
                        System.exit(0);
                    }
                    break;
                //Calcular valor e vector próprio
                case "-e":
                    vecProprio = true;
                    break;
                //Calcular dimensão população a cada geração
                case "-v":
                    dimPopulacao = true;
                    break;
                //Calcular variação da População entre gerações
                case "-r":
                    varPopGeracoes = true;
                    break;
            }
        }

        double matrix[][] = new double[100][100];

        double[] vectorDistribPop = lerDistribPop(nomeFicheiro);
        double[][] matrixLeslie = lerMatriz(nomeFicheiro);

        Distribuição.ApresentarDist(matrixLeslie, Integer.parseInt(numGeracoes),vectorDistribPop,interativo,varPopGeracoes,dimPopulacao,vecProprio);

        ImprimirMatriz(matrixLeslie);



    }

    public static double[] lerDistribPop(String file) {

        String stringX = "";
        String charF = "";
        Scanner ficheiro = null;
        double distribPop[] = null;
        try {

            File myObj = new File(file);
            ficheiro = new Scanner(myObj);

            while (ficheiro.hasNextLine()) {
                stringX = ficheiro.nextLine();
                if (stringX.substring(0, 0) == "x") {

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

    public static double[][] lerMatriz(String file) {

        String stringY = "", stringS = "", stringF = "";
        Scanner ficheiro = null;
        double matriz[][] = null;
        try {

            File myObj = new File(file);
            ficheiro = new Scanner(myObj);

            while (ficheiro.hasNextLine()) {
                if (stringY.substring(0, 0) == "s") {

                    stringS = stringY;

                } else if (stringY.substring(0, 0) == "f") {

                    stringF = stringY;
                }
            }
            String linhaStringSSeparados[] = stringS.split(",");
            String linhaStringFSeparados[] = stringF.split(",");


            matriz = new double[linhaStringFSeparados.length][linhaStringFSeparados.length];

            for (int i = 0; i < linhaStringFSeparados.length; i++) {
                matriz[0][i] = SeparaDouble(linhaStringFSeparados[i]);
            }
            for (int j = 0; j < linhaStringSSeparados.length; j++) {
                matriz[j + 1][j] = SeparaDouble(linhaStringSSeparados[j]);
            }
        } catch (FileNotFoundException e) {
            //Ficheiro Inexistente
            e.printStackTrace();
            System.exit(0);
        }
        ficheiro.close();
        return matriz;
    }

    public static double SeparaDouble(String valor) {
        double valorD = 0;
        try {
            String valorS = valor.substring(valor.indexOf("=") + 1, valor.length());
            valorD = Double.parseDouble(valorS);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return valorD;
    }

    public static void ImprimirMatriz(double m[][]) {
        int tamanhoMatriz = m.length;
        for (int i = 0; i < tamanhoMatriz; i++) {

            for (int j = 0; j < tamanhoMatriz; j++) {
                System.out.print(m[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void Grava(int k, double[][] matrizLeslie,double[] total,double[] variacao,double[][] naonormalizada,double[][] normalizada,double valorproprio,double[] vetorprorio  ) {
        try {

            File saida = new File("OutPut\\saida.txt");
            FileWriter grava = new FileWriter("OutPut\\saida.txt");


            grava.write("k="+k+"\n");

            grava.write("Matriz de Leslie");
            int tamanhoMatriz = matrizLeslie.length;
            for (int i = 0; i < tamanhoMatriz; i++) {

                for (int j = 0; j < tamanhoMatriz; j++) {
                    grava.write(String.valueOf(matrizLeslie[i][j]));
                    grava.write("\n");
                }
            }


            grava.write("Numero total de individuos\n");
            grava.write("(t, Nt)\n");
            for(int i=0; i< total.length;i++){
                grava.write("("+i+", "+total[i]+")");
            }



            grava.write("Crescimento da população\n");
            grava.write("(t, delta_t)\n");
            for(int i=0; i< variacao.length;i++){
                grava.write("("+i+", "+variacao[i]+")");
            }



            grava.write("Numero por classe (não normalizado)\n");
            grava.write("(t,");
            for (int i =0;i<naonormalizada[0].length;i++){
                grava.write("x"+(i+1)+",");
            }
            grava.write(")\n");

            for(int i=0; i< naonormalizada.length;i++){
                grava.write("(" + i + ", ");
                for (int j = 0; j < naonormalizada[i].length; j++) {

                    grava.write(naonormalizada[i][j] + ",");
                }
                grava.write(")\n");
            }



            grava.write("Numero por classe (normalizado)\n");
            grava.write("(t,");
            for (int i =0;i<normalizada[0].length;i++){
                grava.write("x"+(i+1)+",");
            }
            for(int i=0; i< normalizada.length;i++){
                grava.write("(" + i + ", ");
                for (int j = 0; j < normalizada[i].length; j++) {

                    grava.write(normalizada[i][j] + ",");
                }
                grava.write(")\n");
            }
            grava.write("\n\n\n");

            grava.write("Maior valor próprio e vetor associado\n");
            grava.write("Lambda="+valorproprio+"\n");
            grava.write("vetor próprio=(");
            for(int i =0; i< vetorprorio.length;i++){
                grava.write(vetorprorio[i] +",");
            }
            grava.write(")");



            grava.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


