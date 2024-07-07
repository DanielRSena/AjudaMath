package objsExerciMath.temas;

import java.util.InputMismatchException;
import java.util.Scanner;

import objsExerciMath.Nums;
import objsExerciMath.Util;

public class Tabuadas {
    public static int executar(Scanner entrada, int pontos) {

        int p1, p2, produto, resposta, tempoLimite = 15; // segundos
        long tempoInicio = System.currentTimeMillis();

        while ((System.currentTimeMillis() - tempoInicio) < (tempoLimite * 1000)) {
            p1 = Nums.intRandom(10); 
            p2 = Nums.intRandom(10);
            produto = p1 * p2;

            try {

                System.out.print("\n\t" + p1 + " x " + p2 + " = "); resposta = entrada.nextInt();
                if (produto == resposta) Util.acerto(pontos);
                else {
                    System.out.println("\nA resposta certa é " + produto);
                    Util.erro(pontos);
                }

            } catch (InputMismatchException e) {
                entrada.next();
                System.out.println("\nA resposta certa é " + produto);
                Util.erro(pontos);
            }
        }

        System.out.println("\nAcabou o tempo! Você está com " + pontos + " pontos!\n");

        return pontos;
    }
}
