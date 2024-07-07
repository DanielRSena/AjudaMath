import java.util.InputMismatchException;
import java.util.Scanner;

import objsExerciMath.*;
import objsExerciMath.temas.*;

class ExerciMath {
    public static void main(String[] args) {

        char menu = 's', repetir = 's';
        int pontos = 0, opcao = 0;
        Scanner entrada = new Scanner(System.in, "latin1");
        
        String temas[] = {"Agrupamento discreto", "Função de 1º grau" , "Função de 2º grau", "Matrizes", "Sistema Linear", "Tabuada contra o tempo"};
        String descricao[] = {"Encontre a média, variância, desvio padrão e coeficiente de variação para ganhar 4 pontos!", "Encontre o valor de x para ganhar 1 ponto!", "Encontre o valor do delta, 'x1' e  'x2' para ganhar 3 pontos!", "Faça as operações com as matrizes para ganhar pontos!", "Encontre o valor de 'x' e  'y' para ganhar 2 pontos!", "Coloque a resposta certa para ganhar um ponto!"};
        
        while (menu == 's') {

            System.out.println( "\n\n\t\t--- ExerciMath --- \n\nBem vindo à central de exercícios do AjudaMath! Escolha o assunto que deseja fazer exercícios:");
            for(int i = 0; i < temas.length; i++) System.out.print("\n" + (i+1) + ". " + temas[i]); 
            System.out.print("\n\n");

            while (true) { //não sairá daqui até colocar uma opção válida
                try {
                    do {
                        System.out.print("\tSua escolha: "); opcao = entrada.nextInt();
                    } while (opcao < 1 || opcao > 6);
                    break;
                } catch (InputMismatchException e) { entrada.nextLine(); } //limpa o buffer do Scanner se for letras ou símbolos
            }
               
            // Repetição
            while (repetir == 's') {

                // texto inicial
                System.out.println("\n\n\t\t--- " + temas[(opcao - 1)] + " ---\n\nSaluton, e muito bem vindo! " + descricao[(opcao - 1)] + "\nMas cuidado! Se errar, perde 1 ponto.");

                if (opcao == 1) pontos = AgrupamentoDiscreto.executar(entrada, pontos);
                else if(opcao == 2)  pontos = Equacao1Grau.executar(entrada, pontos);
                else if(opcao == 3)  pontos = Equacao2Grau.executar(entrada, pontos);
                else if(opcao == 4)  pontos = Matrizes.executar(entrada, pontos);
                else if(opcao == 5)  pontos = SistemaLinear.executar(entrada, pontos);
                else  pontos = Tabuadas.executar(entrada, pontos);

                repetir = Util.repetirProcesso(); // Escolha de repetição
            }
            menu = Util.repetirProcesso("\n\nVocê quer voltar ao menu? (s/n): ");
        }

        System.out.println("\n\nObrigado por usar o ExerciMath! Aceito sugestões :)\n\n");
        entrada.close();
    }
}