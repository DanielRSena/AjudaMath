import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;



public class AgrupDiscreto {

    static double media, tFreq;

    //  Média
    static double media(double amostra1[], int freq[]) {

           for (int i = 0; i < amostra1.length; i++) {
            amostra1[i] *= freq[i]; //multiplica as amostras pela frequência
            media += amostra1[i]; //toda essa multiplicação é acumulada
            tFreq += freq[i]; //todas as frequências são acumuladas
        }

        media = media / tFreq;

        //Arredondamento para duas casas
        BigDecimal resX = BigDecimal.valueOf(media).setScale(2, RoundingMode.HALF_UP);
        media = resX.doubleValue();

        return media;
    }
    
    //  Variância
    static double variancia(double amostra2[], int frequenc[]) {
        double vari = 0;

        for (int i = 0; i < amostra2.length; i++) {
            amostra2[i] /= frequenc[i]; //após a média ser feita, as amostras foram multiplcadas pela frequência. Aqui elas voltam ao normal
            amostra2[i] = Math.pow((amostra2[i] - media), 2) * frequenc[i]; // processo em que cada amostra passa pela (xi - x)^2.fi
            vari += amostra2[i]; //acumula o resultado anterior
        }
        vari = vari / (tFreq - 1); // somatória anterior dividida por (frequência - 1)

        //Arredondamento para duas casas
        BigDecimal resVar = BigDecimal.valueOf(vari).setScale(2, RoundingMode.HALF_UP);
        vari = resVar.doubleValue();

        return vari;
    }

    //  Programa
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "latin1");

        char programa = 's';
        String sPrograma;
        double desvioPadrao, CV;
        
        // Home
        while (programa == 's') {
            System.out.println("\n\n\t\t--- Agrupamento Discreto ---\n\n");

            //usuário define qtd de amostras
            int nAmostras;
            do {
                System.out.print("\tQuantidade de amostras: ");
                nAmostras = entrada.nextInt();
            } while (nAmostras <= 0);

            //cria e preenche os vetores das amostras e fequências 
            double amostra[] = new double[nAmostras];
            int frequencia[] = new int[nAmostras];
            for (int i = 0; i < nAmostras; i++) {
                System.out.println("\n\n\t\t--- Amostra " + (i + 1) + " ---");
                do {
                    System.out.print("\nValor: ");
                    amostra[i] = entrada.nextDouble();
                } while (frequencia[i] < 0);
                System.out.print("Frequência: ");
                    frequencia[i] = entrada.nextInt();
            }

            //chama as funções e colhe os resultados da média e variância
            media = media(amostra, frequencia);
            double varian = variancia(amostra, frequencia);
           
            //desvio padrão
            desvioPadrao = Math.sqrt(varian);
            BigDecimal resDp = BigDecimal.valueOf(desvioPadrao).setScale(2, RoundingMode.HALF_UP);
            desvioPadrao = resDp.doubleValue();

            //coeficiente de variação
            CV = (100 * desvioPadrao) / media;
            BigDecimal resCv = BigDecimal.valueOf(CV).setScale(2, RoundingMode.HALF_UP);
            CV = resCv.doubleValue();

            //resultados
            System.out.println("\n\n\t\t--- Resultados ---\n\nMédia: " + media + "\nVariancia: " + varian + "\nDesvio padrão: " + desvioPadrao + "\nCoeficiente de variação: " + CV + "\n\n");
   
            //usuário escolhe se continuará com o processo
            System.out.print("\nDeseja fazer novamente? (s/n): ");
            do {
                entrada.nextLine();
                sPrograma = entrada.nextLine();
                programa = sPrograma.charAt(0);
            } while (programa != 's' && programa != 'n');
            
        }

        //Mensagem de despedida
        System.out.println("\n\n\tObrigado por usar essa ferramenta! Aceito sugestões para melhoria :)");
        entrada.close();
    }
}
