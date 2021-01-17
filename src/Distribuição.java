import java.util.Scanner;

public class Distribuição {

    public static Scanner ler = new Scanner(System.in);

    public static void ApresentarDist(double[][] matriz, int k, double[] X){


        double[][] matrizGeraçao;
        double[] produto;
        double dimensão;
        double[] vetorNormalizado;
        double[][] matrizGeraçao_1;
        double[] produto_1;
        double[] guardaTaxa = new double[200];
        double[] guardaDimensão = new double[200];
        int t = 0;
        int counter = 0;
        int i = 0;


        System.out.println("*****************************************");
        System.out.println();

        while (t <= k) {

            System.out.printf("Para a %dª geração:\n\n", t + 1);


            if (t>1) {

                matrizGeraçao = leslieT(matriz, t);
                matrizGeraçao_1 = leslieT(matriz, t + 1);

                produto = multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                System.out.println("Distruibuição não Normalizada:");
                apresentarVetor(produto);

                System.out.println("Distribuição Normalizada:");
                apresentarVetor(vetorNormalizado);

                System.out.print("Dimensão da população nessa geração= ");
                System.out.printf("%.2f\n", dimensão);

                System.out.println();

                System.out.printf("T(%d)/", t + 1);
                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter);
                counter++;

                t++;

                guardarDimensão(guardaDimensão,dimensão,i);
                i++;

                System.out.println();
                System.out.println("*****************************************");
                System.out.println();

            }


            else if(t==1){

                matrizGeraçao = leslieT(matriz, t-1);
                matrizGeraçao_1 = leslieT(matriz, t);

                produto = multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                System.out.println("Distruibuição não Normalizada:");
                apresentarVetor(produto);

                System.out.println("Distribuição Normalizada:");
                apresentarVetor(vetorNormalizado);

                System.out.print("Dimensão da população nessa geração= ");
                System.out.printf("%.2f\n", dimensão);

                System.out.println();

                System.out.printf("T(%d)/", t + 1);
                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter);
                counter++;

                t++;

                guardarDimensão(guardaDimensão,dimensão,i);
                i++;

                System.out.println();
                System.out.println("*****************************************");
                System.out.println();
            }


              else {

                matrizGeraçao = leslieT(matriz, t);
                matrizGeraçao_1 = leslieT(matriz, t + 1);

                produto = X;
                produto_1 = multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                System.out.println("Distruibuição não Normalizada:");
                apresentarVetor(produto);

                System.out.println("Distribuição Normalizada:");
                apresentarVetor(vetorNormalizado);

                System.out.print("Dimensão da população nessa geração= ");
                System.out.printf("%.2f\n", dimensão);

                System.out.println();

                System.out.printf("T(%d)/", t + 1);
                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter);
                counter++;

                t++;

                guardarDimensão(guardaDimensão,dimensão,i);
                i++;


                System.out.println();
                System.out.println("*****************************************");
                System.out.println();


            }

        }

        Vectores.vetores(matriz);

        System.out.println("Numero total de individuos");
        System.out.printf("(t ; delta_t)\n");
        apresentarTaxaOUDimensão(guardaTaxa);

        System.out.println("Crescimento da população");
        System.out.printf("(t ; Nt)\n");
        apresentarTaxaOUDimensão(guardaDimensão);

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

    public static void apresentarTaxaOUDimensão(double[] vetor) {

        int t=0;

        for (int j = 0; j < vetor.length; j++) {

            if (vetor[j] != 0) {

                System.out.printf("(%d ; %.2f)\n",t,vetor[j]);
                t++;

            }

        }

        System.out.println();

    }

    public static void guardarDimensão(double[]guardarDimensão, double dimensão,int i) {

        guardarDimensão[i]=dimensão;

    }

}