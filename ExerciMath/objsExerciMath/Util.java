package objsExerciMath;
import java.util.Scanner;

public class Util {

    static Scanner entrada = new Scanner(System.in);
    
    public static char stringToChar(String palavra){
        char letra = palavra.charAt(0);
        return letra;
    }

    public static char repetirProcesso(){

        String repete;
        char voltar = 's';

        do {
            System.out.print("\n\tQuer fazer novamente? (s/n): ");
            repete = entrada.nextLine();
            voltar = repete.charAt(0);
        } while (voltar != 's' && voltar != 'n');

        return voltar;
    }

    public static char repetirProcesso(String mensagem){
        
        String repete;
        char voltar = 's';

        do {
            System.out.print(mensagem);
            repete = entrada.nextLine();
            voltar = repete.charAt(0);
        } while (voltar != 's' && voltar != 'n');

        return voltar;
    }

    public static int acerto(int pontos) {
        return pontos += 1;
    }

    public static int erro(int pontos) {
        return pontos -= 1;
    }

    public static double[] bubbleSort(double v[], int n) {
        int i;
        double aux;
    
        for(i = n - 1; i >= 1; i--) {
            for(int j = 0; j < i; j++) {
                if(v[j] > v[j+1]) {
                    aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }

        return v;
    }

}
