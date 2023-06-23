#include <stdio.h>
#include <math.h>

int main()

{
	int menu = 0;
	while (menu == 0)
    {
		int opcao, ntabuada, cont, vezes = 1; 
   		float a, b, c, x1, x2, igualdade, delta;
    	printf("\n--------------------\n\n\t\t- Ajudante matematico -\n");
		printf("\n	Qual assunto serah abordado?");
    	printf("\n\n\t\t1. Funcao de 1 grau;\n\t\t2. Funcao de 2 grau;\n\t\t3. Tabuadas;\n\n\tSua escolha: "); scanf("%d", &opcao);
    	if (opcao == 1) 
     	{
			if (vezes == 1)
			{
				printf("\n--------------------\n\n\t\t- Funcao de 1 grau -\n");
				printf("\n\tA funcao de 1 grau tem:\n\n\t\t* 'a', acompanhado do 'x', sendo diferente de 0;\n\t\t* 'b'.\n");
				do { printf("\n	Coloque o 'a': "); scanf("%f", &a); } while (a == 0);
	 			printf("\n\n	Digite o 'b': "); scanf("%f", &b);
	   			printf("\n\n	Numero depois da igualdade: "); scanf("%f", &igualdade);
	   			printf("\n\n		%.2fx + %.2f = %.2f\n", a, b, igualdade);
	   			printf("\n		%.2fx = %.2f - %.2f\n", a, igualdade, b );
	   			b = b * (-1) + igualdade; 
	   			printf("\n		%.2fx = %.2f", a, b );
	    		x1 = b / a;
	    		printf("\n\n		x = %.2f / %.2f\n", b, a);
	    		printf("\n\n	O valor de x eh de %.2f\n\n", x1);
				do 
				{
					printf("\n\tDigite 1 se quiser fazer de novo\n\tDigite 0 se quiser encerrar o assunto: "); scanf("%d", &vezes);
				} while (vezes != 1 && vezes != 0); 
       		}
			opcao = 0;
		}
    	else if (opcao == 2)
        {
			if (vezes == 1)
			{
				printf("\n--------------------\n\n\t\t- Funcao de 2 grau -\n");
				printf("\n\tA funcao de 2 tem:\n\n\t\t* 'a' acompanhado do 'x' e elevado a 2;\n\t\t* 'b', acompanhado de x;\n\t\t* 'c'.\n");
				do { printf("\n	Coloque o 'a': "); scanf("%f", &a); } while (a == 0);
	    		printf("\n\n	Digite o 'b': "); scanf("%f", &b);
				printf("\n\n	Agora o 'c': "); scanf("%f", &c);
				printf("\n\n	Numero depois da igualdade: "); scanf("%f", &igualdade);
				printf("\n	delta = %.2f ^ 2 - 4 * %.2f * %.2f\n	delta = %.2f - %.2f", b, a, c, b*b, 4*a*c);
			    delta = b * b - 4 * a * c;
		   		printf ("\n	delta = %.2f", delta);
			   	if (delta < 0) printf("\n\n	Essa equacao tem delta = %.2f, portanto nao possui raizes reais.\n\n", delta);
			    else if (delta == 0) printf("\n\n	Essa equacao tem os dois 'x' com o mesmo valor, que eh = %.2f\n\n", (-b)/(2*a));
			    else
			   	{
		    		printf("\n	Raiz quadrada de %.2f = %.2f", delta, sqrt(delta));
		     		delta = sqrt(delta);
		    		printf("\n\n	-%.2f + %.2f / 2 * %.2f", b, delta, a);
		    		printf("\n	-%.2f / %.2f", -b + delta, 2 * a);
		    		x1 = ((-b) + delta) / (2 * a); 
		    		printf ("\n	x1 = %.2f", x1);
		    		printf("\n\n	-%.2f - %.2f / 2 * %.2f", b, delta, a);
		    		printf("\n	-%.2f / %.2f", - b - delta, 2 * a);
		    		x2 = ((-b) - delta) / (2 * a); 
		    		printf ("\n	x2 = %.2f", x2);
		    		printf ("\n\n	Nessa equacao, o x1 eh %.2f e o x2 eh %.2f.\n\n", x1, x2);
				do 
				{
					printf("\n\tDigite 1 se quiser fazer de novo\n\tDigite 0 se quiser encerrar o assunto: "); scanf("%d", &vezes);
				} while (vezes != 1 && vezes != 0); 
       			}
			}
			opcao = 0;
		}
		else if (opcao == 3)
		{
 			while (vezes == 1)
 			{	
				printf("\n--------------------\n\n\t\t- Gerador de tabuada -\n");
				printf("\n\tQual tabuada vc quer? "); scanf("%d", &ntabuada);
				printf("\n");
				for (cont = 0; cont < 11; cont = cont + 1) printf("\n\t\t%d x %d = %d", ntabuada, cont, ntabuada * cont);
 				do
	 			{
					printf("\n\n\tDigite 1 se quiser fazer de novo\n\tDigite 0 se quiser encerrar o assunto: "); scanf("%d", &vezes);
		 		} while (vezes != 1 && vezes != 0); 
            }
			opcao = 0;
		}
		do
		{
			printf("\n\n\tSe quiser voltar para o menu, digite 0;\n\tSe quiser fechar o programa. digite 1: "); scanf("%d", &menu);
		} while (menu != 1 && menu != 0);
	}
	printf("\n--------------------\n\n\tMuito obrigado por usar a minha ferramenta! Aceito sugestoes para melhoria!\n\n--------------------");
}
		
