import java.io.*;

public class Grava {


    public static void matriz(int k, double[][] matrizLeslie,String ficheirosaida) throws IOException {

         File saida = new File("OutPut\\"+ficheirosaida);
         FileWriter grava=new FileWriter(saida);


        grava.write("k=" + k + "\n");

        grava.write("Matriz de Leslie");
        int tamanhoMatriz = matrizLeslie.length;
        for (double[] doubles : matrizLeslie) {

            for (int j = 0; j < tamanhoMatriz; j++) {
                grava.write(String.valueOf(doubles[j]));
                grava.write("\n");
            }
        }
        grava.close();


    }

    public static void total(double[] total,String ficheirosaida) throws IOException {
        File saida = new File("OutPut\\"+ ficheirosaida);
        FileWriter grava=new FileWriter(saida);


        grava.write("Numero total de individuos\n");
        grava.write("(t, Nt)\n");
        for (int i = 0; i < total.length; i++) {
            grava.write("(" + i + ", " + total[i] + ")");
        }
        grava.close();

    }


    public static void variacao(double[] variacao,String ficheirosaida) throws IOException {

        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida);
        grava.write("Crescimento da população\n");
        grava.write("(t, delta_t)\n");
        for (int i = 0; i < variacao.length; i++) {
            grava.write("(" + i + ", " + variacao[i] + ")");
        }
        grava.close();

    }

    public static void naonormalizado(double[][] naonormalizada,String ficheirosaida) throws IOException {

        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida);


        grava.write("Numero por classe (não normalizado)\n");
        grava.write("(t,");
        for (int i = 0; i < naonormalizada[0].length; i++) {
            grava.write("x" + (i + 1) + ",");
        }
        grava.write(")\n");

        for (int i = 0; i < naonormalizada.length; i++) {
            grava.write("(" + i + ", ");
            for (int j = 0; j < naonormalizada[i].length; j++) {

                grava.write(naonormalizada[i][j] + ",");
            }
            grava.write(")\n");

        }
        grava.close();

    }

    public static void normalizado(double[][] normalizada,String ficheirosaida) throws IOException {

        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida);


        grava.write("Numero por classe (normalizado)\n");
        grava.write("(t,");
        for (int i = 0; i < normalizada[0].length; i++) {
            grava.write("x" + (i + 1) + ",");
        }
        for (int i = 0; i < normalizada.length; i++) {
            grava.write("(" + i + ", ");
            for (int j = 0; j < normalizada[i].length; j++) {

                grava.write(normalizada[i][j] + ",");
            }
            grava.write(")\n");
        }
        grava.write("\n\n\n");

        grava.close();

    }

    public static void valorproprio(double valorproprio,String ficheirosaida) throws IOException {
        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida);

        grava.write("Maior valor próprio e vetor associado\n");
        grava.write("Lambda=" + valorproprio + "\n");

        grava.close();

    }

    public static void vetorproprio(double[] vetorproprio,String ficheirosaida) throws IOException {
        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida);
        grava.write("vetor próprio=(");
        for (double v : vetorproprio) {
            grava.write(v + ",");
        }
        grava.write(")");

        grava.close();


    }

    public static void gravaTudo(){

    }


}

