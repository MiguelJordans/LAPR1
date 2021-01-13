import java.util.Scanner;

public class multiplicarMatrizes {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //int r1 = 2, c1 = 3;
        //int r2 = 3, c2 = 2;

        int l1 = in.nextInt(), c1 = in.nextInt();
        int l2 = in.nextInt(), c2 = in.nextInt();
        System.out.println();

        if (c1 != l2) {
            System.out.println("Produto Impossível");
        } else {

            int[][] firstMatrix = new int[l1][c1];
            int[][] secondMatrix = new int[l2][c2];

            for (int i = 0; i < l1; i++) {
                for (int j = 0; j < c1; j++) {
                    firstMatrix[i][j] = in.nextInt();
                }
            }
            System.out.println();
            for (int i = 0; i < l2; i++) {
                for (int j = 0; j < c2; j++) {
                    secondMatrix[i][j] = in.nextInt();
                }
            }
            System.out.println();

            // Multiplicar 2 matrizes
            int[][] product = multiplicarMatrizes(firstMatrix, secondMatrix, l1, c1, c2);
            // Mostrar o resultado
            apresentarProduto(product);
        }

    }

    public static int[][] multiplicarMatrizes(int[][] firstMatrix, int[][] secondMatrix, int l1, int c1, int c2) {
        int[][] produto = new int[l1][c2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    produto[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return produto;
    }

    public static void apresentarProduto(int[][] produto) {
        System.out.println("O produto das duas matrizes é: ");
        for (int[] linha : produto) {
            for (int coluna : linha) {
                System.out.print(coluna + "    ");
            }
            System.out.println();
        }
    }
}

