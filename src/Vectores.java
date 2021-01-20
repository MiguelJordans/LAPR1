import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;

public class Vectores {

    public static void vetores(double[][] firstMatrix, int l) {

        double mvalorp;

        mvalorp = vetorproprio(firstMatrix, l);

        if (l == 0) {
            System.out.printf("-lambda=%.4f\n", mvalorp);
            comportamentoAssintotico(mvalorp);
            System.out.println();
        }

        switch (l) {
            case 9:
                comportamentoAssintotico(mvalorp);
                break;
            case 11:
                System.out.printf("-lambda=%.4f\n", mvalorp);
                break;
            case 12:
                vetorproprio(firstMatrix, l);
                break;
        }
    }

    public static double vetorproprio(double[][] matriz, int l) {

        double lambda;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio
        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio

        double[] VetorColuna = VetorProprio(matA);
        double[] VetorNormalizado = NormalizarVetorProprio(VetorColuna);

        if (l == 0) {
            System.out.printf("Vetor próprio:");
            Apresentar.apresentarVetor(VetorNormalizado);

        } else if (l == 12) {

            System.out.printf("Vetor próprio:");
            Apresentar.apresentarVetor(VetorNormalizado);
        }

        lambda = maiorValorProprio(matB);

        return lambda;

    }

    public static double maiorValorProprio(double[][] matB) {

        //verifica qual é o modulo do maior valor e guarda o número

        double maior = matB[0][0];

        for (int i = 0; i < matB.length; i++) {
            for (int j=0; j<matB[0].length;j++){
                if (Math.abs(matB[i][j]) > maior) {

                    maior = matB[i][j];


                }
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
}