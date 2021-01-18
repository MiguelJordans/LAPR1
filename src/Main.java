public class Main {

<<<<<<< HEAD
    public static void main(String[] args) {
=======
        static Scanner read = new Scanner(System.in);

        public static void main(String[] args) {

            if (args.length != 0) {


                try {

                    {

                        String nomeFicheiro = "";
                        String nomeFicheiroSaida = "";
                        String numGeracoes = "";
                        String nomeEspecie = "";
                        String formatFicheiro = "";
                        boolean vecProprio = false;
                        boolean dimPopulacao = false;
                        boolean varPopGeracoes = false;
                        boolean interativo = false;
                        int v_arg = 0;

                        //ler parâmetros
                        for (int i=0;i<args.length;i++){

                            switch(args[i]){

                                //interativo
                                case "-n":
                                    try {
                                        nomeFicheiro = args[i + 1];
                                        interativo = true;
                                    }catch(Exception e){
                                        System.out.println("Parâmetros Inválidos!");
                                        System.exit(0);
                                    }
                                    break;
                                //Não Interativo
                                //Número de Gerações
                                case "-t":
                                    try {
                                        numGeracoes = args[i + 1];
                                        nomeFicheiro = args[args.length - 2];
                                        nomeFicheiroSaida = args[args.length - 1];
                                    }catch(Exception e){
                                        System.out.println("Parâmetros Inválidos!");
                                        System.exit(0);
                                    }
                                    break;
                                //Formato de Ficheiro gráfico
                                case "-g":
                                    try {
                                        v_arg = Integer.parseInt(args[i + 1]);
                                        if (v_arg == 1) {
                                            formatFicheiro = "png";
                                        } else if (v_arg == 2) {
                                            formatFicheiro = "txt";
                                        } else if ((v_arg == 3)) {
                                            formatFicheiro = "eps";
                                        } else {
                                            System.out.println("Formato de Ficheiro inválido!");
                                            System.exit(0);
                                        }
                                    }catch(Exception e){
                                        System.out.println("Parâmetros inválidos -g");
                                        System.exit(0);
                                    }
                                    break;
                                //Calcular valor e vector próprio
                                case "-e": vecProprio = true; break;
                                //Calcular dimensão população a cada geração
                                case "-v": dimPopulacao = true; break;
                                //Calcular variação da População entre gerações
                                case "-r": varPopGeracoes = true; break;
                            }
                        }

                        double matrix[][] = new double[100][100];

                        double[] vectorDistribPop = NaoInterativo.lerDistribPop(nomeFicheiro);
                        double[][] matrixLeslie = NaoInterativo.lerMatriz(nomeFicheiro);

                        NaoInterativo.ImprimirMatriz(matrixLeslie);


                        //MODO INTERATIVO
                        if (interativo == true) {

                            Scanner ler = new Scanner(System.in);

                        }
                    }


                } catch (Exception e) {

                    e.printStackTrace();

                }

            } else {

                boolean choice = true;
                int flag=0;

                while (choice) {

                    String choi = "";

                    double[] taxaS = new double[199];
                    double[] taxaF = new double[199];
                    double[] nIndividuos = new double[199];
                    int t;

<<<<<<< HEAD
                    Welcome.Welcome();

                    System.out.print("Por favor introduza a matriz de Lelie:\n\n");

                    boolean acabou = false;
                    int geracao = 0;

                    while (!acabou) {

                        String acabar = "";


                        System.out.printf("Número de indivíduos da %dª geração\n",geracao+1);
                        nIndividuos[geracao] = read.nextInt();
=======
                    if(flag==0){
>>>>>>> 6aaca8b0a7b2eb018d2df493760908e43eaf7d3b

                        Welcome.Welcome();
                        flag++;
                        System.out.printf("Por favor introduza a matriz de Lelie:\n\n");

                    }

                    else if(flag>0)  {

                        System.out.printf("\n\n\n\nPor favor introduza novamente a matriz de Lelie:\n\n");
>>>>>>> 3fb32a80422f9eb5246d376c7fb9fe5bc326ee57

        if (args.length != 0) {

            try {

                // Interface.main(args);

<<<<<<< HEAD
            } catch (Exception e) {

                e.printStackTrace();

            }

        } else {

            Menu.Menu();

        }

    }

}
=======
                    double[][] matriz = Ler.criaMatriz(nIndividuos, taxaS, taxaF, geracao);

                    //Interface.ImprimirMatriz(matriz);
                    nIndividuos = Ler.limpaVetor(nIndividuos, geracao);

                    System.out.printf("k=%d\n\n",t);

                    System.out.printf("Matriz de Leslie\n");

                    Apresentar.apresentarMatriz(matriz);

                    Distribuição.ApresentarDist(matriz,t,nIndividuos);

                    read.nextLine();

                    while (!choi.equals("S") && !choi.equals("N")) {

                        System.out.printf("Deseja voltar a introduzir dados?(S/N)\n\n");
                        choi = read.nextLine();

                        if (choi.equals("S")) {

                            choice = true;

                        } else if (choi.equals("N")) {

                            choice = false;

                        }
                    }
                }
            }
        }
    }
>>>>>>> 3fb32a80422f9eb5246d376c7fb9fe5bc326ee57
