public class testesUnitarios {

    public static void main(String[] args) {

        double[][] matrizPCasoM = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] matriz2PCasoM = {{9 , 8, 7}, {6, 5, 4}, {3, 2, 1}};
        double[][] resultadoEsperadoPCasoM = {{30.0 ,24.0 ,18.0}, {84.0, 69.0, 54.0}, {138.0, 114.0, 90.0}};
        double[][] matrizSCasoM = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        double[][] matriz2SCasoM = {{1 , 2}, {1, 2}, {1, 2},{1, 2},{1, 2}};
        double[][] resultadoEsperadoSCasoM = {{15 ,30}, {40, 80}};
        double[][] matrizTCasoM = {{0, 3.5, 1.5, 0.39}, {0.4, 0, 0, 0}, {0, 0.6, 0, 0}, {0, 0, 0.5, 0}};
        double[][] matriz2TCasoM = {{60.678}, {200}, {130},{40}};
        double[][] resultadoEsperadoTCasoM = {{910.6}, {24.27}, {120}, {65}};
        System.out.println("1º teste de multiplicar matrizes:");
        System.out.println(test_multiplicarMatrizes(matrizPCasoM, matriz2PCasoM, resultadoEsperadoPCasoM) ? "certo" : "ERRO");
        System.out.println("2º teste de multiplicar matrizes:");
        System.out.println(test_multiplicarMatrizes(matrizSCasoM, matriz2SCasoM, resultadoEsperadoSCasoM) ? "certo" : "ERRO");
        System.out.println("3º teste de multiplicar matrizes:");
        System.out.println(test_multiplicarMatrizes(matrizTCasoM, matriz2TCasoM, resultadoEsperadoTCasoM) ? "certo" : "ERRO");


        double[][] matrizPCasoMV = {{0, 3.5, 1.5, 0.39}, {0.4, 0, 0, 0}, {0, 0.6, 0, 0}, {0, 0, 0.5, 0}};
        double[] vetorPCasoMV = {600, 200, 130, 40};
        double[] resultadoPCasoMV = {910.6, 240.0, 120.0, 65.0};
        double[][] matrizSCasoMV = {{1, 2, 3, 4, 5}, { 6, 7, 8, 9, 10},{ 1, 1, 1, 1, 1}, {10, 9, 8, 7, 6}, { 5, 4, 3, 2, 1}};
        double[] vetorSCasoMV = {10, 20, 30, 40, 50};
        double[] resultadoSCasoMV = {550, 1300, 150,1100, 350};
        double[][] matrizTCasoMV = {{17.45, 10.35, 0.7}, {27, 8.333, 9}, {3, 5.8, 38.333}};
        double[] vetorTCasoMV = {1.5, 3.5, 2.5};
        double[] resultadoTCasoMV = {64.15, 92.17, 120.63};
        System.out.println("1ª Teste de multiplicar matriz e vetor:");
        System.out.println(test_multiplicarMatrizporVetor(matrizPCasoMV, vetorPCasoMV, resultadoPCasoMV) ? "certo" : "ERRO");
        System.out.println("2ª Teste de multiplicar matriz e vetor:");
        System.out.println(test_multiplicarMatrizporVetor(matrizSCasoMV, vetorSCasoMV, resultadoSCasoMV) ? "certo" : "ERRO");
        System.out.println("3ª Teste de multiplicar matriz e vetor:");
        System.out.println(test_multiplicarMatrizporVetor(matrizTCasoMV, vetorTCasoMV, resultadoTCasoMV) ? "certo" : "ERRO");


