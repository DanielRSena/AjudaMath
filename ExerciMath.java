

import java.util.InputMismatchException;
import java.util.Scanner;

import objsExerciMath.*;

class ExerciMath {

    static int pontos = 0;
    static Scanner entrada = new Scanner(System.in, "latin1");

    // 1. Funções gerais

    static String acerto() {
        pontos += 1;
        return "\nParabéns! Está com " + pontos + " pontos!\n";
    }

    static String erro() {
        pontos -= 1;
        return ", -1 ponto. Seu saldo total de pontos é " + pontos + "\n";
    }

    // 2. Exercícios

    static int agDiscreto() {

        int nAmostras = 5, frequencias[] = new int[nAmostras];
        double media = 0.0, s2 = 0.0, desvioPadrao = 0.0, CV = 0.0, tFreq = 0.0, rMedia, rDesvio, rCV, rS2;
        double amostras[] = new double[nAmostras], auxAmostras[] = new double[nAmostras];

        System.out.println("Lembre-se de ordenar as amostras antes de calcular!\n\n\txi\t f");

        //armazena e printa os valores
        for (int i = 0; i < nAmostras; i++) {
            amostras[i] = Nums.arredonda(Nums.doubleRandom(50)); //sorteia um número aleatório entre 0 e 50 e o arredonda
            System.out.print("\t" + amostras[i] + "\t");
            auxAmostras[i] = amostras[i]; //esse vetor auxiliar serve para ajudar na conta da média, sem comprometer as outras
            frequencias[i] = Nums.intRandom(50); //sorteia um número aleatório entre 0 e 50 e o arredonda
            System.out.println(frequencias[i]);
        }

        // média
        for (int i = 0; i < nAmostras; i++) {
            auxAmostras[i] *= frequencias[i]; // multiplica as amostras pela sua respectiva frequência
            media += auxAmostras[i]; // o produto disto é acumulado
            tFreq += frequencias[i]; // todas as frequências são acumuladas
        }

        media = Nums.arredonda(media / tFreq); //faz a média e a arredonda

        // variancia
        for (int i = 0; i < nAmostras; i++) {
            amostras[i] = Math.pow((amostras[i] - media), 2) * frequencias[i];
            s2 = s2 + amostras[i];
        }
        s2 = Nums.arredonda(s2 / (tFreq - 1));
        
        desvioPadrao = Nums.arredonda(Math.sqrt(s2)); // desvio padrao
    
        CV = ((100 * desvioPadrao) / media); // coeficiente de variacao
        CV = Nums.arredonda(CV);

        //respotas

        //verificação da média
        try { 

            System.out.print("\n\n\tMédia: "); rMedia = entrada.nextDouble();
            if (rMedia == media) System.out.println(acerto());
            else System.out.println("O certo é " + media + erro());

        } catch (InputMismatchException e) {
            System.out.println("A resposta correta é " + media + erro());
            entrada.nextLine();
        }

        //verificação da variância
        try {

            System.out.print("\tVariância: "); rS2 = entrada.nextDouble();
            if (rS2 == s2) System.out.println(acerto());
            else System.out.println("O certo é " + s2 + erro());

        } catch (InputMismatchException e) {
            System.out.println("A resposta correta é " + s2 + erro());
            entrada.nextLine();
        }

        //verificação do desvio padrão
        try {

            System.out.print("\tDesvio Padrão: "); rDesvio = entrada.nextDouble();
            if (rDesvio == desvioPadrao) System.out.println(acerto());
            else System.out.println("O certo é " + desvioPadrao + erro());
            
        } catch (InputMismatchException e) {
            System.out.println("A resposta correta é " + desvioPadrao + erro());
            entrada.nextLine();
        }

        //verificação do CV
        try {
            
            System.out.print("\tCoeficiente de Variação: "); rCV = entrada.nextDouble();
            if (rCV == CV) System.out.println(acerto());
            else System.out.println("O certo é " + CV + erro());

        } catch (InputMismatchException e) {
            System.out.println("A resposta correta é " + CV + erro());
            entrada.nextLine();
        }

        return 0;
    }

