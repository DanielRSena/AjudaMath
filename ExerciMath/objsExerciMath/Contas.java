package objsExerciMath;

public class Contas {
    
    public static int[][] somarMatriz(int matSomada[][], int segundaMat[][]){

        for (int i = 0; i < matSomada.length; i++) {
            for (int j = 0; j < matSomada[0].length; j++) {
                matSomada[i][j] += segundaMat[i][j];
            }
        }

        return matSomada;
    }

    public static int[][] subtrairMatriz(int matSubtraida[][], int segundaMat[][]){

        for (int i = 0; i < matSubtraida.length; i++) {
            for (int j = 0; j < matSubtraida[0].length; j++) {
                matSubtraida[i][j] -= segundaMat[i][j];
            }
        }

        return matSubtraida;
    }

    public static int[][] multEscalarMatriz(int matProduto[][], int escalar){

        for (int i = 0; i < matProduto.length; i++) {
            for (int j = 0; j < matProduto[0].length; j++) {
                matProduto[i][j] *= escalar;
            }
        }

        return matProduto;
    }
}