#include <stdio.h>
#include <math.h>

char repeteProcesso(){
	char vezes;
	do {
		printf("\n\n\tQuer fazer novamente? (s/n): "); 
		scanf(" %c", &vezes); 
	} while (vezes != 's' && vezes != 'n');

	return vezes;
}

int agDiscreto(){

    //usuário define qtd de amostras
    int nAmostras = 0, tFreq = 0;
	float media = 0, s2 = 0, desvioPadrao = 0, CV = 0;

    do {
        printf("\n\tQuantidade de amostras: "); scanf("%d", &nAmostras);
    } while (nAmostras <= 0);

    //cria e preenche os vetores das amostras e fequências 
    float amostras[nAmostras], auxAmostras[nAmostras];
    int frequencias[nAmostras];
    for (int i = 0; i < nAmostras; i++) {
		printf("\n\t\tValor: "); scanf("%f", &amostras[i]);

        do {
            printf("\t\tFrequencia: ");
            scanf("%d", &frequencias[i]);
        } while (frequencias[i] < 0);
	}

	for (int i = 0; i < nAmostras; i++) auxAmostras[i] = amostras[i]; //os valores das amostras são atribuídos para o vetor auxiliar
	
	//média
    for (int i = 0; i < nAmostras; i++) {
        auxAmostras[i] = auxAmostras[i] * frequencias[i]; //multiplica as amostras pela frequência
        media = media + auxAmostras[i]; //toda essa multiplicação é acumulada
        tFreq = tFreq + frequencias[i]; //todas as frequências são acumuladas
    }
    media = round((media / tFreq) * 100) / 100;

	//variancia
	for (int i = 0; i < nAmostras; i++) {
		amostras[i] = round((pow((amostras[i] - media), 2) * frequencias[i]) * 100) / 100;
		s2 = s2 + amostras[i];
	}
	s2 = s2 / (tFreq - 1);

	desvioPadrao = round((sqrt(s2)) * 100) / 100; //desvio padrao

	CV = round(((100 * desvioPadrao) / media) * 100) / 100; //coeficiente de variacao

	printf("\n\n\tMedia: %.2f\n\tVariancia: %.2f\n\tDesvio padrao: %.2f\n\tCoeficiente de variacao: %.2f%%\n\n", media, s2, desvioPadrao, CV);
	
	return 0;
}

int equacao1grau()
{
	float a, b, igualdade;

	do {
		printf("\n\t'a': "); scanf("%f", &a);
	} while (a == 0);

	printf("\t'b': "); scanf("%f", &b);
	printf("\tigualdade: "); scanf("%f", &igualdade);

	//printa o processo da conta
	printf("\n\t\t%.2fx + %.2f = %.2f", a, b, igualdade);
	printf("\n\t\t%.2fx = %.2f - %.2f", a, igualdade, b);
	b = b * (-1) + igualdade;
	printf("\n\t\t%.2fx = %.2f", a, b);
	printf("\n\t\tx = %.2f / %.2f", b, a); 
	printf("\n\n\tx = %.2f\n\n", (b/a));

	return 0;
}

int equacao2grau()
{
	float a, b, c, igualdade, delta, x1, x2;

	
	do { //pega a variável 'a' separada, pois essa tem que ser diferente de 0
		printf("\n\t'a': "); scanf("%f", &a);
	} while (a == 0); //fará enquanto 'a' for igual a 0

	printf("\t'b': "); scanf("%f", &b);               //armazena o 'b'
	printf("\t'c': "); scanf("%f", &c);               //armazenao 'c'
	printf("\tigualdade: "); scanf("%f", &igualdade); //armazena a igualdade (geralmente é 0)

	c = c - igualdade; // caso a igualdade não seja 0, o que pode acontecer

	printf("\n\n\t\td = %.2f ^ 2 - 4 * %.2f * %.2f\n\t\td = %.2f - %.2f", b, a, c, b * b, 4 * a * c); //printa a operação -b^2 - 4*a*c (delta)
	delta = b * b - 4 * a * c; //faz a conta propriamente dita
	printf("\n\t\td = %.2f", delta);

	if (delta < 0) printf("\n\n\tdelta = %.2f, sem raizes reais.\n\n", delta); //se delta for < 0
	else if (delta == 0) printf("\n\n\tx = %.2f\n\n", (-b) / (2 * a));         //se delta for igual a 0
	else {
		printf("\n\n\t\tRaiz de %.2f = %.2f", delta, sqrt(delta));
		delta = sqrt(delta);
		printf("\n\n\t\tx1 = %.2f + %.2f / 2 * %.2f", (b * (-1)), delta, a);
		printf("\n\t\tx1 = %.2f / %.2f", (-b + delta), (2 * a));
		x1 = (((-1) * b) + delta) / (2 * a);
		printf("\n\n\t\tx2 = -%.2f - %.2f / 2 * %.2f", b, delta, a);
		printf("\n\t\tx2 = %.2f / %.2f", (((-1) * b) - delta), (2 * a));
		x2 = (((-1) * b) - delta) / (2 * a);

		printf("\n\n\tx1 = %.2f\n\tx2 = %.2f\n\n", x1, x2);
	}
	return 0;
}

