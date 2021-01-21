public class Apresentar {

    public static void apresentarMatriz(double[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%.2f\t", matriz[i][j]);

            }

            System.out.println();

        }

        System.out.println();

    }

    public static void apresentarVetor(double[] vetor) {

        for (int j = 0; j < vetor.length; j++) {

            if (j == vetor.length) System.out.printf("%.2f)", vetor[j]);

            else if (j == 0) System.out.printf("(%.2f", vetor[j]);

            else System.out.printf(";%.2f", vetor[j]);

        }

        System.out.print(")");

        System.out.println();

        System.out.println();

    }

    public static void apresentarTaxaOUDimensão(double[] vetor) {

        int t = 0;

        for (int j = 0; j < vetor.length; j++) {

            if (vetor[j] != 0) {

                System.out.printf("(%d ; %.2f)\n", t, vetor[j]);
                t++;

            }

        }

        System.out.println();

    }


    public static void apresentarDistribuição(double[][] Distribuição) {

        int t = 0;


        for (int i = 0; i < Distribuição.length; i++) {

            for (int j = 0; j < Distribuição[i].length; j++) {

                if (Distribuição[i].length > 0 && Distribuição[i][j] != 0) {

                    if (j == 0) {

                        System.out.printf("(%d ; %.2f ", t, Distribuição[i][j]);
                        t++;

                    } else System.out.printf("; %.2f ", Distribuição[i][j]);

                }
            }
            if(Distribuição[i][0]!=0) System.out.printf(")\n");
        }

    }

    public static boolean isIgual(double[] A, double[] B) {

        boolean igual = true;

            for (int j = 0; j < A.length; j++) {

                if (A[j] != B[j]) {

                    break;

                }

            }

        return igual;

    }
     public static void apresentarVetorFicheiro(double[] vetor) {

        for (int j = 0; j < vetor.length; j++) {

            if (j == vetor.length) {
                String aux = "";
              aux = "%.2f)"+Double.toString(vetor[j]);
                System.out.printf("saida.txt",aux );
            }

            else if (j == 0) {
                String aux = "";
                aux = "(%.2f"+Double.toString(vetor[j]);
                System.out.printf("saida.txt", aux);
            }
            else{
                String aux = "";
                aux = ";%.2f"+Double.toString(vetor[j]);
                System.out.printf("saida.txt", aux);
            }

        }

        Grava.UpdateFicheiro("saida.txt",")");

        Grava.UpdateFicheiro("saida.txt","\n");;

        Grava.UpdateFicheiro("saida.txt","\n");;

    }
    public static void apresentarTaxaOUDimensãoFicheiro(double[] vetor) {

        int t = 0;
        String aux= "";

        for (int j = 0; j < vetor.length; j++) {

            if (vetor[j] != 0) {
        aux = "(%d ; %.2f)" + t + Double.toString(vetor[j]);
                Grava.UpdateFicheiro("saida.txt",aux);
                t++;

            }

        }

        Grava.UpdateFicheiro("saida.txt","\n");;

    }
     public static void apresentarDistribuiçãoFicheiro(double[][] Distribuição) {

        int t = 0;
        int count2 = 0;
        String aux = "";
        for (int i = 0; i < Distribuição.length; i++) {

            for (int j = 0; j < Distribuição[i].length; j++) {

                if (Distribuição[i].length > 0 && Distribuição[i][j] != 0) {

                    if (j == 0) {
                         aux = "(%d ; %.2f "+ t + Double.toString(Distribuição[i][j]);
                        Grava.UpdateFicheiro("saida.txt",aux);
                        t++;

                    } else{
                        aux = "; %.2f "+ Double.toString(Distribuição[i][j]);
                        Grava.UpdateFicheiro("saida.txt",aux);
                    }

                }
            }
            if(Distribuição[i][0]!=0){

                Grava.UpdateFicheiro("saida.txt",")\n");;
            }
        }

    }
}