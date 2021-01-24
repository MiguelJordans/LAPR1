
/**
 * Classe encarregue aos testes unitários
 */

public class testesUnitarios {

    public static void testes() {

        //caso 1
        double[][] matrizPCasoM = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] matriz2PCasoM = {{9 , 8, 7}, {6, 5, 4}, {3, 2, 1}};
        double[][] resultadoEsperadoPCasoM = {{30.0 ,24.0 ,18.0}, {84.0, 69.0, 54.0}, {138.0, 114.0, 90.0}};

        //caso 2
        double[][] matrizSCasoM = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        double[][] matriz2SCasoM = {{1 , 2}, {1, 2}, {1, 2},{1, 2},{1, 2}};
        double[][] resultadoEsperadoSCasoM = {{15 ,30}, {40, 80}};

        //caso 3
        double[][] matrizTCasoM = {{0, 3.5, 1.5, 0.39}, {0.4, 0, 0, 0}, {0, 0.6, 0, 0}, {0, 0, 0.5, 0}};
        double[][] matriz2TCasoM = {{60.678}, {200}, {130},{40}};
        double[][] resultadoEsperadoTCasoM = {{910.6}, {24.27}, {120}, {65}};


        System.out.println("==========================================================");
        System.out.printf("\nTestes unitários:\n");
        System.out.printf("\n1º Teste de multiplicar matrizes:\n\n");
        System.out.print(">");
        System.out.println(test_multiplicarMatrizes(matrizPCasoM, matriz2PCasoM, resultadoEsperadoPCasoM) ? "Certo" : "ERRO");

        System.out.printf("\n2º Teste de multiplicar matrizes:\n\n");
        System.out.print(">");
        System.out.println(test_multiplicarMatrizes(matrizSCasoM, matriz2SCasoM, resultadoEsperadoSCasoM) ? "Certo" : "ERRO");

        System.out.printf("\n3º Teste de multiplicar matrizes:\n\n");
        System.out.print(">");
        System.out.println(test_multiplicarMatrizes(matrizTCasoM, matriz2TCasoM, resultadoEsperadoTCasoM) ? "Certo" : "ERRO"); //Verificação aos módulos de multiplicação de matrizes
        System.out.println();

        //caso 1
        double[][] matrizPCasoMV = {{0, 3.5, 1.5, 0.39}, {0.4, 0, 0, 0}, {0, 0.6, 0, 0}, {0, 0, 0.5, 0}};
        double[] vetorPCasoMV = {600, 200, 130, 40};
        double[] resultadoPCasoMV = {910.6, 240.0, 120.0, 65.0};

        //caso 2
        double[][] matrizSCasoMV = {{1, 2, 3, 4, 5}, { 6, 7, 8, 9, 10},{ 1, 1, 1, 1, 1}, {10, 9, 8, 7, 6}, { 5, 4, 3, 2, 1}};
        double[] vetorSCasoMV = {10, 20, 30, 40, 50};
        double[] resultadoSCasoMV = {550, 1300, 150,1100, 350};

        //caso 3
        double[][] matrizTCasoMV = {{17.45, 10.35, 0.7}, {27, 8.333, 9}, {3, 5.8, 38.333}};
        double[] vetorTCasoMV = {1.5, 3.5, 2.5};
        double[] resultadoTCasoMV = {64.15, 92.17, 120.63};


        System.out.println("==========================================================");
        System.out.printf("\n1ª Teste da multiplicação de uma matriz por vetor:\n\n");
        System.out.print(">");
        System.out.println(test_multiplicarMatrizporVetor(matrizPCasoMV, vetorPCasoMV, resultadoPCasoMV) ? "Certo" : "ERRO");

        System.out.printf("\n2ª Teste da multiplicação de uma matriz por vetor:\n\n");
        System.out.print(">");
        System.out.println(test_multiplicarMatrizporVetor(matrizSCasoMV, vetorSCasoMV, resultadoSCasoMV) ? "Certo" : "ERRO");

        System.out.printf("\n3ª Teste da multiplicação de uma matriz por vetor:\n\n");
        System.out.print(">");
        System.out.println(test_multiplicarMatrizporVetor(matrizTCasoMV, vetorTCasoMV, resultadoTCasoMV) ? "Certo" : "ERRO"); //Verificação aos módulos de multiplicação de uma matriz por um vetor
        System.out.println();

        //caso 1
        double[] vetorPCasoDim = {100, 200, 300, 1000};
        double resultadoEsperadoPCasoDim = 1600;

