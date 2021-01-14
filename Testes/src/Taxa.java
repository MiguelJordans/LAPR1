/**
 * @author Ana Ferreira
 */

public class taxa {
    public static void main(String[] args) {

        //ciclo for para apresenta todos os valores de 0 a t
        for (int t=0; t <= k; t++){
            double dimensao=dimPopulacao_NumMomento(leslie,v_inicial,t) ;
            System.out.print("D.P com t=" + t+ ": ");  //D.P: dimensao da populaçao
            System.out.printf("%.2f\n",dimensao);
            if (t != k){
                taxaVariacao(leslie,v_inicial,t);
            }
        }
    }

    public static double dimPopulacao_NumMomento(double[][] leslie, double[] v_inicial, int t) {
        double[] vetor = multiplicar_matriz_por_vetor(potencia_matriz(leslie, t), v_inicial);
        double soma=0;

        for(int i = 0;i < vetor.length; i++) {
            soma += vetor[i];
        }

        return soma;
    }

    public static double[][] potencia_matriz(double A[][], int n) {
        double[][] matriz = A;
        for (int i = 1; i < n; i++) {
            matriz = multiplicar_2matrizes(matriz, A);
        }

        return matriz;
    }

    public static void taxaVariacao(double[][] leslie, double[] v_inicial, int t){
        double Nt0, Nt1, lambda;
        Nt0=dimensao_populacao_num_determinado_momento(leslie, v_inicial, t);
        Nt1=dimensao_populacao_num_determinado_momento(leslie, v_inicial, t + 1);
        lambda = Nt1/Nt0;

        System.out.print("Taxa de variação (t=" + t + "): ");
        System.out.printf("%.4f\n",lambda);
    }

    /public static void taxa_variacao(double[] matriz) {
        double taxa;
        for (int i=0; i < matriz.length - 1 ; i++){
            taxa = matriz[i+1] / matriz[i];
            System.out.printf("["+taxa+"]");
        }
        System.out.println();
    }/


}

Message #geral