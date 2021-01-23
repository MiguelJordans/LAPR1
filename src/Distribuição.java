public class Distribuição {

    public static void ApresentarDist(double[][] matriz, int k, double[] X,int l) {


        double[][] matrizGeraçao;
        double[] produto;
        double dimensão;
        double[] vetorNormalizado;
        double[][] matrizGeraçao_1;
        double[] produto_1;
        double[] guardaTaxa = new double[201];
        double[] guardaDimensão = new double[201];
        double[][] D = new double[201][2000]; //Matriz da distribuição Normalizada
        double[][] E = new double[201][2000]; //Matriz da distribuição Não Normalizada
        int t = 0;
        int i = 0;
        int P=l;
        double taxa;


        if(P==0){

            System.out.printf("\n*****************************************\n");
            System.out.println();

        }


        while (t <= k) {

            if(P==0 && t <= k) System.out.printf("Para a %dª geração:\n\n", t+1);

            if (t > 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                taxa = taxaVariacao(produto,produto_1,dimensão);

                if(P==0){

                    System.out.println("Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);


                    System.out.print("\nDimensão da população nessa geração= ");
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();

                    if(taxa!=0)   System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa);

                    System.out.println();
                    System.out.println("*****************************************");
                    System.out.println();

                }

                if(dimensão==0){

                    produto=Ler.resetarVetor(produto);
                    vetorNormalizado = Ler.resetarVetor(vetorNormalizado);
                    taxa = 0;

                }

                t++;

                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E, produto, i);
                guardarTaxa(guardaTaxa,taxa,i);
                i++;



            } else if (t == 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t+1);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                taxa = taxaVariacao(produto,produto_1,dimensão);


                if(P==0){
                    System.out.println("Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);

                    System.out.print("\nDimensão da população nessa geração= ");
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();

                    if(taxa!=0)   System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa);

                    System.out.println();
                    System.out.println("*****************************************");
                    System.out.println();

                }

                if(dimensão==0){
                    produto=Ler.resetarVetor(produto);
                    vetorNormalizado = Ler.resetarVetor(vetorNormalizado);
                    taxa = 0;

                }

                t++;

                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E, produto, i);
                guardarTaxa(guardaTaxa,taxa,i);
                i++;


            } else if(t<100) {

                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = X;
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                taxa = taxaVariacao(produto,produto_1,dimensão);


                if(P==0){
                    System.out.println("Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);

                    System.out.print("\nDimensão da população nessa geração= ");
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();

                    if(taxa!=0)   System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa);

                    System.out.println();
                    System.out.println("*****************************************");
                    System.out.println();

                }

                if(dimensão==0){

                    produto=Ler.resetarVetor(produto);
                    vetorNormalizado = Ler.resetarVetor(vetorNormalizado);
                    taxa = 0;

                }

                t++;

                guardarDimensão(guardaDimensão, dimensão, i);
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i);
                guardarDistribuiçãoNãoNormalizada(E, produto, i);
                guardarTaxa(guardaTaxa,taxa,i);
                i++;

            }

        }

        if (P==100){

            Grava.graficototal(k,guardaDimensão);
            Grava.graficovariacao(k,guardaTaxa);
            Grava.graficonormalizada(k,D,X.length);
            Grava.graficoNaoNormalizada(k,E,X.length);

        }


        if(P==0){

            Vectores.vetores(matriz,P);
            crescimento(guardaTaxa);
            População(guardaDimensão,k);
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

                População(guardaDimensão,k);

                System.out.println();
                break;

            case 10:

                crescimento(guardaTaxa);

                System.out.println();
                break;

        }


    }


    public static double dimensao(double[] produto) {

        double soma = 0;

        for (int j = 0; j < produto.length; j++) {

            soma += produto[j];

        }

        if (soma<1) soma=0; //Pois nao existe menos que 1 indivíduo, pois caso isso aconteça a população exntingiu-se

        return soma;

    }


    public static double[] distribuiçaoNormalizada(double[] produto, double dimensao) {


        double[] vetorNormalizado = new double[produto.length];


        if (dimensao != 0) {

            for (int j = 0; j < produto.length; j++) {

                vetorNormalizado[j] = (produto[j] / dimensao) * 100;

            }

            return vetorNormalizado;

        } else {

            for (int j = 0; j < produto.length; j++) {

                vetorNormalizado[j] = 0;

            }

            return vetorNormalizado;

        }

    }


    public static double taxaVariacao(double[] produto, double[] produto_1,double dimensao) {


        double Nt;
        double Nt1;
        double taxa;

        if (dimensao != 0) {

            Nt1 = dimensao(produto_1);
            Nt = dimensao(produto);
            taxa = Nt1 / Nt;

        } else taxa=0;


        return taxa;

    }


    public static void guardarDimensão(double[] guardarDimensão, double dimensão, int i) {

        guardarDimensão[i] = dimensão;

    }

    public static void guardarTaxa(double[] guardarTaxa, double taxa, int i) {

        guardarTaxa[i] = taxa;

    }


    public static void guardarDistribuiçãoNormalizada(double[][] D, double[] vetorNormalizado, int i) {

        for (int j = 0; j < vetorNormalizado.length; j++) {

            D[i][j]=vetorNormalizado[j];

        }

    }


    public static void guardarDistribuiçãoNãoNormalizada(double[][] E, double[] produto, int i) {

        for (int j = 0; j < produto.length; j++) {

            if(produto[j]!=0) E[i][j]=produto[j];

        }

    }

    public static void População(double[] guardaTaxa,int k) {

        System.out.printf("\nNumero total de individuos:\n");
        System.out.printf("(t ; Nt)\n");
        Apresentar.apresentarDimensão(guardaTaxa,k);

    }


    public static void crescimento(double[] guardaTaxa) {

        System.out.printf("\nCrescimento da população:\n");
        System.out.printf("(t ; delta_t)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

    }


    public static void distribuiçãoNormalizada(double[][] D) {

        System.out.printf("\nDistribuição Normalizada:\n");
        System.out.printf("(t ; números por classe normalizados)\n");
        Apresentar.apresentarDistribuição(D);

    }

    public static void distribuiçãoNãoNormalizada(double[][] E) {

        System.out.printf("\nDistribuição Não Normalizada:\n");
        System.out.printf("(t ; números por classe não normalizados)\n");
        Apresentar.apresentarDistribuição(E);

    }

}
