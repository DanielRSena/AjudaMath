#include <stdio.h>
#include "funsRespondeMath/matrizes.h"
#include "funsRespondeMath/biblioMath.h"

int main() {

	char *titulos[6];
	titulos[0] = "Agrupamento discreto";
	titulos[1] = "Funcao de 1 grau";
	titulos[2] = "Funcao de 2 grau";
	titulos[3] = "Matrizes";
	titulos[4] = "Sistema Linear";
	titulos[5] = "Tabuada";

	int opcao;
	char menu = 's', vezes = 's';

	// RespondeMath
	while (menu == 's') {

		printf("\n\n-----\tRespondeMath\t-----\n\n\tQual o assunto da pergunta?\n");
		for(int i = 0; i < 6; i++) 
			printf("\n\t\t%d. %s", (i+1), titulos[i]);
		printf("\n\n");

		do {
			printf("\tSua escolha: ");
			scanf("%d", &opcao);
		} while (opcao < 1 || opcao > 6);
		
		while (vezes == 's') {

			printf("\n\n\t\t--- %s ---\n\n", titulos[opcao-1]);
			if(opcao == 1) agrDiscreto();
			else if (opcao == 2) equacao1grau();
			else if (opcao == 3) equacao2grau();
			else if (opcao == 4) matriz();
			else if (opcao == 5) sistemaLinear();
			else if (opcao == 6) tabuada();
			else printf("Operação Inexistente");

			vezes = repetirProcesso("\n\n\tQuer fazer novamente? (s/n): ");
		}
			
		menu = repetirProcesso("\nDeseja retornar ao menu? (s/n): ");
	}

	free(titulos);
	printf("\n--------------------\n\n\tMuito obrigado por usar o RespondeMath! Aceito sugestoes :)\n\n--------------------\n\n");
}