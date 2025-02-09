#include <stdio.h>
#include <string.h>
#include <malloc.h>
#include <math.h>

//1.	Funções básicas do programa

char repetirProcesso(char descr[]) {
	char vezes;
	fflush(stdin);
	do {
		printf("%s", descr); 
		scanf("%c", &vezes); 
	} while (vezes != 's' && vezes != 'n');
	return vezes;
}

float arredondar(float num) {
	float numAux;
	numAux = num * 100;
	numAux = (int)numAux;
	numAux = numAux / 100;
	return numAux;
}

int pedirIntMin(char msg[], int min) {
	int num;
	do {
		printf("%s", msg);
		scanf("%d", &num);
	} while (num < min);
	return num;
}

int pedirInt(char msg[]) {
	int num;
	printf("%s", msg);
	scanf("%d", &num);
	return num;
}

float pedirFloat(char msg[]) {
	float num;
	printf("%s", msg);
	scanf("%f", &num);
	return num;
}

float pedirFloatMin(char msg[], float min) {
	float num;
	do {
		printf("%s", msg);
		scanf("%f", &num);
	} while (num < min);
	return num;
}


//2.	Funções-Programas, baseadas nos temas

//2.1	Agrupamento Discreto
int agrDiscreto() {

	int nAmostras = 0, tFreq = 0;
	float media = 0, s2 = 0, desvioPadrao = 0, CV = 0;

	nAmostras = pedirIntMin("\n\tQuantidade de amostras: ", 2);

	// cria e preenche os vetores das amostras e frequências
	float amostras[nAmostras], auxAmostras[nAmostras];
	int frequencias[nAmostras];
	for (int i = 0; i < nAmostras; i++) {
		amostras[i] = pedirFloat("\n\t\tValor: ");
		frequencias[i] = pedirIntMin("\t\tFrequencia: ", 0);
	}

	// os valores das amostras são atribuídos para o vetor auxiliar
	for (int i = 0; i < nAmostras; i++) 
		auxAmostras[i] = amostras[i]; 

	// média
	for (int i = 0; i < nAmostras; i++) {
		auxAmostras[i] = auxAmostras[i] * frequencias[i]; 
		media += auxAmostras[i];					  
		tFreq += frequencias[i];		
	}
	media = arredondar(media / tFreq);

	// variância
	for (int i = 0; i < nAmostras; i++) {
		amostras[i] = round((pow((amostras[i] - media), 2) * frequencias[i]) * 100) / 100;
		s2 += amostras[i];
	}
	s2 = s2 / (tFreq - 1);

	desvioPadrao = arredondar(sqrt(s2)); // desvio padrão

	CV = arredondar((100 * desvioPadrao) / media); // coeficiente de variação

	printf("\n\n\tMedia: %.2f\n\tVariancia: %.2f\n\tDesvio padrao: %.2f\n\tCoeficiente de variacao: %.2f%%", media, s2, desvioPadrao, CV);

	return 0;
}

//2.2 	Círculos
int circulos() {

	float raio, pi = 3.14159265;
	int op;
	raio = pedirFloatMin("\n\tRaio: ", 0);

	printf("\n\tDigite a opcao desejada \n\n\t1. Area\n\t2. Circunferencia\n\t3. Comprimento do arco\n\n");
	do {
		printf("\tOpcao: ");
		scanf("%d", &op);
	} while (op < 1 || op > 3);

	if(op == 1) printf("\n\tArea: %.2f", (pi * raio * raio));
	else if(op == 2) printf("\n\tCircunferencia: %.2f", (2 * pi * raio));
	else {
		printf("\n");
		float angulo = pedirFloatMin("\tDigite o angulo: ", 0);
		printf("\n\tComprimento do arco: %.2f", (2 * 3.14 * raio * angulo / 360));
	}
	return 0;
}

//2.3	Equação de 1º Grau
int equacao1grau() {

	float a, b, igualdade;

	do {
		printf("\n\t'a': ");
		scanf("%f", &a);
	} while (a == 0);

	b = pedirFloatMin("\t'b': ", 0);
	igualdade = pedirFloat("\tigualdade: ");

	// printa o processo da conta
	printf("\n\t\t%.2fx + %.2f = %.2f", a, b, igualdade);
	printf("\n\t\t%.2fx = %.2f - %.2f", a, igualdade, b);
	b = b * (-1) + igualdade;
	printf("\n\t\t%.2fx = %.2f", a, b);
	printf("\n\t\tx = %.2f / %.2f", b, a);
	printf("\n\n\tx = %.2f ", (b / a));

	return 0;
}

