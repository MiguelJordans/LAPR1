public class Calculos {

    public static double[][] leslieT(double[][] Xgeraçao, int k) {

        double[][] A = Xgeraçao;

        if (k > 0) { // Compor isto

            for (int i = 0; i < k; i++) {

                Xgeraçao = multiplicarMatrizes(Xgeraçao, A);

            }

            return Xgeraçao;

        } else return A;

    }

        public static double[][] multiplicarMatrizes(double[][] firstMatrix, double[][] secondMatrix) {

            double[][] produto = new double[firstMatrix.length][secondMatrix[0].length];


            for (int i = 0; i < firstMatrix.length; i++) {

                for (int j = 0; j < secondMatrix[0].length; j++) {

                    for (int k = 0; k < firstMatrix[0].length; k++) {

                        produto[i][j] += firstMatrix[i][k] * secondMatrix[k][j];

                    }

                }

            }

            return produto;

        }

    public static double[] multiplicarMatrizporVetor(double[][] firstMatrix, double[] vector) {


        double[] resposta = new double[firstMatrix.length];
        int i=0;


        for(int linha = 0; linha<firstMatrix.length; linha++){

            for(int k = 0; k < firstMatrix.length; k++){

                resposta[i] += firstMatrix[linha][k] * vector[k];

            }

            i++;

        }


        return resposta;

    }

    }

