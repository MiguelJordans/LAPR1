import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Grava {
    public File saida = new File("OutPut\\saida.txt");
    public FileWriter grava;

    {
        try {
            grava = new FileWriter("OutPut\\saida.txt");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    public static void matriz(int k, double[][] matrizLeslie) throws IOException {

        File saida = new File("OutPut\\saida.txt");
        FileWriter grava = new FileWriter("OutPut\\saida.txt");


        grava.write("k=" + k + "\n");

        grava.write("Matriz de Leslie");
        int tamanhoMatriz = matrizLeslie.length;
        for (int i = 0; i < tamanhoMatriz; i++) {

            for (int j = 0; j < tamanhoMatriz; j++) {
                grava.write(String.valueOf(matrizLeslie[i][j]));
                grava.write("\n");
            }
        }

    }

    public void total(double[] total) throws IOException {


        grava.write("Numero total de individuos\n");
        grava.write("(t, Nt)\n");
        for (int i = 0; i < total.length; i++) {
            grava.write("(" + i + ", " + total[i] + ")");
        }
    }


    public void variacao(double[] variacao) throws IOException {
        grava.write("Crescimento da população\n");
        grava.write("(t, delta_t)\n");
        for (int i = 0; i < variacao.length; i++) {
            grava.write("(" + i + ", " + variacao[i] + ")");
        }
    }

    public void naonormalizado(double[][] naonormalizada) throws IOException {


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
    }

    public void normalizado(double[][] normalizada) throws IOException {


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
    }

    public void valorproprio(double valorproprio) throws IOException {

        grava.write("Maior valor próprio e vetor associado\n");
        grava.write("Lambda=" + valorproprio + "\n");
    }

    public void vetorproprio(double[] vetorproprio) throws IOException {
        grava.write("vetor próprio=(");
        for (int i = 0; i < vetorproprio.length; i++) {
            grava.write(vetorproprio[i] + ",");
        }
        grava.write(")");


    }

    public void close() throws IOException {
        grava.close();
    }
}

