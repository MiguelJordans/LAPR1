import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;

import java.io.IOException;

public class Vectores {

<<<<<<< HEAD
    public static void vetores(double[][] firstMatrix,int l) {

        double mvalorp;

        mvalorp = vetorproprio(firstMatrix,l);

       if(l==0) {
           System.out.printf("-lambda=%.4f\n", mvalorp);
           comportamentoAssintotico(mvalorp);
           System.out.println();
       }

       switch (l){
           case 9:
               comportamentoAssintotico(mvalorp);
               break;
           case 11:
               System.out.printf("-lambda=%.4f\n", mvalorp);
               break;
           case 12:
               vetorproprio(firstMatrix,l);
               break;
       }
    }

    private static double vetorproprio(double[][] matriz,int l) {
=======
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
>>>>>>> f0aa3b9564daf414e1d874d54f494d8470573360

        double lambda;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio
        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio
        if (interativo) {
            System.out.println("Vetor Próprio Bidimensional (Estudar para corrigir os valores)");
            Apresentar.apresentarMatriz(matA);

<<<<<<< HEAD
        if(l==0){
            System.out.println("Vetor Próprio Bidimensional (Estudar para corrigir os valores)");
            Apresentar.apresentarMatriz(matA);

            System.out.printf("Vetor próprio:");

            Apresentar.apresentarVetorBidimensional(matriz,matA);
        }

        else if(l==12){
            System.out.println("Vetor Próprio Bidimensional (Estudar para corrigir os valores)");
            Apresentar.apresentarMatriz(matA);

            System.out.printf("Vetor próprio:");

            Apresentar.apresentarVetorBidimensional(matriz,matA);
        }
=======
            System.out.printf("Vetor próprio:");

            Apresentar.apresentarVetorBidimensional(matriz, matA);

>>>>>>> f0aa3b9564daf414e1d874d54f494d8470573360

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