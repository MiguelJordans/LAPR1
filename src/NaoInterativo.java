import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NaoInterativo {

    public static void main(String[] args) throws InterruptedException, IOException {

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

        double[] vectorDistribPop = lerDistribPop(nomeFicheiro);
        double[][] matrixLeslie = lerMatriz(nomeFicheiro);
        ImprimirMatriz(matrixLeslie);

        System.out.println(varPopGeracoes);
        System.out.println(nomeEspecie);
        System.out.println(nomeFicheiro);
        System.out.println(nomeFicheiroSaida);

        for (int i=0; i < vectorDistribPop.length -1;i++ ){
            System.out.println(vectorDistribPop[i]);
        }


        DistribuiçãoNãoInterativa.ApresentarDist(matrixLeslie, Integer.parseInt(numGeracoes),vectorDistribPop,0,nomeFicheiroSaida,vecProprio,dimPopulacao,varPopGeracoes);
/*
        if (formatFicheiro.equals("png")){
            System.out.println("entrei png");
            CriaGrafico("cria_nao_normalizada_png.gp","png","nao_normalizada_tmp");
            CriaGrafico("cria_normalizada_png.gp","png", "normalizada_tmp");
            CriaGrafico("cria_total_png.gp","png", "total_tmp");
            CriaGrafico("cria_variacao_png.gp","png", "variacao_tmp");

        }else if (formatFicheiro.equals("txt")){
            CriaGrafico("cria_nao_normalizada_txt.gp","txt","nao_normalizada_tmp");
            CriaGrafico("cria_normalizada_txt.gp","txt", "normalizada_tmp");
            CriaGrafico("cria_total_txt.gp","txt", "total_tmp");
            CriaGrafico("cria_variacao_txt.gp","txt", "variacao_tmp");


        }else if (formatFicheiro.equals("eps")){
            CriaGrafico("cria_nao_normalizada_eps.gp","eps","nao_normalizada_tmp");
            CriaGrafico("cria_normalizada_eps.gp","eps", "normalizada_tmp");
            CriaGrafico("cria_total_eps.gp","eps", "total_tmp");
            CriaGrafico("cria_variacao_eps.gp","eps", "variacao_tmp");



        }

 */

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
                char x = 'x';

                if (stringX.charAt(0) == x) {

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
        double matriz[][] = null;
        Scanner ficheiro = null;
        try {

            File myObj = new File(file);
            ficheiro = new Scanner(myObj);

            while (ficheiro.hasNextLine()) {
                stringY = ficheiro.nextLine();





                char s ='s';
                char f ='f';
                if (stringY.charAt(0) == s) {

                    stringS = stringY;


                } else if (stringY.charAt(0) == f) {

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
            String valorS = valor.substring(valor.indexOf("=") + 1);
            valorD = Double.parseDouble(valorS);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return valorD;
    }

    public static String ObtemData() {

        Date data = new Date();
        DateFormat f = new SimpleDateFormat("dd-MM-yyyy_HH;mm;ss");
        String date = f.format(data);
        return date;
    }


    public static void CriaGrafico(String ficheiro, String formato, String nometmp) throws InterruptedException {
        String[] location = new String[2];
//      localização do programa
        location[0] = "C:\\Program Files\\gnuplot\\bin\\gnuplot.exe";
//      localização do gnuplot

        location[1] = "GnuPlot\\" + "cria_" + ficheiro + "_" + formato + ".gp";
        Thread.sleep(20);

        try {

            Runtime.getRuntime().exec(location);
            System.out.println("criado");

        } catch (IOException e) {

            System.out.println("Algo está errado");

            e.printStackTrace();

        }
       try {
            MudaNomeFicheiro(ficheiro, nometmp, formato);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }
    public static void MudaNomeFicheiro(String nome, String nomepng, String formato) throws InterruptedException {

        File ficheiro = new File("GnuPlot\\" + nomepng + "." + formato);
        System.out.println("A criar o ficheiro ...");
        System.out.println("aa");
        System.out.println(ficheiro);

        while (!ficheiro.exists()) {
            while (!ficheiro.canRead()) {
                System.out.println("e");

            }
        }

        Thread.sleep(20);


        try {


            Path oldname = FileSystems.getDefault().getPath("GnuPlot\\" + nomepng + "." + formato);
            Path newname = FileSystems.getDefault().getPath(nome + "_" + ObtemData() + "." + formato);

            Files.move(oldname, oldname.resolveSibling(newname));
            Path path = FileSystems.getDefault().getPath("Gnuplot\\" + nome + "_" + ObtemData() + "." + formato);

            Path newdir = FileSystems.getDefault().getPath("Output");

            Files.move(path, newdir.resolve(path.getFileName()));

            System.out.println("Ficheiro guardado com sucesso!");

        } catch (IOException e) {
            System.out.println("Algo falhou... Não foi possivel criar o ficheiro");
            e.printStackTrace();
        }

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


