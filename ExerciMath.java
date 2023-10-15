import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

class ExerciMat {
    public static void main(String[] args) {

        Scanner scanf = new Scanner(System.in, "latin1");
        char menu = 's';
        int pontos = 0;
        // menu
        while (menu == 's') {

            String escolha, repete;
            char repetir = 's';
            int opcao;

            // Home
            System.out.println("\n\n\t\t--- ExerciMat --- \n\nBem vindo à central de exercícios do AJudaMat! Escolha o assunto que deseja fazer exercícios: \n\n1. Funções de 1º grau;\n2. Funções de 2º grau;\n3. Tabuada\n");

            do {
                System.out.print("\tSua escolha: ");
                opcao = scanf.nextInt();
            } while (opcao < 1 || opcao > 3);

            // 1. Função de 1º grau
            if (opcao == 1) {

                System.out.println(
                        "\n\n\t\t--- Função de 1º grau ---\n\nSaluton, e muito bem vindo! Encontre o valor de 'x' para ganhar 2 pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    double a0, b0, resposta, x;
                    a0 = Math.random() * 10 + 1;
                    b0 = Math.random() * 10 + 1;
                    int a = (int) a0, b = (int) b0;
                    x = (-b) / (double) a;
                    BigDecimal res = BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_UP);
                    x = res.doubleValue();

                    System.out.print("\n\tEquação: " + a + "x + " + b + " = 0.\n\tValor de x: ");
                    resposta = scanf.nextDouble();

                    if (x == resposta) {
                        pontos += 1;
                        System.out.println("\nParabéns, a resposta está certa! Agora está com " + pontos + " pontos!");
                    } else {
                        pontos -= 1;
                        System.out.printf("\nA resposta certa é %.2f, -1 ponto. Seu saldo total de pontos é %d\n", x,
                                pontos);
                    }

                    // Escolha de repetição
                    do {
                        System.out.print("\n\tQuer fazer novamente? (s/n): ");
                        repete = scanf.next();
                        repetir = repete.charAt(0);
                    } while (repetir != 's' && repetir != 'n');
                }
            }

            // 2. Função de 2º grau
            if (opcao == 2) {

                System.out.println(
                        "\n\n\t\t--- Função de 2º grau ---\n\nSaluton, e muito bem vindo! Encontre o valor de 'x1' e  'x2' para ganhar 3 pontos!\nMas cuidado! Se errar, perde 1 ponto.");

                // Repetição
                while (repetir == 's') {

                    double a0, b0, c0, respostaDelta, delta, x1, respostaX1, x2, respostaX2;
                    a0 = Math.random() * 10 + 1;
                    b0 = Math.random() * 10 + 5;
                    c0 = Math.random() * 10 + 1;
                    int a = (int) a0, b = (int) b0, c = (int) c0;

                    delta = (b * b) - (4 * a * c);
                    BigDecimal resDelta = BigDecimal.valueOf(delta).setScale(2, RoundingMode.HALF_UP);
                    delta = resDelta.doubleValue();

                    System.out.print("\n\t\tEquação: " + a + "x2 + " + b + "x + " + c + " = 0.\n\n\n\tDelta = ");
                    respostaDelta = scanf.nextDouble();

                    if (delta == respostaDelta) {
                        pontos += 1;
                        System.out.println("\nParabéns, a resposta está certa! Agora está com " + pontos + " pontos!");
                    }

                    else {
                        pontos -= 1;
                        System.out.printf("\nA resposta certa é %.2f, -1 ponto. Seu saldo total de pontos é %d\n",
                                delta, pontos);
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

                        System.out.print("\n\n\tValor do x1 = ");
                        respostaX1 = scanf.nextDouble();

                        if (x1 == respostaX1) {
                            pontos += 1;
                            System.out.println(
                                    "\nParabéns, a resposta está certa! Agora está com " + pontos + " pontos!");
                        } else {
                            pontos -= 1;
                            System.out.printf("\nA resposta certa é %.2f, -1 ponto. Seu saldo total de pontos é %d\n", x1, pontos);
                        }

                        System.out.print("\n\nValor do x2 = ");
                        respostaX2 = scanf.nextDouble();

                        if (x2 == respostaX2) {
                            pontos += 1;
                            System.out.println("\nParabéns, a resposta está certa! Agora está com " + pontos + " pontos!");
                        } else {
                            pontos -= 1;
                            System.out.printf("\nA resposta certa é %.2f, -1 ponto. Seu saldo total de pontos é %d\n", x2, pontos);
                        }

                    }

                    // Escolha de repetição
                    do {
                        System.out.print("\n\n\tQuer fazer novamente? (s/n): ");
                        repete = scanf.next();
                        repetir = repete.charAt(0);
                    } while (repetir != 's' && repetir != 'n');
                }
            }

            // 3. Tabuada
            if (opcao == 3) {

                System.out.println(
                        "\n\n\t\t--- Tabuada ---\n\nSaluton, e muito bem vindo! Coloque a resposta certa para ganhar um ponto!\nMas cuidado! Se errar, perde um ponto.");

                // Repetição
                while (repetir == 's') {

                    double n1 = Math.random() * 10, n2 = Math.random() * 10;
                    int p1 = (int) n1;
                    int p2 = (int) n2;
                    int produto = p1 * p2, resposta;

                    System.out.print("\n\t" + p1 + " x " + p2 + " = ");
                    resposta = scanf.nextInt();

                    if (produto == resposta) {
                        pontos += 1;
                        System.out.println("\nParabéns, a resposta está certa! Agora está com " + pontos + " pontos!");
                    } else {
                        pontos -= 1;
                        System.out.println("\nA resposta certa é " + produto
                                + ", -1 ponto. Seu saldo total de pontos é " + pontos);
                    }

                    // Escolha de repetição
                    do {
                        System.out.print("\n\tQuer fazer novamente? (s/n): ");
                        repete = scanf.next();
                        repetir = repete.charAt(0);
                    } while (repetir != 's' && repetir != 'n');
                }
            }

            System.out.print("\n\nVocê quer voltar ao menu? (s/n): ");
            escolha = scanf.next();
            menu = escolha.charAt(0);
        }

        System.out.println("\n\nObrigado por usar essa ferramenta de exercícios! Aceito sugestões :)\n\n");

        scanf.close();
    }
}