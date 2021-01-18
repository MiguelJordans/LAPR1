import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;

import java.io.IOException;

public class Vectores {

    public static void vetores(double[][] firstMatrix,boolean interativo) throws IOException {

        double mvalorp;

        mvalorp = vetorproprio(firstMatrix,false);
        if (interativo) {
            System.out.printf("-lambda=%.4f\n", mvalorp);

            comportamentoAssintotico(mvalorp);
            System.out.println();
        }else {
            Grava.valorproprio(mvalorp);
        }


    }

    private static double vetorproprio(double[][] matriz,boolean interativo) throws IOException {

        double lambda;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio
        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio
        if (interativo) {
            System.out.println("Vetor Próprio Bidimensional (Estudar para corrigir os valores)");
            Apresentar.apresentarMatriz(matA);

            System.out.printf("Vetor próprio:");

            Apresentar.apresentarVetorBidimensional(matriz, matA);


        }else {
            double[] vetorprorio = new double[5];
            Grava.vetorproprio(vetorprorio);

        }

        lambda = maiorValorProprio(matB);
        return lambda;

    }

    private static double maiorValorProprio(double[][] matB) {

        //verifica qual é o modulo do maior valor e guarda o número

        double maior = matB[0][0];

        for (int i = 0; i < matB.length; i++) {

            if (Math.abs(matB[i][i]) > maior) {

                maior = matB[i][i];


            }

        }

        return maior;

    }


    private static void comportamentoAssintotico(double numero) {

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