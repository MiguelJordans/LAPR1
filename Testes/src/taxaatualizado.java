public class taxaatualizado {
    public static void main(String[] args) {
        double[][]matrizLeslie={{0.00,3.5,1.5,0.29},{0.4,0,0,0},{0,0.6,0,0},{0,0,0.5,0}};
        double[] vetorInicial ={600,200,130,40};
        int k = 30;
        int t = 40;


        escreverTaxaVariacao( matrizLeslie, vetorInicial, t);

    }


    public static void escreverTaxaVariacao(double[][] matrizLeslie, double[] vetorInicial, int t) {
        System.out.println("Taxa de variação:");
        System.out.println();
        for (int i = 0; i < t; i++) {
            double taxaVariacao = taxaVariacao(matrizLeslie, vetorInicial, i);
            System.out.printf("(t=" + i + ")- " + "%.2f", taxaVariacao);
            System.out.println();
        }
    }

    public static double taxaVariacao(double[][] matrizLeslie, double[] vetorInicial, int t){
        double Nt;
        double Nt1;
        double lambda;
        Nt1 = dimPopulacao_NumMomento(matrizLeslie, vetorInicial, t + 1);
        Nt = dimPopulacao_NumMomento(matrizLeslie, vetorInicial, t);

        lambda = Nt1/Nt;
        return lambda;

    }


    public static double dimPopulacao_NumMomento(double[][] matrizLeslie, double[] vetorInicial, int t) {
        double soma = 0;
        double[] vetor = multiplicarMatrizVetor(potenciaMatriz(matrizLeslie, t), vetorInicial);

        for(int i = 0;i < vetor.length; i++) {
            soma += vetor[i];
        }
        return soma;
    }

    public static double[][] potenciaMatriz(double[][] matrizLeslie, int t) {
        double[][] matriz = matrizLeslie;

        for (int i = 1; i < t; i++) {
            matriz = multiplicarMatrizMatriz(matriz, matrizLeslie);
        }
        return matriz;
    }


    public static double[][] multiplicarMatrizMatriz(double[][] matriz1, double[][] matriz2) {
        double[][] resposta = new double[matriz1.length][matriz2[0].length];

        for (int i = 0; i < matriz1.length; i++){
            for (int j = 0; j < matriz2[0].length; j++){
                for(int k = 0; k < matriz1[0].length; k++){
                    resposta[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resposta;
    }

    public static double[] multiplicarMatrizVetor(double[][] matriz, double[] vetor) {
        double[] resposta = new double[matriz.length];
        int i=0;

        for(int linha = 0; linha<matriz.length; linha++){
            for(int k = 0; k < matriz.length; k++){
                resposta[i] += matriz[linha][k] * vetor[k];
            }
            i++;
        }
        return resposta;
    }
}

