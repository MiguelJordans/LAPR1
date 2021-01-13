import org.la4j.Matrix;
import org.la4j.matrix.DenseMatrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;
public class compAssintotico_vetorproprio{
               /* mat1.length - linhas
               mat1[0].length - colunas
             */
    public static void main(String[] args) {
        double[][] mat1 = {{1.00, 2.10, 3.21, 4.00}, {0.30, 0, 0, 0}, {0, 0.40, 0, 0}, {0, 0, 0.90, 0}};
        int n = 40;

        double mvalorp;
        double[] percentagem = new double[mat1.length];

        mvalorp = calc_vetorProprio(mat1, percentagem);
        System.out.printf("maior valor proprio: %.4f\n", mvalorp);
        comportamentoAssintotico(mvalorp);

    }
    public static double calc_vetorProprio(double[][] matriz, double[] percentagem) {
    double lambda;
    Matrix a = new Basic2DMatrix(matriz);
    EigenDecompositor eigenD = new EigenDecompositor(a);
    Matrix [] mattD = eigenD.decompose();
    for (int i = 0; i < 2; i++){
        System.out.println(mattD[i]);
    }
    double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio
    double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio

    lambda = maiorValorProprio(matB, matA, percentagem);
    return lambda;

    }

    public static double maiorValorProprio(double[][] matB, double[][] matA, double[] percentagem) {
        //verifica qual é o modulo do maior valor e guarda o numero
        int maiorn = 0;
        double maior = matB[0][0];
        for (int i = 0; i < matB.length; i++){
            if(Math.abs(matB[i][i]) > maior){

                    maior = matB[i][i];
                    maiorn = i;
            }
        }
        vetorProprio(maiorn,matA,percentagem);
        return maior;
    }


    public static void vetorProprio(int coluna, double[][] matA, double[] percentagem){
        double soma = 0;

        for (int i=0; i < matA.length;i++){
            soma += matA[i][coluna];
        }
        for (int j=0; j < matA.length; j++){
            percentagem[j] = matA[j][coluna] / soma * 100;
        }
    }



    public static void comportamentoAssintotico(double numero) {
        if (numero > 1){
            System.out.println("a população tenderá para +infinito");
        }
        else if (numero == 1){
            System.out.println("A população permanecerá constante");
        }
        else{
            System.out.println("A população tenderá para 0");
        }
    }

}