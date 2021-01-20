import org.la4j.Matrix;
import org.la4j.decomposition.EigenDecompositor;
import org.la4j.matrix.dense.Basic2DMatrix;

import java.io.IOException;

public class VetoresNaoInterativos {
    public static double[] vetorproprio(double[][] matriz, String nomeficheiro) throws IOException {


        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio

        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio

        double[] VetorColuna = VetorProprio(matA);
        double[] VetorNormalizado = NormalizarVetorProprio(VetorColuna);

        double lambda = maiorValorProprio(matB);



        Grava.valorproprio(lambda,nomeficheiro);
        Grava.vetorproprio(VetorNormalizado,nomeficheiro);



        return VetorNormalizado;





    }
    public static double[] VetorProprio(double[][] matA) {

        double[] A = new double[matA.length];

        for (int i = 0; i < matA.length; i++) {

            A[i] = matA[i][0];

        }

        return A;

    }

    public static double[] NormalizarVetorProprio(double[] VetorColuna) {

        double[] A = new double[VetorColuna.length];
        double soma = 0;

        for (int i = 0; i < VetorColuna.length; i++) {
            soma += VetorColuna[i];
        }

        for (int j = 0; j < VetorColuna.length; j++) {
            A[j] = (VetorColuna[j] / soma) * 100;
            A[j] = Math.abs(A[j]);
        }

        return A;

    }

    public static double maiorValorProprio(double[][] matB) {

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
