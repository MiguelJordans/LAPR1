import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length != 0) {
            try {
                Interface.main(args);
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
                System.out.println("Bem Vindo!");

                System.out.println("Por favor introduza a matriz de Lelie:");
                boolean acabou = false;
                int geracao = 0;
                while (!acabou) {
                    String acabar = "";

                    System.out.println("Número de individuos da geração " + (geracao + 1));
                    nIndividuos[geracao] = read.nextInt();

                    System.out.println("Taxa de fecundidade da geração " + (geracao + 1));
                    taxaF[geracao] = read.nextDouble();


                    System.out.println("Taxa de mortalidade da geração" + (geracao + 1) + "(Se for ultima geração este valor não vai ser lido, por isso pode deixar a 0)");
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


                double[][] matriz = criaMatriz(nIndividuos, taxaS, taxaF);
                Interface.ImprimirMatriz(matriz);
                nIndividuos = limpaVetor(nIndividuos);


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

    public static double[][] criaMatriz(double[] nIndividuos, double[] taxaS, double[] taxaF) {
        nIndividuos = limpaVetor(nIndividuos);
        taxaS = limpaVetor(taxaS);
        taxaF = limpaVetor(taxaF);

        double[][] matizLeslie = new double[nIndividuos.length][nIndividuos.length];

        for (int i = 0; i < taxaF.length; i++) {
            matizLeslie[0][i] = taxaF[i];
        }
        for (int j = 0; j < taxaS.length; j++) {
            matizLeslie[j + 1][j] = taxaS[j];
        }
        return matizLeslie;


    }

    public static double[] limpaVetor(double[] array) {
        double[] vetorLimpo = Arrays.copyOf(array, encontraUltimoValor(array));
        return vetorLimpo;

    }

    public static int encontraUltimoValor(double[] array) {
        int end = 0;
        int i = 0;
        boolean acabou = false;
        while (i < array.length && !acabou) {
            if (array[i] == 0) {
                end = i;
                acabou = true;
            }
            i++;
        }
        return end;

    }


}