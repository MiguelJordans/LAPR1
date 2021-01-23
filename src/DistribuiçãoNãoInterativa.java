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

                dimensão = Distribuição.dimensao(produto);

                vetorNormalizado = Distribuição.distribuiçaoNormalizada(produto, dimensão);

                taxa = Distribuição.taxaVariacao(produto, produto_1, k);

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


            } else if (t == 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t - 1);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = Distribuição.dimensao(produto);

                vetorNormalizado = Distribuição.distribuiçaoNormalizada(produto, dimensão);

                taxa = Distribuição.taxaVariacao(produto, produto_1, k);

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


            } else {

                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = X;
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = Distribuição.dimensao(produto);

                vetorNormalizado = Distribuição.distribuiçaoNormalizada(produto, dimensão);

                taxa = Distribuição.taxaVariacao(produto, produto_1, k);

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

        if (P == 100) {

            Grava.graficototal(k, guardaDimensão);
            Grava.graficovariacao(k, guardaTaxa);
            Grava.graficonormalizada(k, D, X.length);
            Grava.graficoNaoNormalizada(k, E, X.length);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

}