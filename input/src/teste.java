import java.io.FileNotFoundException;
import  java.util.*;
import java.io.File;

public class teste {
    public static int[][] lerMatriz() throws FileNotFoundException {
        String nomeMatriz = "";
        int matrizLinhaAtual = 0;

        Scanner ler = new Scanner(System.in);
        System.out.print("Qual é o nome do ficheiro: ");
        String nomeFicheiro = ler.nextLine();
        File main = new File(nomeFicheiro);

            Scanner ficheiro;
            int dimensao;
            //falta definir como vai ser o tamanho da matriz
            int matriz[][] = new int[][];

                ficheiro = new Scanner(main);
                nomeMatriz = ficheiro.nextLine();
                System.out.println("Nome: " + nomeMatriz);
                dimensao = Integer.parseInt(ficheiro.nextLine());

                matriz = new int[dimensao][dimensao];
                    while (ficheiro.hasNextLine()) {

                        String linhaAux = ficheiro.nextLine();
                        String linhaNumerosSeparados[] = linhaAux.split("");
                        int inteiros[] = new int[dimensao];
                            for (int i = 0; i < dimensao; i++) {
                                inteiros[i] = Integer.parseInt(linhaNumerosSeparados[i]);
                }
                                     for (int i = 0; i < dimensao; i++) {
                    matriz[matrizLinhaAtual][i] = inteiros[i];
                }
                matrizLinhaAtual++;
            }
            ficheiro.close();
        }
        return matriz;
    }



