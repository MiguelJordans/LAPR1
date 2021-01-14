import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Distribuição {
    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        String file_in = "C:\\Users\\MiguelJordão(1201487\\IdeaProjects\\Teste Vetores\\src\\array.txt";

        Scanner input = new Scanner(new File(file_in));
        Scanner in = new Scanner(new File(file_in));

        System.out.println();

        int n=0;

        while (in.hasNextDouble()) {
           ++n;
           in.nextLine();
            }
        in.nextLine();

        double[][] X;
        X=lerVetor(n);

        //if(in.hasNextInt()) for(int i=0;i<n;i++) X[i]=in.nextInt();

        double[][] matriz = new double[n][n];


            for(int i = 0;i<n;i++){
                for(int j=0;j<n;j++){
                    matriz[i][j]=input.nextDouble();
                }
                if(input.hasNextLine()) input.nextLine();

            }
        int m=n,b=1;

        apresentarMatriz(matriz,n);

        double[][]produto=multiplicarMatrizes(matriz,X,n,m,b);

        double dimensão=dimensao(X,n);

        System.out.println();
        System.out.println(dimensão);

        double[][]vetorNormalizado=distribuiçaoNormalizada(produto,dimensão,n);
        apresentarMatriz(vetorNormalizado,n);

    }
    public static void apresentarMatriz(double [][] matriz,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.printf("%.2f\t",matriz[i][j]);
            }
            System.out.println();
        }
    }
    public static double[][] lerVetor(int n){
        double[][]A=new double[1][n];

        for(int i=0;i<n;i++){
            A[0][i]=ler.nextDouble();
        }
        System.out.println();
        return A;
    }
    public static double[][] multiplicarMatrizes(double[][] firstMatrix, double[][] X, int l1,int c1,int c2) {
        double[][] produto = new double[l1][c2];
        for(int i = 0; i < l1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    produto[i][j] = produto[i][j]+(firstMatrix[i][k] * X[0][j]);
                }
            }
        }
        System.out.println();
        for(int i = 0; i < l1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.printf("%.0f\t",produto[i][j]);
            }
            System.out.println();

        }
        return produto;
    }
    public static double dimensao(double[][]X,int n){
        double soma=0;
        for(int i=0;i<1;i++){
            for(int j=0;j<n;j++){
                soma+=X[0][j];
            }
        }
        return soma;
    }
    public static double[][] distribuiçaoNormalizada(double[][]produto,double dimensao,int n){

        double[][] vetorNormalizado=new double[1][produto.length];
        for(int i=0;i<1;i++){
            for(int j=0;j<n;j++){
                vetorNormalizado[i][j]=(produto[i][j]/dimensao)*100;
            }
        }
        return vetorNormalizado;
    }

}


