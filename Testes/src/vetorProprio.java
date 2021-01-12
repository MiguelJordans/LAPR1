import java.util.Scanner;
import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;

public class vetorProprio {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduza o número de linhas e colunas, respetivamente:");
        int l1 = in.nextInt(), c1 = in.nextInt();

        double[][] firstMatrix = new double[l1][c1];

        System.out.println("Introduza os valores desejados na matriz");
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < c1; j++) {
                firstMatrix[i][j] = in.nextInt();
            }
        }

        Matrix a = new Basic2DMatrix(firstMatrix);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] Vetor = eigenD.decompose();


        System.out.println();

         //Função para obter o array unidimensional do vetor próprio
        double matA[][] = Vetor[0].toDenseMatrix().toArray();

        //Função para obter o array unidimensional do valor próprio
        double matB[][] = Vetor[1].toDenseMatrix().toArray();


        System.out.println("Vetor Próprio:");
        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {
                System.out.printf("%.4f\n", matA[i][j]);
            }
        }

        System.out.println();

        double lambda=matB[0][0];

        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 2; j++) {

                if(lambda<matB[i][j])
                 lambda=matB[i][j];
            }

        }
        System.out.println("O valor próprio é:" +lambda);
    }
}