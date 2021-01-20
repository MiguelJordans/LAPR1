import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

    public class EscreverNumFicheiro {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("saída.txt");
            myWriter.write("");
            myWriter.close();

            System.out.println("Escrito no Ficheiro com sucesso.");

        } catch (IOException e) {
            System.out.println("Occureu um erro.");
            e.printStackTrace();
        }

    }



    public static void CriarFicheiro(String ficheiro){
        try {
            File myObj = new File("saída.txt");
            if (myObj.createNewFile()) {

                System.out.println("Ficheiro criado: " + myObj.getName());
            } else {

                System.out.println("Ficheiro já existe. ");
            }
        } catch (IOException e) {
            System.out.println("Ocurrei um erro.");
            e.printStackTrace();
        }

    }
}