        double[] vetorPCasoDim = {100, 200, 300, 1000};
        double resultadoEsperadoPCasoDim = 1600;
        double[] vetorSCasoDim = {123456789, 987654321};
        double resultadoEsperadoSCasoDim = 1111111110;
        double[] vetorTCasoDim = {1.0555, 2.223, 3.4567, 7.1234};
        double resultadoEsperadoTCasoDim = 13.86;
        System.out.println("1º teste de dimensão:");
        System.out.println(test_dimensao(vetorPCasoDim, resultadoEsperadoPCasoDim) ? "certo" : "ERRO");
        System.out.println("2º teste de dimensão:");
        System.out.println(test_dimensao(vetorSCasoDim, resultadoEsperadoSCasoDim) ? "certo" : "ERRO");
        System.out.println("3º teste de dimensão:");
        System.out.println(test_dimensao(vetorTCasoDim, resultadoEsperadoTCasoDim) ? "certo" : "ERRO");


        double[] produtoPCaso = {100, 200, 300, 1000};
        double[] produto1PCaso = {200, 400, 600, 2000};
        double resultadoEsperadoPCaso = 2;
        double[] produtoSCaso = {5, 6, 7, 8, 9};
        double[] produto1SCaso = {1, 2, 3, 4, 5};
        double resultadoEsperadoSCaso = 0.4286;
        double[] produtoTCaso = {1, 2, 3, 10};
        double[] produto1TCaso = {6, 4, 6, 20};
        double resultadoEsperadoTCaso = 2.25;
        System.out.println("1º teste da Taxa de Variação:");
        System.out.println(test_taxaVariacao(produtoPCaso, produto1PCaso, resultadoEsperadoPCaso) ? "certo" : "ERRO");
        System.out.println("2º teste da Taxa de Variação:");
        System.out.println(test_taxaVariacao(produtoSCaso, produto1SCaso, resultadoEsperadoSCaso) ? "certo" : "ERRO");
        System.out.println("3º teste da Taxa de Variação:");
        System.out.println(test_taxaVariacao(produtoTCaso, produto1TCaso, resultadoEsperadoTCaso) ? "certo" : "ERRO");


        double[] vetorPCasoDN = {100, 200, 300, 1000};
        double[] resultadoEsperadoPCasoDN = {6.25, 12.5, 18.75, 62.5};
        double[] vetorSCasoDN = {5, 6, 7, 8, 9};
        double[] resultadoEsperadoSCasoDN = { 14.29, 17.14, 20.00, 22.86, 25.71};
        double[] vetorTCasoDN = {20, 5, 35, 10, 30};
        double[] resultadoEsperadoTCasoDN = {20, 5, 35, 10, 30};
        System.out.println("1º teste da Distribuição Normalizada:");
        System.out.println(test_distribuiçaoNormalizada(vetorPCasoDN,resultadoEsperadoPCasoDN) ? "certo" : "ERRO");
        System.out.println("2º teste da Distribuição Normalizada:");
        System.out.println(test_distribuiçaoNormalizada(vetorSCasoDN,resultadoEsperadoSCasoDN) ? "certo" : "ERRO");
        System.out.println("3º teste da Distribuição Normalizada:");
        System.out.println(test_distribuiçaoNormalizada(vetorTCasoDN,resultadoEsperadoTCasoDN) ? "certo" : "ERRO");


        double[][] matrizPCasoVeP = {{0, 3.5, 1.5, 0.39}, {0.4, 0, 0, 0}, {0, 0.6, 0, 0}, {0, 0, 0.5, 0}};
        double resultadoPCasoVeP = 1.31;
        int l1 = 4;  //????
        double[][] matrizSCasoVeP = {{0, 3, 3.17, 0.39}, {0.11, 0, 0, 0}, {0, 0.29, 0, 0}, {0, 0, 0.33, 0}};
        double resultadoSCasoVeP = 0.70;
        int l2 = 4; //????
        double[][] matrizTCasoVeP = {{0, 20, 40, 79, 10}, {0.4, 0, 0, 0, 0}, {0, 0.6, 0, 0, 0}, {0, 0, 0.9, 0, 0}, {0, 0, 0, 0.1, 0}};
        double resultadoTCasoVeP = 3.49;
        int l3 = 5; //?????
        System.out.println("1º teste do Vetor Próprio:");
        System.out.println(test_vetorproprio(matrizPCasoVeP,l1,resultadoPCasoVeP) ? "certo" : "ERRO");
        System.out.println("2º teste do Vetor Próprio:");
        System.out.println(test_vetorproprio(matrizSCasoVeP,l2,resultadoSCasoVeP) ? "certo" : "ERRO");
        System.out.println("3º teste do Vetor Próprio:");
        System.out.println(test_vetorproprio(matrizTCasoVeP,l3,resultadoTCasoVeP) ? "certo" : "ERRO");


