import java.util.Scanner;

public class Menu {

    static Scanner read = new Scanner(System.in);

    public static void Menu(String nomefich, int f){

        boolean choice = true;
        int flag=0;

        while (choice) {

            String text
                    = "\n**********************************************************************************************************************\n"
                    + "\t(0)\tSair\t\t\t\t\t\t\t\t\t(1)\tIntroduzir novos dados\t\n"
                    + "\t(2)\tMostrar matriz\t\t\t\t\t\t\t(3)\tMostrar gerações (k)\t\n"
                    + "\t(4)\tApresentar as informações todas\t\t\t(5)\tGuardar dados no ficheiro\t\n"
                    + "\t(6)\tApresentar a distribuição normalizada\t(7)\tApresentar a distribuição não normalizada\t\n"
                    + "\t(8)\tApresentar a dimensão populacional\t\t(9)\tApresentar o comportamento Assintotico\t\n"
                    + "\t(10) Apresentar a taxa de variação\t\t\t(11) Apresentar o valor próprio\t\n"
                    + "\t(12) Apresentar o vetor próprio\t\t\t\t(13) Ler dados a partir de um ficheiro\t\n"
                    + "\t(14) Aplicar gráficos\t\t\t\t\t\t(15) Dar run aos testes unitários\t\n"
                    + "\t(16) Limpar o output existente na consola\t(17) Verificar se o vetor próprio esta correto (Utilizando a fórmula)\t\n"
                    + "**********************************************************************************************************************\nComando> ";

            double[] taxaS = new double[199];
            double[] taxaF = new double[199];
            double[] nIndividuos = new double[199];
            int t;
            double D;


                if (flag == 0) {

                    Welcome.Welcome();
                    flag++;
                    System.out.printf("Por favor introduza a matriz de Lelie:\n\n"); //Implementar uma função que consiga ler . tbm

                } else if (flag > 0) {

                    System.out.printf("\n\n\n\nPor favor introduza novamente a matriz de Lelie:\n\n");

                }

                int geracao = Ler.leslie(nIndividuos, taxaF, taxaS);


                System.out.printf("\nIntroduza o número de instantes de tempo a gerar\n\n");
                t = read.nextInt();
                System.out.println();


                double[][] matriz = Ler.criaMatriz(nIndividuos, taxaS, taxaF, geracao);

                nIndividuos = Ler.limpaVetor(nIndividuos, geracao);

                System.out.printf(text);


                D = read.nextDouble();
                boolean check = true;
                int counter2 = 0;
                int Flag = 0;
                int l = 0;
                int counter = 0;



            while(check){ //Depois de usar 5 vezes implementar uma contador para apresentar a String Text no output outra vez

                int Y=(int)D;

                if(Y==0||Y==1) check=false;

                switch (Y){
                    case 0:
                        counter++;
                        choice=false;
                        Flag++;
                        break;

                    case 1:
                        counter++;
                        choice=true;
                        Flag++;
                        break;

                    case  2:
                        counter++;
                        System.out.printf("\nMatriz de Leslie\n");
                        Apresentar.apresentarMatriz(matriz);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 3:
                        counter++;
                        System.out.printf("\nk=%d\n\n",t);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 4:
                        counter=0;
                        l=0;
                        Distribuição.ApresentarDist(matriz,t,nIndividuos,l);
                        System.out.printf(text);
                        break;

                    case 5:
                        counter=0;
                        //Colocar aqui a classe para guardar as informações num ficheiro
                        DistribuiçãoUpdateFicheiro.ApresentarDist(matriz,t,nIndividuos,l);
                        System.out.printf(text);
                        break;

                    case 6:
                        counter++;
                        l=6;
                        Distribuição.ApresentarDist(matriz,t,nIndividuos,l);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 7:
                        counter++;
                        l=7;
                        Distribuição.ApresentarDist(matriz,t,nIndividuos,l);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 8:
                        counter++;
                        l=8;
                        Distribuição.ApresentarDist(matriz,t,nIndividuos,l);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 9:
                        counter++;
                        l=9;
                        Vectores.vetores(matriz,l);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 10:
                        counter++;
                        l=10;
                        Distribuição.ApresentarDist(matriz,t,nIndividuos,l);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 11:
                        counter++;
                        l=11;
                        Vectores.vetores(matriz,l);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 12:
                        counter++;
                        l=12;
                        Vectores.vetores(matriz,l);
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                    case 13:

                        String A="";
                        counter=0;
                        counter2++;
                        boolean P=false;

                        System.out.printf("\nDeseja  introduzir dados a partir de um ficheiro?(S/N)\n\n");

                        while (!A.equals("S") && !A.equals("N")) {

                            A = read.nextLine();

                            if (A.equals("N")) {
                                P = false;

                            } else if (A.equals("S")) {

                                P = true;

                            }

                        }

                        if (P){
                            //Introduzir a função para ler os dados a partir do ficheiro!
                            CLS.clearScreen();
                            if(counter2!=0){
                                System.out.println("Novos dados alocados");
                                System.out.printf(text);
                                counter2=0;
                            }
                            break;
                        }
                         else {
                            if(counter<5)  System.out.printf("\nComando>");
                             break;
                        }

                    case 14:
                        counter=0;
                        //Aqui aplica-se a classe respetiva dos gráficos
                        GnuPlot.main(null);
                        System.out.printf(text);
                        break;

                    case 15:
                        counter=0;
                        //Classe para os testes unitários
                        testesUnitarios.testes();
                        System.out.printf(text);
                        break;

                    case 16:
                        CLS.clearScreen(); // No java é impossível apagar a consola toda então o melhor a fazer se é dar print a varias linhas sem texto, pois para apagar o texto da consola o mesmo precisava de dar rerun em string isso não é o que queremos neste projeto logo torna se impossível dar um "clear" comepleto à consola
                        System.out.println("Conteúdo apagado");
                        System.out.println(text);
                        break;

                    case 17:
                        counter++;
                        l=1;
                       Vectores.vetores(matriz,l);
                        if(counter<5)  System.out.printf("\nComando>");
                       break;


                    default:
                        System.out.println("Porfavor introduza um valor válido");
                        if(counter<5)  System.out.printf("\nComando>");
                        break;

                }

                if(counter==5){
                    System.out.printf(text);
                    counter=0;

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