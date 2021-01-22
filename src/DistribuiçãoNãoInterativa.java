import java.io.IOException;

public class DistribuiçãoNãoInterativa {

    public static void ApresentarDist(double[][] matriz, int k, double[] X, int l, String nomeFicheiroSaida, boolean vecProprio, boolean dimPopulacao, boolean varPopGeracoes) throws IOException {


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
        int P = l;
        int classes = X.length;
        double taxa;


        while (t <= k) {

            if (t > 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);


                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                taxa = taxaVariacao(produto, k, produto_1);

                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter, P);

                counter++;


                t++;

                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E, produto, i);
                i++;


            } else if (t == 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t - 1);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);


                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);
                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter, P);

                counter++;


                t++;


                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E, produto, i);

                i++;


            } else {

                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = X;
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);
                escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter, P);

                counter++;

                t++;

                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E, produto, i);
                i++;


            }

        }
        Grava.gravaTudo();
        Grava.matriz(k, matriz, nomeFicheiroSaida);
        if (dimPopulacao) {
            Grava.total(guardaDimensão, nomeFicheiroSaida, k + 1);
        }
        if (varPopGeracoes) {
            Grava.variacao(guardaTaxa, nomeFicheiroSaida, k + 1);
        }

        Grava.naonormalizado(E, nomeFicheiroSaida, k + 1, classes);

        Grava.normalizado(D, nomeFicheiroSaida, k + 1, classes);

        if (vecProprio) {
            VetoresNaoInterativos.vetorproprio(matriz, nomeFicheiroSaida);
        }

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


    private static void escreverTaxaVariacao(double[] produto, int k, double[] produto_1, double[] guardaTaxa, int counter, int P) {

        double taxaVariacao = taxaVariacao(produto, k, produto_1);


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

            D[i][j] = vetorNormalizado[j];

        }

    }


    private static void guardarDistribuiçãoNãoNormalizada(double[][] E, double[] produto, int i) {

        for (int j = 0; j < produto.length; j++) {

            E[i][j] = produto[j];

        }

    }

    public static void crescimento(double[] guardaTaxa, String ficheirosaida, int k) throws IOException {
        Grava.variacao(guardaTaxa, ficheirosaida, k);

    }


    public static void distribuiçãoNormalizada(double[][] D, String ficheirosaida, int k, int classes) throws IOException {

        Grava.normalizado(D, ficheirosaida, k, classes);

    }

    public static void distribuiçãoNãoNormalizada(double[][] E, String ficheirosaida, int k, int classes) throws IOException {

        Grava.naonormalizado(E, ficheirosaida, k, classes);


    }

}