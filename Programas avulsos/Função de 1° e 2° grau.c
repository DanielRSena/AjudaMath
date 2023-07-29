#include <stdio.h>
#include <math.h>
main ()

//Função de 1º e 2º grau
{
	char menu = 's';
	while (menu == 's')
	{
		float a, b, c, x1, x2, igualdade, delta;
		int opcao;
		char vezes = 's';
		printf("\n\n			----- Funcoes de 1 e 2 grau -----");
		printf("\n\n\n	Para equacao de 1 grau, digite 1\n	Para equacao de 2 grau, digite 2\n");
		do { printf("\n\t\tSua opcao:  "); scanf("%d", &opcao); } while (opcao != 1 && opcao != 2);
		if (opcao == 1) 
		{
			while (vezes == 's')
			{
				printf("\n\n\t\t\t----- Funcao de 1 grau -----\n\n");
				do { printf("\n	'a': "); scanf("%f", &a); } while (a == 0);
				printf("	'b': "); scanf("%f", &b);
				printf("	valor da igualdade: "); scanf("%f", &igualdade);
				printf("\n\n		%.2fx + %.2f = %.2f", a, b, igualdade);
				printf("\n		%.2fx = %.2f - %.2f", a, igualdade, b );
				b = b * (-1) + igualdade; 
				printf("\n		%.2fx = %.2f", a, b );
				x1 = b / a;
				printf("\n\t\tx = %.2f / %.2f", b, a);
				printf("\n\n\t\tx = %.2f", x1);
				do { printf("\n\n\n\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes); } while (vezes != 's' && vezes != 'n');
			}
		}
		else
		{
			while (vezes == 's')
			{
				printf("\n\n\t\t\t----- Funcao de 2 grau -----\n\n");
				do { printf("\n	'a': "); scanf("%f", &a); } while (a == 0);
				printf("\t'b': "); scanf("%f", &b);
				printf("\t'c': "); scanf("%f", &c);
				printf("\tvalor da igualdade: "); scanf("%f", &igualdade);
				printf("\n\n\t	d = %.2f ^ 2 - 4 * %.2f * %.2f\n\t	d = %.2f - %.2f", b, a, c, b*b, 4*a*c);
				delta = b * b - 4 * a * c;
				printf ("\n\t	d = %.2f", delta);
				if (delta < 0) printf("\n\n\t	delta = %.2f, sem raizes reais.", delta);
				else if (delta == 0) printf("\n\n	x = %.2f\n\n", (-b)/(2*a));
				else
				{
					printf("\n\n\t	Raiz de %.2f = %.2f", delta, sqrt(delta));
					delta = sqrt(delta);
					printf("\n\n\t\tx1 = -%.2f + %.2f / 2 * %.2f", b, delta, a);
					printf("\n\t\tx1 = -%.2f / %.2f", -b + delta, 2 * a);
					x1 = ((-b) + delta) / (2 * a); 
					printf ("\n\n\t	x1 = %.2f", x1);
					printf("\n\n\t\tx2 = -%.2f - %.2f / 2 * %.2f", b, delta, a);
					printf("\n\t\tx2 = %.2f / %.2f", - b - delta, 2 * a);
					x2 = ((-b) - delta) / (2 * a); 
					printf ("\n\n\t	x2 = %.2f", x2);	
				}
			do {printf("\n\n\n\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes); } while (vezes != 's' && vezes != 'n');
			}
		}
		do { printf("\n	Deseja retornar ao menu? (s/n): " ); scanf(" %c", &menu); } while (menu != 's' && menu != 'n');
		if (menu == 'n') printf("\n\n------- Obrigado por usar meu programa!!\n\n");
	}
}
