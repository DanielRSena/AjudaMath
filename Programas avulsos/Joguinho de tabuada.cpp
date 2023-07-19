#include <stdio.h>
#include<stdlib.h>
#include <time.h>
int main()
{
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
