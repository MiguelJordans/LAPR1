import java.util.Scanner;
import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;

public class Vectores {

    public static Scanner in = new Scanner(System.in);

    public static void vetores(double[][] firstMatrix, double[] X) {




        double mvalorp;

        System.out.println("************************************************");
        System.out.println();

        mvalorp = vetorproprio(firstMatrix, firstMatrix.length,firstMatrix.length , firstMatrix.length);

        System.out.printf("-lambda=%.4f\n", mvalorp);

        comportamentoAssintotico(mvalorp);
        System.out.println();

        // Multiplicar o vetor pela matriz
        double[] product = Distribuição.multiplicarMatrizporVetor(firstMatrix,X);

        // Mostrar o resultado
        System.out.println("O produto das duas matrizes é: ");
        Distribuição.apresentarVetor(product);

        System.out.println();

        //Multiplicar o vetor pelo valor próprio
        double[] vetorLambda = multiplicarEscalarPorMatriz(X,mvalorp, firstMatrix.length);

        // Mostrar o resultado
        System.out.println("O produto do valor próprio pela matriz é: ");
        Distribuição.apresentarVetor(vetorLambda);

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


    public static double vetorproprio(double[][] matriz,int l1, int c1,int c2) {

        double lambda;
        int A=1;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio
        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio

        System.out.printf("Vetor próprio:");

        for (int i = 0; i < l1; i++) {

            for (int j = 0; j < c2; j++) {

                if (i == 0 && j == c2) System.out.printf("%.2f)", matA[i][j]);

                else if (i == 0 && j == 0) System.out.printf("(%.2f", matA[i][j]);

                else System.out.printf(";%.2f", matA[i][j]);

            }

        }
        System.out.print(")");

        System.out.println();

        System.out.println();


        lambda = maiorValorProprio(matB, matA);

        return lambda;

    }

    public static double maiorValorProprio(double[][] matB, double[][] matA) {

        //verifica qual é o modulo do maior valor e guarda o número

        int maiorn = 0;
        double maior = matB[0][0];

        for (int i = 0; i < matB.length; i++) {

            if (Math.abs(matB[i][i]) > maior) {

                maior = matB[i][i];
                maiorn = i;
            }

        }

        vetorProprio(maiorn, matA);

        return maior;

    }



    public static void vetorProprio(int coluna, double[][] matA) {

        double soma = 0;

        for (int i = 0; i < matA.length; i++) {

            soma += matA[i][coluna];

        }


    }


    public static void comportamentoAssintotico(double numero) {

        System.out.println();

        if (numero > 1) {

            System.out.println("-A população tenderá para +infinito");

        } else if (numero == 1) {

            System.out.println("-A população permanecerá constante");

        } else {

            System.out.println("-A população tenderá para 0");

        }

    }




    public static void apresentarProduto(double[][] produto) {


        for(double[] linha : produto) {

            for (double coluna : linha) {

                System.out.print(coluna + "    ");

            }

            System.out.println();

        }

    }


    public static double[] lerVetor(int n) {

        double[] A = new double[n];

        System.out.println("Escreva os valores do vetor desejados [dimensão n*1]");

        for (int i = 0; i < n; i++) {

            A[i] = in.nextDouble();

        }

        System.out.println();

        return A;

    }

    public static double[] multiplicarEscalarPorMatriz(double[] vetor, double mpvalor,int n) {


        for(int i=0;i<n;i++){

            vetor[i]=vetor[i]*mpvalor;

        }

        return vetor;

    }
    public static void imprimirMatriz(int c1,int l1,double [][]matriz) {

        for(int i=0;i<l1;i++){

            for(int j=0;j<c1;j++){

                System.out.printf("%.0f\t",matriz[i][j]);

            }

            System.out.println();

        }

        System.out.println();

    }
}
