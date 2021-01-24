import org.la4j.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.decomposition.EigenDecompositor;

/**
 * Classe respetiva ao cálculo do vetor próprio e valor próprio do modo interativo  (E apresentação do comportamento assimtótico)
 */


public class Vectores {

    /**
     * @param matriz matriz original
     * @param l variável de controlo (obtida no menu quando se esta a escolher uma opção)
     */

    public static void vetores(double[][] matriz, int l) {

        double mvalorp;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matA = mattD[0].toDenseMatrix().toArray(); //matA - vetor proprio, cálculo do vetor próprio

        double[][] matB = mattD[1].toDenseMatrix().toArray(); //matB - valor proprio, cálculo do valor próprio

        mvalorp = maiorValorProprio(matB); //obter o maior valor próprio

        double[] VetorColuna = VetorProprio(matA); //obter o vetor próprio ( correto ), pois antes era apenas uma matriz com valores respetivos ao vetor próprio
        double[] VetorNormalizado = NormalizarVetorProprio(VetorColuna); //normalização do vetor próprio

        if (l == 0) { //Caso no menu seja pedido para mostrar o output tod"o (case 4) , vai ser esta condição que vai controlar o mesmo output, ou seja, é dentro deste "if" que é possível dar print às informações desejadas

            System.out.printf("Vetor próprio:"); //Print do vetor próprio
            Apresentar.apresentarVetor(VetorNormalizado);

            System.out.printf("-lambda=%.4f\n", mvalorp); //Print do valor próprio

            comportamentoAssintotico(mvalorp); //Print do comportamento assimtótico
            System.out.println();

        } else if (l==1){ //Caso no menu seja pedido os testes unitários, é com esta condição que um dos testes é realizado

            Calculos.verificarVetorProprio(VetorNormalizado,mvalorp,matriz); //Teste Unitário para verificar o vetor próprio

        }


        switch (l) { //Variável de controlo para dar print ao conteúdo desejado ( escolhido no menu principal )

            case 9:

                comportamentoAssintotico(mvalorp); //Demonstrar o comportamento assimtótico

                break;

            case 11:

                System.out.printf("-lambda=%.4f\n", mvalorp); //Demonstrar o maior valor próprio

                break;

            case 12:

                System.out.printf("Vetor próprio:");
                Apresentar.apresentarVetor(VetorNormalizado); //Demonstrar o vetor próprio

                break;

        }

    }


    /**
     * @param matriz matriz original
     * @return return ao valor próprio
     */


    public static double vetorproprioTesteUnitario(double[][] matriz) { //Método utilizado nos testes unitários para o cálculo do valor próprio

        double lambda;

        Matrix a = new Basic2DMatrix(matriz);

        EigenDecompositor eigenD = new EigenDecompositor(a);
        Matrix[] mattD = eigenD.decompose();

        double[][] matB = mattD[1].toDenseMatrix().toArray();

        lambda = maiorValorProprio(matB);

        return lambda;

    }

    /**
     * @param matB matriz da qual se vai calcular o valor próprio
     * @return ao maior valor próprio
     */


    public static double maiorValorProprio(double[][] matB) {


        double maior = matB[0][0];

        for (int i = 0; i < matB.length; i++) {  //ciclo para verificar qual é o modulo do maior valor e guarda o número

            for (int j=0; j<matB[0].length;j++){

                if (Math.abs(matB[i][j]) > maior) { //Condição para obter o maior valor próprio

                    maior = matB[i][j]; //Guardar o maior valor próprio

                }

            }

        }

        return maior; //return ao maio valor próprio

    }

    /**
     * @param numero valor próprio obtido previamente
     */

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

    /**
     * @param matA matriz da qual se vai obter o vetor próprio (1ª coluna da matriz)
     * @return ao vetor próprio ( não normalizado )
     */

    public static double[] VetorProprio(double[][] matA) {

        double[] A = new double[matA.length];


        for (int i = 0; i < matA.length; i++) { //Guardar apenas os valores da primeira coluna da matriz matA

            A[i] = matA[i][0];

        }

        return A; //return ao vetor prórprio ( não normalizado )

    }

    /**
     * @param VetorColuna vetor próprio não normalizado
     * @return return ao vetor prórpio normalizado
     */

    public static double[] NormalizarVetorProprio(double[] VetorColuna) {

        double[] A = new double[VetorColuna.length];
        double soma = 0;

        for (int i = 0; i < VetorColuna.length; i++) { //ciclo para obter a soma de todos os valores existentes no vetor próprio

            soma += VetorColuna[i];

        }

        for (int j = 0; j < VetorColuna.length; j++) { //Ciclo para normalizar o vetor próprio

            A[j] = (VetorColuna[j] / soma) * 100;
            A[j] = Math.abs(A[j]);

        }

        return A; //return ao vetor próprio normalizado

    }

}