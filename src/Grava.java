import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Classe usada para gravar os resultados do programa no ficheiro de saida do modo não interativo
 */
public class Grava {

    /**
     *
     * @param k
     * @param matrizLeslie
     * @param ficheirosaida
     * @throws IOException
     */

    public static void matriz(int k, double[][] matrizLeslie,String ficheirosaida) throws IOException {

        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida);


        grava.write("k=" + k + "\n");

        grava.write("Matriz de Leslie\n");
        int tamanhoMatriz = matrizLeslie.length;
        for (double[] doubles : matrizLeslie) {

            for (int j = 0; j < tamanhoMatriz; j++) {
                grava.write(String.valueOf(doubles[j]));
                grava.write(" ");
            }
            grava.write("\n");
        }
        grava.write("\n");
        grava.close();


    }

    /**
     *
     * @param total
     * @param ficheirosaida
     * @param k
     * @throws IOException
     */


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

    /**
     *
     * @param variacao
     * @param ficheirosaida
     * @param k
     * @throws IOException
     */


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

    /**
     *
     * @param naonormalizada
     * @param ficheirosaida
     * @param k
     * @param classes
     * @throws IOException
     */


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

    /**
     *
     * @param normalizada
     * @param ficheirosaida
     * @param k
     * @param classes
     * @throws IOException
     */


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

    /**
     *
     * @param valorproprio
     * @param ficheirosaida
     * @throws IOException
     */


    public static void valorproprio(double valorproprio,String ficheirosaida) throws IOException {
        File saida = new File("OutPut\\"+ficheirosaida);
        FileWriter grava=new FileWriter(saida,true);
        DecimalFormat df = new DecimalFormat("#.####");

        grava.write("Maior valor próprio e vetor associado\n");
        grava.write("Lambda=" + df.format(valorproprio) + "\n");

        grava.close();

    }

    /**
     *
     * @param vetorproprio
     * @param ficheirosaida
     * @throws IOException
     */


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

    /**
     *
     * @param k
     * @param total
     */


    public static void graficototal(int k, double[] total) {
        try {
            File fich = new File("Output\\total.txt");
            FileWriter grava = new FileWriter(fich);
            fich.createNewFile();
            for (int i = 0; i < k+1; i++) {

                grava.write(String.valueOf(i));
                grava.write(" "+total[i]+"\n");
            }
            grava.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param k
     * @param variacao
     */


    public static void graficovariacao(int k, double[] variacao){
        try {
            File fich= new File("Output\\variacao.txt");
            FileWriter grava=new FileWriter(fich);
            fich.createNewFile();
            for (int i =0;i<(k);i++) {

                grava.write(String.valueOf(i));
                grava.write(" "+ variacao[i]+"\n");
            }
            grava.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param k
     * @param normalizada
     * @param classes
     */


    public static void graficonormalizada(int k, double[][] normalizada, int classes){
        try {
            File fich= new File("Output\\normalizada.txt");
            FileWriter grava=new FileWriter(fich);
            fich.createNewFile();

            grava.write("g");


            for(int i = 0;i<classes;i++){
                grava.write(" "+"c"+i);
            }

            for(int i= 0; i<k+1;i++){
                grava.write("\n"+i);
                for (int j =0; j<classes; j++) {
                    grava.write(" " + normalizada[i][j]);
                }
            }


            grava.close();


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param k
     * @param naonormalizada
     * @param classes
     */


    public static void graficoNaoNormalizada(int k, double[][] naonormalizada, int classes){
        try {
            File fich= new File("Output\\nao_normalizada.txt");
            FileWriter grava=new FileWriter(fich);
            fich.createNewFile();


            grava.write("g");

            for(int i = 0;i<classes;i++){
                grava.write(" "+"c"+i);
            }

            for(int i= 0; i<k+1;i++){
                grava.write("\n"+i);
                for (int j =0; j<classes; j++) {
                    grava.write(" " + naonormalizada[i][j]);
                }
            }

            grava.close();



        }catch (IOException e){
            e.printStackTrace();
        }
    }
}