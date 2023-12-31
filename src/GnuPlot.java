import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Classe responsavél por mostrar os gráficos ao utilizador, por criar os ficheiros onde vão ser armazenados os gráficos e por mudar o nome destes ficheiros
 */
public class GnuPlot {

    static Scanner read = new Scanner(System.in);

    /**
     *
     * @param nomefich
     */

    public static void main(String nomefich) {


        String opc;
        byte esc = 0;
        do {
            System.out.println("Qual gráfico pretende visualizar?");
            System.out.println("1:Total de individuos");
            System.out.println("2:Variação do número de individuos");
            System.out.println("3:Distribuição de individuos por classe");
            System.out.println("4:Distribuição normalizada de individuos por classe");
            esc = read.nextByte();
            switch (esc) {
                case 1:
                    EscolhaGrafico("total", "total_tmp",nomefich);

                    break;
                case 2:
                    EscolhaGrafico("variacao", "variacao_tmp",nomefich);

                    break;
                case 3:
                    EscolhaGrafico("nao_normalizada", "nao_normalizada_tmp",nomefich);

                    break;
                case 4:
                    EscolhaGrafico("normalizada", "normalizada_tmp",nomefich);
                    break;
            }
            System.out.println("Deseja visualizar outro gráfico?(S/N)");
            opc = read.next();
        } while (!opc.equals("N"));
    }

    /**
     *
     * @param ficheiro
     * @param nometmp
     * @param nomefich
     */


    public static void EscolhaGrafico(String ficheiro, String nometmp,String nomefich) {
        MostraGrafico(ficheiro);

        String choice = "";
        read.nextLine();

        while (!choice.equals("S") && !choice.equals("N")) {
            System.out.println("Pretende guardar o gráfico?(S/N)");
            choice = read.nextLine();
            if (choice.equals("S")) {

                CriaGrafico(ficheiro, EscolhaFormato(), nometmp,nomefich);


            } else if (choice.equals("N")) {

            }
        }
    }

    /**
     *
     * @return
     */

    public static String EscolhaFormato() {

        Byte esc = 0;
        String escolha = "";
        System.out.println("Qual o formato em que pretende guardar o gráfico?");
        System.out.println("1:png");
        System.out.println("2:eps");
        System.out.println("3:txt");
        esc = read.nextByte();
        switch (esc) {
            case 1:
                escolha = "png";

                break;
            case 2:
                escolha = "eps";

                break;
            case 3:
                escolha = "txt";

                break;
            default:
                break;
        }
        return escolha;
    }

    /**
     *
     * @param ficheiro
     */


    public static void MostraGrafico(String ficheiro) {
        String[] location = new String[2];
//      localização do programa
        location[0] = "gnuplot";
//      ddefine o script

        location[1] = "GnuPlot\\" + "mostra_" + ficheiro + ".gp";

        try {
            Runtime.getRuntime().exec(location);

        } catch (IOException e) {

            System.out.println("Algo está errado");

            e.printStackTrace();

        }


    }

    /**
     *
     * @param ficheiro
     * @param formato
     * @param nometmp
     * @param nomefich
     */

    public static void CriaGrafico(String ficheiro, String formato, String nometmp,String nomefich) {
        String[] location = new String[2];
//       programa
        location[0] = "gnuplot";
//      define o script
        location[1] = "GnuPlot\\" + "cria_" + ficheiro + "_" + formato + ".gp";

        try {

            Runtime.getRuntime().exec(location);

        } catch (IOException e) {

            System.out.println("Algo está errado");

            e.printStackTrace();

        }
        try {
            MudaNomeFicheiro(ficheiro, nometmp, formato,nomefich);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     * @return
     */


    public static String ObtemData() {

        Date data = new Date();
        DateFormat f = new SimpleDateFormat("dd-MM-yyyy_HH;mm;ss");
        String date = f.format(data);
        return date;
    }

    /**
     *
     * @param nome
     * @param nomepng
     * @param formato
     * @param nomefich
     * @throws InterruptedException
     */


    public static void MudaNomeFicheiro(String nome, String nomepng, String formato,String nomefich) throws InterruptedException {

        File ficheiro = new File("GnuPlot\\" + nomepng + "." + formato);

        while (!ficheiro.exists()) {
            while (!ficheiro.canRead()) {

            }
        }
        read.nextLine();
        Thread.sleep(100);
        System.out.println("Qual o nome do ficheiro?");
        nomefich=read.nextLine();


        try {

            Path oldname = FileSystems.getDefault().getPath("GnuPlot\\" + nomepng + "." + formato);
            Path newname = FileSystems.getDefault().getPath( nomefich+"_"+nome + "_" + ObtemData() + "." + formato);


            Files.move(oldname, oldname.resolveSibling(newname));
            Path path = FileSystems.getDefault().getPath("Gnuplot\\"+ nomefich+"_"+nome + "_" + ObtemData() + "." + formato);

            Path newdir = FileSystems.getDefault().getPath("Output");

            Files.move(path, newdir.resolve(path.getFileName()));

            System.out.println("Ficheiro guardado com sucesso!");

        } catch (IOException e) {
            System.out.println("Algo falhou... Não foi possivel criar o ficheiro");
            e.printStackTrace();
        }

    }
}