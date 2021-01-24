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

/**
 * Classe responsável para dar "run" ao modo não interativo
 */

public class NaoInterativo {

    /**
     * Dentro deste método vão ser lidos os comandos introduzidos na linha de comandos e dar print aos respetivos pedidos solicitados pelo utilizador
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */


    public static void main(String[] args) throws InterruptedException, IOException {

        //Inicialização das variáveis
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
                            System.exit(0);
                        }
                    } catch (Exception e) {
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

        nomeEspecie=nomeFicheiro;

        double[] vectorDistribPop = lerDistribPop(nomeFicheiro);
        double[][] matrixLeslie = lerMatriz(nomeFicheiro);



        DistribuiçãoNãoInterativa.ApresentarDist(matrixLeslie, Integer.parseInt(numGeracoes),vectorDistribPop,100,nomeFicheiroSaida,vecProprio,dimPopulacao,varPopGeracoes);

        CriaGrafico("total", formatFicheiro, "total_tmp",nomeEspecie); //Funções para criar os gráficos no modo não interativo
        CriaGrafico("variacao", formatFicheiro, "variacao_tmp",nomeEspecie);
        CriaGrafico("nao_normalizada", formatFicheiro, "nao_normalizada_tmp",nomeEspecie);
        CriaGrafico("normalizada", formatFicheiro, "normalizada_tmp",nomeEspecie);


    }

    /**
     * @param file
     * @return
     */


    public static double[] lerDistribPop(String file) {

        String stringX = "";
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

    /**
     * @param file
     * @return
     */


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

    /**
     * @param valor
     * @return
     */


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

    /**
     * @return
     */


    public static String ObtemData() {

        Date data = new Date();
        DateFormat f = new SimpleDateFormat("dd-MM-yyyy_HH;mm;ss");
        String date = f.format(data);
        return date;
    }

    /**
     * @param ficheiro
     * @param formato
     * @param nometmp
     * @param nomeEspecie
     * @throws InterruptedException
     */


    public static void CriaGrafico(String ficheiro, String formato, String nometmp,String nomeEspecie) throws InterruptedException {
        String[] location = new String[2];
        // localização do programa
        location[0] = "gnuplot";
        // localização do gnuplot

        location[1] = "GnuPlot\\" + "cria_" + ficheiro + "_" + formato + ".gp";
        Thread.sleep(20);

        try {

            Runtime.getRuntime().exec(location);

        } catch (IOException e) {

            e.printStackTrace();

        }

       try {
            MudaNomeFicheiro(ficheiro, nometmp, formato, nomeEspecie);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param nome
     * @param nomepng
     * @param formato
     * @param nomeEspecie
     * @throws InterruptedException
     */


    public static void MudaNomeFicheiro(String nome, String nomepng, String formato, String nomeEspecie) throws InterruptedException {

        File ficheiro = new File("GnuPlot\\" + nomepng + "." + formato);
        while (!ficheiro.exists()){

        }

        Thread.sleep(200);


        try {


            Path oldname = FileSystems.getDefault().getPath("GnuPlot\\" + nomepng + "." + formato);
            Path newname = FileSystems.getDefault().getPath(nomeEspecie+"_"+nome + "_" + ObtemData() + "." + formato);

            Files.move(oldname, oldname.resolveSibling(newname));
            Path path = FileSystems.getDefault().getPath("Gnuplot\\"+nomeEspecie+"_"+nome + "_" + ObtemData() + "." + formato);

            Path newdir = FileSystems.getDefault().getPath("Output");

            Files.move(path, newdir.resolve(path.getFileName()));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


