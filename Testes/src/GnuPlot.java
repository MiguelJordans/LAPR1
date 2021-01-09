import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GnuPlot {
    public static void main(String[] args) {
        CriaGrafico();
        MudaNomeFicheiro();
    }

    public static void CriaGrafico() {


        String[] location = new String[2];
//      localização do programa
        location[0] = "C:\\Program Files\\gnuplot\\bin\\gnuplot.exe";
//      localização do gnuplot
        location[1] = "GnuPlot\\1.gp";

        try {
            Runtime.getRuntime().exec(location);

        } catch (IOException e) {

            System.out.println("Algo está errado");

            e.printStackTrace();

        }


    }


    public static void MudaNomeFicheiro() {

        File ficheiro = new File("GnuPlot\\1.png");
        // Isto pode ser melhorado de certeza
        System.out.println("A criar o ficheiro ...");
        while (!ficheiro.exists()) {
            while (!ficheiro.canRead()) {

            }
        }


        try {

            Date data = new Date();
            DateFormat f = new SimpleDateFormat("dd-MM-yyyy_HH;mm;ss");
            String date = f.format(data);

            Path oldname = FileSystems.getDefault().getPath("GnuPlot\\1.png");
            Path newname = FileSystems.getDefault().getPath(date + ".png");

            Files.move(oldname, oldname.resolveSibling(newname));
            Path path = FileSystems.getDefault().getPath("Gnuplot\\" + date + ".png");

            Path newdir = FileSystems.getDefault().getPath("Output");

            Files.move(path, newdir.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}