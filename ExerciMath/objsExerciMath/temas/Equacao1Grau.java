package objsExerciMath.temas;

import java.util.Scanner;

import objsExerciMath.Nums;
import objsExerciMath.Util;

public class Equacao1Grau {
    public static int executar(Scanner entrada, int pontos) {

        double resposta, x;
        int a = Nums.intRandom(10), b = Nums.intRandom(10);
    
        x = Nums.arredonda((-b) / (double) a);

        System.out.print("\n\tEquação: " + a + "x + " + b + " = 0\n\n");

        resposta = Nums.pedeDouble("\tValor de x: ");
        if (x == resposta) System.out.println(Util.acerto(pontos));
        else System.out.printf("\nA resposta certa é " + x + Util.erro(pontos));

        return pontos;
    }
}