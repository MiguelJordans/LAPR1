import java.util.Scanner;
import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;

public class Vectores {

    public static Scanner in = new Scanner(System.in);

    public static void vetores(double[][] firstMatrix) {

        double mvalorp;

        mvalorp = vetorproprio(firstMatrix);

        System.out.printf("-lambda=%.4f\n", mvalorp);

        comportamentoAssintotico(mvalorp);
        System.out.println();

    }

    public static double vetorproprio(double[][] matriz) {

        double lambda;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio
        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio

        int c=0;
        double [] Vetor = new double[matriz.length];

        System.out.println("Vetor Próprio Bidimensional (Estudar para corrigir os valores)");
        Distribuição.apresentarMatriz(matA);

        System.out.printf("Vetor próprio:");


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


        lambda = maiorValorProprio(matB, matA);

        return lambda;

    }

    public static double maiorValorProprio(double[][] matB, double[][] matA) {

        //verifica qual é o modulo do maior valor e guarda o número

        double maior = matB[0][0];

        for (int i = 0; i < matB.length; i++) {

            if (Math.abs(matB[i][i]) > maior) {

                maior = matB[i][i];


            }

        }

        return maior;

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

}