        //caso 2
        double[] vetorSCasoDim = {123456789, 987654321};
        double resultadoEsperadoSCasoDim = 1111111110;

        //caso 3
        double[] vetorTCasoDim = {1.0555, 2.223, 3.4567, 7.1234};
        double resultadoEsperadoTCasoDim = 13.86;


        System.out.println("==========================================================");
        System.out.printf("\n1º Teste da dimensão:\n\n");
        System.out.print(">");
        System.out.println(test_dimensao(vetorPCasoDim, resultadoEsperadoPCasoDim) ? "Certo" : "ERRO");

        System.out.printf("\n2º Teste da dimensão:\n\n");
        System.out.print(">");
        System.out.println(test_dimensao(vetorSCasoDim, resultadoEsperadoSCasoDim) ? "Certo" : "ERRO");

        System.out.printf("\n3º Teste da dimensão:\n\n");
        System.out.print(">");
        System.out.println(test_dimensao(vetorTCasoDim, resultadoEsperadoTCasoDim) ? "Certo" : "ERRO"); //Verificação ao módulo respetivo ao cálculo da dimensão da população numa geração
        System.out.println();

        //caso 1
        double[] produtoPCaso = {100, 200, 300, 1000};
        double[] produto1PCaso = {200, 400, 600, 2000};
        double resultadoEsperadoPCaso = 2;

        //caso 2
        double[] produtoSCaso = {5, 6, 7, 8, 9};
        double[] produto1SCaso = {1, 2, 3, 4, 5};
        double resultadoEsperadoSCaso = 0.4286;

        //caso 3
        double[] produtoTCaso = {1, 2, 3, 10};
        double[] produto1TCaso = {6, 4, 6, 20};
        double resultadoEsperadoTCaso = 2.25;


        System.out.println("==========================================================");
        System.out.printf("\n1º Teste da Taxa de Variação:\n\n");
        System.out.print(">");
        System.out.println(test_taxaVariacao(produtoPCaso, produto1PCaso, resultadoEsperadoPCaso) ? "Certo" : "ERRO");

        System.out.printf("\n2º Teste da Taxa de Variação:\n\n");
        System.out.print(">");
        System.out.println(test_taxaVariacao(produtoSCaso, produto1SCaso, resultadoEsperadoSCaso) ? "Certo" : "ERRO");

        System.out.printf("\n3º Teste da Taxa de Variação:\n\n");
        System.out.print(">");
        System.out.println(test_taxaVariacao(produtoTCaso, produto1TCaso, resultadoEsperadoTCaso) ? "Certo" : "ERRO"); //Verificação ao módulo respetivo ao cálculo da taxa de variação (crescimento populacional) numa geração
        System.out.println();

        //caso 1
        double[] vetorPCasoDN = {100, 200, 300, 1000};
        double[] resultadoEsperadoPCasoDN = {6.25, 12.5, 18.75, 62.5};

        //caso 2
        double[] vetorSCasoDN = {5, 6, 7, 8, 9};
        double[] resultadoEsperadoSCasoDN = { 14.29, 17.14, 20.00, 22.86, 25.71};

        //caso 3
        double[] vetorTCasoDN = {20, 5, 35, 10, 30};
        double[] resultadoEsperadoTCasoDN = {20, 5, 35, 10, 30};


        System.out.println("==========================================================");
        System.out.printf("\n1º Teste da Distribuição Normalizada:\n\n");
        System.out.print(">");
        System.out.println(test_distribuiçaoNormalizada(vetorPCasoDN,resultadoEsperadoPCasoDN) ? "Certo" : "ERRO");

        System.out.printf("\n2º Teste da Distribuição Normalizada:\n\n");
        System.out.print(">");
        System.out.println(test_distribuiçaoNormalizada(vetorSCasoDN,resultadoEsperadoSCasoDN) ? "Certo" : "ERRO");

        System.out.printf("\n3º Teste da Distribuição Normalizada:\n\n");
        System.out.print(">");
        System.out.println(test_distribuiçaoNormalizada(vetorTCasoDN,resultadoEsperadoTCasoDN) ? "Certo" : "ERRO"); //Verificação ao módulo respetivo ao cálculo da distribuição normalizada numa geração
        System.out.println();

        //caso 1
        double[][] matrizPCasoVeP = {{0, 3.5, 1.5, 0.39}, {0.4, 0, 0, 0}, {0, 0.6, 0, 0}, {0, 0, 0.5, 0}};
        double resultadoPCasoVeP = 1.31;
        int l1 = 4;

