import java.util.Arrays;

/**
 * Classe encarregue à maior parte dos outputs do programa
 */

public class Apresentar {


    /**
     * @param matriz que vai ser apresentado
     */

    public static void apresentarMatriz(double[][] matriz) {

        for (int i = 0; i < matriz.length; i++) { //Ciclos para correrem os endereços de memória existentes na matriz

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%.2f\t", matriz[i][j]); //Print ao respetivo valor guardado na matriz (respetivo endereço de memória)

            }

            System.out.println();

        }

        System.out.println();

    }


    /**
     * @param vetor que vai ser apresentado
     */

    public static void apresentarVetor(double[] vetor) {

        for (int j = 0; j < vetor.length; j++) { //Tal como explicado em cima, só que neste caso apenas é preciso um ciclo pois trata se de um array unidimensional , um vetor

            if (j == vetor.length)
                System.out.printf("%.2f)", vetor[j]); //Respetivas condições para dar print ao vetor com uma certa formatação

            else if (j == 0) System.out.printf("(%.2f", vetor[j]);

            else System.out.printf(";%.2f", vetor[j]);

        }

        System.out.print(")");

        System.out.println();

        System.out.println();

    }


    /**
     * @param vetor vetor que vai ser apresentado
     */

    public static void apresentarTaxa(double[] vetor) { //Neste caso este módulo esta encarregue a dar print tanto à taxa de variação , e para tal é preciso uma determinada formatação

        int t = 0; //Varíavel que vai servir como geração para dar print aos respetivos valores


        for (int j = 0; j < vetor.length; j++) { //Ciclo para correr os valores existentes no vetor

            if (vetor[j] != 0) {

                System.out.printf("(%d ; %.2f)\n", t, vetor[j]); //Função para dar print aos valores com uma determinada formatação
                t++; //Incremento da variável geração

            }

        }

        System.out.println();

    }

    /**
     * @param vetor vetor que vai ser apresentado
     * @param k     valor de gerações introduzido inicialmente
     */

    public static void apresentarDimensão(double[] vetor, int k) {

        int t = 0; //Variável que vai servir como contador de gerações, isto é , variável que vai ser utilizada como geração para dar print aos valores respetivos
        int counter = 0; //Variável de controlo que vai servir para dar print a um caso especial


        for (int j = 0; j < vetor.length; j++) { //Ciclo para correr os valores existentes no vetor

            if (vetor[j] != 0) {

                System.out.printf("(%d ; %.2f)\n", t, vetor[j]); //Função para dar print aos valores com uma determinada formatação
                t++; //Incremento da variável
                counter++; //Incremento da variável de controlo

            }

        }

        if (counter != k + 1)
            System.out.printf("\nA população extingiu-se a partir da %dª geração.\n", counter); //Caso não deia print às k gerações, ou seja caso no output deste módulo não seja apresentado as gerações  todas com os respetivos valores, é deduzido que a população tenha se extinguido numa determinada geração, na geração counter

        System.out.println();

    }

    /**
     * @param Distribuição matrizes que contém todos os valores da distribuição nao normalizada ou a distribuição normalizada
     */

    public static void apresentarDistribuição(double[][] Distribuição) {

        int t = 0; //Varíavel que vai servir como geração para dar print aos respetivos valores


        for (int i = 0; i < Distribuição.length; i++) { //Ciclos para correrem os valores existentes na matriz

            for (int j = 0; j < Distribuição[i].length; j++) {

                if (Distribuição[i].length > 0 && Distribuição[i][j] != 0) { //Para dar print aos valores da matriz a mesma tem de apresentar pelo menos 1 valor por coluna e os mesmos têm de ser diferentes de 0

                    if (j == 0) { //Condições para dar print com uma determinada formatação

                        System.out.printf("(%d ; %.2f ", t, Distribuição[i][j]);
                        t++;

                    } else System.out.printf("; %.2f ", Distribuição[i][j]);

                }
            }

            if (Distribuição[i][0] != 0) System.out.printf(")\n");

        }

    }

    /**
     * @param A primeiro vetor
     * @param B segundo vetor
     * @return return a uma variável do tipo boolean com o valor correspondente à comparação dos dois vetores
     */
    public static boolean isIgual(double[] A, double[] B) {

        boolean igual;

        if (Arrays.equals(A, B)) igual = false; //Caso os dois vetores sejam iguais , a variável "igual" vai ficar com um determinado valor para depois apresentar noutro módulo o respetivo output desejado
        else if(A.length==1 && Arrays.equals(A,B)) igual=false; //Condição para quando o vetor apenas tiver um elemento
        else  igual = true; //Caso os dois vetores sejam diferentes a variavel fica com o valor para dar o output respetivo a esta comparação

        return igual; //return à variável com o valor respetivo à comparação

    }
}