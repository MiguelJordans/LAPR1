import java.util.Scanner;

public class Menu {

    static Scanner read = new Scanner(System.in);

    public static void Menu(){

        boolean choice = true;
        int flag=0;

        while (choice) {

            String text
                    = "\n********************************************************************************************************\n"
                    + "\t(0)\tSair\t\t\t\t\t\t\t\t\t(1)\tIntroduzir novos dados\t\n"
                    + "\t(2)\tMostrar matriz\t\t\t\t\t\t\t(3)\tMostrar gerações(k)\t\n"
                    + "\t(4)\tApresentar as informações todas\t\t\t(5)\tGuardar dados no ficheiro\t\n"
                    + "\t(6)\tApresentar a distribuição normalizada\t(7)\tApresentar a distribuição não normalizada\t\n"
                    + "\t(8)\tApresentar a dimensão populacional\t\t(9)\tApresentar o comportamento Assintotico\t\n"
                    + "\t(10) Apresentar a taxa de variação\t\t\t(11) Apresentar o valor próprio\t\n"
                    + "\t(12) Apresentar o vetor próprio\t\t\t\t(13) Ler dados a partir de um ficheiro\t\n"
                    + "\t(14) Aplicar gráficos\t\t\t\t\t\t(15) Dar run aos testes unitários\t\n"
                    + "********************************************************************************************************\nComando> ";

            double[] taxaS = new double[199];
            double[] taxaF = new double[199];
            double[] nIndividuos = new double[199];
            int t;
            double D;

            if(flag==0){

                Welcome.Welcome();
                flag++;
                System.out.printf("Por favor introduza a matriz de Lelie:\n\n");

            }

            else if(flag>0)  {

                System.out.printf("\n\n\n\nPor favor introduza novamente a matriz de Lelie:\n\n");

            }

            int geracao =  Ler.leslie(nIndividuos,taxaF,taxaS);

            System.out.printf("\nIntroduza o número de instantes de tempo a gerar\n\n");
            t = read.nextInt();
            System.out.println();

            double[][] matriz = Ler.criaMatriz(nIndividuos, taxaS, taxaF, geracao);

            nIndividuos = Ler.limpaVetor(nIndividuos, geracao);

            System.out.println(text);
            D=read.nextDouble();
            boolean check=true;
            String A="";
            int counter2=0;
            int Flag=0;

            while(check){

                int Y=(int)D;

                if(Y==0||Y==1) check=false;
                if(counter2!=0){
                    System.out.println("Novos dados alocados");
                    System.out.println(text);
                }

                switch (Y){
                    case 0:
                        choice=false;
                        Flag++;
                        break;

                    case 1:
                        choice=true;
                        Flag++;
                        break;

                    case  2:
                        System.out.printf("\nMatriz de Leslie\n");
                        Apresentar.apresentarMatriz(matriz);
                        break;

                    case 3:
                        System.out.printf("\nk=%d\n\n",t);
                        break;

                    case 4:
                        Distribuição.ApresentarDist(matriz,t,nIndividuos);
                        System.out.println(text);
                        break;

                    case 5:

                        break;

                    case 6:

                        break;

                    case 7:

                        break;

                    case 8:

                        break;

                    case 9:

                        break;

                    case 10:

                        break;

                    case 11:

                        break;

                    case 12:

                        break;

                    case 13:

                        counter2++;
                        System.out.printf("\nDe certeza que pretende ler os dados (introduzidos previamente ) de um ficheiro? Caso o faço todos os dados previamente guardados serão apagados\n\n");

                        A=read.nextLine();
                        read.nextLine(); //meter isto a funcionar depois

                        CLS.clearScreen();
                       // if(A) // Aqui metem a função para apagar os dados previamente colocados e guardar novos dados do ficheiro não interavito
                        break;

                    case 14:
                        //Aqui aplica-se a classe respetiva dos gráficos
                        break;

                    default:
                        System.out.println("Porfavor introduza um valor válido");
                        break;
                        
                }

               if(Flag==0)D=read.nextDouble();

            }
        }
    }
    /*
     while (!choi.equals("S") && !choi.equals("N")||!choi.equals("s") && !choi.equals("n")) {

                System.out.printf("Deseja voltar a introduzir dados?(S/N)\n\n");
                choi = read.nextLine();

                if (choi.equals("S")||choi.equals("s")) {

                    choice = true;

                } else if (choi.equals("N")||choi.equals("n")) {

                    choice = false;

                }

                else System.out.println("Porfavor introduza uma opção válida");

            }
     */

}

