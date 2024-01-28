
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import objExerciMath.Nums;

class ExerciMath {

    static Random random = new Random();
    static int pontos = 0;
    static Scanner entrada = new Scanner(System.in, "latin1");

    // 1. Funções gerais

    static double arredonda(double num) {

        BigDecimal arredondando = BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_UP);
        num = arredondando.doubleValue();
        return num;
    }

    static String acerto() {
        pontos += 1;
        return "\nParabéns! Está com " + pontos + " pontos!\n";
    }

    static String erro() {
        pontos -= 1;
        return ", -1 ponto. Seu saldo total de pontos é " + pontos + "\n";
    }

    static char repetirExercicio() {

        String repete;
        char repetir = 's';

        do {
            System.out.print("\n\tQuer fazer novamente? (s/n): ");
            repete = entrada.next();
            repetir = repete.charAt(0);
        } while (repetir != 's' && repetir != 'n');

        return repetir;
    }

    // 2. Exercícios

    static int agDiscreto() {

        int nAmostras = 5, frequencias[] = new int[nAmostras];
        double media = 0.0, s2 = 0.0, desvioPadrao = 0.0, CV = 0.0, tFreq = 0.0, rMedia, rDesvio, rCV, rS2;
        double amostras[] = new double[nAmostras], auxAmostras[] = new double[nAmostras];

        System.out.println("Lembre-se de ordenar as amostras antes de calcular!\n\n\txi\t f");

        //printa os valores
        for (int i = 0; i < nAmostras; i++) {
            amostras[i] = random.nextInt(50) + 1;
            System.out.print("\t" + amostras[i] + "\t");
            auxAmostras[i] = amostras[i];
            frequencias[i] = random.nextInt(50) + 1;
            System.out.println(frequencias[i]);
        }

        // média
        for (int i = 0; i < nAmostras; i++) {
            auxAmostras[i] *= frequencias[i]; // multiplica as amostras pela frequência
            media += auxAmostras[i]; // toda essa multiplicação é acumulada
            tFreq += frequencias[i]; // todas as frequências são acumuladas
        }

        media /= tFreq;

        BigDecimal res = BigDecimal.valueOf(media).setScale(2, RoundingMode.HALF_UP);
        media = res.doubleValue();

        // variancia
        for (int i = 0; i < nAmostras; i++) {
            amostras[i] = Math.pow((amostras[i] - media), 2) * frequencias[i];
            s2 = s2 + amostras[i];
        }
        s2 = s2 / (tFreq - 1);
        res = BigDecimal.valueOf(s2).setScale(2, RoundingMode.HALF_UP);
        s2 = res.doubleValue();

        // desvio padrao
        desvioPadrao = Math.sqrt(s2);
        res = BigDecimal.valueOf(desvioPadrao).setScale(2, RoundingMode.HALF_UP);
        desvioPadrao = res.doubleValue();

        CV = ((100 * desvioPadrao) / media) * 100; // coeficiente de variacao
        res = BigDecimal.valueOf(CV).setScale(2, RoundingMode.HALF_UP);
        CV = res.doubleValue();

        try {
            System.out.print("\n\nMédia: ");
            rMedia = entrada.nextDouble();
            if (rMedia == media)
                System.out.println(acerto());
            else
                System.out.println("O certo é " + media + erro());

            System.out.print("Variância: ");
            rS2 = entrada.nextDouble();
            if (rS2 == s2)
                System.out.println(acerto());
            else
                System.out.println("O certo é " + s2 + erro());

            System.out.print("Desvio Padrão: ");
            rDesvio = entrada.nextDouble();
            if (rDesvio == desvioPadrao)
                System.out.println(acerto());
            else
                System.out.println("O certo é " + desvioPadrao + erro());

            System.out.print("Coeficiente de Variação: ");
            rCV = entrada.nextDouble();
            if (rCV == CV)
                System.out.println(acerto());
            else
                System.out.println("O certo é " + CV + erro());

        } catch (InputMismatchException e) {
            entrada.next();
        }

        return 0;
    }

    static int equa1() {

        double a0, b0, resposta, x;

        // criando numeros aleatórios e convertendo-os para int
        a0 = Nums.intRandom(10);
        b0 = Nums.intRandom(10);
        int a = (int) a0, b = (int) b0;
        x = (-b) / (double) a;
        BigDecimal res = BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_UP);
        x = res.doubleValue();

        System.out.print("\n\tEquação: " + a + "x + " + b + " = 0.\n\n\tValor de x: ");
        try {

            resposta = entrada.nextDouble();
            if (x == resposta)
                System.out.println(acerto());
            else
                System.out.printf("\nA resposta certa é " + x + erro());

        } catch (InputMismatchException e) {
            entrada.next();
        }

        return 0;
    }

    static int equa2() {

        double a0, b0, c0, respostaDelta, delta, x1, respostaX1, x2, respostaX2;

        // equilibrada nos valores
        a0 = Nums.intRandom(10);
        b0 = random.nextInt(10) + 5;
        c0 = Nums.intRandom(10);

        int a = (int) a0, b = (int) b0, c = (int) c0; // atribuição dos valores para variáveis

        // delta
        delta = (b * b) - (4 * a * c);
        BigDecimal resDelta = BigDecimal.valueOf(delta).setScale(2, RoundingMode.HALF_UP);
        delta = resDelta.doubleValue(); // valor do delta arredondado

        System.out.print("\n\t\tEquação: " + a + "x2 + " + b + "x + " + c + " = 0.\n\n\n\tDelta = ");

        try {

            respostaDelta = entrada.nextDouble();
            if (delta == respostaDelta)
                System.out.println(acerto());
            else
                System.out.printf("\nA resposta certa é " + respostaDelta + erro());

        } catch (InputMismatchException e) {
            entrada.next();
        }

        delta = Math.sqrt(delta);
        resDelta = BigDecimal.valueOf(delta).setScale(2, RoundingMode.HALF_UP);
        delta = resDelta.doubleValue();

        if (delta > 0) {

            x1 = ((b * (-1)) + delta) / (2 * a);
            BigDecimal resx1 = BigDecimal.valueOf(x1).setScale(2, RoundingMode.HALF_UP);
            x1 = resx1.doubleValue();

            x2 = ((b * (-1)) - delta) / (2 * a);
            BigDecimal resx2 = BigDecimal.valueOf(x2).setScale(2, RoundingMode.HALF_UP);
            x2 = resx2.doubleValue();

            try {
                System.out.print("\n\n\tValor do x1 = ");
                respostaX1 = entrada.nextDouble();

                if (x1 == respostaX1)
                    System.out.println(acerto());
                else
                    System.out.printf("\nA resposta certa é " + x1 + erro());

            } catch (InputMismatchException e) {
                entrada.next();
            }

            try {
                System.out.print("\n\nValor do x2 = ");
                respostaX2 = entrada.nextDouble();

                if (x2 == respostaX2)
                    System.out.println(acerto());
                else
                    System.out.printf("\nA resposta certa é " + x2 + erro());

            } catch (InputMismatchException e) {
                entrada.next();
            }

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

        y = n2 / ny2;
        y = arredonda(y);

        x = (aux2 - (aux * y)) / nx1;
        x = arredonda(x);

        try {
            System.out.print("\n\tValor do x = ");
            respostaX = entrada.nextDouble();

            if (x == respostaX) System.out.println(acerto());
            else System.out.println("\nA resposta certa é " + x + erro());

        } catch (InputMismatchException e) {
            System.out.println("\nA resposta certa é " + x + erro()); // se coloca letra, também errou o exercício
            entrada.next();
        }

        try {
            System.out.print("\tValor do y = ");
            respostaY = entrada.nextDouble();

            if (y == respostaY) System.out.println(acerto());
            else System.out.printf("\nA resposta certa é " + y + erro());

        } catch (InputMismatchException e) {
            System.out.println("\nA resposta certa é " + y + erro()); // se coloca letra, também errou o exercício
            entrada.next();
        }

        return 0;
    }

    static int tabuada() {

        int tempoLimite = 15; // segundos
        long tempoInicio = System.currentTimeMillis();
        int p1, p2;

        while ((System.currentTimeMillis() - tempoInicio) < (tempoLimite * 1000)) {
            p1 = Nums.intRandom(10); 
            p2 = Nums.intRandom(10);
            int produto = p1 * p2;

            try {

                System.out.print("\n\t" + p1 + " x " + p2 + " = ");
                int resposta = entrada.nextInt();
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

            String escolha;
            char repetir = 's';
            int opcao = 0;

            // Home
            try {
                System.out.println(
                        "\n\n\t\t--- ExerciMath --- \n\nBem vindo à central de exercícios do AJudaMath! Escolha o assunto que deseja fazer exercícios: \n\n1. Agrupamento Discreto\n2. Função de 1º grau\n3. Função de 2º grau\n4. Sistema linear\n5. Tabuada\n");

                do {
                    System.out.print("\tSua escolha: ");
                    opcao = entrada.nextInt();
                } while (opcao < 1 || opcao > 5);
            } catch (InputMismatchException e) {
                entrada.next();
            }

            // continua se o home não crashar

            // 1. Agrupamento Discreto
            if (opcao == 1) {

                // texto inicial
                System.out.println(
                        "\n\n\t\t--- Função de 1º grau ---\n\nSaluton, e muito bem vindo! Encontre o valor de 'x' para ganhar 2 pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    agDiscreto(); // chamada da função de 1º grau

                    repetir = repetirExercicio(); // Escolha de repetição
                }
            }

            // 2. Função de 1º grau
            if (opcao == 2) {

                // texto inicial
                System.out.println(
                        "\n\n\t\t--- Função de 1º grau ---\n\nSaluton, e muito bem vindo! Encontre o valor de 'x' para ganhar 2 pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    equa1(); // chamada da função de 1º grau

                    repetir = repetirExercicio(); // Escolha de repetição
                }
            }

            // 3. Função de 2º grau
            if (opcao == 3) {

                // Texto inicial
                System.out.println(
                        "\n\n\t\t--- Função de 2º grau ---\n\nSaluton, e muito bem vindo! Encontre o valor de 'x1' e  'x2' para ganhar 3 pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    equa2(); // chamada da função de 2º grau

                    repetir = repetirExercicio(); // Escolha de repetição
                }
            }

            // 4. Sistemas Lineares
            if (opcao == 4) {

                // Texto inicial
                System.out.println(
                        "\n\n\t\t--- Sistema Linear ---\n\nSaluton, e muito bem vindo! Encontre o valor de 'x' e  'y' para ganhar 3 pontos!\nMas cuidado! Se errar, perde 1 ponto.\n");

                // Repetição
                while (repetir == 's') {

                    sisLinear(); // chamada da função de 2º grau

                    repetir = repetirExercicio(); // Escolha de repetição

                }
            }

            // 5. Tabuada
            if (opcao == 5) {

                // texto inicial
                System.out.println(
                        "\n\n\t\t--- Tabuada ---\n\nSaluton, e muito bem vindo! Coloque a resposta certa para ganhar um ponto!\nMas cuidado! Se errar, perde um ponto.");

                // Repetição
                while (repetir == 's') {

                    tabuada();

                    repetir = repetirExercicio(); // Escolha de repetição
                }
            }

            System.out.print("\n\nVocê quer voltar ao menu? (s/n): ");
            escolha = entrada.next();
            menu = escolha.charAt(0);

            System.out.println("\n\nObrigado por usar essa ferramenta de exercícios! Aceito sugestões :)\n\n");
        }

        entrada.close();
    }
}