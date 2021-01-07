
public class GnuPlot {
    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        String[] location = new String[2];
        location[0] = "C:\\Program Files\\gnuplot\\bin\\wgnuplot.exe";
        location[1] = "GnuPlot\\1.gp";
        try {
            run.exec(location);
            System.out.println("gráfico gerado com sucesso!!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
