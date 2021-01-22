import java.util.Arrays;

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
        int counter=0;


        for (int j = 0; j < vetor.length; j++) {

            if (vetor[j] != 0) {

                System.out.printf("(%d ; %.2f)\n", t, vetor[j]);
                t++;

            }

        }

        System.out.println();

    }


    public static void apresentarDimensão(double[]vetor,int k){

        int t = 0;
        int counter=0;


        for (int j = 0; j < vetor.length; j++) {

            if (vetor[j] != 0) {

                System.out.printf("(%d ; %.2f)\n", t, vetor[j]);
                t++;
                counter++;

            }

        }

        if(counter!=k+1) System.out.printf("\nA população extingiu-se a partir da %dª geração.\n",counter);

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

        boolean igual;

           /* for (int j = 0; j < A.length; j++) { //Não esta a dar bem?

                if (A[j] != B[j]) {

                    igual=false;
                    break;

                }

            }*/

        if(Arrays.equals(A,B)) igual=false; //Tentei ver no stackoverflow mas continua a dar erro mesmo utilizando estas funções??
        else igual=true;

        return igual;

    }
    public static void apresentarVetorFicheiro(double[] vetor) {


        String fichSaida = "c:\temp\teste1.txt";

        for (int j = 0; j < vetor.length; j++) {

            if (j == vetor.length) {

                String aux = "";

                aux = "%.2f)"+Double.toString(vetor[j]);

                Grava.UpdateFicheiro(fichSaida,aux );

            }

            else if (j == 0) {

                String aux = "";

                aux = "(%.2f"+Double.toString(vetor[j]);

                Grava.UpdateFicheiro(fichSaida, aux);

            }

            else{

                String aux = "";

                aux = ";%.2f"+Double.toString(vetor[j]);

                Grava.UpdateFicheiro(fichSaida, aux);

            }

        }

        Grava.UpdateFicheiro(fichSaida,")");

        Grava.UpdateFicheiro(fichSaida,"\n");;

        Grava.UpdateFicheiro(fichSaida,"\n");;

    }

    public static void apresentarTaxaOUDimensãoFicheiro(double[] vetor) {

        String fichSaida = "c:\temp\teste1.txt";
        int t = 0;
        String aux= "";

        for (int j = 0; j < vetor.length; j++) {

            if (vetor[j] != 0) {

                aux = "(%d ; %.2f)" + t + Double.toString(vetor[j]);

                Grava.UpdateFicheiro(fichSaida,aux);

                t++;

            }

        }

        Grava.UpdateFicheiro(fichSaida,"\n");;

    }


    public static void apresentarDistribuiçãoFicheiro(double[][] Distribuição) {

        String fichSaida = "c:\temp\teste1.txt";
        int t = 0;
        String aux = "";

        for (int i = 0; i < Distribuição.length; i++) {

            for (int j = 0; j < Distribuição[i].length; j++) {

                if (Distribuição[i].length > 0 && Distribuição[i][j] != 0) {

                    if (j == 0) {

                         aux = "(%d ; %.2f "+ t + Double.toString(Distribuição[i][j]);

                        Grava.UpdateFicheiro(fichSaida,aux);

                        t++;

                    } else{

                        aux = "; %.2f "+ Double.toString(Distribuição[i][j]);

                        Grava.UpdateFicheiro(fichSaida,aux);

                    }

                }

            }

            if(Distribuição[i][0]!=0){

                Grava.UpdateFicheiro(fichSaida,")\n");;

            }

        }

    }

}