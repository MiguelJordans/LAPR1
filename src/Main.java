import java.util.Arrays;
import java.util.Scanner;

public class Main {

        static Scanner read = new Scanner(System.in);

        public static void main(String[] args) {
            if (args.length != 0) {

                try {

                   // Interface.main(args);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            } else {

                boolean choice = true;

                while (choice) {

                    String choi = "";

                    double[] taxaS = new double[199];
                    double[] taxaF = new double[199];
                    double[] nIndividuos = new double[199];
                    int t;

                    Welcome.Welcome();

                    System.out.printf("Por favor introduza a matriz de Lelie:\n\n");

                    boolean acabou = false;
                    int geracao = 0;

                    while (!acabou) {

                        String acabar = "";


                        System.out.printf("Número de indivíduos da %dª geração\n",geracao+1);
                        nIndividuos[geracao] = read.nextInt();


                        System.out.printf("Taxa de fecundidade da %dª geração\n",geracao+1);
                        taxaF[geracao] = read.nextDouble();


                        System.out.printf("Taxa de mortalidade da %dª geração ",geracao+1);
                        System.out.print("(Se for ultima geração este valor não vai ser lido, por isso pode deixar a 0)\n");
                        taxaS[geracao] = read.nextDouble();

                        while (taxaS[geracao] > 1 || 0 > taxaS[geracao]) {

                            System.out.println("valor inválido, por favor introduza um valor entre 0 e 1 ");
                            taxaS[geracao] = read.nextDouble();

                        }

                        read.nextLine();


                        while (!acabar.equals("S") && !acabar.equals("N")) {

                            System.out.println("Deseja  introduzir mais dados?(S/N)");
                            acabar = read.nextLine();

                            if (acabar.equals("N")) {

                                acabou = true;

                            } else if (acabar.equals("S")) {

                                acabou = false;

                            }

                        }

                        geracao++;

                    }

                    System.out.println("Introduza o número de instantes de tempo a gerar");
                    t = read.nextInt();
                    System.out.println();

                    double[][] matriz = Ler.criaMatriz(nIndividuos, taxaS, taxaF, geracao);

                    //Interface.ImprimirMatriz(matriz);
                    nIndividuos = Ler.limpaVetor(nIndividuos, geracao);

                    System.out.println("OUTPUT");
                    System.out.printf("\n\nk=%d\n\n",t);

                    System.out.println("Matriz de Leslie");
                    System.out.println();
                    Apresentar.apresentarMatriz(matriz);

                    Distribuição.ApresentarDist(matriz,t,nIndividuos);

                    read.nextLine();

                    while (!choi.equals("S") && !choi.equals("N")) {

                        System.out.println("Deseja voltar a introduzir dados?(S/N)");
                        choi = read.nextLine();

                        if (choi.equals("S")) {

                            choice = true;

                        } else if (choi.equals("N")) {

                            choice = false;

                        }

                    }

                }


            }


        }

    }