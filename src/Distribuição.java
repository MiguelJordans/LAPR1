
/**
 * Classe respetiva à distribuição(normalizada e não normalizada), crescimento da população e dimensão da mesma por geração
 */

public class Distribuição {


    /**
     * @param matriz matriz inicial
     * @param k número de gerações a estimar introduzidas pelo utilizador
     * @param X vetor com o número de indíviduos correspondentes à sua classe
     * @param l variável de controlo para haver uma melhor organização no código
     */


    public static void ApresentarDist(double[][] matriz, int k, double[] X,int l) {

        //Inicialização das variáveis necessárias
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
        int P=l; //variável de controlo
        double taxa;


        if(P==0){

            System.out.printf("\n*****************************************\n");
            System.out.println();

        }


        while (t <= k) { //Rodar o programa k vezes até obter os valores desejados

            if(P==0 && t <= k) System.out.printf("Para a %dª geração:\n\n", t+1); //Print à geração correspondente

            if (t > 1) { //Caso se trate da 3º geração, e todas as outras para a frente

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1); //Cálculos na matriz inicial para mais tarde serem utilizados na taxa, e nas distribuições

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X); //Cálculos na matriz após sofrer alterações (alterações presentes em cima), para se obter a distribuição não normalizada dessa geração

                dimensão = dimensao(produto); //Função para obter a dimensão da população na respetiva geração ( t )

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão); // Normalização da distribuição (após obter a dimensão é possível realizar esta operação)

                taxa = taxaVariacao(produto,produto_1,dimensão); //Função para obter o crescimento da população

                if(P==0){ //Caso no menu seja pedido para mostrar o output tod"o (case 4) , vai ser esta condição que vai controlar o mesmo output, ou seja, é dentro deste "if" que é possível dar print às informações calculadas em cima no output por geração

                    System.out.println("Distruibuição não Normalizada:"); //Print à distribuição não normalizada
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:"); //Print à distribuição normalizada
                    Apresentar.apresentarVetor(vetorNormalizado);


                    System.out.print("\nDimensão da população nessa geração= "); //Print à dimensão populacional
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();

                    if(taxa!=0)   System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa); //Print ao crescimento populacional

