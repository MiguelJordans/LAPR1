import java.util.Scanner;

public class Main {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

            if (args.length != 0) {


                try {

                    {
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

                        double[] vectorDistribPop = NaoInterativo.lerDistribPop(nomeFicheiro);
                        double[][] matrixLeslie = NaoInterativo.lerMatriz(nomeFicheiro);
                        
                        if (dimPopulacao = true){
                    GnuPlot.CriaGrafico("total", formatFicheiro, "total_tmp");
                      }
                        if(varPopGeracoes = true){
                        GnuPlot.CriaGrafico("variacao", formatFicheiro, "variacao_tmp");
                   }
                            if (vecProprio = true){
                        GnuPlot.CriaGrafico("nao_normalizada", formatFicheiro, "nao_normalizada_tmp");
                        GnuPlot.CriaGrafico("normalizada", formatFicheiro, "normalizada_tmp");
                 }


                        NaoInterativo.ImprimirMatriz(matrixLeslie);


                        //MODO INTERATIVO
                        if (interativo == true) {

                            Scanner ler = new Scanner(System.in);

                        }
                    }


            } catch (Exception e) {

                e.printStackTrace();

            }

        } else {

            Menu.Menu();

        }

    }

}





