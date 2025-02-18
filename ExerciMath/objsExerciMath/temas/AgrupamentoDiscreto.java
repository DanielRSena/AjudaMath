package objsExerciMath.temas;

import java.util.Scanner;
import java.util.ArrayList;

import objsExerciMath.Nums;
import objsExerciMath.Util;

public class AgrupamentoDiscreto {
    public static int executar(Scanner entrada, int pontos) {

        int i, nAmostras = 5, frequencias[] = new int[nAmostras];
        double media = 0.0, s2 = 0.0, desvioPadrao = 0.0, CV = 0.0, tFreq = 0.0, rMedia, rDesvio, rCV, rS2;
        ArrayList<Double> amostras = new ArrayList<>(), auxAmostras = new ArrayList<>();

        System.out.println("Lembre-se de ordenar as amostras antes de calcular!\n\n\txi\t f");

        //  armazena e printa os valores
        for (i = 0; i < nAmostras; i++) {
            amostras.add(Nums.arredonda(Nums.doubleRandom(50))); //sorteia um número aleatório entre 0 e 50 e o arredonda
            amostras.sort(null);
            System.out.print("\t" + amostras.get(i) + "\t");
            auxAmostras.add(amostras.get(i)); //ajuda na conta da média, sem comprometer as outras
            frequencias[i] = Nums.intRandom(50); //sorteia um inteiro entre 0 e 50
            System.out.println(frequencias[i]);
        }

        // média
        i = 0;
        for (Double amostra: amostras) {
            amostra *= frequencias[i]; // multiplica as amostras pela sua respectiva frequência
            media += auxAmostras.get(i); // o produto disto é acumulado
            tFreq += frequencias[i]; // todas as frequências são acumuladas
        }

        media = Nums.arredonda(media / tFreq); //faz a média e a arredonda

        // variância
        i = 0;
        for (Double amostra: amostras) {
            amostra = Math.pow((amostra - media), 2) * frequencias[i];
            s2 = s2 + amostras.get(i);
        }
        s2 = Nums.arredonda(s2 / (tFreq - 1));
        
        desvioPadrao = Nums.arredonda(Math.sqrt(s2)); // desvio padrão
    
        CV = ((100 * desvioPadrao) / media); // coeficiente de variação
        CV = Nums.arredonda(CV);

        //  verificação da média
        rMedia = Nums.pedeDouble("\tMédia: ");
        if (rMedia == media) System.out.println(Util.acerto(pontos));
        else System.out.println("O certo é " + media + Util.erro(pontos));

        //verificação da variância
        rS2 = Nums.pedeDouble("\tVariância: ");
        if (rS2 == s2) System.out.println(Util.acerto(pontos));
        else System.out.println("O certo é " + s2 + Util.erro(pontos));

        //verificação do desvio padrão
        rDesvio = Nums.pedeDouble("\tDesvio Padrão: ");
        if (rDesvio == desvioPadrao) System.out.println(Util.acerto(pontos));
        else System.out.println("O certo é " + desvioPadrao + Util.erro(pontos));

        //verificação do CV
        rCV = Nums.pedeDouble("\tCoeficiente de Variação: ");
        if (rCV == CV) System.out.println(Util.acerto(pontos));
        else System.out.println("O certo é " + CV + Util.erro(pontos));

        return pontos;
    }
}