                    System.out.println();
                    System.out.println("*****************************************"); //Formatação do output
                    System.out.println();

                }

                if(dimensão==0){ //Caso a dimensão seja 0, é preciso resetar os outros valores pois a população exintiguiu-se e é preciso demonstrar os respetivos dados por causa desse aconticemento

                    produto=Ler.resetarVetor(produto);
                    vetorNormalizado = Ler.resetarVetor(vetorNormalizado);
                    taxa = 0;

                }

                t++;

                guardarDimensão(guardaDimensão, dimensão, i); //guardar em vetor as informações de todas as dimensões populacionais (respetivas à sua geração)
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i); //guardar em matriz as informações de todas as distribuições não normalizadas (respetivas à sua geração)
                guardarDistribuiçãoNãoNormalizada(E, produto, i); //guardar em matriz as informações de todas as distribuições normalizadas (respetivas à sua geração)
                guardarTaxa(guardaTaxa,taxa,i); //guardar em vetor as informações de todos os crescimentos populacionais (respetivos à sua geração)
                i++;



            } else if (t == 1) { //Caso se trate da 2ª geração

                matrizGeraçao = Calculos.leslieT(matriz, t);
                matrizGeraçao_1 = Calculos.leslieT(matriz, t+1); //Cálculos na matriz inicial para mais tarde serem utilizados na taxa, e nas distribuições

                produto = Calculos.multiplicarMatrizporVetor(matrizGeraçao, X);
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X); //Cálculos na matriz após sofrer alterações (alterações presentes em cima), para se obter a distribuição não normalizada dessa geração

                dimensão = dimensao(produto); //Função para obter a dimensão da população na respetiva geração ( t )

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão); // Normalização da distribuição (após obter a dimensão é possível realizar esta operação)

                taxa = taxaVariacao(produto,produto_1,dimensão); //Função para obter o crescimento da população


                if(P==0){ //Caso no menu seja pedido para mostrar o output tod"o (case 4) , vai ser esta condição que vai controlar o mesmo output, ou seja, é dentro deste "if" que é possível dar print às informações calculadas em cima no output por geração

                    System.out.println("Distruibuição não Normalizada:"); //Print à distribuição não normalizada
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:"); //Print à distribuição normalizada
                    Apresentar.apresentarVetor(vetorNormalizado);

                    System.out.print("\nDimensão da população nessa geração= "); //Print à dimensão populacional
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();

                    if(taxa!=0)   System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa); //Print à dimensão populacional

                    System.out.println();
                    System.out.println("*****************************************"); //Formatação do output
                    System.out.println();

                }

                if(dimensão==0){ //Caso a dimensão seja 0, é preciso resetar os outros valores pois a população exintiguiu-se e é preciso demonstrar os respetivos dados por causa desse aconticemento

                    produto=Ler.resetarVetor(produto);
                    vetorNormalizado = Ler.resetarVetor(vetorNormalizado);
                    taxa = 0;

                }

                t++;

                guardarDimensão(guardaDimensão, dimensão, i); //guardar em vetor as informações de todas as dimensões populacionais (respetivas à sua geração)
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i); //guardar em matriz as informações de todas as distribuições não normalizadas (respetivas à sua geração)
                guardarDistribuiçãoNãoNormalizada(E, produto, i); //guardar em matriz as informações de todas as distribuições normalizadas (respetivas à sua geração)
                guardarTaxa(guardaTaxa,taxa,i); //guardar em vetor as informações de todos os crescimentos populacionais (respetivos à sua geração)
                i++;


            } else if(t<1) { //Caso se trate da 1ª geração

                matrizGeraçao_1 = Calculos.leslieT(matriz, t + 1); //Cálculos na matriz inicial para mais tarde serem utilizados na taxa, e nas distribuições

                produto = X;
                produto_1 = Calculos.multiplicarMatrizporVetor(matrizGeraçao_1, X); //Cálculos na matriz após sofrer alterações (alterações presentes em cima), para se obter a distribuição não normalizada dessa geração

                dimensão = dimensao(produto); //Função para obter a dimensão da população na respetiva geração ( t )

                vetorNormalizado = distribuiçaoNormalizada(produto, dimensão); // Normalização da distribuição (após obter a dimensão é possível realizar esta operação)

                taxa = taxaVariacao(produto,produto_1,dimensão); //Função para obter o crescimento da população


                if(P==0){ //Caso no menu seja pedido para mostrar o output tod"o (case 4) , vai ser esta condição que vai controlar o mesmo output, ou seja, é dentro deste "if" que é possível dar print às informações calculadas em cima no output por geração

                    System.out.println("Distruibuição não Normalizada:"); //Print à distribuição não normalizada
                    Apresentar.apresentarVetor(produto);

                    System.out.println("Distribuição Normalizada:"); //Print à distribuição normalizada
                    Apresentar.apresentarVetor(vetorNormalizado);

                    System.out.print("\nDimensão da população nessa geração= "); //Print à dimensão populacional
                    System.out.printf("%.2f\n", dimensão);

                    System.out.println();

                    if(taxa!=0)   System.out.printf("T(%d)/Taxa de variação=%.2f\n",t,taxa); //Print à dimensão populacional

                    System.out.println();
                    System.out.println("*****************************************"); //Formatação do output
                    System.out.println();

                }

                if(dimensão==0) { //Caso a dimensão seja 0, é preciso resetar os outros valores pois a população exintiguiu-se e é preciso demonstrar os respetivos dados por causa desse aconticemento

                    produto=Ler.resetarVetor(produto);
                    vetorNormalizado = Ler.resetarVetor(vetorNormalizado);
                    taxa = 0;

                }

                t++;

                guardarDimensão(guardaDimensão, dimensão, i); //guardar em vetor as informações de todas as dimensões populacionais (respetivas à sua geração)
                guardarDistribuiçãoNormalizada(D, vetorNormalizado, i); //guardar em matriz as informações de todas as distribuições não normalizadas (respetivas à sua geração)
                guardarDistribuiçãoNãoNormalizada(E, produto, i); //guardar em matriz as informações de todas as distribuições normalizadas (respetivas à sua geração)
                guardarTaxa(guardaTaxa,taxa,i); //guardar em vetor as informações de todos os crescimentos populacionais (respetivos à sua geração)
                i++;

            }

        }

        if (P==100){ //Variável de controlo para guardar as informações necessárias para a realização dos gráficos

            Grava.graficototal(k,guardaDimensão);
            Grava.graficovariacao(k,guardaTaxa);
            Grava.graficonormalizada(k,D,X.length);
            Grava.graficoNaoNormalizada(k,E,X.length);

        }


        if(P==0){ //Caso no menu seja pedido para mostrar o output tod"o (case 4) , vai ser esta condição que vai controlar o mesmo output, ou seja, é dentro deste "if" que é possível apresentar a taxa, a dimensão e as distribuições em lista (numa formatação específica), e as informações todas correspondentes aos vetores(isto é vetor próprio, valor próprio, e o comportamento assimtótico)

            Vectores.vetores(matriz,P); //Demonstrar as informações respetivas ao vetor próprio, valor próprio e ao comportamento assimtótico
            crescimento(guardaTaxa); //Demonstrar o crescimento populacional
            População(guardaDimensão,k); //Demonstrar a dimensão populacional
            distribuiçãoNãoNormalizada(E); //Demonstrar a distribuição não normalizada
            distribuiçãoNormalizada(D); //Demonstrar a distribuição normalizada

        }

        switch(P){ //Variável de controlo para dar print ao conteúdo desejado ( escolhido no menu principal )

            case 6:

                distribuiçãoNormalizada(D); //Demonstrar a distribuição normalizada

                System.out.println();
                break;

            case 7:

                distribuiçãoNãoNormalizada(E); //Demonstrar a distribuição não normalizada

                System.out.println();
                break;

            case 8:

                População(guardaDimensão,k); //Demonstrar a dimensão populacional

                System.out.println();
                break;

            case 10:

                crescimento(guardaTaxa); //Demonstrar o crescimento populacional

                System.out.println();
                break;

        }


    }


    /**
     * @param produto vetor corresponde à distribuição não normalizada, de onde vai ser calculada a dimensão populacional
     * @return return à dimensão existente naquela geração
     */

    public static double dimensao(double[] produto) {

        double soma = 0;

        for (int j = 0; j < produto.length; j++) { //Ciclo para calcular a dimensão total naquela geração

            soma += produto[j];

        }

        if (soma<1) soma=0; //Pois nao existe menos que 1 indivíduo, pois caso isso aconteça a população exntingiu-se

        return soma; //Return à dimensão

    }


    /**
     * @param produto vetor corresponde à distribuição não normalizada
     * @param dimensao variável com a dimensão da população na respetiva geração
     * @return ao vetor após sofrer a normalização
     */


    public static double[] distribuiçaoNormalizada(double[] produto, double dimensao) {


        double[] vetorNormalizado = new double[produto.length];


        if (dimensao != 0) { //Caso a dimensão seja maior que 0 é possível normalizar o vetor, caso o contrário não seria possível de o fazer

            for (int j = 0; j < produto.length; j++) {

                vetorNormalizado[j] = (produto[j] / dimensao) * 100; //Função para normalizar o vetor

            }

            return vetorNormalizado; //return ao vetor normalizado

        } else {

            for (int j = 0; j < produto.length; j++) {

                vetorNormalizado[j] = 0; //Atribuição de valores neutros ao vetor inteiro (pois a dimensão é igual a 0 )

            }

            return vetorNormalizado; //return ao vetor neutralizado

        }

    }


    /**
     *
     * @param produto distribuição não normalizada para a respetiva geração
     * @param produto_1 distribuição não normalizada para a geração asseguir (t+1)
     * @param dimensao dimensão populacional na geração atual
     * @return return à variável que tem como valor o crescimento populacional
     */


    public static double taxaVariacao(double[] produto, double[] produto_1,double dimensao) {

        //Inicialização das variáveis
        double Nt;
        double Nt1;
        double taxa;

        if (dimensao != 0) { //Caso a dimensão seja diferente de 0 é possível apresentar a taxa de variação da população

            Nt1 = dimensao(produto_1);//Dimensão da geração atual
            Nt = dimensao(produto);//Dimensão da geração seguinte
            taxa = Nt1 / Nt; //Cálculo da taxa

        } else taxa=0; //Caso a dimensão da população seja igual a 0, a taxa deverá ser também 0


        return taxa; //return à variável com o valor da taxa

    }

    /**
     * @param guardarDimensão vetor que vai guardar os valores de todas as dimensões que existiram por geração
     * @param dimensão valor da dimensão na geração atual
     * @param i variável de incremento , que vai servir para guardar as informações no vetor
     */


    public static void guardarDimensão(double[] guardarDimensão, double dimensão, int i) {

        guardarDimensão[i] = dimensão;

    }

    /**
     * @param guardarTaxa vetor que vai guardar os valores de todas as taxas que existiram por geração
     * @param taxa valor da taxa na geração atual
     * @param i variável de incremento , que vai servir para guardar as informações no vetor
     */


    public static void guardarTaxa(double[] guardarTaxa, double taxa, int i) {

        guardarTaxa[i] = taxa;

    }

    /**
     * @param D matriz que vai guardar os valores de todas as distribuições normalizadas que existiram por geração
     * @param vetorNormalizado vetor da distribuição normalizada da respetiva geração
     * @param i variável de incremento , que vai servir para guardar as informações no vetor
     */


    public static void guardarDistribuiçãoNormalizada(double[][] D, double[] vetorNormalizado, int i) {

        for (int j = 0; j < vetorNormalizado.length; j++) {

            D[i][j]=vetorNormalizado[j];

        }

    }

    /**
     * @param E matriz que vai guardar os valores de todas as distribuições normalizadas que existiram por geração
     * @param produto vetor da distribuição não normalizada da respetiva geração
     * @param i variável de incremento , que vai servir para guardar as informações no vetor
     */

    public static void guardarDistribuiçãoNãoNormalizada(double[][] E, double[] produto, int i) {

        for (int j = 0; j < produto.length; j++) {

            if(produto[j]!=0) E[i][j]=produto[j];

        }

    }


    public static void População(double[] guardaTaxa,int k) { //Módulo para dar print a todas as taxas calculadas

        System.out.printf("\nNumero total de individuos:\n");
        System.out.printf("(t ; Nt)\n");
        Apresentar.apresentarDimensão(guardaTaxa,k);

    }


    public static void crescimento(double[] guardaTaxa) { //Módulo para dar print a todas as dimensões calculadas

        System.out.printf("\nCrescimento da população:\n");
        System.out.printf("(t ; delta_t)\n");
        Apresentar.apresentarTaxa(guardaTaxa);

    }


    public static void distribuiçãoNormalizada(double[][] D) { //Módulo para dar print a todos os valores das distribuições normalizadas calculadas

        System.out.printf("\nDistribuição Normalizada:\n");
        System.out.printf("(t ; números por classe normalizados)\n");
        Apresentar.apresentarDistribuição(D);

    }

    public static void distribuiçãoNãoNormalizada(double[][] E) { //Módulo para dar print a todos os valores das distribuições não normalizadas calculadas

        System.out.printf("\nDistribuição Não Normalizada:\n");
        System.out.printf("(t ; números por classe não normalizados)\n");
        Apresentar.apresentarDistribuição(E);

    }

}