    static int equa1() {

        double resposta, x;
        int a = Nums.intRandom(10), b = Nums.intRandom(10);
    
        x = Nums.arredonda((-b) / (double) a);

        System.out.print("\n\tEquação: " + a + "x + " + b + " = 0\n\n\tValor de x: ");
        try {

            resposta = entrada.nextDouble();
            if (x == resposta) System.out.println(acerto());
            else System.out.printf("\nA resposta certa é " + x + erro());

        } catch (InputMismatchException e) {
            System.out.printf("\nA resposta certa é " + x + erro());
            entrada.next();
        }

        return 0;
    }

    static int equa2() {

        double respostaDelta, delta, x1, respostaX1, x2, respostaX2;
        int a, b, c;
        // equilibrada nos valores
        a = Nums.intRandom(10);
        b = Nums.intRandom(15);
        c = Nums.intRandom(10);

        // delta
        delta = (b * b) - (4 * a * c);
        delta = Nums.arredonda(delta);

        System.out.print("\n\t\tEquação: " + a + "x2 + " + b + "x + " + c + " = 0.\n\n\n\tDelta = ");

        try {

            respostaDelta = entrada.nextDouble();
            if (respostaDelta == delta) System.out.println(acerto());
            else System.out.printf("\nA resposta certa é " + delta + erro());

        } catch (InputMismatchException e) {
            System.out.printf("\nA resposta certa é " + delta + erro());
            entrada.next();
        }

        if (delta > 0) {

            delta = Nums.arredonda(Math.sqrt(delta));

            x1 = ((b * (-1)) + delta) / (2 * a);
            x1 = Nums.arredonda(x1);

            x2 = ((b * (-1)) - delta) / (2 * a);
            x2 = Nums.arredonda(x2);

            try {

                System.out.print("\n\n\tValor do x1 = "); respostaX1 = entrada.nextDouble();
                if (respostaX1 == x1) System.out.println(acerto());
                else System.out.printf("\nA resposta certa é " + x1 + erro());

            } catch (InputMismatchException e) {
                System.out.printf("\nA resposta certa é " + x1 + erro());
                entrada.next();
            }

            try {

                System.out.print("\n\nValor do x2 = "); respostaX2 = entrada.nextDouble();
                if (x2 == respostaX2) System.out.println(acerto());
                else System.out.printf("\nA resposta certa é " + x2 + erro());

            } catch (InputMismatchException e) {
                System.out.printf("\nA resposta certa é " + x2 + erro());
                entrada.next();
            }

        }
        return 0;
    }

