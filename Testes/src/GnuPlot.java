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
    public static void main(String[] args) throws InterruptedException {
        CriaGrafico();
        MudaNomeFicheiro();
    }

    public static void CriaGrafico() {

        Runtime run = Runtime.getRuntime();
        String[] location = new String[2];

        location[0] = "C:\\Program Files\\gnuplot\\bin\\wgnuplot.exe";
        location[1] = "GnuPlot\\1.gp";

        try {

            run.exec(location);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void MudaNomeFicheiro() {
/*

        Calendar datahora = Calendar.getInstance();
        Date data = new Date();

        DateFormat f = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");

        String date = f.format(data);

        File oldfile = new File("C:\\Users\\eduar\\Documents\\Projeto_Lapr\\GnuPlot\\1.png");
        File newfile = new File( "C:\\Users\\eduar\\Documents\\Projeto_Lapr\\GnuPlot\\"+ date + ".png");

        System.out.println(newfile);

        boolean success = oldfile.renameTo(newfile);

        if (success) {

            System.out.println("File renamed");

        } else {

            System.out.println("Sorry! the file can't be renamed");

        }


*/
        File ficheiro = new File("GnuPlot\\1.png");
        // Isto pode ser melhorado de certeza
        while (!ficheiro.exists()) {
        }

        try {

            Date data = new Date();
            DateFormat f = new SimpleDateFormat("dd-MM-yyyy_HH;mm;ss");
            String date = f.format(data);

            Path oldname = FileSystems.getDefault().getPath("GnuPlot\\1.png");
            Path newname = FileSystems.getDefault().getPath(date+".png");

            Files.move( oldname, oldname.resolveSibling(newname));
            Path path = FileSystems.getDefault().getPath("Gnuplot\\"+date+".png");

            Path newdir = FileSystems.getDefault().getPath("Output");

            Files.move(path, newdir.resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}