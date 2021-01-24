
/**
 * Esta classe esta encarregue ao cálculo de todos os valores necessários para a classe distribuição (e outros) possam funcionar como deve ser
 */

public class Calculos {


    /**
     * @param Xgeraçao matriz inicial que vai sofrer alterações nesta classe, pois pela fórmula é necessário multiplicar a mesma for si K-1 vezes consoante a geração que isto esta a acontecer
     * @param k geração atual no momento em que esta função é chamada para a realização dos respetivos cálculos
     * @return à matriz inicial após ser multiplicada por si mesma K-1 vezes
     */

    public static double[][] leslieT(double[][] Xgeraçao, int k) {

        double[][] A = Xgeraçao;

        if (k > 1) { //O "k" tem de ser maior que 1 , uma vez que esta função só deveria dar run quando estamos na 3ª geração, ou a cima

            for (int i = 1; i < k; i++) { //Realizar a multiplicação k-1 vezes

                Xgeraçao = multiplicarMatrizes(Xgeraçao, A); //Chamar o módulo de multiplicação de matrizes

            }

            return Xgeraçao; //return à matriz após sofrer as alterações necessárias

        } else return A; //Caso o k não seja superior a 1, ou seja caso se trate  da 1ª geração ou da 2ª geração , esta não vai sofrer alterações logo vai dar return à matriz que foi transportada como parâmetro para esta classe

    }


    /**
     * @param A primeira matriz para a multiplicação
     * @param B segunda matriz para a multiplicação
     * @return ao produto das duas matrizes iniciais
     */

        public static double[][] multiplicarMatrizes(double[][] A, double[][] B) {

            double[][] produto = new double[A.length][B[0].length]; //Matriz que vai ser originada através da multiplicação das duas matrizes originais


            for (int i = 0; i < A.length; i++) { //Ciclos para correrem pelos valores existentes em cada matriz para que seja possível aplicar a multiplicação correta (ou seja aplicar a fórmula de multiplicação de matrizes)

                for (int j = 0; j < B[0].length; j++) {

                    for (int k = 0; k < A[0].length; k++) {

                        produto[i][j] += A[i][k] * B[k][j]; //Soma dos valores obtidos após a multiplicação de cada entrada de uma linha pela respetiva entrada de cada coluna

                    }

                }

            }

            return produto; //Return à matriz "produto" (À matriz gerada através da multiplicação das matrizes originais)

        }


    /**
     * @param A matriz original
     * @param vector vetor para a realização da multiplicação
     * @return return ao produto da matriz pelo vetor
     */

    public static double[] multiplicarMatrizporVetor(double[][] A, double[] vector) {


        double[] produto = new double[A.length]; //Vetor produto obtido através da multiplicação da matriz pelo vetor que vai ser realizado nos ciclos "for"
        int i=0;


        for(int j = 0; j<A.length; j++){ //Ciclos para correrem os valores que existem na memória do vetor/matriz

            for(int k = 0; k < A.length; k++){

                produto[i] += A[j][k] * vector[k]; //Produto respetivo à as entradas solicitas nos ciclos (para obter uma correta multiplicação entre a matriz e o vetor)

            }

            i++; //Incremento para guardar em memória do vetor produto o resultado entra a multiplicação do vetor com a matriz

        }


        return produto; //Return ao vetor produto obtido neste módulo

    }

    /**
     * @param vetorProprio Vetor próprio originado da matriz inicial
     * @param lambda Valor próprio originado da matriz inicial
     * @param matriz matriz inicial introduzida
     */

    public static void verificarVetorProprio(double[]vetorProprio, double lambda,double[][]matriz) {

         boolean check; //Variável controlo que vai possibilitar o "print" da frase desejada

         double[]A=multiplicarMatrizporVetor(matriz,vetorProprio); //Declaração do vetor originado através da multiplicação de uma matriz por um vetor
         double[]B=multiplicarVetorporValorProprio(vetorProprio,lambda); //Declaração do vetor originado através da multiplicação do vetor pelo valor próprio

         check = Apresentar.isIgual(A,B); //Função para verificar se os dois vetores são iguais

         if (check) System.out.println("\nO vetor próprio esta bem calculado\n"); //Caso os vetores sejam iguais (A e B) o mesmo esta bem calculado
         else System.out.println("\nO vetor próprio está mal calculado\n"); //Caso os vetores sejam diferentes (A e B) o mesmo foi mal calculado

            System.out.printf("\nMatriz de leslie a mutiplicar pelo vetor:\n"); //Print do resultado da multiplicação da matriz inicial pelo vetor
            Apresentar.apresentarVetor(A);

            System.out.printf("\nVetor Próprio a multiplicar pelo valor próprio:\n");//Print do resultado da multiplicação do vetor pelo valor prórprio
            Apresentar.apresentarVetor(B);

    }


    /**
     * @param vetor vetor próprio que vai sofrer alterações
     * @param lambda valor próprio que vai ser utilizado na multiplicação do vetor por um escalar
     * @return
     */

    public static double[] multiplicarVetorporValorProprio(double[] vetor, double lambda) {

            for(int k = 0; k < vetor.length; k++){ //Ciclo para correr os valores existentes no vetor

                 vetor[k] = vetor[k]*lambda; //Multiplicação do valor correspondente ao respetivo endereço de memória por um escalar
            }


        return vetor; //Return ao vetor após a multiplicação pelo escalar

    }

}