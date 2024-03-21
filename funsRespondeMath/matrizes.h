#include <stdio.h>
#include <malloc.h>

float **criarMatriz(int linhas, int colunas) {
    
    // Aloca memória para as linhas
    float **matriz = (float **)malloc(linhas * sizeof(float *));

    // Aloca memória para as colunas
    for (int i = 0; i < linhas; i++) {
        matriz[i] = (float *)malloc(colunas * sizeof(float));
        printf("\n");
        for (int j = 0; j < colunas; j++) {
            printf("Digite o valor da posicao [%d][%d]: ", (i + 1), (j + 1));
            scanf("%f", &matriz[i][j]);
        }
    }
    return matriz;
}

void printaMatriz(int linhas, int colunas, float **matriz) {
    printf("\nMatriz:\n\n");
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            printf("%.2f\t", matriz[i][j]);
        }
        printf("\n");
    }
}

float **somaMatriz(int linhas, int colunas, float **m1, float **m2) {
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) 
            m1[i][j] += m2[i][j];
    }
    return m1;
}

float **subtraiMatriz(int linhas, int colunas, float **m1, float **m2) {
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) 
            m1[i][j] -= m2[i][j];
    }
    return m1;
}

float **escalarMatriz(int linhas, int colunas, float **m1, int escalar) {
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) 
            m1[i][j] *= escalar;
    }
    return m1;
}

float **matrizTransposta(int linhas, int colunas, float **m1) {

    float **mat = (float **)malloc(linhas * sizeof(float *));

    for (int i = 0; i < linhas; i++) {
        mat[i] = (float *)malloc(colunas * sizeof(float));
        for (int j = 0; j < colunas; j++) 
            mat[i][j] = m1[j][i];
    }
    return mat;
}

void liberarMatriz(int linhas, float **matriz) {
    for (int i = 0; i < linhas; i++) {
        free(matriz[i]); // Libera as colunas de cada linha
    }
    free(matriz); // Libera as linhas da matriz
}