import java.util.Arrays;
import java.util.Scanner;

public class Ler {

    static Scanner read = new Scanner(System.in);

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


    public static int leslie(double[] nIndividuos, double[] taxaF, double[] taxaS) {

        int geracao = 0;
        boolean acabou = false;
        double[] ler = new double[nIndividuos.length];

        while (!acabou) {

            String acabar = "";


            System.out.printf("\nNúmero de indivíduos da %dª geração\n\n", geracao + 1);
            ler[geracao] = read.nextDouble(); //Se quiserem podemos tirar esta redundância que fiz
            nIndividuos[geracao] = (int) ler[geracao];


            System.out.printf("\nTaxa de fecundidade da %dª geração\n", geracao + 1);
            System.out.println();
            taxaF[geracao] = read.nextDouble();


            System.out.printf("\nTaxa de mortalidade da %dª geração ", geracao + 1);
            System.out.print("(Se for ultima geração este valor não vai ser lido, por isso pode deixar a 0)\n");
            System.out.println();
            taxaS[geracao] = read.nextDouble();

            while (taxaS[geracao] > 1 || 0 > taxaS[geracao]) {

                System.out.printf("\nValor inválido, por favor introduza um valor entre 0 e 1\n\n");
                taxaS[geracao] = read.nextDouble();

            }

            read.nextLine();


            while (!acabar.equals("S") && !acabar.equals("N")) {

                System.out.printf("\nDeseja  introduzir mais dados?(S/N)\n\n");
                acabar = read.nextLine();

                if (acabar.equals("N")) {
                    acabou = true;

                } else if (acabar.equals("S")) {

                    acabou = false;

                }

            }

            geracao++;

        }
        return geracao;
    }

    public static double[] resetarVetor(double[] Vetor) {

        double[] vetorReset = new double[Vetor.length];

        for (int i = 0; i < vetorReset.length; i++) {
            Vetor[i] = 0;
            vetorReset[i] = Vetor[i];
        }

        return vetorReset;

    }


    public static double[] resetarTaxa(double[] guardaTaxa, double[] guardaDimensao) {

        for (int i = 0; i < guardaTaxa.length; i++) {
            if (guardaDimensao[i] == 0) {
                guardaTaxa[i] = 0;
            }
        }

        return guardaTaxa;
    }
}
