#include <stdio.h>
#include <math.h>

int agDiscreto(){

    //usuário define qtd de amostras
    int nAmostras = 0, tFreq = 0;
	float media = 0, s2 = 0, desvioPadrao = 0, CV = 0;
    do {
        printf("\n\tQuantidade de amostras: ");
        scanf("%d", &nAmostras);
    } while (nAmostras <= 0);

    //cria e preenche os vetores das amostras e fequências 
    float amostras[nAmostras], auxAmostras[nAmostras];
    int frequencias[nAmostras];
    for (int i = 0; i < nAmostras; i++) {
		printf("\n\t\tValor: ");
        scanf("%f", &amostras[i]);

        do {
            printf("\t\tFrequencia: ");
            scanf("%d", &frequencias[i]);
        } while (frequencias[i] < 0);
	}

	for (int i = 0; i < nAmostras; i++)
		auxAmostras[i] = amostras[i];
	
	//média
    for (int i = 0; i < nAmostras; i++) {
        auxAmostras[i] = auxAmostras[i] * frequencias[i]; //multiplica as amostras pela frequência
        media = media + auxAmostras[i]; //toda essa multiplicação é acumulada
        tFreq = tFreq + frequencias[i]; //todas as frequências são acumuladas
    }
    media = round((media / tFreq) * 100) / 100;

	//variancia
	for (int i = 0; i < nAmostras; i++)
	{
		amostras[i] = round((pow((amostras[i] - media), 2) * frequencias[i]) * 100) / 100;
		s2 = s2 + amostras[i];
	}
	s2 = s2 / (tFreq - 1);

	//desvio padrao
	desvioPadrao = round((sqrt(s2)) * 100) / 100;

	//coeficiente de variacao
	CV = round(((100 * desvioPadrao) / media) * 100) / 100;

	printf("\n\n\tMedia: %.2f\n\tVariancia: %.2f\n\tDesvio padrao: %.2f\n\tCoeficiente de variacao: %.2f%%\n\n", media, s2, desvioPadrao, CV);
	
	return 0;
}

float equacao1grau()
{
	float a, b, igualdade;
	do
	{
		printf("\n\t'a': ");
		scanf("%f", &a);
	} while (a == 0);

	printf("\t'b': ");
	scanf("%f", &b);
	printf("\tigualdade: ");
	scanf("%f", &igualdade);
	printf("\n\t\t%.2fx + %.2f = %.2f", a, b, igualdade);
	printf("\n\t\t%.2fx = %.2f - %.2f", a, igualdade, b);
	b = b * (-1) + igualdade;
	printf("\n\t\t%.2fx = %.2f", a, b);
	printf("\n\t\tx = %.2f / %.2f", b, a); 
	printf("\n\n\tx = %.2f\n\n", (b/a));

	return 0;
}

float equacao2grau()
{
	float a, b, c, igualdade, delta, x1, x2;

	//pega as variáveis
	do
	{
		printf("\n\t'a': ");
		scanf("%f", &a);
	} while (a == 0); //caso 'a' seja diferente de 0, esse bloco o armazena
	printf("\t'b': "); scanf("%f", &b); //armazena o 'b'
	printf("\t'c': "); scanf("%f", &c); //armazenao 'c'
	printf("\tigualdade: "); scanf("%f", &igualdade); //armazena a igualdade (geralmente é 0)

	c = c - igualdade; // caso a igualdade não seja 0

	printf("\n\n\t\td = %.2f ^ 2 - 4 * %.2f * %.2f\n\t\td = %.2f - %.2f", b, a, c, b * b, 4 * a * c); //printa a operação -b^2 - 4*a*c (delta)
	delta = b * b - 4 * a * c; //faz a conta propriamente dita
	printf("\n\t\td = %.2f", delta);

	if (delta < 0)
		printf("\n\n\tdelta = %.2f, sem raizes reais.\n\n", delta); //se delta for < 0
	else if (delta == 0)
		printf("\n\n\tx = %.2f\n\n", (-b) / (2 * a)); //se delta for igual a 0
	else
	{
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

int main()
{
	char menu = 's';

	// RespondeMath
	while (menu == 's')
	{
		int opcao, ntabuada, cont;
		char vezes = 's';

		printf("\n\n-----\tRespondeMath\t-----\n\n\tQual o assunto da pergunta?");
		printf("\n\n\t\t1. Agrupamento discreto\n\t\t2. Funcao de 1 grau\n\t\t3. Funcao de 2 grau\n\t\t4. Tabuadas.\n\n");
		do
		{
			printf("\tSua escolha: ");
			scanf("%d", &opcao);
		} while (opcao < 1 || opcao > 4);

		// 1. Agrupamento discreto
		if (opcao == 1)
		{
			printf("\n\n\t\t--- Agrupamento discreto ---\n");
			while (vezes == 's')
			{

            	agDiscreto();
				do { printf("\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes); } while (vezes != 's' && vezes != 'n');
			}
		}

		// 2. Função de 1ºgrau
		else if (opcao == 2)
		{
			printf("\n\n\t\t--- Funcao de 1 grau ---\n");
			while (vezes == 's')

			{
				equacao1grau();

				do
				{
					printf("\tQuer fazer novamente? (s/n): ");
					scanf(" %c", &vezes);
				} while (vezes != 's' && vezes != 'n');
			}
		}

		// 3. Função de 2º grau
		else if (opcao == 3)
		{
			printf("\n\n\t\t--- Funcao de 2 grau ---\n");
			while (vezes == 's')
			{
				equacao2grau();
				do{ 
					printf("\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes);
				} while (vezes != 's' && vezes != 'n');
			}
		}

		// 4. Tabuadas
		else if (opcao == 4)
		{
			printf("\n\n\t\t--- Gerador de tabuada ---\n");
			while (vezes == 's')
			{
				printf("\n\tQual tabuada vc quer? ");
				scanf("%d", &ntabuada);
				for (cont = 0; cont < 11; cont = cont + 1)
					printf("\n\t\t%d x %d = %d", ntabuada, cont, ntabuada * cont);
				printf("\n\n");
				do
				{
					printf("\tQuer fazer novamente? (s/n): ");
					scanf(" %c", &vezes);
				} while (vezes != 's' && vezes != 'n');
			}
		}

		// Modelo para englobar as opções
		/*		else if (opcao == x)
		{
			printf("\n\n\t\t--- Funcao de 1 grau ---\n\n");
			while (vezes == 's')
			{

				do { printf("\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes); } while (vezes != 's' && vezes != 'n');
			}

		}*/


		// Volta para o menu ou ncerra programa
		do
		{
			printf("\nDeseja retornar ao menu? (s/n): "); scanf(" %c", &menu);
		} while (menu != 's' && menu != 'n');
	}

	// Fim do respondeMat
	printf("\n--------------------\n\n\tMuito obrigado por usar a minha ferramenta! Aceito sugestoes :)\n\n--------------------\n\n");
}
