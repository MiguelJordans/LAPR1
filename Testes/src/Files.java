import java.io.*;

public class Files {
    public static void main(String[] args) {
        try {

            File saida = new File("OutPut\\saida.txt");
            FileWriter grava = new FileWriter("OutPut\\saida.txt");
            String data = "Ola \n";
            for(int i=0;i<5;i++) {
                grava.write(i+" Sei la\n");
            }
            grava.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

