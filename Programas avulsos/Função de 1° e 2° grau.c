#include <stdio.h>
#include <math.h>
main ()

//Função de 1º e 2º grau
{
int cont;
for (cont = 0; cont == 0;)
{
	float a, b, c, x1, x2, igualdade, delta;
	int opcao;
	do { printf("\n	Para equacao de 1 grau --- ax + b = 0 --- digite 1.\n	Para equacao de 2 grau --- ax^2 + bx + c = 0 --- digite 2: "); scanf("%i", &opcao); } while (opcao != 1 && opcao != 2);
	do { printf("\n	Coloque o 'a': "); scanf("%f", &a); } while (a == 0);
	printf("\n\n	Digite o 'b': "); scanf("%f", &b);
	if (opcao == 1) {
		printf("\n\n	Numero depois da igualdade: "); scanf("%f", &igualdade);
		printf("\n\n		%.2fx + %.2f = %.2f\n", a, b, igualdade);
		printf("\n		%.2fx = %.2f - %.2f\n", a, igualdade, b );
		b = b * (-1) + igualdade; 
		printf("\n		%.2fx = %.2f", a, b );
		x1 = b / a;
		printf("\n\n		x = %.2f / %.2f\n", b, a);
		printf("\n\n	O valor de x eh de %.2f\n\n", x1);
		            }
	else {
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
		}
	     }
	printf("\n	Coloca 0 para continuar:" ); scanf("%i", &cont);
}
}
