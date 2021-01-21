import java.util.Scanner;

public class Calculos {

    static Scanner read = new Scanner(System.in);

    public static double[][] leslieT(double[][] Xgeraçao, int k) {

        double[][] A = Xgeraçao;

        if (k > 1) { // Em princípio esta tudo bem , estou acabar de fazer testes manuais para comparar valores e verificar tudo

            for (int i = 1; i < k; i++) {

                Xgeraçao = multiplicarMatrizes(Xgeraçao, A);

            }

            return Xgeraçao;

        } else return A;

    }

        public static double[][] multiplicarMatrizes(double[][] firstMatrix, double[][] secondMatrix) {

            double[][] produto = new double[firstMatrix.length][secondMatrix[0].length];


            for (int i = 0; i < firstMatrix.length; i++) {

                for (int j = 0; j < secondMatrix[0].length; j++) {

                    for (int k = 0; k < firstMatrix[0].length; k++) {

                        produto[i][j] += firstMatrix[i][k] * secondMatrix[k][j];

                    }

                }

            }

            return produto;

        }

    public static double[] multiplicarMatrizporVetor(double[][] firstMatrix, double[] vector) {


        double[] resposta = new double[firstMatrix.length];
        int i=0;


        for(int linha = 0; linha<firstMatrix.length; linha++){

            for(int k = 0; k < firstMatrix.length; k++){

                resposta[i] += firstMatrix[linha][k] * vector[k];

            }

            i++;

        }


        return resposta;

    }

    public static void verificarVetorProprio(double[]vetorProprio, double lambda,double[][]matriz) {

         boolean check;

         double[]A=multiplicarMatrizporVetor(matriz,vetorProprio);
         double[]B=multiplicarVetorporValorProprio(vetorProprio,lambda);

         check =  Apresentar.isIgual(A,B);

         if (check) System.out.println("\nO vetor próprio esta bem calculado\n");
         else System.out.println("\nO vetor próprio está mal calculado\n");

            System.out.printf("\nMatriz de leslie a mutiplicar pelo vetor:\n");
            Apresentar.apresentarVetor(A);

            System.out.printf("\nVetor Próprio a multiplicar pelo valor próprio:\n");
            Apresentar.apresentarVetor(B);

    }


    public static double[] multiplicarVetorporValorProprio(double[] vetor, double lambda) {

            for(int k = 0; k < vetor.length; k++){

                 vetor[k] = vetor[k]*lambda;
            }


        return vetor;

    }

}

