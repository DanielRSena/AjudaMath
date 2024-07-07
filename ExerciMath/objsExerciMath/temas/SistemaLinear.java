package objsExerciMath.temas;

import java.util.Scanner;

import objsExerciMath.Nums;
import objsExerciMath.Util;

public class SistemaLinear {
    public static int executar(Scanner entrada, int pontos) {

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

        System.out.println();
        respostaX = Nums.pedeDouble("\tValor do x = ");
        if (x == respostaX) System.out.println(Util.acerto(pontos));
        else System.out.println("\nA resposta certa é " + x + Util.erro(pontos));

        System.out.println();
        respostaX = Nums.pedeDouble("\tValor do y = ");
        if (y == respostaY) System.out.println(Util.acerto(pontos));
        else System.out.println("\nA resposta certa é " + y + Util.erro(pontos));

        return pontos;
    }
}
