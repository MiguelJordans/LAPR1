/**
 * @author Miguel Jordão
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DistribuiçãoFinal {


    public static Scanner ler = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException {

        String file_in = "C:\\Users\\MiguelJordão(1201487\\IdeaProjects\\Teste Vetores\\src\\array.txt";

        Scanner input = new Scanner(new File(file_in));

        Scanner in = new Scanner(new File(file_in));

        System.out.println();

        int n = 0;
        boolean Y= true;

        while (in.hasNextDouble()) {

            ++n;
            in.nextLine();
        }

        double[][] matriz = new double[n][n];

        System.out.println("Pretende introduzir a matriz inicial(true/false)?");
        Y=ler.nextBoolean();

        if(Y==true){
            matriz=lerMatriz(n,n);
        }

        else {
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    matriz[i][j] = input.nextDouble();
                }

                if (input.hasNextLine()) input.nextLine();

            }
        }

        System.out.println("Introduza o número de gerações(t/k)");
        int k = ler.nextInt();

        System.out.println();

        System.out.println("Introduza os valores do vetor");
        double[] X;
        X = lerVetor(n);

        System.out.printf("k=%d\n\n", k);

        System.out.println("Matriz de Leslie: ");
        apresentarMatriz(matriz);

        double[][] matrizGeraçao;
        double[] produto;
        double dimensão;
        double[] vetorNormalizado;
        double[][] matrizGeraçao_1;
        double[] produto_1;
        double[] guardaTaxa = new double[200];
        int t = 0;
        int counter=0;

        System.out.println("*****************************************");
        System.out.println();

        while (t <= k) {

            System.out.printf("Para a %dª geração:\n\n", t + 1);

            matrizGeraçao = leslieT(matriz, t);
            matrizGeraçao_1=leslieT(matriz,t+1);

            produto = multiplicarMatrizporVetor(matrizGeraçao, X);
            produto_1=multiplicarMatrizporVetor(matrizGeraçao_1,X);

            dimensão = dimensao(produto);

            vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

            System.out.println("Distruibuição não Normalizada:");
            apresentarVetor(produto);

            System.out.println("Distribuição Normalizada:");
            apresentarVetor(vetorNormalizado);

            System.out.print("Dimensão da população nessa geração= ");
            System.out.printf("%.2f\n", dimensão);

            System.out.println();

            System.out.printf("T(%d)/",t+1);
            escreverTaxaVariacao(produto,t,produto_1, guardaTaxa,counter);
            counter++;

            t++;

            System.out.println();
            System.out.println("*****************************************");
            System.out.println();

        }

        apresentarVetorTaxa(guardaTaxa);


    }


    public static void apresentarMatriz(double[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%.2f\t", matriz[i][j]);

            }

            System.out.println();

        }

        System.out.println();

    }


    public static double[] lerVetor(int n) {

        double[] A = new double[n];


        for (int i = 0; i < n; i++) {

            A[i] = ler.nextDouble();

        }

        System.out.println();

        return A;

    }


    public static double[] multiplicarMatrizporVetor(double[][] firstMatrix, double[] vector) {


        double[] resposta = new double[firstMatrix.length];

        int i=0;


        for(int linha = 0; linha<firstMatrix.length; linha++){

            for(int k = 0; k < firstMatrix.length; k++){

                resposta[i] += firstMatrix[linha][k] * vector[k];

            }

            i++;

        }


        return resposta;

    }


    public static double[][] multiplicarMatrizes(double[][] firstMatrix, double[][] secondMatrix) {

        double[][] produto = new double[firstMatrix.length][secondMatrix[0].length];


        for (int i = 0; i < firstMatrix.length; i++) {

            for (int j = 0; j < secondMatrix[0].length; j++) {

                for (int k = 0; k < firstMatrix[0].length; k++) {

                    produto[i][j] += firstMatrix[i][k] * secondMatrix[k][j];

                }

            }

        }

        return produto;

    }


    public static double dimensao(double[] produto) {

        double soma = 0;

        for (int j = 0; j < produto.length; j++) {

            soma += produto[j];


        }

        return soma;

    }


    public static double[] distribuiçaoNormalizada(double[] produto, double dimensao) {


        double[] vetorNormalizado = new double[produto.length];



        for (int j = 0; j < produto.length; j++) {

            vetorNormalizado[j] = (produto[j] / dimensao) * 100;

        }

        return vetorNormalizado;

    }


    public static double[][] leslieT(double[][] Xgeraçao, int k) {

        double[][] A = Xgeraçao;

        if (k > 0) {

            for (int i = 0; i < k; i++) {

                Xgeraçao = multiplicarMatrizes(Xgeraçao, A);

            }

            return Xgeraçao;

        } else return A;


    }


    public static void apresentarVetor(double[] vetor) {

        for (int j = 0; j < vetor.length; j++) {

            if  (j == vetor.length) System.out.printf("%.2f)", vetor[j]);

            else if (j == 0) System.out.printf("(%.2f", vetor[j]);

            else System.out.printf(";%.2f", vetor[j]);

        }

        System.out.print(")");

        System.out.println();

        System.out.println();

    }


    public static void escreverTaxaVariacao(double[] produto, int k,double []produto_1,double[]guardaTaxa,int counter) {



        System.out.print("Taxa de variação=");

        double taxaVariacao = taxaVariacao(produto,k,produto_1);

        System.out.printf("%.2f\n",taxaVariacao);

        guardaTaxa[counter]=taxaVariacao;


    }


    public static double taxaVariacao(double[] produto, int k,double[]produto_1) {


        double Nt;
        double Nt1;
        double taxa;

        Nt1 = dimensao(produto_1);
        Nt = dimensao(produto);

        taxa = Nt1 / Nt;

        return taxa;


    }

    public static void apresentarVetorTaxa(double[] vetor) {

        for (int j = 0; j < vetor.length; j++) {

            if (vetor[j] != 0) {

                if (j == vetor.length) System.out.printf("%.2f)", vetor[j]);

                else if (j == 0) System.out.printf("(%.2f", vetor[j]);

                else System.out.printf(";%.2f", vetor[j]);

            }
        }

        System.out.print(")");

        System.out.println();

        System.out.println();

    }

    public static double[][] lerMatriz(int c1, int l1) {

        double A[][] = new double[l1][c1];

        System.out.println("Introduza os valores desejados na matriz");


        for (int i = 0; i < l1; i++) {

            for (int j = 0; j < c1; j++) {

                A[i][j] = ler.nextDouble();

            }

        }

        System.out.println();

        return A;

    }

}
