/**
 * @author Miguel Jordão
 */


import java.util.Scanner;

public class Transposta {
    public static Scanner in = new Scanner(System.in);


    public static void main(String[] args)  {

        System.out.println("Introduza o número de linhas e colunas, respetivamente:");
        int l1 = in.nextInt(), c1 = in.nextInt();

        double[][] firstMatrix;
        firstMatrix = lerMatriz(l1, c1);

        double[][]A = transposta(c1,l1,firstMatrix);
        imprimirMatriz(c1,l1,A);

    }
    public static double[][] lerMatriz(int c1, int l1) {

        double A[][] = new double[l1][c1];

        System.out.println("Introduza os valores desejados na matriz");


        for (int i = 0; i < l1; i++) {

            for (int j = 0; j < c1; j++) {

                A[i][j] = in.nextInt();

            }

        }

        System.out.println();

        return A;

    }

    public static double[][] transposta(int c1, int l1,double [][]firstmatrix) {

        double A[][] = new double[l1][c1];

        for(int i=0;i<l1;i++){

            for(int j=0;j<c1;j++){

                A[i][j]=firstmatrix[j][i];

            }

        }

        return A;

    }

    public static void imprimirMatriz(int c1,int l1,double [][]transposta) {

        for(int i=0;i<l1;i++){

            for(int j=0;j<c1;j++){

                System.out.printf("%.0f\t",transposta[i][j]);

            }

            System.out.println();

        }

        System.out.println();

    }
}

