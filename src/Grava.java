import java.io.*;
import java.text.DecimalFormat;

public class Grava {


    public static void matriz(int k, double[][] matrizLeslie,String ficheirosaida) throws IOException {

         File saida = new File("OutPut\\"+ficheirosaida);
         FileWriter grava=new FileWriter(saida);


        grava.write("k=" + k + "\n");

        grava.write("Matriz de Leslie\n");
        int tamanhoMatriz = matrizLeslie.length;
        for (double[] doubles : matrizLeslie) {

            for (int j = 0; j < tamanhoMatriz; j++) {
                grava.write(String.valueOf(doubles[j]));
                grava.write("");
            }
            grava.write("\n");
        }
        grava.write("\n");
        grava.close();


    }

    public static void total(double[] total,String ficheirosaida, int k) throws IOException {
        File saida = new File("OutPut\\"+ ficheirosaida);
        FileWriter grava=new FileWriter(saida,true);


        grava.write("Numero total de individuos\n");
        grava.write("(t, Nt)\n");
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < k; i++) {
            grava.write("(" + i + ", " + df.format(total[i]) + ")\n");
        }
        grava.write("\n");
        grava.close();

    }


    public static void variacao(double[] variacao,String ficheirosaida, int k) throws IOException {

        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida,true);
        grava.write("Crescimento da população\n");
        grava.write("(t, delta_t)\n");
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < k; i++) {
            grava.write("(" + i + ", " + df.format(variacao[i]) + ")\n");
        }
        grava.write("\n");
        grava.close();

    }

    public static void naonormalizado(double[][] naonormalizada,String ficheirosaida,int k,int classes) throws IOException {

        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida,true);

        DecimalFormat df = new DecimalFormat("#.##");

        grava.write("Numero por classe (não normalizado)\n");
        grava.write("(t,");
        for (int i = 0; i < classes; i++) {
            grava.write("x" + (i + 1) + ";");
        }
        grava.write(")\n");

        for (int i = 0; i < k; i++) {
            grava.write("(" + i + ";");
            for (int j = 0; j < classes; j++) {

                grava.write(df.format(naonormalizada[i][j]) + ";");
            }
            grava.write(")\n");

        }
        grava.write("\n");
        grava.close();

    }

    public static void normalizado(double[][] normalizada,String ficheirosaida, int k,int classes) throws IOException {

        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida,true);

        DecimalFormat df = new DecimalFormat("#.##");
        grava.write("Numero por classe (normalizado)\n");
        grava.write("(t,");

        for (int i = 0; i < classes; i++) {
            grava.write("x" + (i + 1) + ",");
        }
        grava.write(")\n");
        for (int i = 0; i < k; i++) {
            grava.write("(" + i + "; ");
            for (int j = 0; j < classes; j++) {

                grava.write(df.format(normalizada[i][j]) + ";");
            }
            grava.write(")\n");
        }
        grava.write("\n\n\n");

        grava.close();

    }

    public static void valorproprio(double valorproprio,String ficheirosaida) throws IOException {
        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida,true);
        DecimalFormat df = new DecimalFormat("#.##");

        grava.write("Maior valor próprio e vetor associado\n");
        grava.write("Lambda=" + df.format(valorproprio) + "\n");

        grava.close();

    }

    public static void vetorproprio(double[] vetorproprio,String ficheirosaida) throws IOException {
        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida,true);
        grava.write("vetor próprio=(");
        DecimalFormat df = new DecimalFormat("#.##");

        for (double v : vetorproprio) {

            grava.write(df.format(v) + ";");
        }
        grava.write(")\n");

        grava.close();


    }

    public static void gravaTudo(){

    }
    
    public static void UpdateFicheiro(String ficheiroSaida, String vTexto){

        try {
            FileWriter escrever = new FileWriter(ficheiroSaida, true);
            BufferedWriter update = new BufferedWriter(escrever);

            update.write(vTexto);
            update.newLine();
            update.close();

            System.out.println("Escrito no Ficheiro com sucesso.");

        } catch (IOException e) {
            System.out.println("Occureu um erro.");
            e.printStackTrace();
        }


    }

    public static void CriarFicheiro(String saida){
        try {
            File myObj = new File("saída.txt");
            if (myObj.createNewFile()) {

                System.out.println("Ficheiro Criado. " + myObj.getName());
            } else {

                System.out.println("Ficheiro já existe. ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }



}