    static int matrizes(){

        String tema[] = {"adição", "subtração", "multiplição por escalar", "matriz transposta"};
        int resposta, pontosGanhos = 0, 
            mat1[][] = Nums.criarMatriz(),
                sorteio = Nums.intRandom(4);
                
        System.out.println("\n\nE o estilo sorteado foi ... " + tema[sorteio - 1]);
        Nums.printaMatriz(mat1);
        
        if(sorteio < 4) { //qualquer um que não seja transposta

            if (sorteio < 3) { //soma ou subtração

                int mat2[][] = Nums.criarMatriz(mat1.length, mat1[0].length);  //cria outra matriz aleatória, mas com mesmo tamanho da primeira
                System.out.println("\n\n\tSegunda matriz");
                Nums.printaMatriz(mat2);
                if (sorteio == 1) mat1 = Contas.somarMatriz(mat1, mat2); //se é adição, soma as matrizes
                else mat1 = Contas.subtrairMatriz(mat1, mat2); //se é subtração, faz a diferença das matrizes
            }
            else { //multiplicação por escalar

                int escalar = Nums.intRandom(10); // o escalar será será um número entre 1 e 10
                mat1 = Contas.multEscalarMatriz(mat1, escalar);
                System.out.println("\n\n\tO escalar é " + escalar + "\n");
            }
    
            for (int i = 0; i < mat1.length; i++) { //passa por todas as linhas da matriz
                System.out.println();
                for (int j = 0; j < mat1[0].length; j++) { //passa por todas as colunas das linhas da matriz
                    try {
    
                        System.out.print("\tValor do endereço [" + (i+1) + "][" + (j+1) + "]: "); resposta = entrada.nextInt();
                        if (mat1[i][j] == resposta){ acerto(); pontosGanhos ++; }
                        else erro();
    
                    } catch (InputMismatchException e) { entrada.next(); erro(); }
                }
            }

            System.out.println("\nSegue o gabarito:");
            Nums.printaMatriz(mat1);
            System.out.println("\nO total de pontos ganhos foram " + pontosGanhos + ". Agora está com " + pontos + " pontos.\n");

        }
        else { //matriz transposta
            int mat2[][] = new int[mat1[0].length][mat1.length]; 
            for (int i = 0; i < mat2.length; i++) {
                System.out.println();
                for (int j = 0; j < mat2[0].length; j++) {

                    mat2[i][j] = mat1[j][i]; //como é transposta, as linhas viram colunas e as colunas viram linhas
                    try {
    
                        System.out.print("\tValor do endereço [" + (i+1) + "][" + (j+1) + "]: "); resposta = entrada.nextInt();
                        if (mat2[i][j] == resposta){ acerto(); pontosGanhos ++; }
                        else erro();
        
                    } catch (InputMismatchException e) { entrada.next(); erro(); }
                }
            }

            System.out.println("\nSegue o gabarito:");
            Nums.printaMatriz(mat2);
            System.out.println("\nO total de pontos ganhos foram " + pontosGanhos + ". Agora está com " + pontos + " pontos.\n");
        }

        return 0;
    }

    static int sisLinear() {

        double aux = 0, aux2 = 0, x = 0, y = 0, respostaX = 0, respostaY = 0;
        double nx1 = Nums.intRandom(10);
        double ny1 = Nums.intRandom(10);
        double n1 = Nums.intRandom(10);
        double nx2 = Nums.intRandom(10);
        double ny2 = Nums.intRandom(10);
        double n2 = Nums.intRandom(10);

        System.out.printf("\t%.0fx + %.0fy = %.0f\n", nx1, ny1, n1);
        System.out.printf("\t%.0fx + %.0fy = %.0f\n", nx2, ny2, n2);

        aux = ny1;
        ny1 *= nx2;
        aux2 = n1;
        n1 *= nx2;

        ny2 = ny2 * (-nx1);
        n2 = n2 * (-nx1);

        ny2 += ny1;
        n2 += n1;

        y = Nums.arredonda(n2 / ny2);

        x = (aux2 - (aux * y)) / nx1;
        x = Nums.arredonda(x);

        try {

            System.out.print("\n\tValor do x = "); respostaX = entrada.nextDouble();
            if (x == respostaX) System.out.println(acerto());
            else System.out.println("\nA resposta certa é " + x + erro());


        } catch (InputMismatchException e) {
            System.out.println("\nA resposta certa é " + x + erro()); // se coloca letra, também errou o exercício
            entrada.next();
        }

        try {

            System.out.print("\tValor do y = "); respostaY = entrada.nextDouble();
            if (y == respostaY) System.out.println(acerto());
            else System.out.printf("\nA resposta certa é " + y + erro());

        } catch (InputMismatchException e) {
            System.out.println("\nA resposta certa é " + y + erro()); // se coloca letra, também errou o exercício
            entrada.next();
        }

        return 0;
    }

    static int tabuada() {

        int p1, p2, produto, resposta, tempoLimite = 15; // segundos
        long tempoInicio = System.currentTimeMillis();

        while ((System.currentTimeMillis() - tempoInicio) < (tempoLimite * 1000)) {
            p1 = Nums.intRandom(10); 
            p2 = Nums.intRandom(10);
            produto = p1 * p2;

            try {

                System.out.print("\n\t" + p1 + " x " + p2 + " = "); resposta = entrada.nextInt();
                if (produto == resposta) acerto();
                else {
                    System.out.println("\nA resposta certa é " + produto);
                    erro();
                }

            } catch (InputMismatchException e) {
                entrada.next();
                System.out.println("\nA resposta certa é " + produto);
                erro();
            }
        }

        System.out.println("\nAcabou o tempo! Você está com " + pontos + " pontos!\n");
        return 0;

    }

