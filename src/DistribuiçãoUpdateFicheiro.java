public class DistribuiçãoUpdateFicheiro {

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
        String texto_out;
        String fichSaida = "C:\\Users\\MiguelJordão(1201487\\Documents\\lapr1_turmadij_grupo04\\Output\\OutPutCase4";

        if(P==0){

            Grava.UpdateFicheiro("","\n*****************************************\n");
            Grava.UpdateFicheiro("","\n");

        }


        while (t <= k) {

            texto_out = "Para a %dª geração:\n\n" + Integer.toString(t+1);
            if(P==0) Grava.UpdateFicheiro(fichSaida,texto_out);

            if (t > 1) {

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1);

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X);

                dimensão = dimensao(produto);

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão);

                taxa = taxaVariacao(produto,produto_1);

                if(P==0){

                    Grava.UpdateFicheiro(fichSaida,"Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    Grava.UpdateFicheiro(fichSaida,"Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);

                    Grava.UpdateFicheiro(fichSaida,"Distruibuição não Normalizada:");
                    for(int I=0;I<produto.length;I++){

                        texto_out = "Idade %d = %.2f\n" + Integer.toString(I+1) + Double.toString(produto[I]);
                        Grava.UpdateFicheiro(fichSaida,texto_out);

                    }

                    Grava.UpdateFicheiro(fichSaida,"\nDistribuição Normalizada:");
                    for(int I=0;I<vetorNormalizado.length;I++){
                        texto_out = "Idade %d = %.2f" + Integer.toString(I+1) + Double.toString(vetorNormalizado[I]);
                        Grava.UpdateFicheiro(fichSaida,texto_out);
                        Grava.UpdateFicheiro(fichSaida,"%");

                    }

                    Grava.UpdateFicheiro(fichSaida,"\nDimensão da população nessa geração= ");
                    texto_out = "%.2f\n" + Double.toString(dimensão);
                    Grava.UpdateFicheiro(fichSaida,texto_out);

                    Grava.UpdateFicheiro(fichSaida,"\n");

                    texto_out = "T(%d)/Taxa de variação=%.2f\n" + Integer.toString(t) + taxa;
                    Grava.UpdateFicheiro(fichSaida,texto_out);

                    Grava.UpdateFicheiro(fichSaida,"\n");
                    Grava.UpdateFicheiro(fichSaida,"*****************************************");
                    Grava.UpdateFicheiro(fichSaida,"\n");

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
                    Grava.UpdateFicheiro(fichSaida, "Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    Grava.UpdateFicheiro(fichSaida,"Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);

                    Grava.UpdateFicheiro(fichSaida,"Distruibuição não Normalizada:");
                    for(int I=0;I<produto.length;I++){

                        texto_out = "Idade %d = %.2f\n"+ Integer.toString(I+1) + Double.toString(produto[I]);
                        Grava.UpdateFicheiro(fichSaida,texto_out);

                    }

                    Grava.UpdateFicheiro(fichSaida,"\nDistribuição Normalizada:");
                    for(int I=0;I<vetorNormalizado.length;I++){

                        texto_out = "Idade %d = %.2f" + Integer.toString(I+1) + Double.toString(vetorNormalizado[I]);
                        Grava.UpdateFicheiro(fichSaida,texto_out);
                        Grava.UpdateFicheiro(fichSaida,"%");

                    }

                    Grava.UpdateFicheiro(fichSaida,"\nDimensão da população nessa geração= ");
                    texto_out =   "%.2f\n" + dimensão;
                    Grava.UpdateFicheiro(fichSaida,texto_out);

                    Grava.UpdateFicheiro(fichSaida,"\n");
                    texto_out = "T(%d)/Taxa de variação=%.2f\n"+t+taxa;
                    Grava.UpdateFicheiro(fichSaida,texto_out);

                    Grava.UpdateFicheiro(fichSaida,"\n");
                    Grava.UpdateFicheiro(fichSaida,"*****************************************");
                    Grava.UpdateFicheiro(fichSaida,"\n");

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

                    Grava.UpdateFicheiro(fichSaida,"Distruibuição não Normalizada:");
                    Apresentar.apresentarVetor(produto);

                    Grava.UpdateFicheiro(fichSaida,"Distribuição Normalizada:");
                    Apresentar.apresentarVetor(vetorNormalizado);

                    Grava.UpdateFicheiro(fichSaida,"Distruibuição não Normalizada:");
                    for(int I=0;I<produto.length;I++){
                        texto_out = "Idade %d = %.2f\n"+Integer.toString(I+1)+Double.toString(produto[I]);
                        Grava.UpdateFicheiro(fichSaida,texto_out);

                    }

                    Grava.UpdateFicheiro(fichSaida,"\nDistribuição Normalizada:");
                    for(int I=0;I<vetorNormalizado.length;I++){

                        texto_out = "Idade %d = %.2f"+Integer.toString(I+1)+Double.toString(vetorNormalizado[I]);
                        Grava.UpdateFicheiro(fichSaida,texto_out);
                        Grava.UpdateFicheiro(fichSaida,"%");

                    }

                    Grava.UpdateFicheiro(fichSaida,"\nDimensão da população nessa geração= ");
                    texto_out = "%.2f\n"+ dimensão;
                    Grava.UpdateFicheiro(fichSaida,texto_out);

                    Grava.UpdateFicheiro(fichSaida,"\n");

                    texto_out = "T(%d)/Taxa de variação=%.2f\n"+t+taxa;
                    Grava.UpdateFicheiro(fichSaida,texto_out);


                    Grava.UpdateFicheiro(fichSaida,"\n");
                    Grava.UpdateFicheiro(fichSaida,"*****************************************");
                    Grava.UpdateFicheiro(fichSaida,"\n");

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
                Grava.UpdateFicheiro(fichSaida,"\n");
                break;

            case 7:
                distribuiçãoNãoNormalizada(E);
                Grava.UpdateFicheiro(fichSaida,"\n");
                break;

            case 8:
                População(guardaDimensão);
                Grava.UpdateFicheiro(fichSaida,"\n");
                break;

            case 10:
                crescimento(guardaTaxa);
                Grava.UpdateFicheiro(fichSaida,"\n");
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
        String fichSaida = "C:\\Users\\MiguelJordão(1201487\\Documents\\lapr1_turmadij_grupo04\\Output\\OutPutCase4";

        Grava.UpdateFicheiro(fichSaida,"\nNumero total de individuos\n");
        Grava.UpdateFicheiro(fichSaida,"(t ; Nt)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

    }


    public static void crescimento(double[] guardaTaxa) {
        String fichSaida = "C:\\Users\\MiguelJordão(1201487\\Documents\\lapr1_turmadij_grupo04\\Output\\OutPutCase4";

        Grava.UpdateFicheiro(fichSaida,"\nCrescimento da população\n");
        Grava.UpdateFicheiro(fichSaida,"(t ; delta_t)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaTaxa);

    }

    public static void população(double[] guardaDimensão) {
        String fichSaida = "C:\\Users\\MiguelJordão(1201487\\Documents\\lapr1_turmadij_grupo04\\Output\\OutPutCase4";

        Grava.UpdateFicheiro(fichSaida,"\nNumero total de individuos\n");
        Grava.UpdateFicheiro(fichSaida,"(t ; Nt)\n");
        Apresentar.apresentarTaxaOUDimensão(guardaDimensão);

    }

    public static void distribuiçãoNormalizada(double[][] D) {
        String fichSaida = "C:\\Users\\MiguelJordão(1201487\\Documents\\lapr1_turmadij_grupo04\\Output\\OutPutCase4";

        Grava.UpdateFicheiro(fichSaida,"\nDistribuição Normalizada\n");
        Apresentar.apresentarDistribuição(D);

    }

    public static void distribuiçãoNãoNormalizada(double[][] E) {
        String fichSaida = "C:\\Users\\MiguelJordão(1201487\\Documents\\lapr1_turmadij_grupo04\\Output\\OutPutCase4";

        Grava.UpdateFicheiro(fichSaida,"\nDistribuição Não Normalizada\n");
        Apresentar.apresentarDistribuição(E);

    }

}