        //caso 2
        double[][] matrizSCasoVeP = {{0, 3, 3.17, 0.39}, {0.11, 0, 0, 0}, {0, 0.29, 0, 0}, {0, 0, 0.33, 0}};
        double resultadoSCasoVeP = 0.70;
        int l2 = 4;

        //caso 3
        double[][] matrizTCasoVeP = {{0, 20, 40, 79, 10}, {0.4, 0, 0, 0, 0}, {0, 0.6, 0, 0, 0}, {0, 0, 0.9, 0, 0}, {0, 0, 0, 0.1, 0}};
        double resultadoTCasoVeP = 3.49;
        int l3 = 5;

        System.out.println("==========================================================");
        System.out.printf("\n1º Teste do Vetor Próprio:\n");
        System.out.print(">");
        System.out.println(test_vetorproprio(matrizPCasoVeP,l1,resultadoPCasoVeP) ? "Certo" : "ERRO");

        System.out.printf("\n2º Teste do Vetor Próprio:\n");
        System.out.print(">");
        System.out.println(test_vetorproprio(matrizSCasoVeP,l2,resultadoSCasoVeP) ? "Certo" : "ERRO");

        System.out.printf("\n3º Teste do Vetor Próprio:\n");
        System.out.print(">");
        System.out.println(test_vetorproprio(matrizTCasoVeP,l3,resultadoTCasoVeP) ? "Certo" : "ERRO"); //Verificação ao módulo respetivo ao cálculo do vetor próprio
        System.out.println();

        //caso 1
        double[][] matrizPCasoVP = {{0.1, 0, 0, 0, 0}, {0, 0.07, 0, 0, 0.1}, {0, 0.12, 0.13, 0, 0}, {0, 0, 0.18, 0.191, 0}, {0, 0, 0, 0.01, 0.02}};
        double resultadoPCasoVP = 0.19;

        //caso 2
        double[][] matrizSCasoVP = {{3.178, 0.39}, {0.33, 1.3333}};
        double resultadoSCasoVP = 3.18;

        //caso 3
        double[][] matrizTCasoVP = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        double resultadoTCasoVP = 16;


        System.out.println("==========================================================");
        System.out.printf("\n1º Teste do maior Valor Próprio:\n\n");
        System.out.print(">");
        System.out.println(test_maiorValorProprio(matrizPCasoVP,resultadoPCasoVP) ? "Certo" : "ERRO");

        System.out.printf("\n2º Teste do maior Valor Próprio:\n\n");
        System.out.print(">");
        System.out.println(test_maiorValorProprio(matrizSCasoVP,resultadoSCasoVP) ? "Certo" : "ERRO");