    // 3. Programa ExerciMath
    public static void main(String[] args) {

        char menu = 's';
        // menu
        while (menu == 's') {

            char repetir = 's';
            int opcao = 0;

            // Home
            System.out.println( "\n\n\t\t--- ExerciMath --- \n\nBem vindo à central de exercícios do AJudaMath! Escolha o assunto que deseja fazer exercícios: \n\n1. Agrupamento Discreto\n2. Função de 1º grau\n3. Função de 2º grau\n4. Matrizes\n5. Sistema linear\n6. Tabuada\n");
            while (true) { //não sairá daqui até colocar uma opção válida
                try {
                    do {
                        System.out.print("\tSua escolha: "); opcao = entrada.nextInt();
                    } while (opcao < 1 || opcao > 6);
                    break;
                } catch (InputMismatchException e) { entrada.nextLine(); } //limpa o buffer do Scanner se for letras ou símbolos
            }


            // 1. Agrupamento Discreto
            if (opcao == 1) {

                // texto inicial
                System.out.println( "\n\n\t\t--- Agrupamento discreto ---\n\nSaluton, e muito bem vindo! Encontre a média, variância, desvio padrão e coeficiente de variação para ganhar 4 pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    agDiscreto(); // chamada da função de agrupamento discreto
                    repetir = Util.repetirProcesso(); // Escolha de repetição
                }
            }

            // 2. Função de 1º grau
            if (opcao == 2) {

                // texto inicial
                System.out.println( "\n\n\t\t--- Função de 1º grau ---\n\nSaluton, e muito bem vindo! Encontre o valor de 'x' para ganhar 2 pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    equa1(); // chamada da função de 1º grau
                    repetir = Util.repetirProcesso(); // Escolha de repetição
                }
            }

            // 3. Função de 2º grau
            if (opcao == 3) {

                // Texto inicial
                System.out.println( "\n\n\t\t--- Função de 2º grau ---\n\nSaluton, e muito bem vindo! Encontre o valor do delta, 'x1' e  'x2' para ganhar 3 pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    equa2(); // chamada da função de 2º grau
                    repetir = Util.repetirProcesso(); // Escolha de repetição
                }
            }

            // 4. Matrizes
            if (opcao == 4) {

                // Texto inicial
                System.out.println("\n\n\t\t--- Matrizes ---\n\nSaluton, e muito bem vindo! faça as operações com as matrizes para ganhar pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    matrizes(); // chamada da função de matrizes
                    repetir = Util.repetirProcesso(); // Escolha de repetição

                }
            }

            // 5. Sistemas Lineares
            if (opcao == 5) {

                // Texto inicial
                System.out.println("\n\n\t\t--- Sistema Linear ---\n\nSaluton, e muito bem vindo! Encontre o valor de 'x' e  'y' para ganhar 2 pontos!\nMas cuidado! Se errar, perde 1 ponto.\n");

                // Repetição
                while (repetir == 's') {

                    sisLinear(); // chamada da função de 2º grau
                    repetir = Util.repetirProcesso(); // Escolha de repetição

                }
            }

            // 6. Tabuada
            if (opcao == 6) {

                // texto inicial
                System.out.println( "\n\n\t\t--- Tabuada contra o tempo ---\n\nSaluton, e muito bem vindo! Coloque a resposta certa para ganhar um ponto!\nMas cuidado! Se errar, perde um ponto.");

                // Repetição
                while (repetir == 's') {

                    tabuada();
                    repetir = Util.repetirProcesso(); // Escolha de repetição
                }
            }

            menu = Util.repetirProcesso("\n\nVocê quer voltar ao menu? (s/n): ");

        }

        System.out.println("\n\nObrigado por usar o ExerciMath! Aceito sugestões :)\n\n");
        entrada.close();
    }
}