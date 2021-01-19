import org.la4j.Matrix;
import org.la4j.decomposition.EigenDecompositor;
import org.la4j.matrix.dense.Basic2DMatrix;

import java.io.IOException;

public class VectoresNãoInterativo {

    public static void vetores(double[][] firstMatrix, boolean interativo, String ficheirosaida) throws IOException {

        double mvalorp;

        mvalorp = vetorproprio(firstMatrix, ficheirosaida);
        Grava.valorproprio(mvalorp, ficheirosaida);

    }

    private static double vetorproprio(double[][] matriz, String ficheirosaida) throws IOException {

        double lambda;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio
        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio

        double[] VetorColuna = Vectores.VetorProprio(matA);
        double[] VetorNormalizado = Vectores.NormalizarVetorProprio(VetorColuna);
        Grava.vetorproprio(VetorNormalizado, ficheirosaida);


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

}