        double[][] matrizPCasoVP = {{0.1, 0, 0, 0, 0}, {0, 0.07, 0, 0, 0.1}, {0, 0.12, 0.13, 0, 0}, {0, 0, 0.18, 0.191, 0}, {0, 0, 0, 0.01, 0.02}};
        double resultadoPCasoVP = 0.19;
        double[][] matrizSCasoVP = {{3.178, 0.39}, {0.33, 1.3333}};
        double resultadoSCasoVP = 3.18;
        double[][] matrizTCasoVP = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        double resultadoTCasoVP = 16;
        System.out.println("1º teste do maior Valor Próprio:");
        System.out.println(test_maiorValorProprio(matrizPCasoVP,resultadoPCasoVP) ? "certo" : "ERRO");
        System.out.println("2º teste do maior Valor Próprio:");
        System.out.println(test_maiorValorProprio(matrizSCasoVP,resultadoSCasoVP) ? "certo" : "ERRO");
        System.out.println("3º teste do maior Valor Próprio:");
        System.out.println(test_maiorValorProprio(matrizTCasoVP,resultadoTCasoVP) ? "certo" : "ERRO");

    }

    public static boolean test_multiplicarMatrizes(double[][] firstMatrix, double[][] secondMatrix, double[][] resultadoEsperado) {

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
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean test_multiplicarMatrizporVetor(double[][] matriz, double[] vetor, double[] resultadoEsperado) {

        double[] aux = Calculos.multiplicarMatrizporVetor(matriz, vetor);
        double[] resultado = new double[aux.length];

        for(int i = 0; i < aux.length; i++){
            resultado[i] = Math.round(aux[i] * 100.0) / 100.0;
        }

        for (int i = 0; i < matriz.length; i++){
            if (resultado[i] != resultadoEsperado[i]){
                return false;
            }
        }
        return true;

    }

    public static boolean test_dimensao(double[] vetor, double resultadoEsperado) {

        double aux = Distribuição.dimensao(vetor);
        double resultado = Math.round(aux * 100.0) / 100.0;

        return resultado == resultadoEsperado;
    }

    public static boolean test_taxaVariacao(double[] produto,double[] produto1, double resultadoEsperado) {

        double aux = Distribuição.taxaVariacao(produto, produto1);
        double resultado = Math.round(aux * 10000.0) / 10000.0;


        return resultado == resultadoEsperado;
    }

    public static boolean test_distribuiçaoNormalizada(double[] vetor, double[] resultadoEsperado) {

        double numero = Distribuição.dimensao(vetor);
        double[] aux = Distribuição.distribuiçaoNormalizada(vetor, numero);
        double[] resultado = new double[aux.length];

        for(int i = 0; i < aux.length; i++){
            resultado[i] = Math.round(aux[i] * 100.0) / 100.0;
        }

        for (int i = 0; i < vetor.length; i++){
            if (resultado[i] != resultadoEsperado[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean test_vetorproprio(double[][] matriz, int l, double resultadoEsperado) {

        double aux = Vectores.vetorproprio(matriz,l);
        double resultado = Math.round(aux * 100.0) / 100.0;

        return resultado == resultadoEsperado;
    }

    public static boolean test_maiorValorProprio(double[][] matriz, double resultadoEsperado) {

        double aux = Vectores.maiorValorProprio(matriz);
        double resultado = Math.round(aux * 100.0) / 100.0;

        return resultado == resultadoEsperado;
    }

}
