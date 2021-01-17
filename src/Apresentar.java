public class Apresentar {

    public static void apresentarMatriz(double[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%.2f\t", matriz[i][j]);

            }

            System.out.println();

        }

        System.out.println();

    }

    public static void apresentarVetor(double[] vetor) {

        for (int j = 0; j < vetor.length; j++) {

            if  (j == vetor.length) System.out.printf("%.2f)", vetor[j]);

            else if (j == 0) System.out.printf("(%.2f", vetor[j]);

            else System.out.printf(";%.2f", vetor[j]);

        }

        System.out.print(")");

        System.out.println();

        System.out.println();

    }

    public static void apresentarTaxaOUDimensão(double[] vetor) {

        int t=0;

        for (int j = 0; j < vetor.length; j++) {

            if (vetor[j] != 0) {

                System.out.printf("(%d ; %.2f)\n",t,vetor[j]);
                t++;

            }

        }

        System.out.println();

    }

    public static void apresentarVetorBidimensional(double[][]matriz, double [][]matA){

        for (int i = 0; i < 1; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                if (i == 0 && j == matriz[i].length) System.out.printf("%.2f)", matA[i][j]);

                else if (i == 0 && j == 0) System.out.printf("(%.2f", matA[i][j]);

                else System.out.printf(";%.2f", matA[i][j]);

            }

        }

        System.out.print(")");

        System.out.println();

        System.out.println();

    }

}