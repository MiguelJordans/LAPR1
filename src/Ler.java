import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe encarregue para a leitura de dados e armazenamento das informações nas respetivas variáveis
 */

public class Ler  {

    static Scanner read = new Scanner(System.in);

    /**
     * @param nIndividuos vetor inicial que guarda o número de indivíduos por classe
     * @param taxaS vetor com as informações respetivas à taxa de mortalidade
     * @param taxaF vetor com as informações respetivas à taxa de fecundidade
     * @param geracao gerações introduzidas pelo utilizador a estimar
     * @return return à matriz criada a partir dos parâmetros anteriormente mencionados
     */


    public static double[][] criaMatriz(double[] nIndividuos, double[] taxaS, double[] taxaF, int geracao) {


        nIndividuos = limpaVetor(nIndividuos, geracao); //Função para limpar o vetor(Isto é endereços de memória que não apresentem valores são apagados)
        taxaS = limpaVetor(taxaS, (geracao - 1));
        taxaF = limpaVetor(taxaF, geracao);

        double[][] matizLeslie = new double[nIndividuos.length][nIndividuos.length]; //Criação da matriz que vai guardar as informações sobre a população


        for (int i = 0; i < taxaF.length; i++) { //Ciclo para guardar na matriz os valores respetivos à taxa de fecundidade

            matizLeslie[0][i] = taxaF[i];

        }

        for (int j = 0; j < taxaS.length; j++) { //Ciclo para guardar na matriz os valores respetivos à taxa de mortalidade

            matizLeslie[j + 1][j] = taxaS[j];

        }

        return matizLeslie; //return à matriz de leslie

    }


    /**
     * @param array vetor que vai sofrer as alterações
     * @param geracao variável que guarda o número de gerações a estimar
     * @return
     */


    public static double[] limpaVetor(double[] array, int geracao) {

        double[] vetorLimpo = Arrays.copyOf(array, geracao); //Limpeza dos endereços de memória não utilizados do vetor

        return vetorLimpo; //Return ao vetor após a realização da função anteriormente mencionada

    }

    /**
     * @param nIndividuos vetor inicial que guarda o número de indivíduos por classe
     * @param taxaF vetor com as informações respetivas à taxa de fecundidade
     * @param taxaS vetor com as informações respetivas à taxa de mortalidade
     * @return ao número de gerações a estimar
     */


    public static int leslie(double[] nIndividuos, double[] taxaF, double[] taxaS) {

        //Inicialização das variáveis necessárias
        int geracao = 0;
        boolean acabou = false;
        double[] ler = new double[nIndividuos.length];

        while (!acabou) {

            String acabar = "";


            System.out.printf("\nNúmero de indivíduos da %dª geração\n\n", geracao + 1); //Leitura do número de indivíduos por geração
            ler[geracao] = read.nextDouble();
            nIndividuos[geracao] = (int) ler[geracao];


            System.out.printf("\nTaxa de fecundidade da %dª geração\n", geracao + 1); //Leitura da taxa de fecundidade da respetiva geração
            System.out.println();
            taxaF[geracao] = read.nextDouble();


            System.out.printf("\nTaxa de mortalidade da %dª geração ", geracao + 1); //Leitura da taxa de mortalidade da respetiva geração
            System.out.print("(Se for ultima geração este valor não vai ser lido, por isso pode deixar a 0)\n");
            System.out.println();
            taxaS[geracao] = read.nextDouble();

            while (taxaS[geracao] > 1 || 0 > taxaS[geracao]) { //A taxa de mortalidade tem de estar enquadrada entre os valores 0 e 1 , pois a mesma não pode nem ser negativa nem ultrapassar o 1

                System.out.printf("\nValor inválido, por favor introduza um valor entre 0 e 1\n\n");
                taxaS[geracao] = read.nextDouble();

            }

            read.nextLine();


            while (!acabar.equals("S") && !acabar.equals("N")) { //Ciclo para verificar se o utilizador deseja continuar a introduzir valores

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

        return geracao; //Return ao tamanho da matriz (uma vez que as matrizes de Leslie são sempre de ordem "n" ou seja quadradas )

    }

    /**
     * @param Vetor que vai sofrer alterações
     * @return ao vetor após de ser "resetado" (isto é igual todos as suas entradas a 0)
     */


    public static double[] resetarVetor(double[] Vetor) {

        double[] vetorReset = new double[Vetor.length];

        for (int i = 0; i < vetorReset.length; i++) { //Ciclo para igual os valores do vetor a 0
            Vetor[i] = 0;
            vetorReset[i] = Vetor[i];
        }

        return vetorReset; //return ao vetor "resetado"

    }

}
