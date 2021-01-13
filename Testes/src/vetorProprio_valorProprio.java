import java.util.Scanner;
import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;

public class vetorProprio_valorProprio {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduza o número de linhas e colunas, respetivamente:");
        int l1 = in.nextInt(), c1 = in.nextInt();

        double[][] firstMatrix;
        firstMatrix = lerMatriz(l1, c1);

        double[] percentage = new double[firstMatrix.length];

        double mvalorp;
        mvalorp = vetorproprio(firstMatrix, percentage,l1,c1);

        Matrix a = new Basic2DMatrix(firstMatrix);
        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] Vetor = eigenD.decompose();

        System.out.println();
        System.out.printf("-O maior valor próprio é: %.4f\n", mvalorp);

        comportamentoAssintotico(mvalorp);

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

    public static double vetorproprio(double[][] matriz, double[] percentagem,int l1,int c1) {

        double lambda;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio
        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio

        System.out.println("Vetor Próprio:");
        for (int i = 0; i < l1; i++) {

            for (int j = 0; j < c1; j++) {
                if(i==l1 && j==c1) System.out.printf("%.2f)", matA[i][j]);
                else if(i==0 && j==0) System.out.printf("(%.2f", matA[i][j]);

                else  System.out.printf(";%.2f", matA[i][j]);
            }
        }
        System.out.printf(")");
        System.out.println();

        lambda = maiorValorProprio(matB, matA, percentagem);

        return lambda;

    }

    public static double maiorValorProprio(double[][] matB, double[][] matA, double[] percentagem) {
        //verifica qual é o modulo do maior valor e guarda o numero
        int maiorn = 0;
        double maior = matB[0][0];
        for (int i = 0; i < matB.length; i++) {
            if (Math.abs(matB[i][i]) > maior) {

                maior = matB[i][i];
                maiorn = i;
            }
        }
        vetorProprio(maiorn, matA, percentagem);
        return maior;
    }

    public static void vetorProprio(int coluna, double[][] matA, double[] percentagem) {
        double soma = 0;

        for (int i = 0; i < matA.length; i++) {
            soma += matA[i][coluna];
        }
        for (int j = 0; j < matA.length; j++) {
            percentagem[j] = matA[j][coluna] / soma * 100; // isto pode ser feito de forma mais fácil não precisa de /soma * 100 uma vez que já esta normalizado desde o início ou seja podemos não fazer percentagem ( mudar mais tarde )
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
}