int matrizes(){
	float escalar;
	int qtdLinhas, qtdColunas;
	char op;	

	do {
		printf("\nDigite a quantidade de linhas: "); scanf("%d", &qtdLinhas);
	} while (qtdLinhas < 1);

	do {
		printf("\nDigite a quantidade de colunas: "); scanf("%d", &qtdColunas);
	} while (qtdColunas < 1);

	float mat1[qtdLinhas][qtdColunas], mat2[qtdLinhas][qtdColunas]; //matrizes 'normais'
	float matTransposta[qtdColunas][qtdLinhas]; //matriz especial

	//bloco para definir a operação que será feita
	printf("\nDigite + para somar\nDigite - para subtrair\nDigite . para multiplicar por um escalar\nDigite t para matriz transposta\n\n");
	do {
		printf("Sua escolha: "); scanf(" %c", &op);
	} while (op != '+' && op != '-' && op != '.' && op != 't');

	//bloco construtor da primeira matriz
	printf("\n\nPrimeira matriz\n");
	for (int i = 0; i < qtdLinhas; i++) { //constrói a primeira matriz 
		printf("\n");
		for (int j = 0; j < qtdColunas; j++) {
			printf("Digite o valor do espaco [%d][%d]: ", (i + 1), (j + 1));  scanf("%f", &mat1[i][j]);
		}	
	}

	if(op == '.'){ //fará se o user tiver escolhido multiplicação por um escalar
		printf("\n\nDigite o valor do escalar: "); scanf("%f", &escalar);
	}

	//bloco construtor da segunda matriz, se precisar...
	if(op == '+' || op == '-'){ //bloco de if apenas para operações precisam de outra matriz (soma e subtração)
		printf("\n\nSegunda matriz\n");
		for (int i = 0; i < qtdLinhas; i++) {
				printf("\n");
				for (int j = 0; j < qtdColunas; j++) {
					printf("Digite o valor do espaco [%d][%d]: ",(i + 1), (j + 1));  scanf("%f", &mat2[i][j]);
				}
		}
	}

	printf("\nResultado da operacao\n");

	//bloco para resolver as operações
	if(op == '+' || op == '-' || op == '.'){ //operações em que a matriz resultante permanece com tamanho igual 
		for (int i = 0; i < qtdLinhas; i++) {
			printf("\n");
			for (int j = 0; j < qtdColunas; j++) {
				if(op == '+') mat1[i][j] += mat2[i][j];
				else if(op == '-') mat1 [i][j]-= mat2[i][j];
				else mat1[i][j] *= escalar;
				printf("%.2f\t", (round(mat1[i][j] * 100) / 100));
			}
		}
	}
	else { //operação da matriz transposta
		for (int i = 0; i < qtdColunas; i++) {
			printf("\n");
			for (int j = 0; j < qtdLinhas; j++) {
				matTransposta[i][j] = mat1[j][i];
				printf("%.2f\t", (round(matTransposta[i][j] * 100) / 100));
			}
		}
	}

	return 0;
}

