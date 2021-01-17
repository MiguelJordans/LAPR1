import java.util.Arrays;

public class Ler {

    public static double[][] criaMatriz(double[] nIndividuos, double[] taxaS, double[] taxaF, int geracao) {

        nIndividuos = limpaVetor(nIndividuos, geracao);
        taxaS = limpaVetor(taxaS, (geracao - 1));
        taxaF = limpaVetor(taxaF, geracao);

        double[][] matizLeslie = new double[nIndividuos.length][nIndividuos.length];


        for (int i = 0; i < taxaF.length; i++) {

            matizLeslie[0][i] = taxaF[i];

        }

        for (int j = 0; j < taxaS.length; j++) {

            matizLeslie[j + 1][j] = taxaS[j];

        }

        return matizLeslie;

    }


    public static double[] limpaVetor(double[] array, int geracao) {

        double[] vetorLimpo = Arrays.copyOf(array, geracao);

        return vetorLimpo;

    }

    public static int encontraUltimoValor(double[] array) {

        int end = 0;
        int i = 0;
        boolean acabou = false;

        while (i < array.length && !acabou) {

            if (array[i] == 0) {

                end = i;
                acabou = true;

            }

            i++;
        }

        return end;

    }

}
