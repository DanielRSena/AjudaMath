package objsExerciMath;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Nums {

    static Random random = new Random();
    
    public static double arredonda(double num){

        BigDecimal resNum = BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_UP);
        num = resNum.doubleValue();
        return num;
    }

    public static int intRandom(int until){

        int num;
        if (until <= 0) num = random.nextInt(10) + 1; //se não colocar o intervalo, será de 1 até 10
        else num = random.nextInt(until) + 1; //se colocar, será do 1 até o número especificado
        return num;
    }

    public static double doubleRandom(double until){

        double num;
        if (until <= 0) num = random.nextDouble(10) + 1; //se não colocar o intervalo, será de 1 até 10
        else num = random.nextDouble(until) + 1; //se colocar, será do 1 até o número especificado
        return num;
    }

    public static int[][] criarMatriz(){ //esse método cria matrizes aleatórias, com tamanho aleatório

        int linhas = Nums.intRandom(5),
            colunas = Nums.intRandom(5),
                matriz[][] = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = Nums.intRandom(30);
            }
        }
        return matriz;
    } 

    public static int[][] criarMatriz(int linha, int coluna){ //cria matriz com valores aleatórios, mas com tamanho já setado

        int matriz[][] = new int[linha][coluna];

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                matriz[i][j] = Nums.intRandom(30);
            }
        }
        return matriz;
    } 

    public static void printaMatriz(int matriz[][]){

        for (int i = 0; i < matriz.length; i++) {
            System.out.println();
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("\t" + matriz[i][j]);
            }
        }
        System.out.println();
    }
}
