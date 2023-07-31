#include <stdio.h>
#include <math.h>

int main()

{
	char menu = 's';
	while (menu == 's')
    {
		int opcao, ntabuada, cont;
		char vezes = 's'; 
   		float a, b, c, x1, x2, igualdade, delta;
    	printf("\n--------------------\n\n\t\t- Ajudante matematico -\n");
		printf("\n	Qual assunto serah abordado?");
    	printf("\n\n\t\t1. Funcao de 1 grau;\n\t\t2. Funcao de 2 grau;\n\t\t3. Tabuadas;\n\n\tSua escolha: "); scanf("%d", &opcao);
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
				printf("\n\n\t\tx = %.2f\n\n", x1);
				do { printf("\n\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes); } while (vezes != 's' && vezes != 'n'); 
       		}
		}
    	else if (opcao == 2)
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
				if (delta < 0) printf("\n\n\t	delta = %.2f, sem raizes reais.\n\n", delta);
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
					printf ("\n\n\t	x2 = %.2f\n", x2);
					do { printf("\n\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes); } while (vezes != 's' && vezes != 'n');
       			}
			}
		}
		else if (opcao == 3)
		{
 			while (vezes == 's')
 			{	
				printf("\n--------------------\n\n\t\t- Gerador de tabuada -\n");
				printf("\n\tQual tabuada vc quer? "); scanf("%d", &ntabuada);
				printf("\n");
				for (cont = 0; cont < 11; cont = cont + 1) printf("\n\t\t%d x %d = %d", ntabuada, cont, ntabuada * cont);
				printf("\n\n");
 				do { printf("\n\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes); } while (vezes != 's' && vezes != 'n');
            }
		}
		/*		else if (opcao == x)
		{
 			while (vezes == 's')
 			{	
				
 				do { printf("\n\n\n\tQuer fazer novamente? (s/n): "); scanf(" %c", &vezes); } while (vezes != 's' && vezes != 'n'); 
            }
			
		}*/ 	// Modelo para englobar as opções 
		do { printf("\n	Deseja retornar ao menu? (s/n): " ); scanf(" %c", &menu); } while (menu != 's' && menu != 'n');
	}
	printf("\n--------------------\n\n\tMuito obrigado por usar a minha ferramenta! Aceito sugestoes para melhoria!\n\n--------------------");
}
		
