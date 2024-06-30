package objsExerciMath;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Nums {

    static Random random = new Random();
    static Scanner entrada = new Scanner(System.in);
    
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

    public static int printaMatriz(int matriz[][]){

        for (int i = 0; i < matriz.length; i++) {
            System.out.println();
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("\t" + matriz[i][j]);
            }
        }
        System.out.println();
        return 0;
    }

    public static double pedeDouble(String msg) {     
        
        double num;

        while (true) {

            System.out.print(msg);
            try { 
                num = entrada.nextDouble(); 
                break;
            }
            catch (InputMismatchException e) { 
                entrada.next();
            } catch (NoSuchElementException e) { 
                entrada.next();
            }
        }
        return num;
    }
}