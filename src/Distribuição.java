import jdk.swing.interop.SwingInterOpUtils;

public class Distribuição {

    public static void ApresentarDist(double[][] matriz, int k, double[] X,int l) {


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
        int P=l;
        double taxa;


        if(P==0){
            System.out.printf("\n*****************************************\n");
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

                taxa = taxaVariacao(produto,produto_1);

                if(P==0){

                    System.out.println("Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);

                    System.out.println("Distruibuição não Normalizada:");
                    for(int I=0;I<produto.length;I++){
                        System.out.printf("Idade %d = %.2f\n",I+1,produto[I]);
                    }

                    System.out.println("\nDistribuição Normalizada:");
                    for(int I=0;I<vetorNormalizado.length;I++){
                        System.out.printf("Idade %d = %.2f",I+1,vetorNormalizado[I]);
                        System.out.println("%");
                    }

                    System.out.print("\nDimensão da população nessa geração= ");
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();

                    System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa);

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
                guardarTaxa(guardaTaxa,taxa,i);
                i++;



            } else if (t == 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t - 1);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                taxa = taxaVariacao(produto,produto_1);

                if(P==0){
                    System.out.println("Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);

                    System.out.println("Distruibuição não Normalizada:");
                    for(int I=0;I<produto.length;I++){
                        System.out.printf("Idade %d = %.2f\n",I+1,produto[I]);
                    }

                    System.out.println("\nDistribuição Normalizada:");
                    for(int I=0;I<vetorNormalizado.length;I++){
                        System.out.printf("Idade %d = %.2f",I+1,vetorNormalizado[I]);
                        System.out.println("%");
                    }

                    System.out.print("\nDimensão da população nessa geração= ");
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();

                    System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa);

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
                guardarTaxa(guardaTaxa,taxa,i);
                i++;



            } else {

                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = X;
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                taxa = taxaVariacao(produto,produto_1);

                if(P==0){
                    System.out.println("Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);

                    System.out.println("Distruibuição não Normalizada:");
                    for(int I=0;I<produto.length;I++){
                        System.out.printf("Idade %d = %.2f\n",I+1,produto[I]);
                    }

                    System.out.println("\nDistribuição Normalizada:");
                    for(int I=0;I<vetorNormalizado.length;I++){
                        System.out.printf("Idade %d = %.2f",I+1,vetorNormalizado[I]);
                        System.out.println("%");
                    }

                    System.out.print("\nDimensão da população nessa geração= ");
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();


                    System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa);


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
                guardarTaxa(guardaTaxa,taxa,i);
                i++;


            }

        }


        if(P==0){

            Vectores.vetores(matriz,P);

            crescimento(guardaTaxa);

            População(guardaDimensão);

            distribuiçãoNãoNormalizada(E);

            distribuiçãoNormalizada(D);

        }

        switch(P){
            case 6:
                distribuiçãoNormalizada(D);
                System.out.println();
                break;
            case 7:
                distribuiçãoNãoNormalizada(E);
                System.out.println();
                break;
            case 8:
                População(guardaDimensão);
                System.out.println();
                break;
            case 10:
                crescimento(guardaTaxa);
                System.out.println();
                break;
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


    private static double escreverTaxaVariacao(double[] produto, int k, double[] produto_1, double[] guardaTaxa, int counter,int P) {

        double taxaVariacao = taxaVariacao(produto,produto_1);

        //if(P==0) {
         //   System.out.print("Taxa de variação=");
           // System.out.printf("%.2f\n", taxaVariacao);
       // }

        guardaTaxa[counter] = taxaVariacao;

        return taxaVariacao;
    }


    private static double taxaVariacao(double[] produto, double[] produto_1) {


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

    private static void guardarTaxa(double[] guardarTaxa, double taxa, int i) {

        guardarTaxa[i] = taxa;

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

    public static void População(double[] guardaTaxa) {

        System.out.printf("\nNumero total de individuos\n");
        System.out.printf("(t ; Nt)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

    }


    public static void crescimento(double[] guardaTaxa) {

        System.out.printf("\nCrescimento da população\n");
        System.out.printf("(t ; delta_t)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

    }

    public static void população(double[] guardaDimensão) {

        System.out.printf("\nNumero total de individuos\n");
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