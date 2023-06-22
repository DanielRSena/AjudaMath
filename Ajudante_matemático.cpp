#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>

int main()

{
    int fim = 1, opcao; 
    float a, b, c, x1, x2, igualdade, delta;
    printf("\n\t\t- Ajudante matematico -\n");
    printf("\n  Ola, fui feito para ser uma mistura das maiores ferramentas matematicas. Qual serah o assunto?\n\n");
    printf("\t1. Funcao de 1 grau;\n\t2. Funcao de 2 grau;\n\t3. Tabuadas;\n\t4. ");
    if (opcao == 1) 
        {
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
        }
    if (opcao == 2)
        {
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
		      }
	     }

}
}
int n1, n2, r1, r2, pontos = 0, cont, vezes = 1;
 	printf("\n\t\t- Gerador de tabuada -\n");
 	printf("\n\tPrazer, prazer. Vamos treinar a habilidade de multiplicar?\n\tPara cada tentativa certa, vc ganha um ponto. 1, 2, 3 e vai:");
 	while (vezes == 1) {
 		srand(time(NULL));
 		n1 = rand() % 11;
 		n2 = rand() % 11;
 		r1 = n1 * n2;
 		printf("\n\n\t\t%d\tx\t%d\t=\t ", n1, n2); scanf("%d", &r2);
 		if (r1 == r2) {
 			pontos = pontos + 1;
 			printf("\n	Parabens! Vc colocou a resposta certa, e agora tem %d pontos!", pontos);
	   	              }
		else {
			printf("\n\tNa realidade, a resposta certa eh %d:\n ", r1);
			for (cont = 0; cont < 11; cont = cont + 1) printf("\n\t\t%d x %d = %d", n1, cont, n1 * cont);	
	   	     }
	   	do {
		   printf("\n\n\tQuer continuar? 1 para sim, 0 para nao: "); scanf("%d", &vezes);
           } while (vezes != 1 && vezes != 0);
                       }
}
}