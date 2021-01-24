import java.util.Scanner;

/**
 * Classe com o menu principal do programa
 */

public class Menu {

    static Scanner read = new Scanner(System.in);

    /**
     * @param nomefich nome do ficheiro onde vão ser guardadas as informações desejadas
     * @param f variável de controlo
     */

    public static void Menu(String nomefich, int f) {

        //Inicialização de variáveis
        boolean choice = true;
        int flag = 0;
        int t = 0;
        double D;
        double[][] matriz = null;
        double[] nIndividuos = new double[199];


        if (f == 0) { //Condição para gravar no ficheiro a matriz e o número de indivíduos por classe

            matriz = NaoInterativo.lerMatriz(nomefich);
            nIndividuos = NaoInterativo.lerDistribPop(nomefich);

        }

        while (choice) {

            String text
                    = "\n**********************************************************************************************************************\n" //String com o "menu" (apresentável) do programa
                    + "\t(0)Sair\t\t\t\t\t\t\t\t(1) Introduzir novos dados\t\n"
                    + "\t(2) Mostrar matriz\t\t\t\t\t\t(3) Mostrar gerações (k)\t\n"
                    + "\t(4) Apresentar as informações todas\t\t\t\t(5) Apresentar a distribuição normalizada\t\n"
                    + "\t(6) Apresentar a distribuição não normalizada\t\t\t(7) Apresentar a dimensão populacional\t\n"
                    + "\t(8) Apresentar o comportamento Assintotico\t\t\t(9) Apresentar a taxa de variação\t\n"
                    + "\t(10) Apresentar o valor próprio\t\t\t\t\t(11) Apresentar o vetor próprio\t\n"
                    + "\t(12) Ler dados a partir de um ficheiro\t\t\t\t(13) Aplicar gráficos\t\n"
                    + "\t(14) Dar run aos testes unitários\t\t\t\t(15) Limpar o output existente na consola\t\n"
                    + "\t(16) Verificar se o vetor próprio esta correto (Utilizando a fórmula)\t\n"
                    + "**********************************************************************************************************************\nComando> ";

            double[] taxaS = new double[199];
            double[] taxaF = new double[199];


            if (f != 0) {


                t = 0;


                if (flag == 0) { //Quando o programa é iniciado pela primeira vez no modo interativo dá print a esta mensagem

                    Welcome.Welcome();
                    flag++;
                    System.out.printf("Por favor introduza a matriz de Lelie:\n\n");

                } else if (flag > 0) { //Quando o programa é reniciado (case 1 ou seja voltar a introduzir dados) dá print a esta mensagem

                    System.out.printf("\n\n\n\nPor favor introduza novamente a matriz de Lelie:\n\n");

                }

                int geracao = Ler.leslie(nIndividuos, taxaF, taxaS);

                matriz = Ler.criaMatriz(nIndividuos, taxaS, taxaF, geracao); //Criar a matriz a partir dos dados lidos (introduzidos pelo utilizador ou lidos de um ficheiro)

                nIndividuos = Ler.limpaVetor(nIndividuos, geracao); //Limpar o vetor que guarda o número de indivíduos por classe


            }

            System.out.printf("\nIntroduza o número de instantes de tempo a gerar\n\n"); //Número de instantes de tempo a estimar
            t = read.nextInt();
            System.out.println();


            System.out.printf(text);


            D = read.nextDouble(); //Ler a opção introduzida pelo utilizador

            boolean check = true;
            int counter2 = 0;
            int Flag = 0;
            int l = 0;
            int counter = 0;

            Distribuição.ApresentarDist(matriz, t, nIndividuos, 100);


            while (check) { //Ciclo do menu principal

                int Y = (int) D;

                if (Y == 0 || Y == 1) check = false; //Condição para terminar o programa/ler novos dados

                switch (Y) {
                    case 0: //fechar o programa
                        counter++;
                        choice = false;
                        Flag++;
                        break;

                    case 1: //ler novos dados
                        counter++;
                        choice = true;
                        Flag++;
                        break;

                    case 2: //dar print à matriz de leslie
                        counter++;
                        System.out.printf("\nMatriz de Leslie\n");
                        Apresentar.apresentarMatriz(matriz);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;

                    case 3: //dar print ao número de gerações a estimar
                        counter++;
                        System.out.printf("\nk=%d\n\n", t);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;

                    case 4: //apresentar o output tod"o do programa
                        counter = 0;
                        l = 0;
                        Distribuição.ApresentarDist(matriz, t, nIndividuos, l);
                        System.out.printf(text);
                        break;

                    case 5: //apresentar a distribuição normalizada
                        counter++;
                        l = 6;
                        Distribuição.ApresentarDist(matriz, t, nIndividuos, l);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;


                    case 6: //apresentar a distribuição não normalizada
                        counter++;
                        l = 7;
                        Distribuição.ApresentarDist(matriz, t, nIndividuos, l);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;

                    case 7: //apresentar a dimensão populacional
                        counter++;
                        l = 8;
                        Distribuição.ApresentarDist(matriz, t, nIndividuos, l);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;

                    case 8: //apresentar o comportamento assimtótico
                        counter++;
                        l = 9;
                        Vectores.vetores(matriz, l);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;

                    case 9: //apresentar a taxa de variação(crescimento populacional)
                        counter++;
                        l = 10;
                        Distribuição.ApresentarDist(matriz, t, nIndividuos, l);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;

                    case 10: //apresentar o valor próprio
                        counter++;
                        l = 11;
                        Vectores.vetores(matriz, l);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;


                    case 11: //apresentar o vetor próprio
                        counter++;
                        l = 12;
                        Vectores.vetores(matriz, l);
                        if (counter < 5) System.out.printf("\nComando>");
                        break;

                    case 12: //ler dados a partir de um ficheiro
                        String A = "";
                        counter = 0;
                        counter2++;
                        boolean P = false;

                        System.out.printf("\nDeseja  introduzir dados a partir de um ficheiro?(S/N)\n\n");

                        while (!A.equals("S") && !A.equals("N")) {

                            A = read.nextLine();

                            if (A.equals("N")) {
                                P = false;

                            } else if (A.equals("S")) {
                                System.out.println("Qual o nome do ficheiro?");
                                nomefich = read.nextLine();

                                P = true;

                            }

                        }

                        if (P) {

                            CLS.clearScreen();
                            nIndividuos = NaoInterativo.lerDistribPop(nomefich);
                            matriz = NaoInterativo.lerMatriz(nomefich);

                            if (counter2 != 0) {

                                System.out.println("Introduza o número de instantes de tempo a gerar");
                                t=read.nextInt();

                                System.out.println("Novos dados alocados");
                                System.out.printf(text);

                                counter2 = 0;

                                break;
                            }

                        } else {
                            if (counter < 5) System.out.printf("\nComando>");
                            break;
                        }

                            case 13: //apresentar os gráficos
                                counter = 0;
                                //Aqui aplica-se a classe respetiva aos gráficos
                                GnuPlot.main(nomefich);
                                System.out.printf(text);
                                break;

                            case 14: //apresentar os testes unitários
                                counter = 0;
                                //Classe para os testes unitários
                                testesUnitarios.testes();
                                System.out.printf(text);
                                break;

                            case 15: //"apagar" a consola
                                CLS.clearScreen();
                                System.out.println("Conteúdo apagado");
                                System.out.println(text);
                                break;

                            case 16: //verificar o vetor próprio pela fórmula
                                counter++;
                                l = 1;
                                Vectores.vetores(matriz, l);
                                if (counter < 5) System.out.printf("\nComando>");
                                break;


                            default: //caso não tenha sido introduzido nenhuma opção válida dá print a esta mensagem
                                System.out.println("Porfavor introduza um valor válido");
                                if (counter < 5) System.out.printf("\nComando>");
                                break;

                        }

                        if (counter == 5) { //Após se escolher 5 opções do menu, dá print novamente a string que apresenta as opções

                            System.out.printf(text);
                            counter = 0;

                        }

                        if (Flag == 0) D = read.nextDouble(); //Enquanto não for introduzido o valor "0" ou "1" (case 0 e case 1) o menu vai estar sempre a correr

                }

            }

        }

    }