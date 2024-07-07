package objsExerciMath.temas;

import java.util.Scanner;

import objsExerciMath.Nums;
import objsExerciMath.Util;

public class Equacao2Grau {
     public static int executar(Scanner entrada, int pontos) {

        double respostaDelta, delta, x1, respostaX1, x2, respostaX2;
        int a, b, c;

        // equilibrada nos valores
        a = Nums.intRandom(10);
        b = Nums.intRandom(15);
        c = Nums.intRandom(10);

        // delta
        delta = (b * b) - (4 * a * c);
        delta = Nums.arredonda(delta);

        System.out.print("\n\t\tEquação: " + a + "x2 + " + b + "x + " + c + " = 0.\n\n\n");

        respostaDelta = Nums.pedeDouble("\tDelta = ");
        if (respostaDelta == delta) System.out.println(Util.acerto(pontos));
        else System.out.printf("\nA resposta certa é " + delta + Util.erro(pontos));

        if (delta > 0) {

            delta = Nums.arredonda(Math.sqrt(delta));

            x1 = ((b * (-1)) + delta) / (2 * a);
            x1 = Nums.arredonda(x1);

            x2 = ((b * (-1)) - delta) / (2 * a);
            x2 = Nums.arredonda(x2);

            System.out.print("\n\n"); 
            respostaX1 = Nums.pedeDouble("\tValor do x1 = ");
            if (respostaX1 == x1) System.out.println(Util.acerto(pontos));
            else System.out.printf("\nA resposta certa é " + x1 + Util.erro(pontos));

            System.out.print("\n\n"); 
            respostaX2 = Nums.pedeDouble("\tValor do x2 = ");
            if (respostaX2 == x2) System.out.println(Util.acerto(pontos));
            else System.out.printf("\nA resposta certa é " + x2 + Util.erro(pontos));
        }
        return pontos;
    }

}
