import java.io.IOException;

public class DistribuiçãoNãoInterativa {

    public static void ApresentarDist(double[][] matriz, int k, double[] X, int l, String nomeFicheiroSaida, boolean vecProprio, boolean dimPopulacao, boolean varPopGeracoes) throws IOException {


        double[][] matrizGeraçao;
        double[] produto;
        double dimensão;
        double[] vetorNormalizado;
        double[][] matrizGeraçao_1;
        double[] produto_1;
        double[] guardaTaxa = new double[201];
        double[] guardaDimensão = new double[201];
        double[][] D = new double[201][2000];
        double[][] E = new double[201][2000];
        int t = 0;
        int i = 0;
        int classes = X.length;
        double taxa;


        while (t <= k) {

            if (t > 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = Distribuição.dimensao(produto);

                vetorNormalizado = Distribuição.distribuiçaoNormalizada(produto, dimensão);

                taxa = Distribuição.taxaVariacao(produto,produto_1,dimensão);

                t++;

                Distribuição.guardarDimensão(guardaDimensão, dimensão, i);
                Distribuição.guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                Distribuição.guardarDistribuiçãoNãoNormalizada(E, produto, i);
                Distribuição.guardarTaxa(guardaTaxa,taxa,i);
                i++;


            } else if (t == 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t+1);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = Distribuição.dimensao(produto);

                vetorNormalizado = Distribuição.distribuiçaoNormalizada(produto, dimensão);

                taxa = Distribuição.taxaVariacao(produto,produto_1,dimensão);

                t++;

                Distribuição.guardarDimensão(guardaDimensão, dimensão, i);
                Distribuição.guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                Distribuição.guardarDistribuiçãoNãoNormalizada(E, produto, i);
                Distribuição.guardarTaxa(guardaTaxa,taxa,i);
                i++;


            } else if(t<100) {

                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = X;
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = Distribuição.dimensao(produto);

                vetorNormalizado = Distribuição.distribuiçaoNormalizada(produto, dimensão);

                taxa = Distribuição.taxaVariacao(produto,produto_1,dimensão);

                if(dimensão==0){
                    produto=Ler.resetarVetor(produto);
                    vetorNormalizado = Ler.resetarVetor(vetorNormalizado);
                    taxa = 0;
                }

                t++;

                Distribuição.guardarDimensão(guardaDimensão, dimensão, i);
                Distribuição.guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                Distribuição.guardarDistribuiçãoNãoNormalizada(E, produto, i);
                Distribuição.guardarTaxa(guardaTaxa,taxa,i);
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

    private static void crescimento(double[] guardaTaxa, String ficheirosaida, int k) throws IOException {

        Grava.variacao(guardaTaxa, ficheirosaida, k);

    }


    private static void distribuiçãoNormalizada(double[][] D, String ficheirosaida, int k, int classes) throws IOException {

        Grava.normalizado(D, ficheirosaida, k, classes);

    }


    private static void distribuiçãoNãoNormalizada(double[][] E, String ficheirosaida, int k, int classes) throws IOException {

        Grava.naonormalizado(E, ficheirosaida, k, classes);

    }


}