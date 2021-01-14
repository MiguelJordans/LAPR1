/**
 * @author Miguel Jordão
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Distribuição {


    public static Scanner ler = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException {

        String file_in = "C:\\Users\\MiguelJordão(1201487\\IdeaProjects\\Teste Vetores\\src\\array.txt";

        Scanner input = new Scanner(new File(file_in));

        Scanner in = new Scanner(new File(file_in));

        System.out.println();

        int n = 0;

        while (in.hasNextDouble()) {

            ++n;
            in.nextLine();
        }

        in.nextLine();

        System.out.println("Introduza o número de gerações(t/k)");
        int k = ler.nextInt();

        System.out.println();

        System.out.println("Introduza os valores do vetor");
        double[][] X;
        X = lerVetor(n);

        int m = n, b = 1;

        double[][] matriz = new double[n][n];


        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                matriz[i][j] = input.nextDouble();
            }

            if (input.hasNextLine()) input.nextLine();

        }

        System.out.println("Matriz de Leslie: ");
        apresentarMatriz(matriz, n);

        double[][] matrizGeraçao;
        double[][] produto;
        double dimensão;
        double[][] vetorNormalizado;
        int t=0;

        System.out.println("*****************************************");

        while (t <= k) {

            System.out.printf("Para a %dª geração:",t+1);
            System.out.println();

            matrizGeraçao = leslieT(matriz, t, n);

            produto = multiplicarMatrizporVetor(matrizGeraçao, X, n, m, b);

            dimensão = dimensao(produto, n);

            vetorNormalizado = distribuiçaoNormalizada(produto, dimensão, n);

            System.out.println("Distribuição Normalizada");
            apresentarVetor(vetorNormalizado, n, m, b);

            System.out.println("Dimensão da população nessa geração:");
            System.out.printf("%.2f\n", dimensão);

            t++;

            System.out.println("*****************************************");

        }

    }



    public static void apresentarMatriz(double[][] matriz, int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.printf("%.2f\t", matriz[i][j]);
            }

            System.out.println();
        }
        System.out.println();
    }


    public static double[][] lerVetor(int n) {

        double[][] A = new double[1][n];


        for (int i = 0; i < n; i++) {

            A[0][i] = ler.nextDouble();

        }


        System.out.println();

        return A;

    }


    public static double[][] multiplicarMatrizporVetor(double[][] firstMatrix, double[][] X, int l1, int c1, int c2) {

        double[][] produto = new double[l1][c2];


        for (int i = 0; i < l1; i++) {

            for (int j = 0; j < c2; j++) {

                for (int k = 0; k < c1; k++) {

                    produto[i][j] = produto[i][j] + (firstMatrix[i][k] * X[0][j]);
                }

            }

        }

        System.out.println("Distribuição nâo normalizada:");

        for (int i = 0; i < l1; i++) {

            for (int j = 0; j < c2; j++) {

                if (i == 0 && j == c2) System.out.printf("%.2f)", produto[i][j]);

                else if (i == 0 && j == 0) System.out.printf("(%.2f", produto[i][j]);

                else System.out.printf(";%.2f", produto[i][j]);

            }

        }
        System.out.print(")");

        System.out.println();

        System.out.println();

        return produto;

    }


    public static double[][] multiplicarMatrizes(double[][] firstMatrix, double[][] secondMatrix, int l1, int c1, int c2) {

        double[][] produto = new double[l1][c2];


        for (int i = 0; i < l1; i++) {

            for (int j = 0; j < c2; j++) {

                for (int k = 0; k < c1; k++) {

                    produto[i][j] += firstMatrix[i][k] * secondMatrix[k][j];

                }

            }

        }

        return produto;
    }

    public static double dimensao(double[][] produto, int n) {

        double soma = 0;

        for (int j = 0; j < n; j++) {

            soma += produto[j][0];


        }

        return soma;
    }


    public static double[][] distribuiçaoNormalizada(double[][] produto, double dimensao, int n) {


        double[][] vetorNormalizado = new double[n][1];


        for (int j = 0; j < n; j++) {

            vetorNormalizado[j][0] = (produto[j][0] / dimensao) * 100;
        }


        return vetorNormalizado;
    }


    public static double[][] leslieT(double[][] Xgeraçao, int k, int n) {

        int m = n, t = n;
        double[][] A = Xgeraçao;

        if (k > 0) {
            for (int i = 0; i < k; i++) {

                Xgeraçao = multiplicarMatrizes(Xgeraçao, A, n, m, t);

            }

            return Xgeraçao;

        }
        else return A;
    }

    public static void apresentarVetor(double[][] vetor, int l1,int c1,int c2) {


        for (int i = 0; i < l1; i++) {

            for (int j = 0; j < c2; j++) {

                if (i == 0 && j == c2) System.out.printf("%.2f)", vetor[i][j]);

                else if (i == 0 && j == 0) System.out.printf("(%.2f", vetor[i][j]);

                else System.out.printf(";%.2f", vetor[i][j]);
            }

        }
        System.out.print(")");

        System.out.println();

        System.out.println();

    }
}