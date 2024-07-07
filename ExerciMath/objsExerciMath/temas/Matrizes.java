package objsExerciMath.temas;

import java.util.InputMismatchException;
import java.util.Scanner;

import objsExerciMath.Nums;
import objsExerciMath.Util;


public class Matrizes {

    public static int executar(Scanner entrada, int pontos){

        String tema[] = {"adição", "subtração", "multiplição por escalar", "matriz transposta"};
        int resposta, pontosGanhos = 0, 
            mat1[][] = Nums.criarMatriz(),
                sorteio = Nums.intRandom(4);
                
        System.out.println("\n\nE o estilo sorteado foi ... " + tema[sorteio - 1]);
        Nums.printaMatriz(mat1);
        
        if(sorteio < 4) { //qualquer um que não seja transposta

            if (sorteio < 3) { //soma ou subtração

                int mat2[][] = Nums.criarMatriz(mat1.length, mat1[0].length);  //cria outra matriz aleatória, mesmo tamanho da primeira
                System.out.println("\n\n\tSegunda matriz");
                Nums.printaMatriz(mat2);
                if (sorteio == 1) mat1 = Matrizes.somarMatriz(mat1, mat2); //se é adição, soma as matrizes
                else mat1 = Matrizes.subtrairMatriz(mat1, mat2); //se é subtração, faz a diferença das matrizes
            } 
            else { //multiplicação por escalar

                int escalar = Nums.intRandom(10); // o escalar será será um número entre 1 e 10
                mat1 = Matrizes.multEscalarMatriz(mat1, escalar);
                System.out.println("\n\n\tO escalar é " + escalar + "\n");
            }
    
            //passa pela matriz e pega as respostas
            for (int i = 0; i < mat1.length; i++) { 
                System.out.println();
                for (int j = 0; j < mat1[0].length; j++) {
                    try {
    
                        System.out.print("\tValor do endereço [" + (i+1) + "][" + (j+1) + "]: "); resposta = entrada.nextInt();
                        if (mat1[i][j] == resposta){ Util.acerto(pontos); pontosGanhos ++; }
                        else Util.erro(pontos);
                    } catch (InputMismatchException e) { entrada.next(); Util.erro(pontos); }
                }
            }
            System.out.println("\nSegue o gabarito:");
            Nums.printaMatriz(mat1);
            System.out.println("\nO total de pontos ganhos foram " + pontosGanhos + ". Agora está com " + pontos + " pontos.\n");
        }
        else { //matriz transposta

            int mat2[][] = new int[mat1[0].length][mat1.length]; 
            for (int i = 0; i < mat2.length; i++) {
                System.out.println();
                for (int j = 0; j < mat2[0].length; j++) {

                    mat2[i][j] = mat1[j][i]; //como é transposta, as linhas viram colunas e as colunas viram linhas
                    try {
    
                        System.out.print("\tValor do endereço [" + (i+1) + "][" + (j+1) + "]: "); resposta = entrada.nextInt();
                        if (mat2[i][j] == resposta){ Util.acerto(pontos); pontosGanhos ++; }
                        else Util.erro(pontos);

                    } catch (InputMismatchException e) { entrada.next(); Util.erro(pontos); }
                }
            }

            System.out.println("\nSegue o gabarito:");
            Nums.printaMatriz(mat2);
            System.out.println("\nO total de pontos ganhos foram " + pontosGanhos + ". Agora está com " + pontos + " pontos.\n");
        }
        return pontos;
    }
    
    private static int[][] somarMatriz(int matSomada[][], int segundaMat[][]){

        for (int i = 0; i < matSomada.length; i++) {
            for (int j = 0; j < matSomada[0].length; j++) {
                matSomada[i][j] += segundaMat[i][j];
            }
        }

        return matSomada;
    }

    private static int[][] subtrairMatriz(int matSubtraida[][], int segundaMat[][]){

        for (int i = 0; i < matSubtraida.length; i++) {
            for (int j = 0; j < matSubtraida[0].length; j++) {
                matSubtraida[i][j] -= segundaMat[i][j];
            }
        }

        return matSubtraida;
    }

    private static int[][] multEscalarMatriz(int matProduto[][], int escalar){

        for (int i = 0; i < matProduto.length; i++) {
            for (int j = 0; j < matProduto[0].length; j++) {
                matProduto[i][j] *= escalar;
            }
        }

        return matProduto;
    }
}