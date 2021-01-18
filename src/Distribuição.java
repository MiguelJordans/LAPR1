<<<<<<< HEAD
import jdk.swing.interop.SwingInterOpUtils;

public class Distribuição {

    public static void ApresentarDist(double[][] matriz, int k, double[] X,int l) {
=======
import java.io.IOException;

public class Distribuição {

    public static void ApresentarDist(double[][] matriz, int k, double[] X, boolean interativo, boolean geracoes, boolean dimesaoPop, boolean vecprop) throws IOException {
>>>>>>> f0aa3b9564daf414e1d874d54f494d8470573360


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
<<<<<<< HEAD
        int P=l;


           if(P==0){
               System.out.println("*****************************************");
               System.out.println();
           }


            while (t <= k) {

                if(P==0) System.out.printf("Para a %dª geração:\n\n", t + 1);

                if (t > 1) {

                    matrizGeraçao = Calculos.leslieT(matriz, t);
                    matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                    produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                    produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                    dimensão = dimensao(produto);

                    vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                    if(P==0){

                        System.out.println("Distruibuição não Normalizada:");
                        Apresentar.apresentarVetor(produto);

                        System.out.println("Distribuição Normalizada:");
                        Apresentar.apresentarVetor(vetorNormalizado);

                        System.out.print("Dimensão da população nessa geração= ");
                        System.out.printf("%.2f\n", dimensão);

                        System.out.println();

                        System.out.printf("T(%d)/", t + 1);

                        System.out.println();
                        System.out.println("*****************************************");
                        System.out.println();

                    }

                    escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter,P);
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

                   if(P==0){
                       System.out.println("Distruibuição não Normalizada:");
                       Apresentar.apresentarVetor(produto);

                       System.out.println("Distribuição Normalizada:");
                       Apresentar.apresentarVetor(vetorNormalizado);

                       System.out.print("Dimensão da população nessa geração= ");
                       System.out.printf("%.2f\n", dimensão);

                       System.out.println();

                       System.out.printf("T(%d)/", t + 1);

                       System.out.println();
                       System.out.println("*****************************************");
                       System.out.println();

                   }

                    escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter,P);
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

                    if(P==0){
                        System.out.println("Distruibuição não Normalizada:");
                        Apresentar.apresentarVetor(produto);

                        System.out.println("Distribuição Normalizada:");
                        Apresentar.apresentarVetor(vetorNormalizado);

                        System.out.print("Dimensão da população nessa geração= ");
                        System.out.printf("%.2f\n", dimensão);

                        System.out.println();

                        System.out.printf("T(%d)/", t + 1);

                        System.out.println();
                        System.out.println("*****************************************");
                        System.out.println();

                    }

                    escreverTaxaVariacao(produto, t, produto_1, guardaTaxa, counter,P);
                    counter++;

                    t++;

                    guardarDimensão(guardaDimensão, dimensão, i);
                    guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                    guardarDistribuiçãoNãoNormalizada(E, produto, i);
                    i++;


=======
        if (interativo) {

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
                    i++;


                    System.out.println();
                    System.out.println("*****************************************");
                    System.out.println();


>>>>>>> f0aa3b9564daf414e1d874d54f494d8470573360
                }

            }

<<<<<<< HEAD

        if(P==0){

            Vectores.vetores(matriz,P);

            crescimento(guardaTaxa);
            //System.out.println("Crescimento da população");
            //System.out.printf("(t ; delta_t)\n");
            //Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

            crescimento(guardaDimensão);
            //System.out.printf("Numero total de individuos\n");
            //System.out.printf("(t ; Nt)\n");
            //Apresentar.apresentarTaxaOUDimensão(guardaDimensão);

            distribuiçãoNãoNormalizada(E);
            //System.out.printf("Distribuição Não Normalizada\n");
            //Apresentar.apresentarDistribuição(E);

            distribuiçãoNormalizada(D);
            //System.out.printf("\nDistribuição Normalizada\n");
            //Apresentar.apresentarDistribuição(D);
        }

       /* if(P==6){
            System.out.printf("\nDistribuição Normalizada\n");
            Apresentar.apresentarDistribuição(D);
            distribuiçãoNormalizada(D);
        }else if(P==7){
            System.out.printf("Distribuição Não Normalizada\n");
            Apresentar.apresentarDistribuição(E);
            distribuiçãoNãoNormalizada(E);
        }else if(P==8){
            System.out.printf("Numero total de individuos\n");
            System.out.printf("(t ; Nt)\n");
            Apresentar.apresentarTaxaOUDimensão(guardaDimensão);
            crescimento(guardaDimensão);
        }else if(P==9){

        }else if(P==10){
            System.out.println("Crescimento da população");
            System.out.printf("(t ; delta_t)\n");
            Apresentar.apresentarTaxaOUDimensão(guardaTaxa);
            crescimento(guardaTaxa);
        }else if(P==11){

        }else if(P==12){

        }*/

        switch(P){
            case 6:
                //System.out.printf("\nDistribuição Normalizada\n");
                //Apresentar.apresentarDistribuição(D);
                distribuiçãoNormalizada(D);
                System.out.println();
                break;
            case 7:
                //System.out.printf("Distribuição Não Normalizada\n");
                //Apresentar.apresentarDistribuição(E);
                distribuiçãoNãoNormalizada(E);
                System.out.println();
                break;
            case 8:
                //System.out.printf("Numero total de individuos\n");
                //System.out.printf("(t ; Nt)\n");
                //Apresentar.apresentarTaxaOUDimensão(guardaDimensão);
                crescimento(guardaDimensão);
                System.out.println();
                break;
            case 10:
               // System.out.println("Crescimento da população");
               // System.out.printf("(t ; delta_t)\n");
                //Apresentar.apresentarTaxaOUDimensão(guardaTaxa);
                crescimento(guardaTaxa);
                System.out.println();
                break;
        }
=======
            Vectores.vetores(matriz, true);

            System.out.println("Numero total de individuos");
            System.out.printf("(t ; delta_t)\n");
            Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

            System.out.println("Crescimento da população");
            System.out.printf("(t ; Nt)\n");
            Apresentar.apresentarTaxaOUDimensão(guardaDimensão);

        }else {
            Grava.matriz(k,matriz);
            Grava.total(guardaDimensão);
            if(dimesaoPop){
                Grava.variacao(guardaTaxa);
            }
            if (geracoes){

            }
            if (vecprop){
                Vectores.vetores(matriz, false);
            }
>>>>>>> f0aa3b9564daf414e1d874d54f494d8470573360


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


<<<<<<< HEAD
    private static void escreverTaxaVariacao(double[] produto, int k, double[] produto_1, double[] guardaTaxa, int counter,int P) {
=======
    private static void escreverTaxaVariacao(double[] produto, int k,double []produto_1,double[]guardaTaxa,int counter) {

        System.out.print("Taxa de variação=");
>>>>>>> f0aa3b9564daf414e1d874d54f494d8470573360

        double taxaVariacao = taxaVariacao(produto, k, produto_1);

        if(P==0) {
            System.out.print("Taxa de variação=");
            System.out.printf("%.2f\n", taxaVariacao);
        }

        guardaTaxa[counter] = taxaVariacao;


    }



    private static double taxaVariacao(double[] produto, int k,double[]produto_1) {


        double Nt;
        double Nt1;
        double taxa;

        Nt1 = dimensao(produto_1);
        Nt = dimensao(produto);

        taxa = Nt1 / Nt;

        return taxa;


    }



    private static void guardarDimensão(double[]guardarDimensão, double dimensão,int i) {

        guardarDimensão[i] = dimensão;

    }

    public static double[] guardarDimensaor(double[] guardarDimensão, double dimensão, int i) {

        guardarDimensão[i] = dimensão;
        return guardarDimensão;

    }
}



<<<<<<< HEAD
    public static void crescimento(double[] guardaTaxa) {

        System.out.println("Crescimento da população");
        System.out.printf("(t ; delta_t)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

    }

    public static void população(double[] guardaDimensão) {

        System.out.printf("Numero total de individuos\n");
        System.out.printf("(t ; Nt)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaDimensão);

    }

    public static void distribuiçãoNormalizada(double[][] D) {

        System.out.printf("\nDistribuição Normalizada\n");
        Apresentar.apresentarDistribuição(D);

    }

    public static void distribuiçãoNãoNormalizada(double[][] E) {

        System.out.printf("\nDistribuição Não Normalizada\n");
        Apresentar.apresentarDistribuição(E);

    }

}
=======
>>>>>>> f0aa3b9564daf414e1d874d54f494d8470573360