int sistemas(){

	float nx1 = 0, aux = 0, nx2 = 0, ny1 = 0, aux2 = 0, ny2 = 0, n1 = 0, n2 = 0, x = 0, y = 0;

	printf("\tPara a resposta ser calculada de forma correta, coloque apenas os valores numericos. Ex:\n\n\t\t2x + 3y = 2.5\n\t\t2x -4 = 6\n\n\tSequencia de valores a serem colocados: 2, 3, 2.5, 2, -4, 6\n\n\n"); //explica como dar entrada nos dados 

	printf("\tPrimeiro valor, da primeira funcao: "); scanf("%f", &nx1);
	printf("\tSegundo valor, da primeira funcao: "); scanf("%f", &ny1);
	printf("\tTerceiro valor, da primeira funcao: "); scanf("%f", &n1);
	printf("\n\tPrimeiro valor da segunda funcao: "); scanf("%f", &nx2);
	printf("\tSegundo valor da segunda funcao: "); scanf("%f", &ny2);
	printf("\tTerceiro valor da segunda funcao: "); scanf("%f", &n2);

	//para resolver o sistema, usei o método de adição e anulei a variável 'y' 
	aux = ny1; //para não perder o valor dos Ys, os armazenei em auxiliares
	ny1 *= nx2;
	aux2 = n1;
	n1 *= nx2;

	ny2 = ny2 * (-nx1);
	n2 = n2 * (-nx1);

	ny2 += ny1;
	n2 += n1;

	y = n2 / ny2;

	x = (aux2 - (aux * y)) / nx1; //descobre o 'x' ao substituir o 'y' na primeira equação

	printf("\n\tx = %.2f\n\ty = %.2f\n\n", x, y);

	return 0;
}

int main() {

	char menu = 's';

	// RespondeMath
	while (menu == 's') {

		int opcao, nTabuada, cont;
		char vezes = 's';

		printf("\n\n-----\tRespondeMath\t-----\n\n\tQual o assunto da pergunta?");
		printf("\n\n\t\t1. Agrupamento discreto\n\t\t2. Funcao de 1 grau\n\t\t3. Funcao de 2 grau\n\t\t4. Matrizes\n\t\t5. Sistemas lineares\n\t\t6. Tabuadas\n\n");

		do {
			printf("\tSua escolha: ");
			scanf("%d", &opcao);
		} while (opcao < 1 || opcao > 6);

		// 1. Agrupamento discreto
		if (opcao == 1) {

			printf("\n\n\t\t--- Agrupamento discreto ---");
			while (vezes == 's') {
				printf("\n\n");
            	agDiscreto();
				vezes = repeteProcesso();
			}
		}

		// 2. Função de 1ºgrau
		else if (opcao == 2) {

			printf("\n\n\t\t--- Funcao de 1 grau ---");
			while (vezes == 's') {
				printf("\n\n");
				equacao1grau();
				vezes = repeteProcesso();
			}
		}

		// 3. Função de 2º grau
		else if (opcao == 3) {

			printf("\n\n\t\t--- Funcao de 2 grau ---");
			while (vezes == 's') {
				printf("\n\n");
				equacao2grau();
				vezes = repeteProcesso();
			}
		}

		// 4. Matrizes (4 operações básicas)
		else if (opcao == 4) {

			printf("\n\n\t\t--- Matrizes ---");
			while (vezes == 's') {
				printf("\n\n");
				matrizes();
				vezes = repeteProcesso();
			}
		}

		// 5. Sistemas lineares
		else if (opcao == 5) {

			printf("\n\n\t\t--- Sistemas lineares ---");
			while (vezes == 's') {
				printf("\n\n");
				sistemas();
				vezes = repeteProcesso();
			}
		}

		// 6. Tabuadas
		else if (opcao == 6) {

			printf("\n\n\t\t--- Gerador de tabuada ---");
			while (vezes == 's') {
				printf("\n\n\tQual tabuada vc quer? "); scanf("%d", &nTabuada); //user define a tabuada
				for (cont = 1; cont < 11; cont++) printf("\n\t\t%d x %d = %d", nTabuada, cont, nTabuada * cont); //printa a tabuada
				printf("\n\n");
				vezes = repeteProcesso();
			}
		}

		// Modelo para englobar as opções
		/*		else if (opcao == num) {
			printf("\n\n\t\t--- Titulo ---");
			while (vezes == 's') {
				printf("\n\n");
				metodo();
				vezes = repeteProcesso();
			}
		}*/


		do { // Volta para o menu ou encerra programa
			printf("\nDeseja retornar ao menu? (s/n): "); scanf(" %c", &menu);
		} while (menu != 's' && menu != 'n');
	}

	// Fim do RespondeMath
	printf("\n--------------------\n\n\tMuito obrigado por usar a minha ferramenta! Aceito sugestoes :)\n\n--------------------\n\n");
}