        System.out.printf("\n3º Teste do maior Valor Próprio:\n\n");
        System.out.print(">");
        System.out.println(test_maiorValorProprio(matrizTCasoVP,resultadoTCasoVP) ? "Certo" : "ERRO"); //Verificação ao módulo respetivo ao cálculo do valor próprio


    }

    /**
     * @param firstMatrix primeira matriz que vai ser utilizada na multiplicação de matrizes
     * @param secondMatrix segunda matriz que vai ser utilizada na multiplicação de matrizes
     * @param resultadoEsperado produto da multiplicação das duas matrizes
     * @return à veracidade da comparação entre os dois valores
     */


    public static boolean test_multiplicarMatrizes(double[][] firstMatrix, double[][] secondMatrix, double[][] resultadoEsperado) { //Módulo para verificar o cálculo de matrizes

        double[][] aux = Calculos.multiplicarMatrizes(firstMatrix, secondMatrix);

        double[][] resultado = new double[firstMatrix.length][secondMatrix[0].length];


        for (int i = 0; i < firstMatrix.length; i++) {

            for (int j = 0; j < secondMatrix[0].length; j++) {

                resultado[i][j] =Math.round(aux[i][j] * 100.0) / 100.0;

            }

        }


        for (int i= 0;i < firstMatrix.length; i++){

            for (int j = 0;j < secondMatrix[0].length; j++){

                if (resultado[i][j] != resultadoEsperado[i][j]){

                    return false; //Caso o resultado expectado seja diferente ao valor calculado , isto significa que o programa esta a calcular mal o produto das duas matrizes
                }

            }

        }

        return true; //Caso o resultado expectado seja igual ao valor calculado , isto significa que o programa esta a calcular bem produto das duas matrizes

    }

    /**
     * @param matriz matriz utilizada na multiplicação
     * @param vetor vetor ultizado na multiplicação
     * @param resultadoEsperado resultado que se espera que seja calculado nesta multiplicação
     * @return à veracidade da comparação entre os dois valores
     */


    public static boolean test_multiplicarMatrizporVetor(double[][] matriz, double[] vetor, double[] resultadoEsperado) { //Módulo para verificar o produto entre uma matriz e um vetor

        double[] aux = Calculos.multiplicarMatrizporVetor(matriz, vetor);

        double[] resultado = new double[aux.length];


        for(int i = 0; i < aux.length; i++){

            resultado[i] = Math.round(aux[i] * 100.0) / 100.0;

        }


        for (int i = 0; i < matriz.length; i++){

            if (resultado[i] != resultadoEsperado[i]){

                return false; //Caso o resultado expectado seja diferente ao valor calculado , isto significa que o programa esta a calcular mal o produto da matriz com o vetor

            }

        }

        return true; //Caso o resultado expectado seja igual ao valor calculado , isto significa que o programa esta a calcular bem o produto da matriz com o vetor

    }

    /**
     * @param vetor vetor do qual se vai calcular a dimensão(soma de todas as entradas do vetor)
     * @param resultadoEsperado  resultado esperado da dimensão do vetor
     * @return ao valor calculado
     */


    public static boolean test_dimensao(double[] vetor, double resultadoEsperado) { //Módulo para verificar a dimensão

        double aux = Distribuição.dimensao(vetor);

        double resultado = Math.round(aux * 100.0) / 100.0;


        return resultado == resultadoEsperado;

    }

    /**
     * @param produto vetor resultante do produto da matriz de leslie (elevada a k-1) pelo vetor inicial (número de indivíduos por geração)
     * @param produto1 vetor resultante do produto da matriz de leslie (elevada a k) pelo vetor inicial (número de indivíduos por geração)
     * @param resultadoEsperado valor esperado da divisão entre o vetor "produto1" e o vetor "produto" (produto1/produto)
     * @return ao valor calculado
     */


    public static boolean test_taxaVariacao(double[] produto,double[] produto1, double resultadoEsperado) { //Módulo para verificar a taxa de variação

        double aux = Distribuição.taxaVariacao(produto, produto1,10);

        double resultado = Math.round(aux * 10000.0) / 10000.0;


        return resultado == resultadoEsperado;

    }

    /**
     * @param vetor vetor correspondente à distribuição não normalizada
     * @param resultadoEsperado vetor esperado após os respetivos cálculos no vetor anterior
     * @return à veracidade da comparação entre os dois valores
     */


    public static boolean test_distribuiçaoNormalizada(double[] vetor, double[] resultadoEsperado) { //Módulo para verificar a distribuição normalizada

        double numero = Distribuição.dimensao(vetor);

        double[] aux = Distribuição.distribuiçaoNormalizada(vetor, numero);

        double[] resultado = new double[aux.length];


        for(int i = 0; i < aux.length; i++){

            resultado[i] = Math.round(aux[i] * 100.0) / 100.0;

        }


        for (int i = 0; i < vetor.length; i++){

            if (resultado[i] != resultadoEsperado[i]){

                return false; //Caso o resultado expectado seja diferente ao valor calculado , isto significa que o programa esta a calcular mal a distribuição normalizada

            }

        }

        return true; //Caso o resultado expectado seja igual ao valor calculado , isto significa que o programa esta a calcular bem a distribuição normalizada
    }

    /**
     * @param matriz matriz da qual se vai calcular o vetor próprio
     * @param l (Variável de controlo utilizada nas outras classes neste caso não é necessário utilizar a mesma)
     * @param resultadoEsperado resultado esperado após o cálculo do vetor próprio
     * @return à veracidade da comparação entre os dois valores
     */

    public static boolean test_vetorproprio(double[][] matriz, int l, double resultadoEsperado) { //Módulo para verificar o vetor próprio

        double aux = Vectores.vetorproprioTesteUnitario(matriz);

        double resultado = Math.round(aux * 100.0) / 100.0;


        return resultado == resultadoEsperado;

    }

    /**
     * @param matriz
     * @param resultadoEsperado
     * @return à veracidade da comparação entre os dois valores
     */

    public static boolean test_maiorValorProprio(double[][] matriz, double resultadoEsperado) { //Módulo para verificar o valor próprio

        double aux = Vectores.maiorValorProprio(matriz);

        double resultado = Math.round(aux * 100.0) / 100.0;


        return resultado == resultadoEsperado;

    }

}