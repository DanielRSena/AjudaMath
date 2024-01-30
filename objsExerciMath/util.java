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

}
