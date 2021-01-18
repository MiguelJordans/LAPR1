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
                int flag=0;

                while (choice) {

                    String choi = "";

                    double[] taxaS = new double[199];
                    double[] taxaF = new double[199];
                    double[] nIndividuos = new double[199];
                    int t;

                    if(flag==0){

                        Welcome.Welcome();
                        flag++;
                        System.out.printf("Por favor introduza a matriz de Lelie:\n\n");

                    }

                    else if(flag>0)  {

                        System.out.printf("\n\n\n\nPor favor introduza novamente a matriz de Lelie:\n\n");

                    }

                    int geracao =  Ler.leslie(nIndividuos,taxaF,taxaS);

                    System.out.println("Introduza o número de instantes de tempo a gerar");
                    t = read.nextInt();
                    System.out.println();

                    double[][] matriz = Ler.criaMatriz(nIndividuos, taxaS, taxaF, geracao);

                    //Interface.ImprimirMatriz(matriz);
                    nIndividuos = Ler.limpaVetor(nIndividuos, geracao);

                    System.out.printf("k=%d\n\n",t);

                    System.out.printf("Matriz de Leslie\n");

                    Apresentar.apresentarMatriz(matriz);

                    Distribuição.ApresentarDist(matriz,t,nIndividuos);

                    read.nextLine();

                    while (!choi.equals("S") && !choi.equals("N")) {

                        System.out.printf("Deseja voltar a introduzir dados?(S/N)\n\n");
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