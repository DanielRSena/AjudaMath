#include <stdio.h>
#include "funsRespondeMath/matrizes.h"
#include "funsRespondeMath/biblioMath.h"

int main() {

	char *titulos[7];
	titulos[0] = "Agrupamento discreto";
	titulos[1] = "Circulos";
	titulos[2] = "Funcao de 1 grau";
	titulos[3] = "Funcao de 2 grau";
	titulos[4] = "Matrizes";
	titulos[5] = "Sistema Linear";
	titulos[6] = "Tabuada";


	int opcao;
	char menu = 's', vezes = 's';

	// RespondeMath
	while (menu == 's') {

		printf("\n\n-----\tRespondeMath\t-----\n\n\tQual o assunto da pergunta?\n");
		for(int i = 0; i < 7; i++) 
			printf("\n\t\t%d. %s", (i+1), titulos[i]);
		printf("\n\n");

		do {
			printf("\tSua escolha: ");
			scanf("%d", &opcao);
		} while (opcao < 1 || opcao > 7);
		
		while (vezes == 's') {

			printf("\n\n\t\t--- %s ---\n\n", titulos[opcao-1]);
			switch (opcao) {
				case 1: agrDiscreto(); break;
				case 2: circulos(); break;
				case 3: equacao1grau(); break;
				case 4: equacao2grau(); break;
				case 5: matriz(); break;
				case 6: sistemaLinear(); break;
				case 7: tabuada(); break;
			}

			vezes = repetirProcesso("\n\n\tQuer fazer novamente? (s/n): ");
		}
			
		menu = repetirProcesso("\nDeseja retornar ao menu? (s/n): ");
	}

	free(titulos);
	printf("\n--------------------\n\n\tMuito obrigado por usar o RespondeMath! Aceito sugestoes :)\n\n--------------------\n\n");
}