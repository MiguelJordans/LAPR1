public class Distribuição {

    public static void ApresentarDist(double[][] matriz, int k, double[] X) {


        double[][] matrizGeraçao;
        double[] produto;
        double dimensão;
        double[] vetorNormalizado;
        double[][] matrizGeraçao_1;
        double[] produto_1;
        double[] guardaTaxa = new double[200];
        double[] guardaDimensão = new double[200];
        double[][] D = new double[200][2000];
        double[][] E = new double[200][2000];
        int t = 0;
        int counter = 0;
        int i = 0;

        System.out.println("*****************************************");
        System.out.println();

        while (t <= k) {

            System.out.printf("Para a %dª geração:\n\n", t + 1);

            if (t > 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                System.out.println("Distruibuição não Normalizada:");
                Apresentar.apresentarVetor(produto);

                System.out.println("Distribuição Normalizada:");
                Apresentar.apresentarVetor(vetorNormalizado);

                System.out.print("Dimensão da população nessa geração= ");
                System.out.printf("%.2f\n", dimensão);

                System.out.println();

                System.out.printf("T(%d)/", t + 1);
                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter);
                counter++;

                t++;

                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E,produto,i);
                i++;

                System.out.println();
                System.out.println("*****************************************");
                System.out.println();

            } else if (t == 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t - 1);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                System.out.println("Distruibuição não Normalizada:");
                Apresentar.apresentarVetor(produto);

                System.out.println("Distribuição Normalizada:");
                Apresentar.apresentarVetor(vetorNormalizado);

                System.out.print("Dimensão da população nessa geração= ");
                System.out.printf("%.2f\n", dimensão);

                System.out.println();

                System.out.printf("T(%d)/", t + 1);
                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter);
                counter++;

                t++;

                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E,produto,i);
                i++;

                System.out.println();
                System.out.println("*****************************************");
                System.out.println();

            } else {

                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = X;
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                System.out.println("Distruibuição não Normalizada:");
                Apresentar.apresentarVetor(produto);

                System.out.println("Distribuição Normalizada:");
                Apresentar.apresentarVetor(vetorNormalizado);

                System.out.print("Dimensão da população nessa geração= ");
                System.out.printf("%.2f\n", dimensão);

                System.out.println();

                System.out.printf("T(%d)/", t + 1);
                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter);
                counter++;

                t++;

                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E,produto,i);
                i++;


                System.out.println();
                System.out.println("*****************************************");
                System.out.println();


            }

        }

        Vectores.vetores(matriz);

        System.out.println("Crescimento da população");
        System.out.printf("(t ; delta_t)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

        System.out.println("Numero total de individuos");
        System.out.printf("(t ; Nt)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaDimensão);

        Apresentar.apresentarDistribuição(E);

        Apresentar.apresentarDistribuição(D);

    }


    private static double dimensao(double[] produto) {

        double soma = 0;

        for (int j = 0; j < produto.length; j++) {

            soma += produto[j];


        }

        return soma;

    }


    private static double[] distribuiçaoNormalizada(double[] produto, double dimensao) {


        double[] vetorNormalizado = new double[produto.length];


        for (int j = 0; j < produto.length; j++) {

            vetorNormalizado[j] = (produto[j] / dimensao) * 100;

        }

        return vetorNormalizado;

    }


    private static void escreverTaxaVariacao(double[] produto, int k, double[] produto_1, double[] guardaTaxa, int counter) {


        System.out.print("Taxa de variação=");

        double taxaVariacao = taxaVariacao(produto, k, produto_1);

        System.out.printf("%.2f\n", taxaVariacao);

        guardaTaxa[counter] = taxaVariacao;

    }


    private static double taxaVariacao(double[] produto, int k, double[] produto_1) {


        double Nt;
        double Nt1;
        double taxa;

        Nt1 = dimensao(produto_1);
        Nt = dimensao(produto);

        taxa = Nt1 / Nt;

        return taxa;

    }


    private static void guardarDimensão(double[] guardarDimensão, double dimensão, int i) {

        guardarDimensão[i] = dimensão;

    }


    private static void guardarDistribuiçãoNormalizada(double[][] D, double[] vetorNormalizado, int i) {

        for (int j = 0; j < vetorNormalizado.length; j++) {

            D[i][j]=vetorNormalizado[j];

        }

    }


    private static void guardarDistribuiçãoNãoNormalizada(double[][] E, double[] produto, int i) {

        for (int j = 0; j < produto.length; j++) {

            E[i][j]=produto[j];

        }

    }

}