//2.4	Função de 2º Grau (Bhaskara)
int equacao2grau() {
	float a, b, c, igualdade, delta, x1, x2;

	do { // pega a variável 'a' separada, pois essa tem que ser diferente de 0
		printf("\n\t'a': ");
		scanf("%f", &a);
	} while (a == 0);

	b = pedirFloatMin("\t'b': ", 0);
	c = pedirFloatMin("\t'c': ", 0);
	igualdade = pedirFloatMin("\tigualdade: ", 0);

	c = c - igualdade; // caso a igualdade não seja 0, o que pode acontecer

	printf("\n\n\t\td = %.2f ^ 2 - 4 * %.2f * %.2f\n\t\td = %.2f - %.2f", b, a, c, b * b, 4 * a * c); 
	delta = b * b - 4 * a * c;																		
	printf("\n\t\td = %.2f", delta);

	if(delta < 0)
		printf("\n\n\tdelta = %.2f, sem raizes reais.\n\n", delta);
	else if(delta == 0)
		printf("\n\n\tx = %.2f\n\n", (-b) / (2 * a));
	else {

		printf("\n\n\t\tRaiz de %.2f = %.2f", delta, sqrt(delta));

		delta = sqrt(delta);

		printf("\n\n\t\tx1 = %.2f + %.2f / 2 * %.2f", (b * (-1)), delta, a);
		printf("\n\t\tx1 = %.2f / %.2f", (-b + delta), (2 * a));

		x1 = (((-1) * b) + delta) / (2 * a);

		printf("\n\n\t\tx2 = -%.2f - %.2f / 2 * %.2f", b, delta, a);
		printf("\n\t\tx2 = %.2f / %.2f", (((-1) * b) - delta), (2 * a));

		x2 = (((-1) * b) - delta) / (2 * a);

		printf("\n\n\tx1 = %.2f\n\tx2 = %.2f ", x1, x2);
	}
	return 0;
}

//2.5	Operações com Matrizes (+, -, transposta e * por escalar)
int matriz() {

	float escalar;
	int qtdLinhas, qtdColunas;
	char op;

	qtdLinhas = pedirIntMin("Digite a quantidade de linhas: ", 1);
	qtdColunas = pedirIntMin("Digite a quantidade de colunas: ", 1);

	// bloco para definir a operação que será feita
	printf("\nDigite + para somar\nDigite - para subtrair\nDigite . para multiplicar por um escalar\nDigite t para matriz transposta\n\n");
	do {
		printf("Sua escolha: ");
		scanf(" %c", &op);
	} while (op != '+' && op != '-' && op != '.' && op != 't');

	printf("\n\nPrimeira matriz\n");
	float **mat1 = criarMatriz(qtdLinhas, qtdColunas);

	if(op == '.') escalar = pedirFloat("\n\nDigite o valor do escalar: "); //fará se a opção escolhida for a multiplicação por escalar

	if( op == '+' || op == '-') {
		printf("\nSegunda matriz\n");
		float **mat2 = criarMatriz(qtdLinhas, qtdColunas);

		if(op == '+') mat1 = somarMatriz(qtdLinhas, qtdColunas, mat1, mat2);
		else mat1 = subtrairMatriz(qtdLinhas, qtdColunas, mat1, mat2);

		liberarMatriz(qtdLinhas, mat2);
	}
		
	if(op == '.') mat1 = escalarMatriz(qtdLinhas, qtdColunas, mat1, escalar);

	printf("\nResultado da operacao\n");
	if(op != 't') printarMatriz(qtdLinhas, qtdColunas, mat1);		
	else {
		float **matTransposta = matrizTransposta(qtdLinhas, qtdColunas, mat1);
		printarMatriz(qtdColunas, qtdLinhas, matTransposta);
		liberarMatriz(qtdColunas, matTransposta);
	}
	liberarMatriz(qtdLinhas, mat1);

	return 0;
}

//2.6	Sistema Linear
int sistemaLinear() {

	float nx1 = 0, aux = 0, nx2 = 0, ny1 = 0, aux2 = 0, ny2 = 0, n1 = 0, n2 = 0, x = 0, y = 0;

	printf("\tPara a resposta ser calculada de forma correta, coloque apenas os valores numericos. Ex:\n\n\t\t2x + 3y = 2.5\n\t\t2x -4 = 6\n\n\tSequencia de valores a serem colocados: 2, 3, 2.5, 2, -4, 6\n\n\n"); // explica como dar entrada nos dados

	nx1 = pedirFloat("\tPrimeiro valor, da primeira funcao: ");
	ny1 = pedirFloat("\tSegundo valor, da primeira funcao: ");
	n1 = pedirFloat("\tTerceiro valor, da primeira funcao: ");
	nx2 = pedirFloat("\tPrimeiro valor da segunda funcao: ");
	ny2 = pedirFloat("\tSegundo valor da segunda funcao: ");
	n2 = pedirFloat("\tTerceiro valor da segunda funcao: ");

	// para resolver o sistema, usei o método de adição e anulei a variável 'y'
	// para não perder o valor dos Ys, os armazenei em auxiliares
	aux = ny1; 
	ny1 *= nx2;
	aux2 = n1;
	n1 *= nx2;

	ny2 = ny2 * (-nx1);
	n2 = n2 * (-nx1);

	ny2 += ny1;
	n2 += n1;

	y = n2 / ny2;

	x = (aux2 - (aux * y)) / nx1; // descobre o 'x' ao substituir o 'y' na primeira equação

	printf("\n\tx = %.2f\n\ty = %.2f", x, y);

	return 0;
}

//2.7	Tabuada
int tabuada() {

	int nTabuada, nMin, nMax;

	nTabuada = pedirInt("\n\tQual tabuada vc quer? ");
	nMin = pedirInt("\n\tQual o menor valor multiplicado?: ");
	nMax = pedirInt("\n\tQual o maior valor multiplicado?: ");

	for (int cont = nMin; cont <= nMax; cont++) 
		printf("\n\t\t%d x %d = %d", nTabuada, cont, nTabuada * cont);

	return 0;
}